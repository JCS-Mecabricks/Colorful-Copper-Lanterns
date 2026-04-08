package github.jcsmecabricks.entity;

import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class GreenCopperLanternBlockEntity extends LockableBlockEntity {
    @SuppressWarnings("unchecked")
    public GreenCopperLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.GREEN_COPPER_LANTERN, blockPos, blockState);
    }
}