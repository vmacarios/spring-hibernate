# spring-hibernate

Configuration steps to use Hibernate on Spring:

The POM file should include the following dependencies:
`hibernate-core`
`mysql-connector-java`

## Configuration file
The hibernate configuration file should be located at the `src/resources` folder.
The default name is `hibernate.cfg.xml`.
A basic file includes the database driver, address, user, and password.
It can also includes the pool size, dialect, and whether the SQL command should be echoed in the stdout. 

---

## Entity

The object that will be saved to the database should be annotated with `@Entity`.
The `id` column will be annotated with `@Id`.
The getters and setter should be created.

## Executing the queries

A transaction with the database is done through a session.
First, a `SessionFactory` is created.
The object class is defined here.
Then, use the session to perform the operations.
In a `try/finally` block, close the SessionFactory.

## Changing the starting index

If you need to start the index from a higher number, just perform the following query in the MySQL client:
`alter table spring.student auto_increment=10`

If you want to reset the counter, than it's necessary to remove all data.
To do that, use the following:
`truncate table spring.student;`

## Retrieving objects

To retrieve an object, start a new session using `factory.getCurrentSession();`
Then, start the transaction and use the `get` method from the session, passing the Model and Id as arguments.
