# GoEuro-Automation
This is the assignment project
This framework is called Page Object Model (POM), this is a maven project

Basically this framework will have two packages:
1. pom
2. scripts

1. pom
    i. In pom package there will be different classes based on different pages
    ii. And in each class there will be objects on that respective pages
    iii. There will be methods in that pages on what task they have to perform
    
2. scripts
    i. In scripts package there will be BaseTest.java class that will invoke the driver
    ii. There will be other different classes which will drive the tests for each pages

How to run the project
    1. Pre-requisites:
        a. Maven is configured in the system
        b. Mozilla Firefox is installed in the system, firefox version 47.0.1
     2. Use any of these below commands to run the project
        a. mvn clean install
        b. mvn test
        3. Right click on the testng.xml and select run

Test Report:
1. Once the test run is complete, there will be report "Report.html" generated under /src folder
2. Report contains the details like:
    i. Which tests run
    ii. Status of the test
    iii. Time stamp
    iv. Graphical representation of the test result
    v. Start and End time of the complete test run
    vi. Pass percentage
    vii. Environment