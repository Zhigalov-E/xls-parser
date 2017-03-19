Console application on java, using maven.
The application parse *.xls file with known structure

Startup instruction
-------------------

1. build jar file with dependencies
mvn clean compile assembly:single

2. create DB access
database name: 	xls_parser
username: 		postgres
password:		secret
create db structure
3. Migrate DB structure
mvn flyway:migrate

4. run parser
java -jar xls-parser-1.0-jar-with-dependencies.jar <file_path>