# Architecture & Mixins (MC 26.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Quellcode-Hinweis**: Die Dokumentation in diesem Wiki gibt den **aktuellen Stand des Quellcodes im Repository** wieder, einschließlich unfertiger Commits und Entwicklungsfunktionen vor der offiziellen Veröffentlichung auf CurseForge und Modrinth.

---

## 1. Official Technical Infobox
| Parameter | Specification |
| :--- | :--- |
| **Root Package** | `com.dasik.mcagenderbridge` |
| **Mixin Config** | `mca_female_gender_bridge.mixins.json` |
| **Bytecode Compatibility** | `JAVA_25` |
| **Client Mixins** | 3 Classes (`PlayerEntityExtendedModelMixin`, `VillagerEntityBaseModelMCAMixin`, `VillagerLikeEntityMCARendererMixin`) |
| **Side Safety** | Strict `@Environment(EnvType.CLIENT)` separation |
| **Runtime Guard** | `ModVersionGuard.java` (ClassLoader Integrity Gate) |

---

## 2. Step-by-Step Mixin Execution & Bytecode Workflow

```
com.dasik.mcagenderbridge/
├── McaFemaleGenderBridge.java           [ModInitializer - Core entrypoint & guard check]
├── ModVersionGuard.java                 [Runtime Knot/Context ClassLoader validator]
│
├── client/
│   └── McaFemaleGenderBridgeClient.java [ClientModInitializer - Client subsystem startup]
│   └── render/
│       └── McaBreastRenderLayer.java    [Mojang RenderLayer attached to MCA renderer]
│
├── genetics/
│   └── GeneticsBridge.java              [Allele crossover & mutation calculations]
│
├── physics/
│   └── McaBreastPhysicsEngine.java      [Concurrent spring-mass-damper physics engine]
│
├── render/
│   └── McaBreastModelBox.java           [Custom 3D model box geometry & LayerDefinition]
│
└── mixin/
    ├── PlayerEntityExtendedModelMixin.java  [Suppresses MCA player static breast mesh]
    ├── VillagerEntityBaseModelMCAMixin.java [Suppresses MCA villager static breast mesh]
    └── VillagerLikeEntityMCARendererMixin.java [Attaches McaBreastRenderLayer to MCA renderer]
```

---

## 3. Bytecode Mixin Target Matrix

### 1. `PlayerEntityExtendedModelMixin`
- **Target**: `net.conczin.mca.client.model.PlayerEntityExtendedModel` (`remap = false`)
- **Shadow Fields**: `public ModelPart breasts`, `public ModelPart breastsWear`
- **Injections**:
  1. `setupAnim(AvatarRenderState state, CallbackInfo ci)` at `@At("RETURN")`
  2. `copyVisibility(HumanoidModel<?> model, CallbackInfo ci)` at `@At("RETURN")`
  3. `setAllVisible(boolean visible, CallbackInfo ci)` at `@At("RETURN")`
- **Operation**: Sets `this.breasts.visible = false` and `this.breastsWear.visible = false` across all calls.

### 2. `VillagerEntityBaseModelMCAMixin`
- **Target**: `net.conczin.mca.client.model.VillagerEntityBaseModelMCA` (`remap = false`)
- **Shadow Fields**: `public ModelPart breasts`, `public ModelPart breastsWear`
- **Injections**:
  1. `setupAnim(VillagerRenderState state, CallbackInfo ci)` at `@At("RETURN")`
- **Operation**: Suppresses static MCA breast geometry.

### 3. `VillagerLikeEntityMCARendererMixin`
- **Target**: `net.conczin.mca.client.render.VillagerLikeEntityMCARenderer` (`remap = false`)
- **Injection**: `@Inject(method = "<init>", at = @At("RETURN"))`
- **Operation**: Calls `this.addLayer(new McaBreastRenderLayer<>(this))`.

---

> ☕ *Solo-Entwickler Notiz*: Wenn dir die eigenständige Physik und 3D-Modellierung der Dorfbewohnerinnen gefällt, unterstütze mich auf [Ko-fi](https://ko-fi.com/dasikigaijin)!

---

## 🔗 Related Pages (MC 26.2)

- [[Genetics Bridge & Trait Inheritance|de_de-26.2-Genetics-Bridge-and-Trait-Inheritance]]
- [[Spring-Damper Physics Engine|de_de-26.2-Spring-Damper-Physics-Engine]]
- [[Model Geometry & Render Layers|de_de-26.2-Model-Geometry-and-Render-Layers]]
- Return to [[26.2 Portal Home|de_de-26.2-Home]]
