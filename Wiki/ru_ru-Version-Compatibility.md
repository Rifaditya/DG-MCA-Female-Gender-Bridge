# Version Compatibility Matrix

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Отказ от ответственности относительно исходного кода**: Документация в этой вики отражает **текущее состояние исходного кода в репозитории**, которое может содержать недавние невыпущенные коммиты или разрабатываемые функции, опережающие общедоступные сборки на CurseForge и Modrinth.

---

## 📊 Minecraft Multi-Version Support Matrix

| Target Minecraft | Mod Release | MCA Reborn Bound | Fabric Loader | Status |
| :--- | :--- | :--- | :--- | :--- |
| **MC 26.2** | `1.3.1+26.2` | `>= 8.0.0` | `>= 0.16.0` | **Active Mainline** |
| **MC 26.3** | `1.3.1+26.3` | `>= 8.0.0` | `>= 0.19.3` | **Active Lead** |

---

## 🔒 1 Jar 1 Version Policy

MCA Female Gender Bridge strictly enforces the **1 Jar 1 Version** architectural law:
- Every compiled release artifact is built against a dedicated single target directory.
- Cross-version reflection hacks and runtime version branching inside the main jar are strictly prohibited.
- Dependency bounds in `fabric.mod.json` use open-ended lower bounds to prevent loader locks.

---

> ☕ *Заметка соло-разработчика*: Если вам нравится автономная физика и 3D-геометрия моделей жителей, поддержите разработку на [Ko-fi](https://ko-fi.com/dasikigaijin)!

---

## 🔙 Navigation

- [[Back to Central Portal|ru_ru-Home]]
- [[Troubleshooting & FAQ|ru_ru-Troubleshooting-and-FAQ]]
- [[Developer Setup & Building|ru_ru-Developer-Setup-and-Building]]
