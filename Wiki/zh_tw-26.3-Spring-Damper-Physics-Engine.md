# Spring-Damper Physics Engine (MC 26.3)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **代碼倉庫原始碼免責聲明**：本維基文件反映了**倉庫當前的原始碼狀態**，可能包含領先於 CurseForge 與 Modrinth 上公開發布版本的最新開發提交或未發布功能。

---

## 1. Official Technical Infobox
| Parameter | Specification |
| :--- | :--- |
| **Physics Engine Class** | `com.dasik.mcagenderbridge.physics.McaBreastPhysicsEngine` |
| **State Cache** | `ConcurrentHashMap<UUID, EntityPhysicsState>` |
| **Spring Constant ($k$)** | `0.25f` |
| **Damping Factor ($c$)** | `0.75f` |
| **Vertical Velocity Multiplier** | `2.0f` |
| **Horizontal Velocity Multiplier** | `1.5f` |
| **Vertical Clamp Range** | `[-0.4f, +1.2f]` |
| **Horizontal Clamp Range** | `[-0.3f, +0.3f]` |
| **Rotation Clamp Range** | `[-20.0f, +20.0f]` (Degrees) |
| **Size Interpolation (Lerp)** | `0.1f` per tick |

---

## 2. Step-by-Step Physics Update Workflow

```
[ Client Entity Tick / Render Frame ]
                 |
                 v
   [ Query McaBreastPhysicsEngine ]
   getPhysicsState(entity, targetBreastSize)
                 |
                 v
      Is Entity or Target <= 0.02f?
         /               \
      (Yes)              (No)
       /                   \
[ Reset State to 0 ]        v
                    [ Motion Delta Calculation ]
                    motion = currentPos - lastPos
                    speed = |motion|
                    vertVel = motion.y
                           |
                           v
                    [ Spring-Damper Numerical Integration ]
                    forceY = -vertVel * 2.0 - (posY * springK)
                    velocityY = (velocityY + forceY) * damping
                    posY = clamp(posY + velocityY, -0.4, 1.2)
                           |
                           v
                    [ Lateral & Rotational Coupling ]
                    forceX = -motion.x * 1.5 - (posX * springK)
                    velocityX = (velocityX + forceX) * damping
                    posX = clamp(posX + velocityX, -0.3, 0.3)
                    rot = clamp(velocityY * 15.0 + speed * 10.0, -20.0, 20.0)
                           |
                           v
                    [ Apply to PoseStack Matrix ]
```

---

## 3. Mathematical Kinematics & Numerical Integration

$$F_y = -v_y \times 2.0 - (y \times k)$$

$$v_y' = (v_y + F_y) \times c$$

$$y' = \text{clamp}(y + v_y',\, -0.4,\, 1.2)$$

$$\theta_{\text{rot}} = \text{clamp}(v_y' \times 15.0 + |\vec{v}| \times 10.0,\, -20.0^\circ,\, 20.0^\circ)$$

---

> ☕ *獨立開發者寄語*：如果你喜歡原生獨立的村民女性物理與三維網格表現，歡迎在 [Ko-fi](https://ko-fi.com/dasikigaijin) 上支持我的獨立開發！

---

## 🔗 Related Pages (MC 26.3)

- [[Genetics Bridge & Trait Inheritance|zh_tw-26.3-Genetics-Bridge-and-Trait-Inheritance]]
- [[Model Geometry & Render Layers|zh_tw-26.3-Model-Geometry-and-Render-Layers]]
- [[Architecture & Mixins|zh_tw-26.3-Architecture-and-Mixins]]
- Return to [[26.3 Portal Home|zh_tw-26.3-Home]]
