import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.weather"
    compileSdk = 34


    defaultConfig {
        applicationId = "com.example.weather"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        //SALVAR API KEY NO LOCAL DO PC
        val properties = Properties()
        properties.load(file(rootProject.file("local.properties")).inputStream())
        buildConfigField("String", "API_KEY", "\"${properties.getProperty("API_KEY")}\"")


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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.13.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3:1.2.1")

    val activity_version = "1.9.0"
    implementation("androidx.activity:activity-ktx:$activity_version")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")

    //Network
    val retrofitVersion = "2.9.0"
    val okHttpVersion = "4.12.0"
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation ("com.squareup.okhttp3:okhttp:$okHttpVersion")
    implementation ("com.squareup.okhttp3:logging-interceptor:$okHttpVersion")
    implementation ("com.google.code.gson:gson:2.10.1")

    //LOCATION
    implementation ("com.google.android.gms:play-services-location:21.2.0")
    implementation("com.google.accompanist:accompanist-permissions:0.35.0-alpha")

    //Dagger - Hilt
    implementation ("com.google.dagger:hilt-android:2.49")
    implementation ("androidx.hilt:hilt-navigation-compose:1.2.0")
    kapt ("com.google.dagger:hilt-android-compiler:2.48.1")
    kapt ("androidx.hilt:hilt-compiler:1.2.0")


    implementation("androidx.compose.animation:animation:1.6.6")

    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
    implementation("androidx.compose.runtime:runtime-livedata:1.6.5")
    implementation("io.coil-kt:coil-compose:2.5.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

    testImplementation("io.mockk:mockk:1.12.0")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.1-Beta")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}

