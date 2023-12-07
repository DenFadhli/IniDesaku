plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.citiasia.inidesakubeta"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.citiasia.inidesakubeta"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }

    buildTypes {
        release {
            buildConfigField("String", "BASE_URL", "\"https://api-gv.inidesaku.id\"")
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            buildConfigField("String", "BASE_URL", "\"https://api-gv.inidesaku.id\"")
        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    viewBinding{
        enable = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.5")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //circle image
    implementation("com.mikhaellopez:circularimageview:4.3.1")
    implementation("de.hdodenhof:circleimageview:3.1.0")

    //lottie
//    implementation "com.airbnb.android:lottie:5.2.0"

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.6")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.6")

    //glide
    implementation("com.github.bumptech.glide:glide:4.16.0")

    //coroutin
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    //live data
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")



    //shimmer
//    implementation 'com.facebook.shimmer:shimmer:0.5.0'

    //exoPlayer
    implementation ("com.google.android.exoplayer:exoplayer-core:2.19.1")
    implementation ("com.google.android.exoplayer:exoplayer-ui:2.19.1")



    //viewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation ("androidx.activity:activity-ktx:1.8.1")

    //dataStore
//    implementation "androidx.datastore:datastore-preferences:1.0.0"

    //room database
//    implementation 'androidx.room:room-runtime:2.5.1'
//    kapt 'androidx.room:room-compiler:2.5.1'
//    implementation 'androidx.room:room-ktx:2.5.1'

    //pref
    implementation ("androidx.datastore:datastore-preferences:1.0.0")

    //carousel
    implementation ("com.github.denzcoskun:ImageSlideshow:0.1.2")
}