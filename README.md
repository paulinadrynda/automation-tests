## Automated tests for automationpractice.com
[automationpractice.com](automationpractice.com) is an end-to-end e-commerce website created for learning automated software testing. It covers the complete online shopping workflow including registration, logging in, searching and sorting products, adding them to the cart and buying.

This project is made for develop my skills in automation testing. It is written in Java 8 and managed by Maven.

#### Used frameworks:
- Selenium Webdriver
- Webdriver Manager
- Junit 5
- Hamcrest
- Allure Report
- Java Faker
- Ashot

#### Tested functionalities:
- creating a new account
- searching products
- sorting products

#### Instruction of test execution:

Run command:
```
mvn clean test
mvn allure:serve 
```

or run file
- on Windows → [run_test.bat](run_test.bat)
- on Linux → [run_test.sh](run_test.sh)

