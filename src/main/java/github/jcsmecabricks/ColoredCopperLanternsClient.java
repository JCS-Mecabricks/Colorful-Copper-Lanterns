package github.jcsmecabricks;

import github.jcsmecabricks.block.lantern.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import eu.pb4.polymer.core.api.item.PolymerItemUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;

public class ColoredCopperLanternsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientLifecycleEvents.CLIENT_STARTED.register(client -> initializeModels());
    }

    private void initializeModels() {
        var minecraft = Minecraft.getInstance();

        // Safe helper to get model ItemStacks
        var getStack = (ItemStack stack) -> PolymerItemUtils.getPolymerItemStack(stack,
                minecraft.getConnection().getPacketContext(),
                minecraft.level.registryAccess());

        RedCopperLantern.Model.HANGING_MODEL.get().ifPresent(stack -> getStack.apply(stack));
        RedCopperLantern.Model.STANDING_MODEL.get().ifPresent(stack -> getStack.apply(stack));

        YellowCopperLantern.Model.HANGING_MODEL.get().ifPresent(stack -> getStack.apply(stack));
        YellowCopperLantern.Model.STANDING_MODEL.get().ifPresent(stack -> getStack.apply(stack));

        GreenCopperLantern.Model.HANGING_MODEL.get().ifPresent(stack -> getStack.apply(stack));
        GreenCopperLantern.Model.STANDING_MODEL.get().ifPresent(stack -> getStack.apply(stack));

        OrangeCopperLantern.Model.HANGING_MODEL.get().ifPresent(stack -> getStack.apply(stack));
        OrangeCopperLantern.Model.STANDING_MODEL.get().ifPresent(stack -> getStack.apply(stack));

        LimeCopperLantern.Model.HANGING_MODEL.get().ifPresent(stack -> getStack.apply(stack));
        LimeCopperLantern.Model.STANDING_MODEL.get().ifPresent(stack -> getStack.apply(stack));

        CyanCopperLantern.Model.HANGING_MODEL.get().ifPresent(stack -> getStack.apply(stack));
        CyanCopperLantern.Model.STANDING_MODEL.get().ifPresent(stack -> getStack.apply(stack));

        BlueCopperLantern.Model.HANGING_MODEL.get().ifPresent(stack -> getStack.apply(stack));
        BlueCopperLantern.Model.STANDING_MODEL.get().ifPresent(stack -> getStack.apply(stack));

        LightBlueCopperLantern.Model.HANGING_MODEL.get().ifPresent(stack -> getStack.apply(stack));
        LightBlueCopperLantern.Model.STANDING_MODEL.get().ifPresent(stack -> getStack.apply(stack));

        PurpleCopperLantern.Model.HANGING_MODEL.get().ifPresent(stack -> getStack.apply(stack));
        PurpleCopperLantern.Model.STANDING_MODEL.get().ifPresent(stack -> getStack.apply(stack));

        MagentaCopperLantern.Model.HANGING_MODEL.get().ifPresent(stack -> getStack.apply(stack));
        MagentaCopperLantern.Model.STANDING_MODEL.get().ifPresent(stack -> getStack.apply(stack));

        PinkCopperLantern.Model.HANGING_MODEL.get().ifPresent(stack -> getStack.apply(stack));
        PinkCopperLantern.Model.STANDING_MODEL.get().ifPresent(stack -> getStack.apply(stack));

        BrownCopperLantern.Model.HANGING_MODEL.get().ifPresent(stack -> getStack.apply(stack));
        BrownCopperLantern.Model.STANDING_MODEL.get().ifPresent(stack -> getStack.apply(stack));

        BlackCopperLantern.Model.HANGING_MODEL.get().ifPresent(stack -> getStack.apply(stack));
        BlackCopperLantern.Model.STANDING_MODEL.get().ifPresent(stack -> getStack.apply(stack));

        DarkGrayCopperLantern.Model.HANGING_MODEL.get().ifPresent(stack -> getStack.apply(stack));
        DarkGrayCopperLantern.Model.STANDING_MODEL.get().ifPresent(stack -> getStack.apply(stack));

        LightGrayCopperLantern.Model.HANGING_MODEL.get().ifPresent(stack -> getStack.apply(stack));
        LightGrayCopperLantern.Model.STANDING_MODEL.get().ifPresent(stack -> getStack.apply(stack));

        WhiteCopperLantern.Model.HANGING_MODEL.get().ifPresent(stack -> getStack.apply(stack));
        WhiteCopperLantern.Model.STANDING_MODEL.get().ifPresent(stack -> getStack.apply(stack));
    }
}