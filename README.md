Rest Assured API automation project

1. API automation framework built using Rest assured, TestNg, Java following combination of Builder, singleton, service factory and basic service Object model design patterns

2. Tech stack:
- Java 25
- Rest Assured
- TestNg
- Maven
- Apache Poi
- Builder Design pattern with lombok
- Basic singleTon, Service object model

3. Project Design

- Builder Design pattern for POJO(payload) creation
- SingleTon pattern for Request Specs
- Factory service for service selection
- Service object model for separating Tests and API endpoints
- Data-driven testing with Excel

4. Prerequisites
-Java 17+
-Maven 3.5
-Eclipse/ VS code
- Git

5. How to run after pulling the framework
- Clone the repo
- Update snapshots
-Right click on testNg.xml -> Run as TestNg suite

6. Configuration 
- Houses one properties file under resource to fetch baseURL

7. Test Data 
- Data-driver testing using Excel file
- Test data maintained under -> RestAssuredAssignment\TestData\TestData.xlsx







