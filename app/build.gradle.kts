import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.wahid.moviesmleanmrchitecture"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }
    val secrets = Properties().apply {
        File(rootDir, "secretes.properties")
            .takeIf { it.exists() }
            ?.inputStream()?.use { load(it) }
    }

    defaultConfig {
        applicationId = "com.wahid.moviesmleanmrchitecture"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", secrets.getProperty("BASE-URL", ""))
            buildConfigField("String", "IMAGE_URL", secrets.getProperty("IMAGE-URL",""))
            buildConfigField("String", "BEARER_ACCESS_TOKEN", secrets.getProperty("BEARER-ACCESS-TOKEN",""))
            buildConfigField(
                "String",
                "API_KEY",
                secrets.getProperty("TMDB-API-KEY", "")
            )
        }
        debug {
            buildConfigField("String", "BASE_URL", secrets.getProperty("BASE-URL", ""))
            buildConfigField("String", "IMAGE_URL", secrets.getProperty("IMAGE-URL",""))
            buildConfigField("String", "BEARER_ACCESS_TOKEN", secrets.getProperty("BEARER-ACCESS-TOKEN",""))
            buildConfigField(
                "String",
                "API_KEY",
                secrets.getProperty("TMDB-API-KEY", "")
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.glide)
    implementation(libs.androidx.lifecycle.viewmodel.compose.android)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    //LiveData & Compose
    implementation(libs.androidx.compose.runtime.livedata)
    implementation(libs.compose)
    implementation(libs.androidx.navigation.compose)

}