# Portal de Documentação do MCA Female Gender Bridge

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

## 🇧🇷 Português (Portuguese)

MCA Female Gender Bridge é um renderizador 3D autônomo, ponte de herança genética e motor de física de movimento com mola e amortecimento em tempo real para aldeões do Minecraft Comes Alive (MCA Reborn).

---

## Pilares Arquiteturais

- **Geometria 3D Autônoma**: Modelo customizado em 64x64 UV (`McaBreastModelBox`) ancorado no tronco do aldeão com textura de pele.
- **Física Zero-Allocation**: Oscilador harmônico amortecido (`McaBreastPhysicsEngine`) utilizando `ConcurrentHashMap` sem sobrecarga de GC.
- **Herança Genética**: Transmissão mãe-filha (`GeneticsBridge`) com variação de mutação de ±7,5%.
- **Supressão de Malha Bytecode**: Injeções Mixin para ocultar os seios estáticos padrão do MCA.

---

## Seletor de Versão

| Minecraft | Mod Release | Wiki Link |
| :--- | :--- | :--- |
| **Minecraft 26.2** | `1.3.1+26.2` | [[👉 MC 26.2 Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.3.1+26.3` | [[👉 MC 26.3 Portal|26.3-Home]] |

---

## 🧭 Navigation
- [[Portal Principal|Home]]
- [[Visão Geral e Arquitetura|pt_br-Overview]]
- [[Matriz de Compatibilidade|Version-Compatibility]]
- [[Solução de Problemas|Troubleshooting-and-FAQ]]
- [[Guia do Desenvolvedor|Developer-Setup-and-Building]]
