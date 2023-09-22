pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/carlosgub/kotlinm-charts")

            credentials {
                username = "EzekielWachira"
                password = "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"
            }
        }
    }
}

rootProject.name = "Quizzo"
include(":app")
include(":data")
