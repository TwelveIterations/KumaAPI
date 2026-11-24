package net.blay09.mods.kuma;

import net.blay09.mods.kuma.api.*;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.Nullable;

import java.util.Objects;
import java.util.function.Predicate;

public abstract class AbstractManagedKeyMappingBuilder<T> {

    protected final Identifier id;
    protected InputBinding defaultBinding = InputBinding.none();
    @Nullable
    protected WorldInputEventHandler worldInputHandler;
    @Nullable
    protected ScreenInputEventHandler screenInputHandler;
    protected boolean keyRepeat = false;
    protected Predicate<ScreenInputEvent> screenInputPredicate = this::defaultScreenInputPredicate;
    protected Predicate<WorldInputEvent> worldInputPredicate = this::defaultWorldInputPredicate;
    protected KeyMappingStorage storage = Kuma.getDefaultStorage();

    protected AbstractManagedKeyMappingBuilder(Identifier id) {
        this.id = id;
    }

    protected abstract T self();

    public T withCustomStorage(KeyMappingStorage storage) {
        this.storage = storage;
        return self();
    }

    public T handleWorldInput(WorldInputEventHandler handler) {
        this.worldInputHandler = handler;
        return self();
    }

    public T handleScreenInput(ScreenInputEventHandler handler) {
        this.screenInputHandler = handler;
        return self();
    }

    public T enableKeyRepeat() {
        keyRepeat = true;
        return self();
    }

    public T withScreenInputPredicate(Predicate<ScreenInputEvent> predicate) {
        screenInputPredicate = Objects.requireNonNull(predicate);
        return self();
    }

    public T withWorldInputPredicate(Predicate<WorldInputEvent> predicate) {
        worldInputPredicate = Objects.requireNonNull(predicate);
        return self();
    }

    protected KeyConflictContext determineContext() {
        if (worldInputHandler != null && screenInputHandler == null) {
            return KeyConflictContext.WORLD;
        }
        if (screenInputHandler != null && worldInputHandler == null) {
            return KeyConflictContext.SCREEN;
        }
        return KeyConflictContext.UNIVERSAL;
    }

    protected boolean defaultScreenInputPredicate(ScreenInputEvent event) {
        return !(event.input() instanceof KeyEvent) || !event.screen().isInputCaptured();
    }

    protected boolean defaultWorldInputPredicate(WorldInputEvent event) {
        return true;
    }
}
