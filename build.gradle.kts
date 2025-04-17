/*
 * Copyright (C) 2024  Tete
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

plugins {
    `java-library`
    `maven-publish`
}

group = project.property("maven_group") as String
version = project.property("version") as String

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("org.jetbrains:annotations:24.0.0")
    implementation("org.apache.commons:commons-lang3:3.12.0")
}

tasks.test {
    useJUnitPlatform()
}

java {
    withSourcesJar()
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/${System.getenv("GITHUB_USERNAME")}/${project.property("archives_base_name") as String}")
            credentials {
                username = System.getenv("GITHUB_USERNAME") ?: throw RuntimeException("Github username environment variable is null")
                password = System.getenv("GITHUB_MAVEN_TOKEN") ?: throw RuntimeException("Github Maven token environment variable is null")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            groupId = "com.trs"
            artifactId = project.property("archives_base_name") as String
            version = project.version as String

            from(components["java"])

            pom {
                name = "Qlang"
                description = "A Overly complicated regex rapper"
                url = "http://www.github.com/tetex7/qlang"
            }
        }
    }
}