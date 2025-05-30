"Dream Portal Automation"

Overview:

This project automates functional testing for the Dream Portal website (https://arjitnigam.github.io/myDreams/) using Selenium WebDriver with Java, TestNG, and Allure Reports. It follows the Page Object Model (POM) for maintainability and includes tests for index.html, dreams-diary.html, and dreams-total.html.

Prerequisites:

Java 11 or higher
Maven 3.6+
Chrome browser
Allure CLI (for generating reports)

Framework:

DreamPortalAutomation/
├── src/
│   ├── main/
│   │   ├── java/com/dreamportal/
│   │   │   ├── pages/              # Page Object classes
│   │   │   ├── utils/              # Utility classes for WebDriver and screenshots
│   │   │   └── constants/          # Constants like URLs and timeouts
│   ├── test/
│   │   ├── java/com/dreamportal/tests/  # Test classes
│   ├── resources/
│   │   ├── drivers/                # WebDriver binaries (managed by WebDriverManager)
│   │   └── testng.xml              # TestNG configuration
├── reports/                            # Allure reports and screenshots
├── pom.xml                             # Maven dependencies
└── README.md                           # This file


Test Coverage:

index.html: Verifies loading animation, main content visibility, and "My Dreams" button functionality.
dreams-diary.html: Validates 10 dream entries, dream types ("Good" or "Bad"), and non-empty columns.
dreams-total.html: Verifies stats (Good: 6, Bad: 4, Total: 10, Recurring: 2) and recurring dream names.


Reporting:

Allure reports are generated in reports/allure-results.
Screenshots are saved in reports/screenshots on test failure.


Notes:

The project uses WebDriverManager to handle ChromeDriver automatically.
AI-based validation (optional) is not implemented due to external API dependency.
Ensure Chrome browser is installed and up-to-date.