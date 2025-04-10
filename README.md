# Spring Boot Kotlin Template

A modern, production-ready template for Spring Boot applications written in Kotlin. This template provides a solid foundation for building basic web applications using Spring Boot.

## 🚀 Features

- **Modern Stack**
  - Kotlin 2.1.20
  - Spring Boot 3.4.4
  - Java 21
  - Gradle with version catalog
  - YAML-based configuration

- **Development Tools**
  - JUnit 5 for testing
  - Kotlin-specific testing support
  - Strict null-safety with `-Xjsr305=strict`
  - Jackson Kotlin module for JSON handling

- **Production Ready**
  - Spring Boot Actuator for monitoring
  - Micrometer OTLP for metrics
  - Modern dependency management

## 🛠️ Technical Stack

- **Language**: Kotlin 2.1.20
- **Framework**: Spring Boot 3.4.4
- **Build Tool**: Gradle with Kotlin DSL
- **Java Version**: 21
- **Testing**: JUnit 5, Kotlin Test
- **Monitoring**: Spring Boot Actuator, Micrometer
- **Configuration**: YAML-based

## 📦 Dependencies

- Spring Boot Web
- Spring Boot Actuator
- Jackson Kotlin Module
- Kotlin Reflect
- Micrometer OTLP
- JUnit 5
- Kotlin Test JUnit5

## 🏗️ Project Structure

```
.
├── gradle/              # Gradle wrapper and configuration
├── src/                 # Source code
│   ├── main/           # Main application code
│   └── test/          # Test code
├── build.gradle.kts    # Build configuration
├── settings.gradle.kts # Project settings
└── gradle/            # Version catalog
    └── libs.versions.toml
```

## 🚀 Getting Started

1. Create a new repository from this template
2. Import into your favorite IDE
3. Run `./gradlew build` to build the project
4. Run `./gradlew bootRun` to start the application

## 🔧 Configuration

- Application properties are in YAML format
- Version management through Gradle (version catalog)[https://docs.gradle.org/current/userguide/version_catalogs.html]
- Kotlin compiler options optimized for null safety

## 🧪 Testing

- JUnit 5 test framework
- Kotlin-specific test support
- Spring Boot test utilities
- JUnit Platform Launcher for test execution

## 📊 Monitoring

- Spring Boot Actuator endpoints
- Micrometer metrics with OTLP support
- Health checks and metrics out of the box

## 🔄 CI/CD Ready

- Gradle wrapper included
- Standard project structure
- Test automation setup
- Build configuration optimized for CI/CD

 
## 🤝 Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request
 