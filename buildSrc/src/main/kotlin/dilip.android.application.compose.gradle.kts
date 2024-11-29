import dilip.buildlogic.configureCompose

plugins {
    id("com.android.application")
    kotlin("android")

    id("dilip.code.lint")
}

android {
    configureCompose(this)
}
