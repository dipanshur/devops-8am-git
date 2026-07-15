# Shoe Store WebApp

A simple Java web application that displays a catalog of shoes and footwear products.

## Structure

- `pom.xml` - Maven build file
- `src/main/java` - Java source files
- `src/main/webapp` - web application pages and static assets
- `src/main/webapp/WEB-INF/web.xml` - servlet configuration

## Run

1. Build the project:
   ```bash
   mvn clean package
   ```
2. Deploy the generated `target/shoe-store-webapp.war` to any Jakarta/Servlet container (Tomcat, Jetty, WildFly).
3. Open the site at `http://localhost:8080/shoe-store-webapp/` after deploying.
