# Spring-Damper Physics Engine (MC 26.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **저장소 소스 코드 면책 조항**: 본 위키 문서는 **저장소의 현재 소스 코드 상태**를 반영하며, CurseForge 및 Modrinth의 공개 릴리스 빌드보다 앞선 미출시 커밋이나 개발 중인 기능을 포함할 수 있습니다.

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

> ☕ *1인 개발자 노트*: 여성 주민을 위한 독립형 3D 지오메트리와 동적 물리 엔진이 마음에 드셨다면, [Ko-fi](https://ko-fi.com/dasikigaijin)에서 개발을 응원해 주세요!

---

## 🔗 Related Pages (MC 26.2)

- [[Genetics Bridge & Trait Inheritance|ko_kr-26.2-Genetics-Bridge-and-Trait-Inheritance]]
- [[Model Geometry & Render Layers|ko_kr-26.2-Model-Geometry-and-Render-Layers]]
- [[Architecture & Mixins|ko_kr-26.2-Architecture-and-Mixins]]
- Return to [[26.2 Portal Home|ko_kr-26.2-Home]]
