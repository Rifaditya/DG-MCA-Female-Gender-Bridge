// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package com.dasik.mcagenderbridge.physics;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

// Verified against: LivingEntity.java (26.2+)
public class McaBreastPhysicsEngine {

    private static final Map<UUID, EntityPhysicsState> CACHE = new ConcurrentHashMap<>();

    public static EntityPhysicsState getPhysicsState(LivingEntity entity, float targetBreastSize) {
        if (entity == null) {
            return EntityPhysicsState.DEFAULT;
        }
        EntityPhysicsState state = CACHE.computeIfAbsent(entity.getUUID(), id -> new EntityPhysicsState());
        state.update(entity, targetBreastSize);
        return state;
    }

    public static class EntityPhysicsState {
        public static final EntityPhysicsState DEFAULT = new EntityPhysicsState();

        public float positionY;
        public float positionX;
        public float bounceRotation;
        public float currentBreastSize;

        private float velocityY;
        private float velocityX;
        private float velocityRot;
        private Vec3 lastPos;

        public void update(LivingEntity entity, float targetBreastSize) {
            if (entity == null || targetBreastSize <= 0.02f) {
                this.currentBreastSize = 0.0f;
                this.positionY = 0.0f;
                this.positionX = 0.0f;
                this.bounceRotation = 0.0f;
                return;
            }

            // Smoothly interpolate size towards target
            this.currentBreastSize = Mth.lerp(0.1f, this.currentBreastSize, targetBreastSize);

            Vec3 currentPos = entity.position();
            if (lastPos == null) {
                lastPos = currentPos;
                return;
            }

            Vec3 motion = currentPos.subtract(lastPos);
            lastPos = currentPos;

            float speed = (float) motion.length();
            float vertVel = (float) motion.y;

            // Physics calculation
            float springK = 0.25f;
            float damping = 0.75f;

            float forceY = -vertVel * 2.0f - (positionY * springK);
            this.velocityY = (this.velocityY + forceY) * damping;
            this.positionY = Mth.clamp(this.positionY + this.velocityY, -0.4f, 1.2f);

            float forceX = (float) (-motion.x * 1.5f - (positionX * springK));
            this.velocityX = (this.velocityX + forceX) * damping;
            this.positionX = Mth.clamp(this.positionX + this.velocityX, -0.3f, 0.3f);

            this.bounceRotation = Mth.clamp(this.velocityY * 15.0f + (speed * 10.0f), -20.0f, 20.0f);
        }
    }
}
