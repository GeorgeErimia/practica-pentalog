# Database

Database has two tables: game and store, which are related by a foreign key.

They are linked with a one-to-many relationship, so that no game can be present in more than one store.


# Repository Interface

There is a repository interface for each table, which implement CrudRepository
