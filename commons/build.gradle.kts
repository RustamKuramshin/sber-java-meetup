plugins {
    java
}

group = "ru.kuramshin"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-core:2.13.3")
    implementation ("com.fasterxml.jackson.core:jackson-annotations:2.13.3")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.13.3")

    implementation("jakarta.validation:jakarta.validation-api:2.0.2")

    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")
}