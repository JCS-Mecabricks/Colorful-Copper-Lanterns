package github.jcsmecabricks.mixin;

import github.jcsmecabricks.block.lantern.RedCopperLantern;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LanternBlock.class)
public abstract class LanternBlockAttachMixin {

    @Shadow @Final public static BooleanProperty HANGING;

    @Inject(method = "canSurvive", at = @At("RETURN"), cancellable = true)
    private void coloredlanterns_canPlaceAtUnderLantern(BlockState state, LevelReader world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (state.getValue(HANGING)) {
            BlockPos abovePos = pos.above();
            BlockState stateAbove = world.getBlockState(abovePos);
            boolean canAttach = stateAbove.isRedstoneConductor(world, abovePos) ||
                    stateAbove.is(Blocks.COPPER_CHAIN.waxed().unaffected()) || stateAbove.is(Blocks.IRON_CHAIN) ||
                    (stateAbove.is(Blocks.LANTERN) && !stateAbove.getValue(LanternBlock.HANGING)) ||
                    (stateAbove.getBlock() instanceof RedCopperLantern && !stateAbove.getValue(RedCopperLantern.HANGING));

            if (canAttach) {
                cir.setReturnValue(true);
            }
        }
    }
}