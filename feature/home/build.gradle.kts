import ext.implementation

plugins {
    id(ModulePlugin.MODULE_NAME)
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.raven.home"
    dataBinding.enable = true

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    di()
    general()
    testing()
    network()
    room()
    navigation()

    implementation(project(":core"))
}
