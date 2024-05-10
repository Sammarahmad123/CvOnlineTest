# CV.ee Test Automation Project

## Overview

This project automates the end-to-end testing of the CV.ee registration process using Java, Maven, TestNG, Selenium, and Allure for reporting.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Setup and Running Tests and Reporting](#setup-instructions)

## Prerequisites

- **Java 17** or higher
- **Maven 3.6.3** or higher
- **Web Browser** (Chrome)
- **IDE** (IntelliJ IDEA, Eclipse, etc.)

## Project Structure

```plaintext
CVEETestProject/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── base/
│   │       │   └── BaseTest.java
│   │       └── configuration/
│   │       │   ├── AllureListener.java
│   │       │   ├── TimeoutConfig.java
│   │       │   └── WebDriverSetup.java
│   │       └── pages/
│   │       │   ├── HomePage.java
│   │       │   ├── LoginPage.java
│   │       │   └── RegistrationPage.java
│   │       └── utils/
│   │           ├── ConfigReader.java
│   │           ├── EmailGenerator.java
│   │           ├── UIActions.java
│   │           └── WaitUtils.java
│   └── test/
│       └── java/
│           └── ui/
│               └── Registration/
│                   ├── E2E/
│                   │   └── RegistrationE2E.java
│                   └── Negative/
│                       ├── InvalidEmailTest.java
│                       ├── RegistrationWithExistingEmailTest.java
│                       ├── RequiredFieldTurnRedTest.java
│                       └── ShortPasswordTooltipTest.java
│       └── resources/
│           ├── properties/
│           │   └── config.properties
│           └── testng/
│               ├── NegativeRegistration.xml
│               └── RegistrationE2E.xml
│
├── target/
│
├── pom.xml
└── README.md
## Setup Instructions

### Clone the Repository

#### Run following command to run the test cases
```bash
mvn clean install
mvn clean test -> this command will run the tests
mvn allure:serve -> this will generate alure reports and opens a new browser window to view report