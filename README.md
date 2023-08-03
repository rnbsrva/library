# library
 
* ## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/rnbsrva/library.git
```

**2. Create PostgreSQL database**
```bash
create database library
```

**3. Change PostreSQL username and password as per your installation**

+ open `server/src/main/resources/application.properties`
+ change `spring.datasource.username` & `spring.datasource.password` as per your PostgreSQL installation

**6. Run the app using maven**

```bash
mvn spring-boot:run
```
The app will start running at <http://localhost:8080>
Open API Docs link: <http://localhost:8080/swagger-ui/index.html>
