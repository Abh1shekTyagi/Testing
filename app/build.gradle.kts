plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-kapt")
    id("com.google.devtools.ksp") version "1.9.21-1.0.15"
}

android {
    namespace = "com.example.testing"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.testing"
        minSdk = 24
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    dataBinding {
        enable = true
        enableForTests = true
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.test.ext:junit-ktx:1.1.5")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("androidx.test:core:1.5.0")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    testImplementation("org.hamcrest:hamcrest-library:2.2")
    testImplementation("org.robolectric:robolectric:4.11.1")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.0")
    androidTestImplementation("junit:junit:4.13.2")
    androidTestImplementation("org.robolectric:robolectric:4.11.1")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    debugImplementation("androidx.fragment:fragment-testing:1.6.2")
    androidTestImplementation("androidx.test:core:1.5.0")


    // App dependencies
    val androidXVersion = "1.0.0"
    val androidXTestCoreVersion = "1.2.0"
    val androidXTestExtKotlinRunnerVersion = "1.1.1"
    val androidXTestRulesVersion = "1.2.0-beta01"
    val androidXAnnotations = "1.7.1"
    val androidXLegacySupport = "1.0.0"
    val appCompatVersion = "1.0.2"
    val archLifecycleVersion = "2.7.0"
    val archTestingVersion = "2.0.0"
    val cardVersion = "1.0.0"
    val coroutinesVersion = "1.7.1"
    val dexMakerVersion = "2.12.1"
    val espressoVersion = "3.2.0-beta01"
    val fragmentVersion = "1.1.0-alpha07"
    val fragmentKtxVersion = "1.1.0-rc01"
    val hamcrestVersion = "1.3"
    val junitVersion = "4.12"
    val materialVersion = "1.0.0"
    val mockitoVersion = "2.8.9"
    val recyclerViewVersion = " 1.3.2"
    val robolectricVersion = "4.3.1"
    val roomVersion = "2.6.1"
    val rulesVersion = "1.0.1"
    val timberVersion = "5.0.1"
    val truthVersion = "0.44"
    val kotlinVersion = "1.3.31"
    val navigationVersion = "2.7.7"
    implementation("androidx.cardview:cardview:$cardVersion")
    implementation("androidx.recyclerview:recyclerview:$recyclerViewVersion")
    implementation("androidx.annotation:annotation:$androidXAnnotations")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")
    implementation("com.jakewharton.timber:timber:$timberVersion")
    implementation("androidx.legacy:legacy-support-v4:$androidXLegacySupport")
    implementation("androidx.room:room-runtime:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")

    // Architecture Components
    implementation("androidx.room:room-ktx:$roomVersion")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$archLifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$archLifecycleVersion")
    implementation("androidx.navigation:navigation-fragment-ktx:$navigationVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navigationVersion")
}