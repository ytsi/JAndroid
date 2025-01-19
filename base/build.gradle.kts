plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.json.base"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}
dependencies {
    // Kotlin核心库
    api(libs.androidx.core.ktx)

    // Lifecycle
    api(libs.androidx.lifecycle.runtime.ktx)
    api( libs.rxlifecycle.components)
    //viewmodel
    api(libs.androidx.lifecycle.viewmodel.ktx)
    // databinging
    api(libs.androidx.databinding.runtime)

    api( libs.org.jetbrains.kotlinx.coroutines.core)
    api(  libs.org.jetbrains.kotlinx.coroutines.android)

    // Compose UI
    api(libs.androidx.activity.compose)
    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.ui)
    api(libs.androidx.ui.graphics)
    api(libs.androidx.ui.tooling.preview)

    // Material Design
    api(libs.androidx.material3)

    // AppCompat 和 Material 可能重叠，保留一个即可
    api(libs.androidx.appcompat)
    implementation(project(":http"))
    api(libs.androidx.recyclerview)
    api(libs.androidx.viewpager2)

    api(libs.utilcodex)
    api(libs.androidx.monitor)
    api(libs.android.lottie)
    implementation(libs.androidx.junit.ktx)
    testImplementation(libs.testng)
    testImplementation(libs.junit.junit)
    androidTestImplementation(libs.junit.junit)

}
