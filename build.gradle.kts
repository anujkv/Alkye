// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.sonarqube) apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.12" apply false

    // SonarQube plugin
//    id("org.sonarqube") version "2.7.1" apply false
}