# MCA Female Gender Bridge 문서 포털

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **저장소 소스 코드 면책 조항**: 본 위키 문서는 **저장소의 현재 소스 코드 상태**를 반영하며, CurseForge 및 Modrinth의 공개 릴리스 빌드보다 앞선 미출시 커밋이나 개발 중인 기능을 포함할 수 있습니다.

## 개요 및 아키텍처

**MCA Female Gender Bridge**는 Minecraft Comes Alive (MCA Reborn) 여성 주민을 위해 독립형 3D 메시 렌더러, 동적 형질 유전 브리지, 실시간 스프링-댐퍼 운동 물리 엔진을 제공하는 고급 패브릭 모드입니다.

버전 1.3.0부터 외부 모드 의존성을 전면 배제하고 자체 모델 지오메트리와 질량-스프링 물리 솔버를 내장하여 완전한 단독 아키텍처로 동작합니다.

```
+------------------------------------------------------------------------------------+
|                                MINECRAFT CLIENT                                    |
|                                                                                    |
|   +--------------------------+                  +------------------------------+   |
|   |   MCA Reborn Villagers   |                  |   MCA Female Gender Bridge   |   |
|   |  - Chromosome Genetics   |                  |  - Standalone 3D Model Box   |   |
|   |  - Visuals & Phenotypes  |                  |  - Spring-Damper Physics     |   |
|   |  - VillagerRenderState   |                  |  - McaBreastRenderLayer      |   |
|   +------------+-------------+                  +--------------+---------------+   |
|                |                                               |                   |
|                v                                               v                   |
|   [VillagerVisuals Snapshot] ---------------------> [Dynamic Mesh Scaling]         |
|   (breastSize, skin, female)                         (0.7f + breastSize * 0.5f)    |
|                                                                |                   |
|                                                                v                   |
|   [Suppress Static MCA Breasts] <----------------- [Mojang SubmitNodeCollector]    |
|   (PlayerEntityExtendedModelMixin)                  (RenderTypes.entityCutout)     |
|   (VillagerEntityBaseModelMCAMixin)                                                |
+------------------------------------------------------------------------------------+
```

---

## 마인크래프트 버전 선택 포털

| Minecraft Version | Mod Release | Fabric Loader | Fabric API | Java Toolchain | Documentation Portal |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Minecraft 26.2** | `1.3.1+26.2` | `>=0.16.0` | `0.152.1+26.2` | JDK 25 (Loom 1.15.2) | [[👉 Enter MC 26.2 Wiki|ko_kr-26.2-Home]] |
| **Minecraft 26.3** | `1.3.1+26.3` | `>=0.19.3` | `0.156.1+26.3` | JDK 25 (Loom 1.15.2) | [[👉 Enter MC 26.3 Wiki|ko_kr-26.3-Home]] |

---

## 핵심 엔지니어링 기둥

1. **Standalone 3D Model Geometry**: Custom 64x64 UV-mapped cuboid mesh (`McaBreastModelBox`).
2. **Zero-Allocation Spring-Damper Physics**: Tick-level damped harmonic oscillator (`McaBreastPhysicsEngine`).
3. **Genetic Trait Inheritance**: Biological trait inheritance bridge (`GeneticsBridge`) with Gaussian variance ($\pm 7.5\%$).
4. **Bytecode Mesh Suppression**: Clean Mixin injections suppressing legacy static breast geometry.
5. **Pre-Release Version Guard**: Robust runtime diagnostic classloader safety gate (`ModVersionGuard`).

---

> ☕ *1인 개발자 노트*: 여성 주민을 위한 독립형 3D 지오메트리와 동적 물리 엔진이 마음에 드셨다면, [Ko-fi](https://ko-fi.com/dasikigaijin)에서 개발을 응원해 주세요!

---

## 글로벌 문서 내비게이션

- [[Version Compatibility Matrix|ko_kr-Version-Compatibility]]
- [[Troubleshooting & FAQ|ko_kr-Troubleshooting-and-FAQ]]
- [[Developer Setup & Building|ko_kr-Developer-Setup-and-Building]]
