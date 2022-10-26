@file:Suppress("UnstableApiUsage")

rootProject.name = "AndroidProjectTemplate"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

buildCache {
    local {
        removeUnusedEntriesAfterDays = 7
    }
}

include(
    ":data",
    ":domain",
    ":presentation",
)
