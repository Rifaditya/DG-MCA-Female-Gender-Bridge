# Developer Setup & Building Guide

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Quellcode-Hinweis**: Die Dokumentation in diesem Wiki gibt den **aktuellen Stand des Quellcodes im Repository** wieder, einschließlich unfertiger Commits und Entwicklungsfunktionen vor der offiziellen Veröffentlichung auf CurseForge und Modrinth.

---

## Toolchain & Environment Specifications

| Component | Minimum Version | Recommended Version | Details |
| :--- | :--- | :--- | :--- |
| **Java Development Kit (JDK)** | OpenJDK 25 | Eclipse Temurin 25 / Oracle JDK 25 | Required for bytecode level 69 (`release = 25`) |
| **Gradle** | 9.0+ | Gradle 9.3.0 | Modern Gradle with parallel task execution |
| **Fabric Loom** | 1.15.2 | 1.15.2 | Mojang mappings & subproject remapping |
| **Fabric Loader** | 0.16.10 (26.2) | 0.19.3 (26.3) | Core mod loading runtime |

---

## Workspace Setup Step-by-Step

### 1. Clone Repository
```bash
git clone https://github.com/Rifaditya/DG-MCA-Female-Gender-Bridge.git
cd DG-MCA-Female-Gender-Bridge
```

### 2. Configure JDK 25 Path
Set `org.gradle.java.home` in `gradle.properties`:
```properties
org.gradle.java.home=E:/JDK25
fabric.loom.suppressJavaCompatibilityChecks=true
loom.suppressJavaCompatibilityChecks=true
```

### 3. Build Compiled Release JAR
Execute the non-daemon Gradle build task:
```bash
./gradlew build --no-daemon
```

Compiled artifacts will be output to:
- `build/libs/mca-female-gender-bridge-1.3.1+26.2.jar` (for MC 26.2)
- `build/libs/mca-female-gender-bridge-1.3.1+26.3.jar` (for MC 26.3)

---

## Stub Compilation Architecture

```groovy
sourceSets {
    main {
        java {
            srcDirs = ['src/main/java', 'src/stub/java']
        }
    }
}
```

---

> ☕ *Solo-Entwickler Notiz*: Wenn dir die eigenständige Physik und 3D-Modellierung der Dorfbewohnerinnen gefällt, unterstütze mich auf [Ko-fi](https://ko-fi.com/dasikigaijin)!

---

## 🔙 Navigation

- [[Back to Central Portal|de_de-Home]]
- [[Version Compatibility Matrix|de_de-Version-Compatibility]]
- [[Troubleshooting & FAQ|de_de-Troubleshooting-and-FAQ]]
