// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package com.dasik.mcagenderbridge.client;

import com.dasik.mcagenderbridge.McaFemaleGenderBridge;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

// Verified against: ClientModInitializer.java (26.2+)
@Environment(EnvType.CLIENT)
public class McaFemaleGenderBridgeClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        McaFemaleGenderBridge.LOGGER.info("[MCA Female Gender Bridge] Standalone 3D breast mesh renderer & physics layer initialized.");
    }
}
