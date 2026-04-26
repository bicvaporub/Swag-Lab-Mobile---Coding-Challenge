package com.example.demo_swag_victorperez.pages

import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector

class LoginPage(private val device: UiDevice) {

    private val userField = device.findObject(UiSelector().description("test-Username"))
    private val passField = device.findObject(UiSelector().description("test-Password"))
    private val loginBtn = device.findObject(UiSelector().description("test-LOGIN"))

    fun login(user: String, pass: String) {
        if (userField.waitForExists(10000)) {

            userField.click()
            userField.setText(user)

            passField.setText(pass)

            device.pressBack() // Close keyboard

            if (loginBtn.exists()) {
                loginBtn.click()
            }
        } else {
            throw RuntimeException("Login screen not loading at time")
        }
    }
}