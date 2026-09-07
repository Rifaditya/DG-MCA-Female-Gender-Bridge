# Developer Setup & Building Guide (MC 26.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Pernyataan Sumber Repositori**: Dokumentasi di Wiki ini mencerminkan **kondisi kode sumber terkini di repositori**, yang mungkin memuat komit atau fitur pengembangan yang belum dirilis di CurseForge atau Modrinth.

---

## Toolchain & Environment Specifications (MC 26.2)

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
- `build/libs/mca-female-gender-bridge-1.3.1+26.2.jar`

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

> ☕ *Catatan Pengembang Solo*: Jika Anda menyukai fisika gerak dinamis dan geometri 3D mandiri untuk warga desa perempuan, dukung pengembangan saya di [Ko-fi](https://ko-fi.com/dasikigaijin)!

---

## 🔗 Related Pages (MC 26.2)

- [[Genetics Bridge & Trait Inheritance|id_id-26.2-Genetics-Bridge-and-Trait-Inheritance]]
- [[Spring-Damper Physics Engine|id_id-26.2-Spring-Damper-Physics-Engine]]
- [[Model Geometry & Render Layers|id_id-26.2-Model-Geometry-and-Render-Layers]]
- Return to [[26.2 Portal Home|id_id-26.2-Home]]
