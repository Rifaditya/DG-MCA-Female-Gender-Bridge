# MCA Female Gender Bridge 文件門戶

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **代碼倉庫原始碼免責聲明**：本維基文件反映了**倉庫當前的原始碼狀態**，可能包含領先於 CurseForge 與 Modrinth 上公開發布版本的最新開發提交或未發布功能。

## 概述與架構

**MCA Female Gender Bridge** 是一款先進的 Fabric 模組，為 Minecraft Comes Alive (MCA Reborn) 村民提供完全獨立的原生三維胸部網格渲染、動態遺傳性狀橋接以及即時彈簧阻尼運動物理引擎。

從 1.3.0 版本起，模組徹底脫離對任何第三方性別模組的依賴，完全內建專屬的立方體模型幾何、質點彈簧運動學解算器以及自訂渲染圖層，僅需 MCA Reborn 本身即可獨立完美運行。

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

## Minecraft 版本選擇門戶

| Minecraft Version | Mod Release | Fabric Loader | Fabric API | Java Toolchain | Documentation Portal |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Minecraft 26.2** | `1.3.1+26.2` | `>=0.16.0` | `0.152.1+26.2` | JDK 25 (Loom 1.15.2) | [[👉 Enter MC 26.2 Wiki|zh_tw-26.2-Home]] |
| **Minecraft 26.3** | `1.3.1+26.3` | `>=0.19.3` | `0.156.1+26.3` | JDK 25 (Loom 1.15.2) | [[👉 Enter MC 26.3 Wiki|zh_tw-26.3-Home]] |

---

## 核心工程支柱

1. **Standalone 3D Model Geometry**: Custom 64x64 UV-mapped cuboid mesh (`McaBreastModelBox`).
2. **Zero-Allocation Spring-Damper Physics**: Tick-level damped harmonic oscillator (`McaBreastPhysicsEngine`).
3. **Genetic Trait Inheritance**: Biological trait inheritance bridge (`GeneticsBridge`) with Gaussian variance ($\pm 7.5\%$).
4. **Bytecode Mesh Suppression**: Clean Mixin injections suppressing legacy static breast geometry.
5. **Pre-Release Version Guard**: Robust runtime diagnostic classloader safety gate (`ModVersionGuard`).

---

> ☕ *獨立開發者寄語*：如果你喜歡原生獨立的村民女性物理與三維網格表現，歡迎在 [Ko-fi](https://ko-fi.com/dasikigaijin) 上支持我的獨立開發！

---

## 全域文件導航

- [[Version Compatibility Matrix|zh_tw-Version-Compatibility]]
- [[Troubleshooting & FAQ|zh_tw-Troubleshooting-and-FAQ]]
- [[Developer Setup & Building|zh_tw-Developer-Setup-and-Building]]
