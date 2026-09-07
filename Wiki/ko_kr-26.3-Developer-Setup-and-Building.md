# Developer Setup & Building Guide (MC 26.3)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **저장소 소스 코드 면책 조항**: 본 위키 문서는 **저장소의 현재 소스 코드 상태**를 반영하며, CurseForge 및 Modrinth의 공개 릴리스 빌드보다 앞선 미출시 커밋이나 개발 중인 기능을 포함할 수 있습니다.

---

## Toolchain & Environment Specifications (MC 26.3)

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
- `build/libs/mca-female-gender-bridge-1.3.1+26.3.jar`

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

> ☕ *1인 개발자 노트*: 여성 주민을 위한 독립형 3D 지오메트리와 동적 물리 엔진이 마음에 드셨다면, [Ko-fi](https://ko-fi.com/dasikigaijin)에서 개발을 응원해 주세요!

---

## 🔗 Related Pages (MC 26.3)

- [[Genetics Bridge & Trait Inheritance|ko_kr-26.3-Genetics-Bridge-and-Trait-Inheritance]]
- [[Spring-Damper Physics Engine|ko_kr-26.3-Spring-Damper-Physics-Engine]]
- [[Model Geometry & Render Layers|ko_kr-26.3-Model-Geometry-and-Render-Layers]]
- Return to [[26.3 Portal Home|ko_kr-26.3-Home]]
