plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("dev.icerock.mobile.multiplatform-resources")
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
            export(Dependencies.mokoResources)
            export(Dependencies.mokoGraphics)
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
                implementation(compose.material3)
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

                //Voyager
                implementation(Dependencies.voyagerKoin)
                implementation(Dependencies.voyagerNavigator)
                implementation(Dependencies.voyagerTransitions)

                // Moko resources
                api(Dependencies.mokoResources)
                api(Dependencies.mokoResourcesCompose)
            }
        }
        val androidMain by getting {
            dependencies {
                // Compose
                implementation(compose.uiTooling)
                implementation(compose.preview)

                // Ktor
                implementation(Dependencies.ktorAndroid)
            }
        }
        val iosMain by getting {
            dependencies {
                // Ktor
                implementation(Dependencies.ktorIos)

                // Koin
                implementation(Dependencies.koin)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        // Due to this bug, I have to declare this.
        // https://github.com/icerockdev/moko-resources/issues/510#issuecomment-1619141070
        val iosX64Main by getting {
            resources.srcDirs("build/generated/moko/iosX64Main/src")
        }
        val iosArm64Main by getting {
            resources.srcDirs("build/generated/moko/iosArm64Main/src")
        }
        val iosSimulatorArm64Main by getting {
            resources.srcDirs("build/generated/moko/iosSimulatorArm64Main/src")
        }
    }
}

android {
    namespace = Android.applicationId
    compileSdk = Android.compileSdk
    defaultConfig {
        minSdk = Android.minSdk
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
    // Due to this bug, I have to declare this.
    // https://github.com/icerockdev/moko-resources/issues/510#issuecomment-1619141070
    sourceSets {
        getByName("main").java.srcDirs("build/generated/moko/androidMain/src")
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "com.micudasoftware.currencyconverter"
    multiplatformResourcesClassName = "SharedRes"
}