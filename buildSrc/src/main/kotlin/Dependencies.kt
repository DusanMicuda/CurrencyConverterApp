import org.gradle.api.JavaVersion

/**
 * Dependencies for the project.
 */
object Dependencies {
    // Gradle
    val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.gradlePlugin}"
    val atomicfu = "org.jetbrains.kotlinx:atomicfu-gradle-plugin:${Versions.atomicfu}"

    // Kotlin
    val kotlinBom = "org.jetbrains.kotlin:kotlin-bom:${Versions.kotlinBom}"
    val kotlinSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinSerialization}"
    val kotlinSerializationPlugin = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlinSerializationPlugin}"
    val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect"
    val kotlinCouroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
    val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"

    // Android
    val androidCore = "androidx.core:core-ktx:${Versions.androidCore}"
    val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    val activity = "androidx.activity:activity-compose:${Versions.activity}"

    // Jetpack Compose
    val composeBom = "androidx.compose:compose-bom:${Versions.composeBom}"
    val composeUI = "androidx.compose.ui:ui"
    val composeGraphics = "androidx.compose.ui:ui-graphics"
    val composeTooling = "androidx.compose.ui:ui-tooling"
    val composePreview = "androidx.compose.ui:ui-tooling-preview"
    val materialDesign = "androidx.compose.material3:material3"

    // Ktor
    val ktorCore = "io.ktor:ktor-client-core:${Versions.ktor}"
    val ktorAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
    val ktorIos = "io.ktor:ktor-client-darwin:${Versions.ktor}"
    val ktorContentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
    val ktorSerializationJson = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
    val ktorLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
    val logback = "ch.qos.logback:logback-classic:${Versions.logback}"

    // Koin
    val koin = "io.insert-koin:koin-core:${Versions.koin}"
    val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"

    // Voyager
    val voyagerNavigator = "cafe.adriel.voyager:voyager-navigator:${Versions.voyager}"
    val voygerBottomSheet = "cafe.adriel.voyager:voyager-bottom-sheet-navigator:${Versions.voyager}"
    val voyagerAndroidViewModel = "cafe.adriel.voyager:voyager-androidx:${Versions.voyager}"
    val voyagerKoin = "cafe.adriel.voyager:voyager-koin:${Versions.voyager}"
    val voyagerTransitions = "cafe.adriel.voyager:voyager-transitions:${Versions.voyager}"

    // Moko resources
    val mokoResources = "dev.icerock.moko:resources:${Versions.mokoResources}"
    val mokoResourcesCompose = "dev.icerock.moko:resources-compose:${Versions.mokoResources}"
    val mokoGraphics = "dev.icerock.moko:graphics:${Versions.mokoGraphics}"
    val mokoResourcesGenerator = "dev.icerock.moko:resources-generator:${Versions.mokoResources}"

    // Tests
    val jUnit = "junit:junit:${Versions.jUnit}"
    val jUnitExt = "androidx.test.ext:junit:${Versions.jUnitExt}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    val composeTest = "androidx.compose.ui:ui-test-junit4"
}

object Android {
    const val applicationId = "com.micudasoftware.currencyconverter"

    const val minSdk = 26
    const val targetSdk = 34
    const val compileSdk = 34

    const val versionCode = 1
    const val versionName = "1.0.0"

    const val testInstrumentRunner = "androidx.test.runner.AndroidJUnitRunner"

    val sourceCompatibilityJava = JavaVersion.VERSION_1_8
    val targetCompatibilityJava = JavaVersion.VERSION_1_8
}
