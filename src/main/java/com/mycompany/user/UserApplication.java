/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.user;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;

import java.net.URL;

public class UserApplication {

    private static final int DEFAULT_PORT = 8090;

    private UserApplication() {
    }

    public static void main(String[] args) throws Exception {

        final Server server = new Server();

        final ServerConnector serverConnector = new ServerConnector(server);

        serverConnector.setPort(resolvePort());

        server.setConnectors(new Connector[]{serverConnector});

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setDescriptor(getResource("webapp/WEB-INF/web.xml"));
        webAppContext.setResourceBase(getResource("webapp"));
        webAppContext.setContextPath("/");
        webAppContext.setParentLoaderPriority(true);

        server.setHandler(webAppContext);
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                if (server.isStarted()) {
                    server.setStopAtShutdown(true);

                    try {
                        server.stop();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }));

        server.join();

    }

    private static String getResource(String resourceName) {
        URL resourceURL = UserApplication.class.getClassLoader().getResource(resourceName);
        if (resourceURL == null) {
            throw new RuntimeException("Unable to fetch specified resource: " + resourceName);
        }
        return resourceURL.toString();
    }

    private static int resolvePort() {
        try {
            return Integer.parseInt(System.getProperty("port"));
        } catch (NumberFormatException ex) {
            return DEFAULT_PORT;
        }
    }
}
