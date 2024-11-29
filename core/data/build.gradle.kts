plugins {
    id("dilip.library")
    kotlin("android")
    kotlin("plugin.serialization")
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "dilip.common.data"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.domain)

    implementation(libs.retrofit)
    implementation(libs.logging.interceptor)
    implementation(libs.retrofit2.kotlinx.serialization.converter)

    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // Data serialization (JSON, protobuf, xml)
    implementation(kotlinx.bundles.serialization)

    implementation(kotlinx.reflect)
    implementation(kotlinx.immutables)
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        compilerOptions.freeCompilerArgs.addAll(
            "-Xcontext-receivers",
            "-opt-in=kotlinx.serialization.ExperimentalSerializationApi",
        )
    }
}
