# Troubleshooting & Frequently Asked Questions

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **リポジトリソースコードに関する免責事項**: 本Wikiドキュメントは**リポジトリの最新ソースコード状態**を反映しており、CurseForgeやModrinthで公開されているリリース版に含まれない開発中機能を含む場合があります。

---

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

1. **Genetic Trait Threshold**: If `breastSize <= 0.02f`, the pipeline treats the villager as naturally flat-chested to save draw calls.

---

> ☕ *個人開発者ノート*: 村人女性のスタンドアロン3Dメッシュと動的物理演算を気に入っていただけたら、ぜひ [Ko-fi](https://ko-fi.com/dasikigaijin) でのご支援をお願いします！

---

## 🔙 Navigation

- [[Back to Central Portal|ja_jp-Home]]
- [[Version Compatibility Guide|ja_jp-Version-Compatibility]]
- [[Developer Setup & Building|ja_jp-Developer-Setup-and-Building]]
