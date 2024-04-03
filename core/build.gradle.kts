plugins {
    id(ModulePlugin.MODULE_NAME)
}

android {
    namespace = "com.raven.core"

    dataBinding.enable = true

    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    di()
    general()
    testing()
}
