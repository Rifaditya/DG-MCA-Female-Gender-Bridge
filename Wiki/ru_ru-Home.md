# Портал документации MCA Female Gender Bridge

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Отказ от ответственности относительно исходного кода**: Документация в этой вики отражает **текущее состояние исходного кода в репозитории**, которое может содержать недавние невыпущенные коммиты или разрабатываемые функции, опережающие общедоступные сборки на CurseForge и Modrinth.

## Обзор и архитектура

**MCA Female Gender Bridge** — это продвинутый мод для Fabric, предоставляющий автономный рендеринг 3D-мешей, генетический мост наследования признаков и физический движок на основе пружинно-демпферной системы для жителей Minecraft Comes Alive (MCA Reborn).

Начиная с версии 1.3.0, мод является на 100% автономным и не требует сторонних модификаций пола, внедряя собственную геометрию и расчет кинематики.

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

## Выбор версии Minecraft

| Minecraft Version | Mod Release | Fabric Loader | Fabric API | Java Toolchain | Documentation Portal |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Minecraft 26.2** | `1.3.1+26.2` | `>=0.16.0` | `0.152.1+26.2` | JDK 25 (Loom 1.15.2) | [[👉 Enter MC 26.2 Wiki|ru_ru-26.2-Home]] |
| **Minecraft 26.3** | `1.3.1+26.3` | `>=0.19.3` | `0.156.1+26.3` | JDK 25 (Loom 1.15.2) | [[👉 Enter MC 26.3 Wiki|ru_ru-26.3-Home]] |

---

## Ключевые инженерные принципы

1. **Standalone 3D Model Geometry**: Custom 64x64 UV-mapped cuboid mesh (`McaBreastModelBox`).
2. **Zero-Allocation Spring-Damper Physics**: Tick-level damped harmonic oscillator (`McaBreastPhysicsEngine`).
3. **Genetic Trait Inheritance**: Biological trait inheritance bridge (`GeneticsBridge`) with Gaussian variance ($\pm 7.5\%$).
4. **Bytecode Mesh Suppression**: Clean Mixin injections suppressing legacy static breast geometry.
5. **Pre-Release Version Guard**: Robust runtime diagnostic classloader safety gate (`ModVersionGuard`).

---

> ☕ *Заметка соло-разработчика*: Если вам нравится автономная физика и 3D-геометрия моделей жителей, поддержите разработку на [Ko-fi](https://ko-fi.com/dasikigaijin)!

---

## Глобальная навигация

- [[Version Compatibility Matrix|ru_ru-Version-Compatibility]]
- [[Troubleshooting & FAQ|ru_ru-Troubleshooting-and-FAQ]]
- [[Developer Setup & Building|ru_ru-Developer-Setup-and-Building]]
