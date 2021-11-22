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

#####  33. Adding Profiles

To activate `staging` profile
-  `mvn quarkus:dev -Dquarkus.profile=staging`

####  Section 7: Packaging the Application

#####  37. Building Executable JARs

1.  Start in dev mode
   -  `mvn quarkus:dev` - Started in 4.6s (OpenJDK Runtime Environment GraalVM CE 21.3.0 in Windows 10 Home)
   -  `mvn quarkus:dev` - Started in 3.94s (Java(TM) SE Runtime Environment 18.9 (build 11.0.8+10-LTS) in Windows 10 Home)
2.  Package Fast-Jar
   -  `mvn clean package -DskipTests -Dquarkus.package.type=jar`
   -  **or** just (because `jar` is by default)
   -  `mvn clean package -DskipTests`
      -  will generate default Fast Jar with all needed code
      -  `target\quarkus-app\quarkus\quarkus-application.dat` - index for fast class scanning (Fast Jar)
      -  size
         -  quarkus-run.jar: 689B
         -  quarkus-app folder: 17.6MB   
   -  `java -jar target\quarkus-app\quarkus-run.jar` - Started in 1.959s
3.  Package Uber-Jar
    -  `mvn clean package -DskipTests -Dquarkus.package.type=uber-jar` - 17.5MB
    -  `java -jar target\rest-book-1.0.0-SNAPSHOT-runner.jar` - Started in 1.939s
4.  Pass params into command line
    -  `java -Dquarkus.banner.enabled=false -jar target\rest-book-1.0.0-SNAPSHOT-runner.jar`

#####  39.1 Building Native Executables - Windows 10

1.  Package
    -  `mvn clean package -DskipTests -Dquarkus.package.type=native`
    -  `mvn clean package -Pnative` native profile
    -  **errors**
    -  fixing errors
        -  added `C:\Windows\System32` to System PATH    
        -  added `c:\Program Files (x86)\Microsoft Visual Studio\2017\BuildTools\VC\Tools\MSVC\14.16.27023\bin\Hostx64\x64` to PATH
        -  excluded `javafaker`
        -  in PowerShell run
            -  `cmd.exe /c 'call "c:\Program Files (x86)\Microsoft Visual Studio\2017\BuildTools\VC\Auxiliary\Build\vcvars64.bat" && mvn clean package -Pnative' `
    -  got an executable
        -  `target\rest-book-1.0.0-SNAPSHOT-runner.exe` - 47.2MB
        -  Started in 0.23s
2.  Provide command-line arguments
    -  like jar file
    -  `target\rest-book-1.0.0-SNAPSHOT-runner.exe -Dquarkus.banner.enabled=false`

#####  39.2 Building Native Executables - Ubuntu

1.  Install Java manually
    -  `wget https://download.java.net/openjdk/jdk11/ri/openjdk-11+28_linux-x64_bin.tar.gz`
    -  `tar zxvf openjdk-11+28_linux-x64_bin.tar.gz`
    -  `sudo mv jdk-11* /usr/local/`
    -  `sudo vim /etc/profile.d/jdk.sh`
        -  add
        -  `#!/bin/bash`
        -  `export JAVA_HOME=/usr/local/jdk-11`
        -  `export PATH=$PATH:$JAVA_HOME/bin`
    -  `source /etc/profile`
    -  `java -version`
    -  `which java`
2.  Git clone
3.  Build native image
    -  `chmod +x mvnw` (if needed)
    -  `./mvnw clean package -Pnative`
    -  will build in Docker (even without GraalVM installed)
    -  size 45MB
4.  Run native image
    -  `./target/rest-book-1.0.0-SNAPSHOT-runner`
    -  started in 0.026s
        -  `./mvnw quarkus:dev` -  started in 2.615s
        -  Fat-jar        
            -  `./mvnw package -Dquarkus.package.type=uber-jar`
            -  `java -jar ./target/rest-book-1.0.0-SNAPSHOT-runner.jar` - started in 1.573s
        -  Fast jar
            -  `./mvnw package -Dquarkus.package.type=jar`
            -  `java -jar ./target/quarkus-app/quarkus-run.jar`






