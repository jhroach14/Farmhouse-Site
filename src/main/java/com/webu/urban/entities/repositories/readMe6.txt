Author: James Roach 8/5/17
These readMe's will be distributed throughout the project to document the project structure and
give general context to directories/files

Spring Data Layers:
    entities
 -> repositories (you are here)
    database

This directory contains the spring data repositories used to interface with the mysql db.These
repositories all extend the CrudRepository interface which will automatically generate
implementations for any basic CRUD(create read update destroy) methods declared inside of them.

read here: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories
