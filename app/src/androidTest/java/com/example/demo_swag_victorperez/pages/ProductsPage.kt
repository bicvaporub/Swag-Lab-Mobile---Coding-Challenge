package com.example.demo_swag_victorperez.pages

import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector

class ProductsPage(private val device: UiDevice) {
    private val firstAddToCartBtn = device.findObject(UiSelector().description("test-ADD TO CART").instance(0))
    private val cartIcon = device.findObject(UiSelector().description("test-Cart"))

    fun addFirstProductToCart() {
        if (firstAddToCartBtn.waitForExists(10000)) {
            firstAddToCartBtn.click()
            cartIcon.click()
        } else {
            throw RuntimeException("Not products found.")
        }
    }
}