plugins { id("com.android.application") }
android {
    namespace = "com.apollo.greendemo"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.apollo.greendemo"
        minSdk = 22
        targetSdk = 34
        versionCode = 1
        versionName = "7.0-fearless-fixed"
    }
    buildTypes { release { isMinifyEnabled = false } debug { isMinifyEnabled = false } }
    compileOptions { sourceCompatibility = JavaVersion.VERSION_17; targetCompatibility = JavaVersion.VERSION_17 }
}
dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.webkit:webkit:1.9.0")
    implementation("com.getcapacitor:core:6.0.0")
}
