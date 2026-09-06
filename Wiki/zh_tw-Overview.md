# 概述與架構 (🇭🇰 繁體中文 (Traditional Chinese))

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

## 概述與架構

本模組自 1.3.0 版本起完全脫離對第三方 Wildfire 模組的依賴，成為具備完全自主物理模擬與渲染管線的獨立模組。

### 1. Standalone Pipeline
- **Package**: `com.dasik.mcagenderbridge`
- **Render Engine**: `McaBreastRenderLayer` + `McaBreastModelBox`
- **Physics Engine**: `McaBreastPhysicsEngine`
- **Genetics Engine**: `GeneticsBridge`
- **Safety Guard**: `ModVersionGuard`

---

## 🧭 Navigation
- [[返回主門戶|Home]]
- [[🇭🇰 繁體中文 (Traditional Chinese) Home|zh_tw-Home]]
- [[版本相容性矩陣|Version-Compatibility]]
- [[疑難排解與常見問題|Troubleshooting-and-FAQ]]
- [[開發者設定與編譯構建|Developer-Setup-and-Building]]
- [[📦 MC 26.2 Wiki|26.2-Home]]
- [[🚀 MC 26.3 Wiki|26.3-Home]]
