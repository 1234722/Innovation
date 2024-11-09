pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        maven{
            setUrl("https://maven.aliyun.com/repository/public/")
        }
        gradlePluginPortal()
    }
}

rootProject.name = "Innovation"
include(":app")
 