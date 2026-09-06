# MCA Female Gender Bridge Dokumentationsportal

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

## 🇩🇪 Deutsch (German)

MCA Female Gender Bridge ist ein nativer 3D-Brustnetz-Renderer, genetische Merkmalsvererbungsbrücke und Echtzeit-Feder-Dämpfer-Physik-Engine für Minecraft Comes Alive (MCA Reborn) Dorfbewohner.

---

## Architektur-Säulen

- **Eigenständige 3D-Modellgeometrie**: Benutzerdefinierte 64x64 UV-Quader-Geometrie (`McaBreastModelBox`) verankert am Dorfbewohner-Torso.
- **Zero-Allocation Physik**: Gedämpfter harmonischer Oszillator (`McaBreastPhysicsEngine`) mit `ConcurrentHashMap` ohne GC-Last.
- **Genetische Vererbung**: Mutter-Tochter-Vererbung (`GeneticsBridge`) mit natürlicher Mutationsvarianz (±7,5%).
- **Bytecode-Modellunterdrückung**: Unterdrückung der statischen MCA-Standardbrust zur Vermeidung von Mesh-Überlagerungen.

---

## Versionsauswahl

| Minecraft | Mod Release | Wiki Link |
| :--- | :--- | :--- |
| **Minecraft 26.2** | `1.3.1+26.2` | [[👉 MC 26.2 Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.3.1+26.3` | [[👉 MC 26.3 Portal|26.3-Home]] |

---

## 🧭 Navigation
- [[Hauptportal|Home]]
- [[Übersicht & Architektur|de_de-Overview]]
- [[Kompatibilitätsmatrix|Version-Compatibility]]
- [[Fehlerbehebung|Troubleshooting-and-FAQ]]
- [[Entwickler-Leitfaden|Developer-Setup-and-Building]]
