// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.gradle)
        classpath(Dependencies.gradlePlugin)
        classpath(Dependencies.kotlinSerializationPlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
