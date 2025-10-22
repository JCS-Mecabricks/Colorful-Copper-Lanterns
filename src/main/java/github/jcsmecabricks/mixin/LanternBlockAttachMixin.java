package github.jcsmecabricks.mixin;

import github.jcsmecabricks.block.lantern.RedCopperLantern;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LanternBlock;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LanternBlock.class)
public abstract class LanternBlockAttachMixin {

    @Shadow @Final public static BooleanProperty HANGING;

    @Inject(method = "canPlaceAt", at = @At("RETURN"), cancellable = true)
    private void coloredlanterns_canPlaceAtUnderLantern(BlockState state, WorldView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (state.get(HANGING)) {
            BlockPos abovePos = pos.up();
            BlockState stateAbove = world.getBlockState(abovePos);
            boolean canAttach = stateAbove.isSolidBlock(world, abovePos) ||
                    stateAbove.isOf(Blocks.COPPER_CHAINS.unaffected()) || stateAbove.isOf(Blocks.IRON_CHAIN) ||
                    (stateAbove.isOf(Blocks.LANTERN) && !stateAbove.get(LanternBlock.HANGING)) ||
                    (stateAbove.getBlock() instanceof RedCopperLantern && !stateAbove.get(RedCopperLantern.HANGING));

            if (canAttach) {
                cir.setReturnValue(true);
            }
        }
    }
}