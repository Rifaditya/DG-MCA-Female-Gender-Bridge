// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package com.dasik.mcagenderbridge;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Verified against: MCA.java (26.2+) and WildfireGender.java (26.2+)
public class McaFemaleGenderBridge implements ModInitializer {
    public static final String MOD_ID = "mca_female_gender_bridge";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModVersionGuard.checkClass("MCA Female Gender Bridge", "net.conczin.mca.MCA");
        ModVersionGuard.checkClass("MCA Female Gender Bridge", "com.wildfire.main.WildfireGender");

        LOGGER.info("[MCA Female Gender Bridge] Initialized successfully. Bridging MCA villager genetics with Wildfire's Female Gender Mod.");
    }
}
