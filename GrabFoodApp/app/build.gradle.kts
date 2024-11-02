plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.app.java.grabfoodappproject"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.app.java.grabfoodappproject"
        minSdk = 30
        targetSdk = 34
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
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    // thư viện Glide
    implementation(libs.glide)
    // sử dụng phiên bản okhttp3 hoặc mới hơn
    implementation(libs.okhttp)
    // bóc tách và chuyển đổi JSON với Gson
    implementation(libs.gson)
    // thư viện Retrofit2
    implementation(libs.retrofit)
    // thư viện converter của Retrofit cho Gson
    implementation(libs.converter)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.recyclerview)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}