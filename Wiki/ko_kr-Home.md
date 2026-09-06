# MCA Female Gender Bridge 문서 포털

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

## 🇰🇷 한국어 (Korean)

MCA Female Gender Bridge는 Minecraft Comes Alive (MCA Reborn) 주민을 위한 고성능 독립 3D 가슴 메시 렌더러, 유전적 형질 상속 브리지, 그리고 실시간 스프링-댐퍼 물리 엔진입니다.

---

## 아키텍처 핵심 요약

- **독립형 3D 모델 지오메트리**: 주민 몸체에 완벽히 정렬되는 64x64 UV 매핑 큐보이드 메시 (`McaBreastModelBox`).
- **무할당(Zero-Allocation) 물리 엔진**: `ConcurrentHashMap` 기반의 GC 부하 없는 감쇠 조화 진동자 (`McaBreastPhysicsEngine`).
- **유전 형질 상속**: 자연스러운 변이폭(±7.5%)을 포함한 모계 유전 전달 시스템 (`GeneticsBridge`).
- **바이트코드 메시 억제**: 중복 메시 렌더링을 방지하기 위한 MCA 기본 정적 가슴 메시 비활성화 Mixin.

---

## 마인크래프트 버전 선택

| Minecraft | Mod Release | Wiki Link |
| :--- | :--- | :--- |
| **Minecraft 26.2** | `1.3.1+26.2` | [[👉 MC 26.2 Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.3.1+26.3` | [[👉 MC 26.3 Portal|26.3-Home]] |

---

## 🧭 Navigation
- [[메인 포털로 돌아가기|Home]]
- [[개요 및 아키텍처|ko_kr-Overview]]
- [[버전 호환성 매트릭스|Version-Compatibility]]
- [[문제 해결 및 FAQ|Troubleshooting-and-FAQ]]
- [[개발자 환경 및 빌드 가이드|Developer-Setup-and-Building]]
