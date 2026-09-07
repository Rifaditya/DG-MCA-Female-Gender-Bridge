# Portail de documentation MCA Female Gender Bridge

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Clause de non-responsabilité relative au code source** : La documentation de ce Wiki reflète **l'état actuel du code source dans le dépôt**, incluant d'éventuels commits récents non publiés sur CurseForge ou Modrinth.

## Vue d'ensemble & Architecture

**MCA Female Gender Bridge** est un mod Fabric avancé offrant un maillage 3D autonome, un pont d'hérédité génétique et un moteur physique ressort-amortisseur en temps réel pour les villageoises de Minecraft Comes Alive (MCA Reborn).

Depuis la version 1.3.0, le mod est 100% autonome et intègre sa propre géométrie cubique sans dépendre d'autres mods de genre.

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

## Sélecteur de version Minecraft

| Minecraft Version | Mod Release | Fabric Loader | Fabric API | Java Toolchain | Documentation Portal |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Minecraft 26.2** | `1.3.1+26.2` | `>=0.16.0` | `0.152.1+26.2` | JDK 25 (Loom 1.15.2) | [[👉 Enter MC 26.2 Wiki|fr_fr-26.2-Home]] |
| **Minecraft 26.3** | `1.3.1+26.3` | `>=0.19.3` | `0.156.1+26.3` | JDK 25 (Loom 1.15.2) | [[👉 Enter MC 26.3 Wiki|fr_fr-26.3-Home]] |

---

## Piliers d'ingénierie clés

1. **Standalone 3D Model Geometry**: Custom 64x64 UV-mapped cuboid mesh (`McaBreastModelBox`).
2. **Zero-Allocation Spring-Damper Physics**: Tick-level damped harmonic oscillator (`McaBreastPhysicsEngine`).
3. **Genetic Trait Inheritance**: Biological trait inheritance bridge (`GeneticsBridge`) with Gaussian variance ($\pm 7.5\%$).
4. **Bytecode Mesh Suppression**: Clean Mixin injections suppressing legacy static breast geometry.
5. **Pre-Release Version Guard**: Robust runtime diagnostic classloader safety gate (`ModVersionGuard`).

---

> ☕ *Note du développeur*: Si vous appréciez la physique autonome et la géométrie 3D des villageoises, soutenez mon travail sur [Ko-fi](https://ko-fi.com/dasikigaijin) !

---

## Navigation globale

- [[Version Compatibility Matrix|fr_fr-Version-Compatibility]]
- [[Troubleshooting & FAQ|fr_fr-Troubleshooting-and-FAQ]]
- [[Developer Setup & Building|fr_fr-Developer-Setup-and-Building]]
