# MCA Female Gender Bridge ドキュメントポータル

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

## 🇯🇵 日本語 (Japanese)

MCA Female Gender Bridge は、Minecraft Comes Alive (MCA Reborn) の村人向けに設計された、スタンドアロンの 3D 胸部メッシュレンダラー、遺伝的形質継承ブリッジ、およびリアルタイムのバネ・ダンパー物理エンジンです。

---

## アーキテクチャの要点

- **独立した3Dモデルジオメトリ**: 村人の胴体に自然にフィットする 64x64 UV マッピングのカスタムメッシュ (`McaBreastModelBox`)。
- **ゼロアロケーション物理演算**: `ConcurrentHashMap` による GC 負荷のない減衰調和振動子エンジン (`McaBreastPhysicsEngine`)。
- **遺伝的形質継承**: 自然な変異幅 (±7.5%) を伴う母娘間の遺伝システム (`GeneticsBridge`)。
- **バイトコード抑制**: MCA 本体の静止胸部メッシュを非表示にし、モデルの重複描画を完全に防止。

---

## バージョン選択ポータル

| Minecraft | Mod Release | Wiki Link |
| :--- | :--- | :--- |
| **Minecraft 26.2** | `1.3.1+26.2` | [[👉 MC 26.2 Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.3.1+26.3` | [[👉 MC 26.3 Portal|26.3-Home]] |

---

## 🧭 Navigation
- [[メインポータルへ戻る|Home]]
- [[概要とアーキテクチャ|ja_jp-Overview]]
- [[バージョン互換性マトリクス|Version-Compatibility]]
- [[トラブルシューティングとFAQ|Troubleshooting-and-FAQ]]
- [[開発環境とビルド手順|Developer-Setup-and-Building]]
