import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import pl.allegro.tech.build.axion.release.ReleasePlugin

class SetupPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.apply(VersioningPlugin::class.java)
        project.plugins.apply(PublishingConfigPlugin::class.java)
    }
}

class VersioningPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // Apply axion-release-plugin
        project.plugins.apply(ReleasePlugin::class.java)

        // Configure the plugin
        project.extensions.configure<pl.allegro.tech.build.axion.release.domain.VersionConfig>("scmVersion") {
            tag {
                prefix.set("v")
            }
            // Use the last tag as the version
            useHighestVersion.set(true)
            // Create a snapshot version if the code has uncommitted changes
            snapshotCreator { version, position ->
                "$version-SNAPSHOT"
            }
            // Configure how the next version is calculated when running the release task
            versionIncrementer("incrementPatch")
            // Ignore uncommitted changes when checking if the repository is clean
            ignoreUncommittedChanges.set(false)
        }
        project.version =
            project.extensions.getByType(pl.allegro.tech.build.axion.release.domain.VersionConfig::class.java).version
    }
}

class PublishingConfigPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.apply("maven-publish")
        project.extensions.configure<PublishingExtension>("publishing") {
            publications {
                register("maven", MavenPublication::class.java) {
                    from(project.components.getByName("java"))
                }
            }
            repositories {
                maven {
                    name = "GitHubPackages"
                    url = project.uri("https://maven.pkg.github.com/collaboration-tool/template-kotlin-spring")
                    credentials {
                        username = System.getenv("GITHUB_ACTOR")
                        password = System.getenv("GITHUB_TOKEN")
                    }
                }
            }
        }
    }
}
