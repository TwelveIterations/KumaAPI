package net.blay09.mods.kuma.fabric;

import net.blay09.mods.kuma.api.KeyConflictContext;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Options;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FabricKeyMappingContexts {

    private static final Map<KeyMapping, KeyConflictContext> keyMappingsToContext = new ConcurrentHashMap<>();

    public static void setKeyMappingContext(KeyMapping keyMapping, KeyConflictContext context) {
        keyMappingsToContext.put(keyMapping, context);
    }

    public static KeyConflictContext getKeyMappingContext(KeyMapping keyMapping) {
        return keyMappingsToContext.get(keyMapping);
    }

    public static boolean same(KeyMapping first, KeyMapping second) {
        final var firstContext = getKeyMappingContext(first);
        final var secondContext = getKeyMappingContext(second);
        return firstContext == secondContext;
    }

    public static void initVanilla(Options options) {
        setKeyMappingContext(options.keyUp, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keyLeft, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keyDown, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keyRight, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keyJump, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keyShift, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keySprint, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keyInventory, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keySwapOffhand, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keyDrop, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keyRepeatRecipeOrTrade, KeyConflictContext.SCREEN);
        setKeyMappingContext(options.keyUse, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keyAttack, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keyPickItem, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keyChat, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keyPlayerList, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keyCommand, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keyFriends, KeyConflictContext.UNIVERSAL);
        setKeyMappingContext(options.keyOtherPlayers, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keyScreenshot, KeyConflictContext.UNIVERSAL);
        setKeyMappingContext(options.keyTogglePerspective, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keySmoothCamera, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keyFullscreen, KeyConflictContext.UNIVERSAL);
        setKeyMappingContext(options.keySpectatorOutlines, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keyAdvancements, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keyQuickActions, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keyToggleGui, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keyToggleSpectatorShaderEffects, KeyConflictContext.WORLD);
        setKeyMappingContext(options.keySpectatorHotbar, KeyConflictContext.WORLD);
        for (final var keyHotbarSlot : options.keyHotbarSlots) {
            setKeyMappingContext(keyHotbarSlot, KeyConflictContext.UNIVERSAL);
        }
        setKeyMappingContext(options.keySaveHotbarActivator, KeyConflictContext.SCREEN);
        setKeyMappingContext(options.keyLoadHotbarActivator, KeyConflictContext.SCREEN);
        setKeyMappingContext(options.keyDebugOverlay, KeyConflictContext.UNIVERSAL);
        setKeyMappingContext(options.keyDebugModifier, KeyConflictContext.UNIVERSAL);
        setKeyMappingContext(options.keyDebugCrash, KeyConflictContext.DEBUG);
        setKeyMappingContext(options.keyDebugReloadChunk, KeyConflictContext.DEBUG);
        setKeyMappingContext(options.keyDebugShowHitboxes, KeyConflictContext.DEBUG);
        setKeyMappingContext(options.keyDebugClearChat, KeyConflictContext.DEBUG);
        setKeyMappingContext(options.keyDebugShowChunkBorders, KeyConflictContext.DEBUG);
        setKeyMappingContext(options.keyDebugShowAdvancedTooltips, KeyConflictContext.DEBUG);
        setKeyMappingContext(options.keyDebugCopyRecreateCommand, KeyConflictContext.DEBUG);
        setKeyMappingContext(options.keyDebugSpectate, KeyConflictContext.DEBUG);
        setKeyMappingContext(options.keyDebugSwitchGameMode, KeyConflictContext.DEBUG);
        setKeyMappingContext(options.keyDebugDebugOptions, KeyConflictContext.DEBUG);
        setKeyMappingContext(options.keyDebugFocusPause, KeyConflictContext.DEBUG);
        setKeyMappingContext(options.keyDebugDumpDynamicTextures, KeyConflictContext.DEBUG);
        setKeyMappingContext(options.keyDebugReloadResourcePacks, KeyConflictContext.DEBUG);
        setKeyMappingContext(options.keyDebugProfiling, KeyConflictContext.DEBUG);
        setKeyMappingContext(options.keyDebugCopyLocation, KeyConflictContext.DEBUG);
        setKeyMappingContext(options.keyDebugDumpVersion, KeyConflictContext.DEBUG);
        setKeyMappingContext(options.keyDebugPofilingChart, KeyConflictContext.DEBUG);
        setKeyMappingContext(options.keyDebugFpsCharts, KeyConflictContext.DEBUG);
        setKeyMappingContext(options.keyDebugNetworkCharts, KeyConflictContext.DEBUG);
        setKeyMappingContext(options.keyDebugLightmapTexture, KeyConflictContext.DEBUG);
        setKeyMappingContext(options.keyDebugSwitchTranslucencyMode, KeyConflictContext.DEBUG);
        setKeyMappingContext(options.keyDebugEnvironmentAttributeOptions, KeyConflictContext.DEBUG);
    }
}
