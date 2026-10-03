# Architecture & Symbol Index: MCA Female Gender Bridge

## 1. Mod Metadata & Entrypoint
- **Mod ID**: `mca_female_gender_bridge`
- **Main Entrypoint**: `com.dasik.mcagenderbridge.McaFemaleGenderBridge` (`net.fabricmc.api.ModInitializer`)
- **Client Entrypoint**: `com.dasik.mcagenderbridge.client.McaFemaleGenderBridgeClient`

## 2. Bytecode Mixin Target Registry
| Target Vanilla Class | Mixin Class | Purpose |
| :--- | :--- | :--- |
| `Minecraft` | `Mixin` | Core bytecode hook |

## 3. Core Mechanics & Subsystems
- **Source Root**: `src/main/java/`
- **Resource Root**: `src/main/resources/`

## 4. Dynamic GameRules & Commands
- **GameRules / Commands**: Configured dynamically via namespaced keys (`mca_female_gender_bridge:*`).

## 5. Configuration & Sidedness Isolation
- **Sidedness**: Server-safe logic in main, client isolated in `src/client/java` or client entrypoint.
