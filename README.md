# My-Playground


### A playground project for testing solutions

### Branches

- ### h2-db-memory
  > DB used: ``H2 in-memory``</br>
  > Database Migration tool used: ``flyway``</br>
  > Test DB: ``H2 in-memory``</br>
  > Testing database is pre-populated with data

- ### myslq-db
  > DB: ``Mysql 8.0.31``</br>
  > Database Migration tool used: ``flyway``</br>
  > Test DB: ``Testcontainers Mysql 8.0.31``</br>
  > Testing database is pre-populated with data

- ### postgres-db
  > DB: ``Postgres 12.2``</br>
  > Database Migration tool used: ``flyway``</br>
  > Test DB: ``Testcontainers Postgres 12.2``</br> 
  > Testing database is pre-populated with data.</br>
  > ---
  >  You will need to prepare your postgresql DB server</br>
  > in order for flyway to be able to do the migration:</br>
  > - Create the database
  > - Create the schema my_playground_schema
  > - Create the user & grant privileges to database & schema

---

## How to:


Depending on the db-branch you want to use you will need to provide env variables </br>
and update the migration scripts with those values:


### H2
```properties
#h2
H2_DB=***
H2_IN_MEMORY_URL=jdbc:h2:mem:${H2_DB};DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
H2_USER=***
H2_PASSWORD=***

#flyway
FLYWAY_USER=(should be same as the db credentials)
FLYWAY_PASSWORD=(should be same as the db credentials)

###########
#test
###########

#h2
H2_TEST_DB=***
H2_IN_MEMORY_TEST_URL=jdbc:h2:mem:${H2_TEST_DB};DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
H2_TEST_USER=***
H2_TEST_PASSWORD=***
```

### MySql
```properties
#mysql
MYSQL_DB=***
MYSQL_HOST=***
MYSQL_PORT=***
MYSQL_URL=jdbc:mysql://${MYSQL_HOST}:${MYSQL_PORT}/${MYSQL_DB}
MYSQL_USER=***
MYSQL_PASSWORD=***

#flyway
FLYWAY_USER=(should be same as the db credentials)
FLYWAY_PASSWORD=(should be same as the db credentials)
```

### Postgresql
```properties
#mysql
#postgres
POSTGRES_USER=***
POSTGRES_PASSWORD=***
POSTGRES_DB=***
POSTGRES_HOST=***
POSTGRES_PORT=***
POSTGRES_URL=jdbc:postgresql://${POSTGRES_HOST}:${POSTGRES_PORT}/${POSTGRES_DB}

#flyway
FLYWAY_USER=(should be same as the db credentials)
FLYWAY_PASSWORD=(should be same as the db credentials)
```

---

- ### Build

The project is using [maven](https://maven.apache.org/index.html) as a build tool
 and it needs to be built as a jar before running. 

Build the jar with the command:

```terminaloutput
mvn clean package 
```

- ### Run

Run the project with the command:
```terminaloutput
mvn spring-boot:run
```


- ### Tests

By default, the ``maven:package`` phase includes the ``maben:test`` phase.
If you need to run only the tests, use the command: 

```terminaloutput
mvn test 
```

- ### Integration Tests

If you need to trigger the Integration Tests use the command:

```terminaloutput
mvn verify
```

By default the ``maven:verify`` phase includes the ``maven:test`` phase. 
That means units test will also be triggered during this run.

If you want unit tests to be excluded from this round, use the command:

```terminaloutput
mvn verify -Dskip.surefire.tests
```

