load("@rules_android//android:rules.bzl", "android_instrumentation_test")

android_instrumentation_test(
    name = "checkout_e2e_test",
    google_ops = True,
    target_device = "@android_test_support//devices/emulator:pixel_7_api_34",
    test_app = "//app:Demo_Swag_VictorPerez_TestApp",
    binary_under_test = "//app:Demo_Swag_VictorPerez_App",
)