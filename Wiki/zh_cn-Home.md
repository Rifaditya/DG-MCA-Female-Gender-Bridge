# MCA Female Gender Bridge 文档门户

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

## 🇨🇳 简体中文 (Simplified Chinese)

MCA Female Gender Bridge 是一个专为 Minecraft Comes Alive (MCA Reborn) 村民设计的高性能独立 3D 胸部网格渲染器、遗传特征继承桥接器以及实时弹簧阻尼运动物理引擎。

---

## 架构亮点

- **独立 3D 模型几何体**：自定义 64x64 UV 映射立方体网格 (`McaBreastModelBox`)，无缝贴合 MCA 村民躯干并映射皮肤纹理。
- **零分配弹簧阻尼物理**：基于 `ConcurrentHashMap` 的无 GC 负担运动学引擎 (`McaBreastPhysicsEngine`)，实时模拟垂直弹跳与横向摆动。
- **遗传特征继承**：母女等位基因遗传系统 (`GeneticsBridge`)，带有自然高斯突变偏差 (±7.5%)。
- **字节码网格抑制**：注入 MCA 模型类以隐藏默认静态胸部，彻底消除模型穿模与双重网格问题。

---

## 版本选择门户

| Minecraft | Mod Release | Wiki Link |
| :--- | :--- | :--- |
| **Minecraft 26.2** | `1.3.1+26.2` | [[👉 MC 26.2 Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.3.1+26.3` | [[👉 MC 26.3 Portal|26.3-Home]] |

---

## 🧭 Navigation
- [[返回主门户|Home]]
- [[概述与架构|zh_cn-Overview]]
- [[版本兼容性矩阵|Version-Compatibility]]
- [[故障排查与常见问题|Troubleshooting-and-FAQ]]
- [[开发者设置与编译构建|Developer-Setup-and-Building]]
