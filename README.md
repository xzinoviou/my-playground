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
  > Test DB: ``Testcontainers Mysql 8.0.31``</br
  > Testing database is pre-populated with data

- ### postgres-db
  > DB: ``Postgres 12.2``</br>
  > Database Migration tool used: ``flyway``</br>
  > Test DB: ``Testcontainers Postgres 12.2``</br> 
  > Testing database is pre-populated with data 

## How to:

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

