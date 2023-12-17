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
