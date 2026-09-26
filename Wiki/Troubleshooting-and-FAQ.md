# Troubleshooting & Frequently Asked Questions

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

## Frequently Asked Questions (FAQ)

### Q1: Do I need Wildfire's Female Gender Mod installed?
**No.** Starting in version `1.3.0`, MCA Female Gender Bridge is **100% standalone**. It includes its own native 3D breast mesh box, spring-mass physics solver, and render layer. You only need MCA Reborn and Fabric API installed.

### Q2: Why are breasts flat on baby and child villagers?
This is an intentional gameplay and anatomical design choice enforced in `McaBreastRenderLayer.java`:
```java
if (visuals.baby() || !visuals.female()) {
    return;
}
```
Baby and child villagers do not render 3D chest geometry. Full developmental maturation occurs once villagers reach adulthood.

### Q3: Why did MCA female villagers previously display "doubled" breasts?
In earlier addon builds (v1.0.0–v1.2.0), MCA's built-in static breast mesh was rendered simultaneously with external model layers. Version 1.3.0 resolves this permanently by injecting bytecode suppressions into `PlayerEntityExtendedModelMixin` and `VillagerEntityBaseModelMCAMixin`:
```java
@Inject(method = "setupAnim", at = @At("RETURN"))
private void mcagenderbridge$suppressMcaVillagerBreasts(VillagerRenderState state, CallbackInfo ci) {
    if (this.breasts != null) {
        this.breasts.visible = false;
    }
}
```

---

## Technical Troubleshooting Guide

### 1. Missing or Invisible Breasts on Adult Female Villagers
If an adult female villager does not render 3D chest geometry, verify the following diagnostic checklist:

```
                  [ Inspect Villager in Game ]
                               |
                               v
                     Is Villager Female?
                       /             \
                    (No)             (Yes)
                     /                 \
       [ Normal: Male = Flat ]          v
                               Is Villager Adult?
                                 /            \
                              (No)            (Yes)
                               /                \
                [ Normal: Child = Flat ]         v
                                        Is breastSize > 0.02f?
                                          /               \
                                       (No)               (Yes)
                                        /                   \
                        [ Flat Gene Trait ]      [ Check Shader / Texture ]
```

1. **Genetic Trait Threshold**: If the inherited genetic trait (`breastSize`) is below or equal to 0.02f, the rendering pipeline treats the villager as naturally flat-chested to save draw calls.
2. **Skin Texture Integrity**: If custom resource pack skins are used, ensure textures match the 64x64 format with valid UV coordinates at `(18, 20)`.

### 2. Shader & Iris/Sodium Compatibility
- **Issue**: Mesh appears fully black or translucent with certain shaderpacks.
- **Cause**: Shaders applying aggressive backface culling or expecting specialized entity cutout buffers.
- **Solution**: The bridge uses `RenderTypes.entityCutout(skinTexture, false)`. Ensure your shaderpack has entity shadow casting enabled and does not override cutout alphas below 0.1.

### 3. ClassLoader Diagnostics & Post-Mortem Log Analysis
During development of version 1.3.1, two historical crashes were diagnosed and resolved:
1. **`NoSuchMethodError` on `VillagerVisuals.require`**: Resolved by updating the compile stub descriptor to `Object` matching MCA's runtime bytecode erasure.
2. **Vanilla `RenderTypes` Stub Overwrite**: Compile-time stubs in `src/stub/java` previously leaked into the compiled JAR. The `build.gradle` packaging task was patched to strictly exclude stubs:
   ```groovy
   jar {
       exclude '**/stub/**'
       exclude 'net/conczin/**'
       exclude 'com/wildfire/**'
       exclude 'net/minecraft/**'
   }
   ```
