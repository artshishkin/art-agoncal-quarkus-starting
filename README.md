# art-agoncal-quarkus-starting
Starting with Quarkus - Tutorial from Antinio Goncalves (Udemy)

####  Section 3: Getting Started

#####  12. Bootstrapping the Application

1.  Via `https://code.quarkus.io/`
2.  Via IDE
3.  Via Maven
```
mvn -U io.quarkus:quarkus-maven-plugin:create \
-DprojectGroupId=net.shyshkin.study.quarkus.starting \
-DprojectArtifactId=rest-book \
-DclassName="net.shyshkin.study.quarkus.starting.BookResource" \
-Dpath="/api/books" \
-Dextensions="resteasy-jsonb"
```
**or**
```
mvn -U io.quarkus:quarkus-maven-plugin:create
```
and through commands

In Windows
```
mvn -U io.quarkus:quarkus-maven-plugin:create ^
-DprojectGroupId=net.shyshkin.study.quarkus.starting ^
-DprojectArtifactId=rest-book ^
-DclassName="net.shyshkin.study.quarkus.starting.BookResource" ^
-Dpath="/api/books" ^
-Dextensions="resteasy-jsonb"
```

#####  14. Developer Joy

Start Quarkus in Development Mode
-  `mvn quarkus:dev`
cURL it:
-  `curl http://localhost:8080/api/books`

#### Section 6: Configuring the Application

#####  29.3. Injecting Configuration - in command line (#4)

-  `mvn quarkus:dev -Dapp.books.genre="Sci Fi"`
-  `mvn test -Dapp.books.genre="Sci Fi"`

#####  30. Configuring Quarkus

-  [All configurations](https://quarkus.io/guides/all-config)
-  `http://localhost:8080`
-  `http://localhost:8080/q/dev/`
-  `http://localhost:8080/q/dev/io.quarkus.quarkus-vertx-http/config`



