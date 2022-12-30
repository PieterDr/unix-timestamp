plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.11.0"
}

group = "com.ramusthastudio.plugin"
version = "4.1.1"

repositories {
    mavenCentral()
    maven("https://www.jetbrains.com/intellij-repository/releases")
    maven("https://cache-redirector.jetbrains.com/intellij-dependencies")
}

dependencies {
    testImplementation("org.mockito:mockito-core:4.8.0")
    testImplementation("junit:junit:4.13.2")
}

// Configure Gradle IntelliJ Plugin - read more: https://github.com/JetBrains/gradle-intellij-plugin
intellij {
    // https://www.jetbrains.com/idea/download/other.html
    version.set("2022.3")
    type.set("IU") // Target IDE Platform

    plugins.set(listOf(
        "com.intellij.java",
        "com.intellij.css",
        "com.intellij.database",
        "org.jetbrains.kotlin",
        "JavaScript",
        "org.jetbrains.plugins.vue:223.7571.233",
    ))
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    // https://plugins.jetbrains.com/docs/marketplace/product-versions-in-use-statistics.html
    patchPluginXml {
        sinceBuild.set("213.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }

    runPluginVerifier {
        ideVersions.set(
            listOf(
                "IU-2022.3",
                "IU-2022.2.4",
                "IU-2022.1.4"
            ))
    }

}
