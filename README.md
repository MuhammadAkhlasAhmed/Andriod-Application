# Social Based Movies Recommendation System.

## Requirements
* Java 8
* Maven 3.5
* spring boot 1.5.7

## Database Settings
The configuration of the database is done in `application.properties`:

## Running content-base-filtering locally
	**Step 1**: Compile the project:	
		mvn clean install

	**Step 2**: Just run the with `dev` profile obtained WAR file as a JAR:
	mvn spring-boot:run -P dev -Dserver.port=8080

## Running collaborative-base-filtering locally
	**Step 1**: Compile the project:	
		mvn clean install

	**Step 2**: Just run the with `dev` profile obtained WAR file as a JAR:
	mvn spring-boot:run -P dev -Dserver.port=8081

