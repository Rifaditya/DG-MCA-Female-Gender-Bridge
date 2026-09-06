# Портал Документации MCA Female Gender Bridge

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

## 🇷🇺 Русский (Russian)

MCA Female Gender Bridge — это высокопроизводительный автономный 3D-рендерер сетки груди, мост генетического наследования признаков и физический движок пружинно-демпферного движения в реальном времени для жителей Minecraft Comes Alive (MCA Reborn).

---

## Архитектурные Особенности

- **Автономная 3D-геометрия**: Пользовательская сетка кубоида 64x64 UV (`McaBreastModelBox`), идеально крепящаяся к телу жителя с текстурой кожи.
- **Физика без аллокаций**: Кинематический движок (`McaBreastPhysicsEngine`) на базе `ConcurrentHashMap` без нагрузки на сборщик мусора (GC).
- **Генетическое наследование**: Система передачи признаков от матери к дочери (`GeneticsBridge`) с мутацией ±7.5%.
- **Подавление статических полигонов**: Байткод-инъекции в классы MCA для скрытия встроенной статичной груди во избежание дублирования.

---

## Выбор Версии Minecraft

| Minecraft | Mod Release | Wiki Link |
| :--- | :--- | :--- |
| **Minecraft 26.2** | `1.3.1+26.2` | [[👉 MC 26.2 Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.3.1+26.3` | [[👉 MC 26.3 Portal|26.3-Home]] |

---

## 🧭 Navigation
- [[Главный портал|Home]]
- [[Обзор и Архитектура|ru_ru-Overview]]
- [[Матрица совместимости|Version-Compatibility]]
- [[Устранение неполадок|Troubleshooting-and-FAQ]]
- [[Руководство разработчика|Developer-Setup-and-Building]]
