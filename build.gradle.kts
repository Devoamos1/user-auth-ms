plugins {
	java
	id("org.springframework.boot") version "3.1.4"
	id("io.spring.dependency-management") version "1.1.3"
}

group = "com.share"
version = "0.0.1"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	// It will handle the OAuth 2.0 authorization code grant flow, obtain access tokens from the authorization server, and use them to access protected resources.
	implementation ("org.springframework.boot:spring-boot-starter-oauth2-client")
	// If your application is acting as an authorization server:
	implementation("org.springframework.boot:spring-boot-starter-oauth2-authorization-server")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
	implementation("org.springframework.boot:spring-boot-devtools")
	implementation ("org.webjars:jquery:3.4.1")
	implementation ("org.webjars:bootstrap:4.3.1")
	implementation ("org.webjars:webjars-locator-core")
	// Spice up your java: Automatic Resource Management, automatic generation of getters, setters, equals, hashCode and toString, and more!
	compileOnly("org.projectlombok:lombok:1.18.30")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
