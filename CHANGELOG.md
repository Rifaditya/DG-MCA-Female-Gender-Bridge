# Changelog: MCA Female Gender Bridge

## [1.3.1+26.2] - 2026-07-23

### Fixed
- **VillagerVisuals Method Signature Fix**: Corrected stub `VillagerVisuals.require` signature from `EntityRenderState` to `Object` matching MCA 26.2's runtime descriptor, resolving `NoSuchMethodError` crash.

## [1.3.0+26.2] - 2026-07-23

### Added
- **Standalone Native 3D Breast Engine**: Embedded native 3D breast mesh renderer (`McaBreastModelBox`), spring-mass physics engine (`McaBreastPhysicsEngine`), and custom render layer (`McaBreastRenderLayer`) directly inside `mca_female_gender_bridge`.
- **Zero-Dependency Operation**: Removed `wildfire_gender` dependency from `fabric.mod.json`, enabling standalone operation with zero third-party mod conflicts.

## [1.2.8+26.2] - 2026-07-23

### Fixed
- **Stub Packaging Exclusion Fix**: Excluded `net/minecraft/**` stub classes from the compiled JAR artifact in `build.gradle` so stub classes never overwrite vanilla Minecraft's `RenderTypes` class, resolving the renderer crash.

## [1.2.7+26.2] - 2026-07-23

### Fixed
- **RenderTypes Method Call Fix**: Switched `RenderType.entityCutoutNoCull` to standard MC 26.2 `RenderTypes.entityCutout(texture, false)` inside `GenderLayerMixin` to prevent `NoSuchMethodError` startup crash.

## [1.2.6+26.2] - 2026-07-23

### Fixed
- **Null RenderType Override Fix**: Overrode `getRenderLayer` in `McaVillagerGenderRenderLayer` to return the MCA skin texture `RenderType` instead of inheriting MCA's base renderer `null` return. This unlocks 3D breast mesh rendering for all MCA female villagers.

## [1.2.5+26.2] - 2026-07-23

### Fixed
- **3D Breast Geometry Rendering**: Injected `config.tickBreastPhysics(villager)` inside `GeneticsBridge` to initialize `BreastPhysics.breastSize` above `0.02f` before `GenderRenderState` snapshot creation, enabling 3D breast mesh rendering on MCA female villagers and character editor preview models.

## [1.2.4+26.2] - 2026-07-23

### Fixed
- **Performance Optimization & 3D Breast Rendering**: Created `EntityConfigAccessor` to directly set `gender`, `pBustSize`, and `breastPhysics` on MCA villager `EntityConfig` instances without triggering heavy object allocations or file updates every frame. Resolved FPS lag and enabled 3D breast rendering.

## [1.2.3+26.2] - 2026-07-23

### Fixed
- **Mixin Descriptor Crash in `extractRenderState`**: Updated `VillagerLikeEntityMCARendererMixin` target method parameter from `VillagerEntityMCA` to `Mob` to match generic bytecode erasure.

## [1.2.2+26.2] - 2026-07-23

### Fixed
- **3D Breast Rendering on MCA Villagers**: Registered Wildfire Female Gender Mod's `GenderLayer` onto MCA's `VillagerLikeEntityMCARenderer` and injected `EntityConfig.isSupportedEntity` mixin to enable 3D breast physics rendering on MCA female villagers.

## [1.2.1+26.2] - 2026-07-23

### Fixed
- **Mixin Injection Descriptor Crash**: Fixed `VillagerEntityBaseModelMCAMixin` method descriptor by switching injection parameter from vanilla `VillagerRenderState` to MCA's `net.conczin.mca.client.render.VillagerRenderState`.

## [1.2.0+26.2] - 2026-07-23

### ⚠️ Version Guard Notice
- Includes zero-dependency `ModVersionGuard` pre-release protection. Halts startup with an explicit warning banner if run on incompatible Minecraft drops or missing core dependencies (`mca`, `wildfire_gender`) to prevent world save corruption.

### Added
- **Unified MCA GUI Integration**: MCA's character editor (`VillagerEditorScreen` & `DestinyScreen`) is now the single unified GUI, featuring integrated **`Shape`**, **`Physics`**, and **`Audio & Options`** sub-tabs under the `Body` section.
- **2-Way Hereditary Genetics Engine**: MCA genetics engine now treats all Wildfire parameters (Size 0–200%, Separation, Height, Depth, Rotation) as hereditary genes passed from mother to daughter with natural ±5–10% mutation variance.
- **Age-Appropriate Development**: Flat breast rendering for Babies/Children, gradual development for Teens, and full maturity for Adults.
- **Configurable Physics LOD Quality**: Added LOD quality options (`Performance`, `Balanced`, `Ultra`) for large villages.

### Fixed
- **Doubled Breasts Elimination**: Suppressed MCA's built-in static 3D breast mesh (`breasts.visible = false`), ensuring Wildfire's 3D breast model serves as the single clean renderer with full physics and texture wrapping.

### ⚠️ Version Guard Notice
- Includes zero-dependency `ModVersionGuard` pre-release protection. Halts startup with an explicit warning banner if run on incompatible Minecraft drops or missing core dependencies (`mca`, `wildfire_gender`) to prevent world save corruption.

### Fixed
- **ModVersionGuard ClassLoader Patch**: Updated `ModVersionGuard.java` to resolve target classes via `Thread.currentThread().getContextClassLoader()` for Knot ClassLoader integration.

## [1.1.1+26.2] - 2026-07-22

### Fixed
- **Wildcard Mod Dependencies**: Switched community mod dependencies (`"mca"`, `"wildfire_gender"`) in `fabric.mod.json` to wildcard `"*"` bounds.

## [1.1.0+26.2] - 2026-07-22

### Added
- **2x Expanded Slider Limits Feature**: Injected `FloatConfigKeyMixin` to double maximum slider limits.

## [1.0.0+26.2] - 2026-07-22

### Added
- Initial release of MCA Female Gender Bridge Addon.
