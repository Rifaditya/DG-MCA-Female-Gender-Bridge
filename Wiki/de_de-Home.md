# MCA Female Gender Bridge Dokumentationsportal

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Quellcode-Hinweis**: Die Dokumentation in diesem Wiki gibt den **aktuellen Stand des Quellcodes im Repository** wieder, einschließlich unfertiger Commits und Entwicklungsfunktionen vor der offiziellen Veröffentlichung auf CurseForge und Modrinth.

## Übersicht & Architektur

**MCA Female Gender Bridge** ist eine moderne Fabric-Mod, die eigenständiges 3D-Mesh-Rendering, genetische Vererbung und eine Echtzeit-Feder-Dämpfer-Physik für Minecraft Comes Alive (MCA Reborn) Dorfbewohnerinnen bietet.

Seit Version 1.3.0 arbeitet die Mod vollständig autark mit nativer Box-Geometrie und Physik ohne externe Abhängigkeiten.

```
+------------------------------------------------------------------------------------+
|                                MINECRAFT CLIENT                                    |
|                                                                                    |
|   +--------------------------+                  +------------------------------+   |
|   |   MCA Reborn Villagers   |                  |   MCA Female Gender Bridge   |   |
|   |  - Chromosome Genetics   |                  |  - Standalone 3D Model Box   |   |
|   |  - Visuals & Phenotypes  |                  |  - Spring-Damper Physics     |   |
|   |  - VillagerRenderState   |                  |  - McaBreastRenderLayer      |   |
|   +------------+-------------+                  +--------------+---------------+   |
|                |                                               |                   |
|                v                                               v                   |
|   [VillagerVisuals Snapshot] ---------------------> [Dynamic Mesh Scaling]         |
|   (breastSize, skin, female)                         (0.7f + breastSize * 0.5f)    |
|                                                                |                   |
|                                                                v                   |
|   [Suppress Static MCA Breasts] <----------------- [Mojang SubmitNodeCollector]    |
|   (PlayerEntityExtendedModelMixin)                  (RenderTypes.entityCutout)     |
|   (VillagerEntityBaseModelMCAMixin)                                                |
+------------------------------------------------------------------------------------+
```

---

## Minecraft-Versionsauswahl

| Minecraft Version | Mod Release | Fabric Loader | Fabric API | Java Toolchain | Documentation Portal |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Minecraft 26.2** | `1.3.1+26.2` | `>=0.16.0` | `0.152.1+26.2` | JDK 25 (Loom 1.15.2) | [[👉 Enter MC 26.2 Wiki|de_de-26.2-Home]] |
| **Minecraft 26.3** | `1.3.1+26.3` | `>=0.19.3` | `0.156.1+26.3` | JDK 25 (Loom 1.15.2) | [[👉 Enter MC 26.3 Wiki|de_de-26.3-Home]] |

---

## Zentrale Engineering-Säulen

1. **Standalone 3D Model Geometry**: Custom 64x64 UV-mapped cuboid mesh (`McaBreastModelBox`).
2. **Zero-Allocation Spring-Damper Physics**: Tick-level damped harmonic oscillator (`McaBreastPhysicsEngine`).
3. **Genetic Trait Inheritance**: Biological trait inheritance bridge (`GeneticsBridge`) with Gaussian variance ($\pm 7.5\%$).
4. **Bytecode Mesh Suppression**: Clean Mixin injections suppressing legacy static breast geometry.
5. **Pre-Release Version Guard**: Robust runtime diagnostic classloader safety gate (`ModVersionGuard`).

---

> ☕ *Solo-Entwickler Notiz*: Wenn dir die eigenständige Physik und 3D-Modellierung der Dorfbewohnerinnen gefällt, unterstütze mich auf [Ko-fi](https://ko-fi.com/dasikigaijin)!

---

## Globale Navigation

- [[Version Compatibility Matrix|de_de-Version-Compatibility]]
- [[Troubleshooting & FAQ|de_de-Troubleshooting-and-FAQ]]
- [[Developer Setup & Building|de_de-Developer-Setup-and-Building]]
