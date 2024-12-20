plugins {
    id("dilip.library")
    kotlin("android")
//    kotlin("plugin.serialization")
}

android {
    namespace = "com.dilip.common"

    kotlinOptions {
        freeCompilerArgs += listOf(
            "-Xcontext-receivers",
            "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
            "-opt-in=kotlinx.serialization.ExperimentalSerializationApi",
        )
    }
}

dependencies {
    implementation(projects.i18n)

//    api(kotlinx.coroutines.core)
//    api(kotlinx.serialization.json)
//    api(kotlinx.serialization.json.okio)

    api(libs.preferencektx)

    // Sort
    implementation(libs.natural.comparator)

    // JavaScript engine
    implementation(libs.bundles.js.engine)

    testImplementation(libs.bundles.test)
}
