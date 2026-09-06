# Portail de Documentation MCA Female Gender Bridge

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

## 🇫🇷 Français (French)

MCA Female Gender Bridge est un moteur de rendu de maillage 3D autonome, une passerelle d'héritage génétique et un moteur physique à ressort-amortisseur en temps réel pour les villageois de Minecraft Comes Alive (MCA Reborn).

---

## Piliers Architecturaux

- **Géométrie 3D Autonome**: Boîte de modèle 64x64 UV (`McaBreastModelBox`) attachée au torse avec texture de peau dynamique.
- **Physique Zéro Allocation**: Oscillateur harmonique amorti (`McaBreastPhysicsEngine`) sans charge GC via `ConcurrentHashMap`.
- **Hérédité Génétique**: Transmission de mère à fille (`GeneticsBridge`) avec variance de mutation de ±7,5%.
- **Suppression Bytecode**: Masquage de la poitrine statique native de MCA pour éliminer les doublons de maillage.

---

## Sélecteur de Version

| Minecraft | Mod Release | Wiki Link |
| :--- | :--- | :--- |
| **Minecraft 26.2** | `1.3.1+26.2` | [[👉 MC 26.2 Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.3.1+26.3` | [[👉 MC 26.3 Portal|26.3-Home]] |

---

## 🧭 Navigation
- [[Portail Principal|Home]]
- [[Vue d'ensemble & Architecture|fr_fr-Overview]]
- [[Matrice de Compatibilité|Version-Compatibility]]
- [[Dépannage & FAQ|Troubleshooting-and-FAQ]]
- [[Guide Développeur|Developer-Setup-and-Building]]
