load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

http_archive(
    name = "rules_android",
    urls = ["https://github.com/bazelbuild/rules_android/archive/v0.1.1.zip"],
    strip_prefix = "rules_android-0.1.1",
)

load("@rules_android//android:rules.bzl", "android_sdk_repository")

android_sdk_repository(
    name = "androidsdk",
    path = "C:/Users/kevin/AppData/Local/Android/Sdk",
    api_level = 34,
    build_tools_version = "34.0.0",
)
