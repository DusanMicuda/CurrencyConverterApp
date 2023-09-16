plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("org.jetbrains.compose")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //Kotlin
                implementation(platform(Dependencies.kotlinBom))
                implementation(Dependencies.kotlinSerialization)
                implementation(Dependencies.kotlinCouroutinesCore)

                // Compose
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)

                // Ktor
                implementation(Dependencies.ktorCore)
                implementation(Dependencies.ktorContentNegotiation)
                implementation(Dependencies.ktorSerializationJson)
                implementation(Dependencies.ktorLogging)
                implementation(Dependencies.logback)

                // Koin
                implementation(Dependencies.koin)
            }
        }
        val androidMain by getting {
            dependencies {
                // Ktor
                implementation(Dependencies.ktorAndroid)
            }
        }
        val iosMain by getting {
            dependencies {
                // Ktor
                implementation(Dependencies.ktorIos)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = Android.applicationId
    compileSdk = Android.compileSdk
    defaultConfig {
        minSdk = Android.minSdk
    }
}