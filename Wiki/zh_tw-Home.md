# MCA Female Gender Bridge 文件門戶

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

## 🇭🇰 繁體中文 (Traditional Chinese)

MCA Female Gender Bridge 是一個專為 Minecraft Comes Alive (MCA Reborn) 村民設計的高性能獨立 3D 胸部網格渲染器、遺傳特徵繼承橋接器以及即時彈簧阻尼運動物理引擎。

---

## 架構亮點

- **獨立 3D 模型幾何體**：自訂 64x64 UV 映射立方體網格 (`McaBreastModelBox`)，無縫貼合 MCA 村民軀幹並映射皮膚紋理。
- **零分配彈簧阻尼物理**：基於 `ConcurrentHashMap` 的無 GC 負擔運動學引擎 (`McaBreastPhysicsEngine`)，即時模擬垂直彈跳與橫向擺動。
- **遺傳特徵繼承**：母女等位基因遺傳系統 (`GeneticsBridge`)，帶有自然高斯突變偏差 (±7.5%)。
- **位元組碼網格抑制**：注入 MCA 模型類以隱藏預設靜態胸部，徹底消除模型穿模與雙重網格問題。

---

## 版本選擇門戶

| Minecraft | Mod Release | Wiki Link |
| :--- | :--- | :--- |
| **Minecraft 26.2** | `1.3.1+26.2` | [[👉 MC 26.2 Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.3.1+26.3` | [[👉 MC 26.3 Portal|26.3-Home]] |

---

## 🧭 Navigation
- [[返回主門戶|Home]]
- [[概述與架構|zh_tw-Overview]]
- [[版本相容性矩陣|Version-Compatibility]]
- [[疑難排解與常見問題|Troubleshooting-and-FAQ]]
- [[開發者設定與編譯構建|Developer-Setup-and-Building]]
