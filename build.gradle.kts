plugins {
	alias(libs.plugins.kotlin.jvm)
	alias(libs.plugins.kotlin.spring)
	alias(libs.plugins.spring.boot)
	alias(libs.plugins.spring.dependency.management)
	alias(libs.plugins.axion)
}

project.afterEvaluate {
	println("Version: ${project.version}")
}

group = "ai.collaboration"

// Configure axion-release plugin
scmVersion {
	tag { prefix = "v" }
	// Use the last tag as the version
	useHighestVersion.set(true)
	// Create a snapshot version if the code has uncommitted changes
	snapshotCreator { version, _ ->
		"$version-SNAPSHOT"
	}
	// Configure how the next version is calculated when running the release task
	versionIncrementer("incrementPatch")
	// Ignore uncommitted changes when checking if the repository is clean
	ignoreUncommittedChanges.set(false)
}


java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(libs.spring.boot.actuator)
	implementation(libs.spring.boot.web)
	implementation(libs.jackson.kotlin)
	implementation(libs.kotlin.reflect)
	runtimeOnly(libs.micrometer.otlp)
	testImplementation(libs.spring.boot.test)
	testImplementation(libs.kotlin.test.junit5)
	testRuntimeOnly(libs.junit.platform.launcher)
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
