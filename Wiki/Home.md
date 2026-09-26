# MCA Female Gender Bridge Documentation Portal

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

## Overview & Architecture

**MCA Female Gender Bridge** is an advanced Fabric mod that provides a standalone 3D breast mesh renderer, dynamic trait inheritance bridge, and real-time spring-damper movement physics engine for Minecraft Comes Alive (MCA Reborn) villagers.

Originally developed as an integration bridge between MCA Reborn and Wildfire's Female Gender Mod, version 1.3.0 and above transitioned into a fully native, standalone architecture. It embeds its own custom model box geometry, spring-mass kinematics engine, and custom rendering layer with zero third-party dependencies beyond MCA Reborn itself.

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

## Minecraft Version Selector Portal

Select your target Minecraft version anchor below to navigate to dedicated, isolated documentation trees:

| Minecraft Version | Mod Release | Fabric Loader | Fabric API | Java Toolchain | Documentation Portal |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Minecraft 26.2** | `1.3.1+26.2` | `>=0.16.0` | `0.152.1+26.2` | JDK 25 (Loom 1.15.2) | [[👉 Enter MC 26.2 Wiki|26.2-Home]] |
| **Minecraft 26.3** | `1.3.1+26.3` | `>=0.19.3` | `0.156.1+26.3` | JDK 25 (Loom 1.15.2) | [[👉 Enter MC 26.3 Wiki|26.3-Home]] |

---

## Core Engineering Pillars

1. **Standalone 3D Model Geometry**: Custom 64x64 UV-mapped cuboid mesh (`McaBreastModelBox`) that anchors directly onto the MCA villager torso with seamless skin texture projection.
2. **Zero-Allocation Spring-Damper Physics**: Tick-level damped harmonic oscillator (`McaBreastPhysicsEngine`) simulating vertical bounce and lateral sway while caching entity vectors in thread-safe concurrent storage without GC overhead.
3. **Genetic Trait Inheritance**: Biological trait inheritance bridge (`GeneticsBridge`) propagating chest size phenotypes from mother to daughter with natural Gaussian mutation variance ($\pm 7.5\%$).
4. **Bytecode Mesh Suppression**: Clean Mixin injections into MCA model classes suppressing legacy static breast geometry to eliminate model clipping and doubled meshes.
5. **Pre-Release Version Guard**: Robust runtime diagnostic classloader safety gate (`ModVersionGuard`) preventing save corruption when loading on unsupported game drops.

---

## Global Documentation Navigation

- **Compatibility Matrix**: [[Version Compatibility Guide|Version-Compatibility]]
- **Troubleshooting & FAQs**: [[Rendering & Pipeline Diagnostics|Troubleshooting-and-FAQ]]
- **Developer Environment**: [[Gradle & Loom Toolchain Setup|Developer-Setup-and-Building]]
- **MC 26.2 Isolated Tree**: [[MC 26.2 Documentation Portal|26.2-Home]]
- **MC 26.3 Isolated Tree**: [[MC 26.3 Documentation Portal|26.3-Home]]
