package com.example.demo_swag_victorperez.pages

import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiScrollable

class CheckoutPage(private val device: UiDevice) {

    fun startCheckoutAndFillInfo(fName: String, lName: String, zip: String) {
        // Initial click on "Checkout"
        val checkoutBtn: UiObject = device.findObject(UiSelector().description("test-CHECKOUT"))
        if (checkoutBtn.waitForExists(5000)) {
            checkoutBtn.click()
        }

        val firstNameField: UiObject = device.findObject(UiSelector().description("test-First Name"))
        if (firstNameField.waitForExists(5000)) {
            firstNameField.setText(fName)

            val lastNameField: UiObject = device.findObject(UiSelector().description("test-Last Name"))
            lastNameField.setText(lName)

            val zipField: UiObject = device.findObject(UiSelector().description("test-Zip/Postal Code"))
            zipField.setText(zip)

            val continueBtn: UiObject = device.findObject(UiSelector().description("test-CONTINUE"))
            if (continueBtn.exists()) {
                continueBtn.click()
            }
        }
    }

    fun finishOrder(): Boolean {
        val scrollable = UiScrollable(UiSelector().scrollable(true))

        try {
            scrollable.scrollIntoView(UiSelector().description("test-FINISH"))
        } catch (e: Exception) {
            device.swipe(500, 1300, 500, 400, 40)
        }

        val finishBtn: UiObject = device.findObject(UiSelector().description("test-FINISH"))
        if (finishBtn.waitForExists(5000)) {
            finishBtn.click()
        }

        val successHeader = device.findObject(UiSelector().text("CHECKOUT: COMPLETE!"))
        return successHeader.waitForExists(10000)
    }
}