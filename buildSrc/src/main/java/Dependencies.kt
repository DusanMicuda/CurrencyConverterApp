import org.gradle.api.JavaVersion

/**
 * Dependencies for the project.
 */
object Dependencies {
    // Gradle
    val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.gradlePlugin}"

    // Kotlin
    val kotlinBom = "org.jetbrains.kotlin:kotlin-bom:${Versions.kotlinBom}"
    val kotlinSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinSerialization}"
    val kotlinSerializationPlugin = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlinSerializationPlugin}"

    // Android
    val androidCore = "androidx.core:core-ktx:${Versions.androidCore}"
    val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    val activity = "androidx.activity:activity-compose:${Versions.activity}"

    // Jetpack Compose
    val composeBom = "androidx.compose:compose-bom:${Versions.composeBom}"
    val composeUI = "androidx.compose.ui:ui"
    val composeGraphics = "androidx.compose.ui:ui-graphics"
    val composePreview = "androidx.compose.ui:ui-tooling-preview"
    val materialDesign = "androidx.compose.material3:material3"

    // Ktor
    val ktorCore = "io.ktor:ktor-client-core:${Versions.ktor}"
    val ktorAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
    val ktorSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
    val ktorLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
    val logback = "ch.qos.logback:logback-classic:${Versions.logback}"

    // Tests
    val jUnit = "junit:junit:${Versions.jUnit}"
    val jUnitExt = "androidx.test.ext:junit:${Versions.jUnitExt}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    val composeTest = "androidx.compose.ui:ui-test-junit4"
}

object Android {
    const val applicationId = "com.micudasoftware.currencyconverter"

    const val minSdk = 26
    const val targetSdk = 33
    const val compileSdk = 33

    const val versionCode = 1
    const val versionName = "1.0.0"

    const val testInstrumentRunner = "androidx.test.runner.AndroidJUnitRunner"

    val sourceCompatibilityJava = JavaVersion.VERSION_1_8
    val targetCompatibilityJava = JavaVersion.VERSION_1_8
}
