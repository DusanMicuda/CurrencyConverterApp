plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("plugin.serialization")
    id("org.jetbrains.compose")
}

android {
    namespace = Android.applicationId
    compileSdk = Android.compileSdk

    defaultConfig {
        applicationId = Android.applicationId
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = Android.versionCode
        versionName = Android.versionName

        testInstrumentationRunner = Android.testInstrumentRunner
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = Android.sourceCompatibilityJava
        targetCompatibility = Android.targetCompatibilityJava
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }

    packaging {
        resources.excludes.addAll(
            listOf(
                "/META-INF/{AL2.0,LGPL2.1}",
                "META-INF/INDEX.LIST"
            )
        )
    }
}

dependencies {
    implementation(project(":shared"))

    // Kotlin
    implementation(platform(Dependencies.kotlinBom))
    implementation(Dependencies.kotlinSerialization)
    implementation(Dependencies.kotlinReflect)
    implementation(Dependencies.kotlinCoroutines)

    // Android
    implementation(Dependencies.androidCore)
    implementation(Dependencies.lifecycle)
    implementation(Dependencies.activity)

    // Jetpack Compose
    implementation(platform(Dependencies.composeBom))
    implementation(Dependencies.composeUI)
    implementation(Dependencies.composeTooling)
    implementation(Dependencies.composeGraphics)
    implementation(Dependencies.composePreview)
    implementation(Dependencies.materialDesign)
    implementation(compose.material)

    // Ktor
    implementation(Dependencies.ktorCore)
    implementation(Dependencies.ktorAndroid)
    implementation(Dependencies.ktorContentNegotiation)
    implementation(Dependencies.ktorSerializationJson)
    implementation(Dependencies.ktorLogging)
    implementation(Dependencies.logback)

    // Koin
    implementation(Dependencies.koin)
    implementation(Dependencies.koinAndroid)

    // Voyager
    implementation(Dependencies.voyagerNavigator)
    implementation(Dependencies.voyagerTab)
    implementation(Dependencies.voygerBottomSheet)

    // Tests
    testImplementation(Dependencies.jUnit)
    androidTestImplementation(Dependencies.jUnitExt)
    androidTestImplementation(Dependencies.espresso)
    androidTestImplementation(platform(Dependencies.composeBom))
    androidTestImplementation(Dependencies.composeTest)
}
