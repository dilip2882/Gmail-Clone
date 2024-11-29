buildscript {
    dependencies {
        classpath(libs.android.shortcut.gradle)
    }
}

plugins {
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
    alias(kotlinx.plugins.serialization) apply false
    alias(libs.plugins.aboutLibraries) apply false
    alias(libs.plugins.firebase.crashlytics) apply false
    alias(libs.plugins.google.services) apply false
    alias(libs.plugins.moko) apply false
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
