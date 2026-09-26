# Model Geometry & Render Layers (MC 26.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Pernyataan Sumber Repositori**: Dokumentasi di Wiki ini mencerminkan **kondisi kode sumber terkini di repositori**, yang mungkin memuat komit atau fitur pengembangan yang belum dirilis di CurseForge atau Modrinth.

---

## 1. Official Technical Infobox
| Parameter | Specification |
| :--- | :--- |
| **Model Box Class** | `com.dasik.mcagenderbridge.render.McaBreastModelBox` |
| **Render Layer Class** | `com.dasik.mcagenderbridge.client.render.McaBreastRenderLayer` |
| **Texture Dimensions** | $64 \times 64$ pixels |
| **UV Offset** | `(18, 20)` |
| **Box Dimensions** | Width: `8.0F`, Height: `4.0F`, Depth: `3.0F` |
| **Box Origin** | `(-4.0F, 0.0F, -2.0F)` |
| **Chest Anchor Offset** | `(0.0F, 0.12F, -0.10F)` |
| **RenderType** | `RenderTypes.entityCutout(skinTexture, false)` |
| **Submit Queue Order** | `order(1)` (Mojang `SubmitNodeCollector`) |

---

## 2. Step-by-Step Render Pipeline Execution Workflow

```
[ VillagerLikeEntityMCARenderer.render() ]
                     |
                     v
       [ McaBreastRenderLayer.submit() ]
                     |
                     v
          Pass Render Pre-Conditions?
          - renderState != null
          - visuals != null
          - visuals.female() == true
          - visuals.baby() == false
          - visuals.breastSize() > 0.02f
                     |
                     v (All Passed)
       [ Resolve Villager Skin Texture ]
       - Check visuals.skin()
       - Fallback to visuals.genderDataName() + skinIndex
                     |
                     v
       [ PoseStack Transformation ]
       1. parentModel.root().translateAndRotate(poseStack)
       2. parentModel.body.translateAndRotate(poseStack)
       3. poseStack.translate(0.0F, 0.12F, -0.10F)
       4. poseStack.scale(scale, scale, scale)
                     |
                     v
       [ Submit to SubmitNodeCollector ]
       submitNodeCollector.order(1).submitModel(
           modelBox, renderState, poseStack, renderType, packedLight, ...
       )
```

---

## 3. Mathematical Geometry & UV Coordinate Specifications

The custom model box dimensions in pixel units ($1/16$th of a block):

| Vertex Dimension | Axis | Extent | World Coordinate Span |
| :--- | :--- | :--- | :--- |
| **Width** | X-axis | $8.0\text{ pixels}$ | $-4.0\text{F}$ to $+4.0\text{F}$ |
| **Height** | Y-axis | $4.0\text{ pixels}$ | $0.0\text{F}$ to $+4.0\text{F}$ |
| **Depth** | Z-axis | $3.0\text{ pixels}$ | $-2.0\text{F}$ to $+1.0\text{F}$ |

$$\text{Offset}_{\text{anchor}} = \begin{pmatrix} 0.0\\ +0.12\\ -0.10 \end{pmatrix}, \quad S_{\text{matrix}} = 0.7 + (G_{\text{daughter}} \times 0.5)$$

---

> ☕ *Catatan Pengembang Solo*: Jika Anda menyukai fisika gerak dinamis dan geometri 3D mandiri untuk warga desa perempuan, dukung pengembangan saya di [Ko-fi](https://ko-fi.com/dasikigaijin)!

---

## 🔗 Related Pages (MC 26.2)

- [[Genetics Bridge & Trait Inheritance|id_id-26.2-Genetics-Bridge-and-Trait-Inheritance]]
- [[Spring-Damper Physics Engine|id_id-26.2-Spring-Damper-Physics-Engine]]
- [[Architecture & Mixins|id_id-26.2-Architecture-and-Mixins]]
- Return to [[26.2 Portal Home|id_id-26.2-Home]]
