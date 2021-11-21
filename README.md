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




