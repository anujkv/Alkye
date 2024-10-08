plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.sonarqube)
    id("com.google.devtools.ksp")
//    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.net.alkye"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.net.alkye"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //Navigation
    implementation(libs.androidx.navigation.compose)

    //Room
    implementation (libs.androidx.room.paging)
    implementation (libs.androidx.room.ktx)
//    ksp("androidx.room:room-compiler:2.6.1")
    ksp (libs.ksp.room.compiler)

    //Hilt
    implementation (libs.com.google.dagger.hilt)
    implementation (libs.androidx.hilt.navigation.compose)
    ksp (libs.ksp.hilt.compiler)
    ksp (libs.ksp.androidx.hilt.compiler)

    //Retrofit
    implementation (libs.com.squareup.retrofit)
    implementation (libs.com.squareup.converter.gson)
    implementation (libs.com.squareup.okhttp)
    implementation (libs.com.squareup.logging.interceptor)

    //Coil
    implementation (libs.io.coil.coil.compose)

    // In build.gradle, add the dependency for MockWebServer
    testImplementation (libs.mockwebserver)
}