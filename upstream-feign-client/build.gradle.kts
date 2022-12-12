import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	java
	id("org.springframework.boot") version "2.7.6"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "ru.kuramshin-dev"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

tasks.getByName<BootJar>("bootJar") {
	enabled = false
}

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "2021.0.5"

dependencies {
	implementation("io.github.openfeign:feign-httpclient:12.1")
	implementation(project(":commons"))
	implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}
