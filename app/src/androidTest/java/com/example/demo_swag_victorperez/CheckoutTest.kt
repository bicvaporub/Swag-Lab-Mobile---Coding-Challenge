package com.example.demo_swag_victorperez

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.junit.Test
import org.junit.runner.RunWith
import com.example.demo_swag_victorperez.pages.LoginPage
import com.example.demo_swag_victorperez.pages.ProductsPage
import com.example.demo_swag_victorperez.pages.CheckoutPage

@RunWith(AndroidJUnit4::class)
class CheckoutTest {

    @Test
    fun completeCheckoutE2E() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val uiDevice = UiDevice.getInstance(instrumentation)
        val packageName = "com.swaglabsmobileapp"

        uiDevice.executeShellCommand("am force-stop $packageName")
        uiDevice.executeShellCommand("am start -n $packageName/$packageName.MainActivity")

        val loginPage = LoginPage(uiDevice)
        val productsPage = ProductsPage(uiDevice)
        val checkoutPage = CheckoutPage(uiDevice)

        loginPage.login("standard_user", "secret_sauce")
        productsPage.addFirstProductToCart()

        checkoutPage.startCheckoutAndFillInfo("Victor", "Perez", "54766")
        val isSuccessful = checkoutPage.finishOrder()

        assert(isSuccessful) { "Error: Not checkout confirmation screen reached" }
    }
}