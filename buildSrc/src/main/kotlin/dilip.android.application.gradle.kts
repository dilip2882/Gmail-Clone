import dilip.buildlogic.AndroidConfig
import dilip.buildlogic.configureAndroid
import dilip.buildlogic.configureTest

plugins {
    id("com.android.application")
    kotlin("android")

    id("dilip.code.lint")
}

android {
    defaultConfig {
        targetSdk = AndroidConfig.TARGET_SDK
    }
    configureAndroid(this)
    configureTest()
}
