# CV.ee Test Automation Project

## Overview

This project automates the end-to-end testing of the CV.ee registration process using Java, Maven, TestNG, Selenium, and Allure for reporting.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Setup Instructions](#setup-instructions)
- [Running Tests](#running-tests)
- [Generating Allure Reports](#generating-allure-reports)
- [Configuration](#configuration)
- [Additional Information](#additional-information)

## Prerequisites

- **Java 17** or higher
- **Maven 3.6.3** or higher
- **Web Browser** (Chrome)
- **IDE** (IntelliJ IDEA, Eclipse, etc.)


## Setup Instructions

### Clone the Repository

#### Clone the project and then run following command to run the test cases
```bash
mvn clean install
mvn clean test -> this command will run the tests
mvn allure:serve -> this will generate alure reports and opens a new browser window to view report