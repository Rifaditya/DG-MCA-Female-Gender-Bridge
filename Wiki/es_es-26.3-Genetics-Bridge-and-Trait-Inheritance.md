# Genetics Bridge & Trait Inheritance (MC 26.3)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Aviso sobre el código fuente del repositorio**: La documentación de esta Wiki refleja el **estado actual del código fuente en el repositorio**, que puede incluir confirmaciones recientes o características en desarrollo no disponibles aún en CurseForge o Modrinth.

---

## 1. Official Technical Infobox
| Parameter | Specification |
| :--- | :--- |
| **Subsystem Class** | `com.dasik.mcagenderbridge.genetics.GeneticsBridge` |
| **Target Platform** | Minecraft 26.3 / MCA Reborn 8.0.0+ |
| **Random Source** | `net.minecraft.util.RandomSource.create()` |
| **Allele Range** | `[0.0f, 1.0f]` (Clamped Float) |
| **Mutation Variance** | $\pm 0.075\text{f}$ ($\pm 7.5\%$) |
| **Minimum Render Threshold** | `breastSize > 0.02f` |
| **Visual Scale Formula** | `0.7f + (breastSize * 0.5f)` |

---

## 2. Step-by-Step Player & Villager Workflow

```
[ Female Villager Mother ]            [ Male Villager Father ]
      (Gene: G_mother)                      (Male Genome)
              \                                  /
               +---------------+----------------+
                               |
                               v
                       [ Breeding Event ]
                               |
                               v
                     Is Offspring Female?
                       /              \
                    (No)              (Yes)
                     /                  \
           [ Flat Male Profile ]         v
                                 [ Mutation Step ]
                                 delta = (rand - 0.5) * 0.15
                                 G_daughter = clamp(G_mother + delta, 0.0, 1.0)
                                         |
                                         v
                                  [ Baby Phase ]
                                  Visible: FLAT
                                         |
                                         v (Reaches Adulthood)
                                  [ Adult Female ]
                                  Render: 0.7f + (G_daughter * 0.5f)
```

1. **Courtship & Child Creation**: When two villagers produce a child, MCA's breeding system triggers chromosome genetic crossover.
2. **Maternal Allele Sampling**: The daughter's initial breast size gene is derived from the mother's expressed trait $G_{\text{mother}}$.
3. **Mutation Application**: A randomized mutation variance $\Delta_{\text{mutation}}$ is calculated and added to the maternal value.
4. **Range Clamping**: The resulting daughter gene $G_{\text{daughter}}$ is strictly clamped between $0.0$ and $1.0$.
5. **Childhood Suppression**: While the offspring is a baby or child (`visuals.baby() == true`), the breast render layer suppresses mesh generation.
6. **Adult Phenotypic Expression**: Upon reaching adulthood, the 3D model box renders with scale $S_{\text{scale}} = 0.7 + (G_{\text{daughter}} \times 0.5)$.

---

## 3. Mathematical Genetics & Scaling Formulas

$$\Delta_{\text{mutation}} = (\text{rand} - 0.5) \times 0.15$$

$$G_{\text{daughter}} = \text{clamp}(G_{\text{mother}} + \Delta_{\text{mutation}},\, 0.0,\, 1.0)$$

$$S_{\text{scale}} = 0.7\text{f} + (G_{\text{daughter}} \times 0.5\text{f})$$

---

> ☕ *Nota del desarrollador*: Si disfrutas de la física autónoma y la geometría 3D para aldeanas, ¡apoya mi desarrollo independiente en [Ko-fi](https://ko-fi.com/dasikigaijin)!

---

## 🔗 Related Pages (MC 26.3)

- [[Spring-Damper Physics Engine|es_es-26.3-Spring-Damper-Physics-Engine]]
- [[Model Geometry & Render Layers|es_es-26.3-Model-Geometry-and-Render-Layers]]
- [[Architecture & Mixins|es_es-26.3-Architecture-and-Mixins]]
- Return to [[26.3 Portal Home|es_es-26.3-Home]]
