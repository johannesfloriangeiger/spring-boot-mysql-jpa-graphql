Spring Boot GraphQL with MySQL and JPA
=

Setup
-

Checkout the code, run

```
mvn clean install spring-boot:repackage
```

to build the API. Then, run

```
docker-compose up --build 
```

and

```
mvn liquibase:update
```

to set up the database.

Run
-

```
docker-compose up 
```

and open `http://localhost:8080/graphiql` in your Browser to access the GraphiQL UI.
Here, you can try various queries, e.g.

```
query employee {
  employeeById(id: 1) {
    id
    name
    company {
      id
      name
    }
  }
}
```

or

```
query company {
  companyById(id: 1) {
    id
    name
    employees {
      id
      name
    }
  }
}
```

or, to test the error handling

```
query missingCompany {
  companyById(id: 2) {
    id
    name
    employees {
      id
      name
    }
  }
}
```