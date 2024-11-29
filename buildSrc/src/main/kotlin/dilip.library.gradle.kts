import dilip.buildlogic.configureAndroid
import dilip.buildlogic.configureTest

plugins {
    id("com.android.library")

    id("dilip.code.lint")
}

android {
    configureAndroid(this)
    configureTest()
}
