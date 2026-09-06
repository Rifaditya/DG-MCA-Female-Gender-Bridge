# Version Compatibility Matrix

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

## Lifecycle & Compatibility Matrix

MCA Female Gender Bridge is engineered for strict version alignment with Minecraft, Fabric Loader, and MCA Reborn. Below is the comprehensive compatibility index across supported releases:

| Minecraft Version | Mod Release | Fabric Loader | Fabric API | MCA Reborn Target | Java Level | Loom Toolchain | Status |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **26.2** | `1.3.1+26.2` | `>=0.16.0` (Verified: `0.16.10`) | `0.152.1+26.2` | MCA `8.0.0+` | JDK 25 | Loom 1.15.2 | 🟢 Active Production |
| **26.3** | `1.3.1+26.3` | `>=0.19.3` (Verified: `0.19.3`) | `0.156.1+26.3` | MCA `8.0.0+` | JDK 25 | Loom 1.15.2 | 🟡 Modern Lead (Archive) |

---

## Architectural Compatibility Boundaries

### 1. Rendering Pipeline Boundaries
- **Mojang Modern Render Graph**: Fully integrated with Mojang's modern `SubmitNodeCollector` rendering architecture.
- **RenderType Requirements**: Utilizes `RenderTypes.entityCutout(texture, false)` with face culling disabled (`cull = false`) to guarantee inside and bottom faces remain visually intact during player head movement and crouching.
- **Shader Pipeline (Iris / Sodium / Canvas)**: Compatible with modern Fabric rendering engines. The custom `McaBreastRenderLayer` is registered through standard Fabric/Mojang `RenderLayer` semantics and participates normally in shadow mapping and lighting buffers (`packedLight`).

### 2. Dependency Bounds & Decoupling
- **MCA Reborn (`mca`)**: Requires MCA Reborn `8.0.0` or higher. Relies on MCA's chromosome genetic model (`net.conczin.mca.entity.ai.Genetics`) and client visuals snapshot system (`net.conczin.mca.client.render.VillagerVisuals`).
- **Wildfire Female Gender Mod**: As of version `1.3.0`, third-party dependency on Wildfire's mod has been **fully eliminated**. The bridge now runs as a completely standalone engine, preventing mod ID conflicts, duplicate physics loops, and version synchronization stalls.
- **Fabric API**: Relies on standard Fabric lifecycle events and client rendering registries.

### 3. Pre-Release Version Guard (`ModVersionGuard`)
To safeguard player worlds against corrupted states or missing runtime classes, `McaFemaleGenderBridge` incorporates a zero-dependency startup classloader validator:

```
[PRE-RELEASE / VERSION GUARD WARNING] MCA Female Gender Bridge
---------------------------------------------------------------------
CRITICAL: Incompatible Minecraft Game Runtime or Missing Class!
Required Class : net.conczin.mca.MCA
Status         : UNRESOLVED AT RUNTIME

Safety Protection:
Execution halted to prevent unreleased/incompatible build deployment
or broken world state save corruption.
```

The guard verifies classes across both `Thread.currentThread().getContextClassLoader()` and the knot module classloader before initializing rendering hooks.
