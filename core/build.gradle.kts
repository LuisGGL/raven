plugins {
    id(ModulePlugin.MODULE_NAME)
}

android {
    namespace = "com.raven.core"

    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    di()
    general()
    testing()
}
