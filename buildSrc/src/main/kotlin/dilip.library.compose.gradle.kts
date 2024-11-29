import dilip.buildlogic.configureCompose

plugins {
    id("com.android.library")

    id("dilip.code.lint")
}

android {
    configureCompose(this)
}
