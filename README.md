# Swag Labs Mobile E2E Automation - Android

##  Project Description
This repository contains a complete End-to-End (E2E) purchase flow automation for the **Swag Labs** mobile application on Android. The project was developed using **Kotlin** and **UiAutomator**, following the **Page Object Model (POM)** design pattern to ensure clean, scalable, and maintainable code.

##  Automated Scenario: Full Checkout Flow
The `completeCheckoutE2E` test executes the following sequence:
1. **Authentication**: Secure login using standard user credentials.
2. **Product Selection**: Dynamically selecting and adding the first available product to the cart.
3. **Shipping Information**: Completing the checkout form (First Name, Last Name, and Zip Code).
4. **Order Review**: Implementing dynamic scrolling to reach the final order summary.
5. **Confirmation**: Verifying the final success screen: "CHECKOUT: COMPLETE!".

##  Tech Stack & Architecture
- **Language**: Kotlin
- **Framework**: UiAutomator
- **Design Pattern**: Page Object Model (POM)
- **Target Device**: Pixel 7 (Android 14 - API 34)

##  Technical Challenges & Solutions (Senior Level)
Specific strategies were implemented to ensure test stability in modern Android environments:

- **Keyboard Management**: Implemented systematic virtual keyboard dismissal to prevent UI element obstruction during form completion.
- **Dynamic Scrolling**: Optimized `device.swipe()` parameters to accurately locate elements outside the initial viewport (FINISH button).
- **UI Synchronization**: Utilized explicit waits with `waitForExists()` to handle screen transitions and App response times effectively.

##  Project Demo (Recording)
The video recording demonstrating the successful execution of the automated test is located in the root directory of the project:
- **File Name**: `Screen_recording_20260426_012846.webm`

##  Execution Instructions

###  Option 1: Execution with Gradle (Standard)
To run the instrumentation tests using Gradle, ensure you have an Android emulator or physical device connected and execute the following command in the terminal:

```bash
./gradlew connectedAndroidTest
```
After the execution finishes, you can find the detailed HTML report at:
app/build/reports/androidTests/connected/index.html

## Option 2: Execution with Bazel (Advanced)
If you prefer using Bazel, use the following command to trigger the instrumentation test:
```bash
bazel test //app/src/androidTest:checkout_e2e_test
```
Note: This requires the rules_android dependency to be correctly resolved in your WORKSPACE file.

##  Repository Structure
```text
src/androidTest/java/com.example.demo_swag_victorperez/
├── pages/                # Interaction Logic (POM)
│   ├── LoginPage.kt
│   ├── ProductsPage.kt
│   └── CheckoutPage.kt
└── CheckoutTest.kt       # E2E Test Execution