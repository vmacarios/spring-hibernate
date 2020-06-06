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

## Executing the query

A transaction with the database is done through a session.
First, a `SessionFactory` is created.
The object class is defined here.
Then, use the session to perform the operations.
In a `try/finally` block, close the SessionFactory.
