plugins {
	id("org.springframework.boot") version "3.1.5" // Your specified version
	id("io.spring.dependency-management") version "1.1.3" // Your specified version
	jacoco
	kotlin("jvm") version "1.9.10" // Adjust this to your Kotlin version
}

val lombokVersion = "1.18.30"
val springDocVersion = "2.2.0"
val springCloudVersion = "2022.0.3"

group = "com.share"
version = "0.0.1"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

jacoco {
	toolVersion = "0.8.11"
	reportsDirectory = layout.buildDirectory.dir("customJacocoReportDir")
}

repositories {
	mavenCentral()
}

dependencies {
	// Assuming that Spring Boot versions are inherited from the main Spring Boot framework,
	// so no need to specify versions for these.
	implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-authorization-server")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}")

	// Your specified versions
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:$springDocVersion")

	// Other dependencies
	implementation("org.springframework.boot:spring-boot-devtools")
	implementation("org.webjars:jquery:3.7.1")
	implementation("org.webjars:bootstrap:4.3.1")
	implementation("org.webjars:webjars-locator-core")

	// Lombok
	compileOnly("org.projectlombok:lombok:$lombokVersion")

	// Testing dependencies
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
}

tasks.test {
	useJUnitPlatform()

	testLogging {
		events("passed")
	}

	finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}

tasks.jacocoTestReport {
	dependsOn(tasks.test) // tests are required to run before generating the report

	reports {
		xml.required = false
		csv.required = false
		html.outputLocation = layout.buildDirectory.dir("jacocoHtml")
	}
}