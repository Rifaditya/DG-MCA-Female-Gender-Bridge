# Portal Dokumentasi MCA Female Gender Bridge

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

## 🇮🇩 Bahasa Indonesia (Indonesian)

MCA Female Gender Bridge adalah perender mesh 3D mandiri, jembatan pewarisan sifat genetik, dan mesin fisika pegas-peredam gerak waktu nyata untuk penduduk desa Minecraft Comes Alive (MCA Reborn).

---

## Pilar Arsitektur

- **Geometri Model 3D Mandiri**: Mesh kuboid 64x64 UV (`McaBreastModelBox`) yang terpasang di torso penduduk desa dengan proyeksi tekstur kulit halus.
- **Fisika Nol-Alokasi**: Osilator harmonik teredam (`McaBreastPhysicsEngine`) berbasis `ConcurrentHashMap` tanpa beban alokasi memori GC.
- **Pewarisan Genetik**: Sistem pewarisan alel ibu-ke-anak perempuan (`GeneticsBridge`) dengan variansi mutasi alami ±7,5%.
- **Penekanan Mesh Bytecode**: Injeksi Mixin untuk menyembunyikan mesh dada statis bawaan MCA guna mencegah mesh ganda.

---

## Pilihan Versi Minecraft

| Minecraft | Mod Release | Wiki Link |
| :--- | :--- | :--- |
| **Minecraft 26.2** | `1.3.1+26.2` | [[👉 MC 26.2 Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.3.1+26.3` | [[👉 MC 26.3 Portal|26.3-Home]] |

---

## 🧭 Navigation
- [[Portal Utama|Home]]
- [[Ikhtisar & Arsitektur|id_id-Overview]]
- [[Matriks Kompatibilitas|Version-Compatibility]]
- [[Pemecahan Masalah & FAQ|Troubleshooting-and-FAQ]]
- [[Panduan Pengembang & Kompilasi|Developer-Setup-and-Building]]
