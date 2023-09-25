// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.gradle)
        classpath(Dependencies.gradlePlugin)
        classpath(Dependencies.kotlinSerializationPlugin)
        classpath(Dependencies.mokoResourcesGenerator)
        classpath(Dependencies.atomicfu)
    }
}

allprojects {
    allprojects {
        apply(plugin = "kotlinx-atomicfu")
    }
    repositories {
        google()
        mavenCentral()
    }
}