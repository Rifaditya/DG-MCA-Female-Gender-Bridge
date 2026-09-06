# 概述与架构 (🇨🇳 简体中文 (Simplified Chinese))

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

## 概述与架构

本模组自 1.3.0 版本起完全脱离对第三方 Wildfire 模组的依赖，成为具备完全自主物理模拟与渲染管线的独立模组。

### 1. Standalone Pipeline
- **Package**: `com.dasik.mcagenderbridge`
- **Render Engine**: `McaBreastRenderLayer` + `McaBreastModelBox`
- **Physics Engine**: `McaBreastPhysicsEngine`
- **Genetics Engine**: `GeneticsBridge`
- **Safety Guard**: `ModVersionGuard`

---

## 🧭 Navigation
- [[返回主门户|Home]]
- [[🇨🇳 简体中文 (Simplified Chinese) Home|zh_cn-Home]]
- [[版本兼容性矩阵|Version-Compatibility]]
- [[故障排查与常见问题|Troubleshooting-and-FAQ]]
- [[开发者设置与编译构建|Developer-Setup-and-Building]]
- [[📦 MC 26.2 Wiki|26.2-Home]]
- [[🚀 MC 26.3 Wiki|26.3-Home]]
