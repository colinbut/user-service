/* utility cql file that setups cassandra datastore for local testing */

drop keyspace UserKS;

create keyspace UserKS WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 3};

use UserKS;

create table if not exists users (
	ssn text,
	forename text,
	surname text,
	dob date,
	address text,
	postcode text,
	city text,
	country text,
	PRIMARY KEY (ssn, forename, surname)
) with comment = 'database of users' and compaction = {'class' : 'LeveledCompactionStrategy'};

--  dummy data
insert into users (ssn, forename, surname, dob, address, postcode, city, country) values ('000-####-001-###', 'forename', 'surname', '1999-01-30', '85 Address Road', 'ABC 123', 'Paris', 'France');