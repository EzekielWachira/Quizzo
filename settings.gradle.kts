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
