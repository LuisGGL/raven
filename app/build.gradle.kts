import config.ProjectConfig

plugins {
    id(AppPlugin.PLUGIN_APP)
}

android {
    namespace = ProjectConfig.appId

    dataBinding.enable = true
}

dependencies {
    di()
    general()
    testing()
    navigation()

    implementation(project(":core"))
    implementation(project(":feature:home"))
    implementation(project(":feature:news"))
    implementation(project(":common:network"))
}
