# My-Playground


### A playground project for testing solutions

DB used: ``H2 in-memory``
DB migration tool used: ``flyway``


For the testing:

DB used: different ``H2 in-memory`` used.
DB migration tool used: ``flyway``
DB is populated with data.


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

