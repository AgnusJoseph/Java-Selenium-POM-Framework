**Java Selenium POM Framework**

This repository contains an automation testing framework built with Selenium WebDriver, Java, and TestNG. The framework follows the Page Object Model (POM) design pattern and is driven by data from JSON files. It is structured to be scalable, maintainable, and easy to extend.

**Features**

Selenium WebDriver: Automates browser interactions.
TestNG: Provides test configuration, reporting, and assertions.
Page Object Model (POM): Separates test logic and web elements for better maintainability.
Data-Driven Testing: Test data is loaded dynamically from JSON files, enabling reusable and flexible test scenarios.
Maven: For dependency management and build automation.

**Prerequisites**

Java (Version 8 or higher)
Maven (For building and running the project)
TestNG (Included as a Maven dependency)
Java Selenium POM Framework
This repository contains an automation testing framework built with Selenium WebDriver, Java, and TestNG. The framework follows the Page Object Model (POM) design pattern and is driven by data from JSON files. 
It is structured to be scalable, maintainable, and easy to extend.

**Features**

Selenium WebDriver: Automates browser interactions.
TestNG: Provides test configuration, reporting, and assertions.
Page Object Model (POM): Separates test logic and web elements for better maintainability.
Data-Driven Testing: Test data is loaded dynamically from JSON files, enabling reusable and flexible test scenarios.
Maven: For dependency management and build automation.

**Prerequisites**

Java (Version 8 or higher)
Maven (For building and running the project)
TestNG (Included as a Maven dependency)

**Setup**

1. Clone the repository: git clone https://github.com/AgnusJoseph/Java-Selenium-POM-Framework.git
2. Navigate to the project directory: cd Java-Selenium-POM-Framework
3. Install dependencies using Maven: mvn install
4. Configure your test data in the JSON files located under the resources directory.

**Folder Structure**

**Java-Selenium-POM-Framework/**
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── pages/               # Page Object Model classes
│   │   │   ├── utils/               # Utilities like WebDriver setup, test data handling
│   ├── test/
│   │   ├── java/
│   │   │   ├── tests/               # TestNG test classes
│   ├── resources/
│   │   ├── testdata/                # JSON files containing test data
│   │   ├── config/                  # Configuration files like WebDriver setup
├── pom.xml                          # Maven project configuration


**Running the Tests**

1. To run tests, use the following command: mvn test
2. To run tests for a specific class, you can use: mvn -Dtest=TestClassName test
   
**Report Generation**

TestNG generates a detailed report by default. You can find the report in the test-output directory after running the tests.

**Contribution**
Feel free to fork this repository and create pull requests for new features or improvements.
