# selenide-ui-automation
#### Project stack :
- **Gradle project** 
- **Selenide as Web automation framework** 
- **JUnit5 as test runner xUnit framework** 
- **Project is building on Jenkins** 
- **Allure as test reporting** 
- **JavaOwner for usefull config** 
- **Flogger as logger with fluent interface** 


#### Required environment

- Jenkins (is optional for CI running)
- Selenoid (is optional for remote running)
- Java 8


#### Import project (is optional)
- should be imported as Gradle project with using Gradle wrapper
- for run tests from IDEA You need to enable Annotation Processing
```
 Settings > Build > Compiler > Annotation Processors
```

#### Run tests from cli

commands syntax:
- **local run example (Chrome browser as default)**
```
 ./gradlew clean test
```
- **local run with specific browser and parallelism**
```
 ./gradlew clean testFirefox
```
```
 ./gradlew clean testChrome
```
- **remote run with chrome browser (can be configured on driver.properties.file)**
```
 ./gradlew clean testRemoteChrome
```

#### Generate Allure report
- **generate report after full test run**
```
 ./gradlew allureReport
```
- **then run Allure web service**
```
 ./gradlew allureServe
```
