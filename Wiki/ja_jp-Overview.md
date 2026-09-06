# 概要とアーキテクチャ (🇯🇵 日本語 (Japanese))

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

## 概要とアーキテクチャ

バージョン 1.3.0 以降、サードパーティ製 Wildfire mod への依存を完全に排除し、単体で動作するようになりました。

### 1. Standalone Pipeline
- **Package**: `com.dasik.mcagenderbridge`
- **Render Engine**: `McaBreastRenderLayer` + `McaBreastModelBox`
- **Physics Engine**: `McaBreastPhysicsEngine`
- **Genetics Engine**: `GeneticsBridge`
- **Safety Guard**: `ModVersionGuard`

---

## 🧭 Navigation
- [[メインポータルへ戻る|Home]]
- [[🇯🇵 日本語 (Japanese) Home|ja_jp-Home]]
- [[バージョン互換性マトリクス|Version-Compatibility]]
- [[トラブルシューティングとFAQ|Troubleshooting-and-FAQ]]
- [[開発環境とビルド手順|Developer-Setup-and-Building]]
- [[📦 MC 26.2 Wiki|26.2-Home]]
- [[🚀 MC 26.3 Wiki|26.3-Home]]
