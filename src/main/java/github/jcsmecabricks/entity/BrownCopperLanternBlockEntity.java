package github.jcsmecabricks.entity;

import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class BrownCopperLanternBlockEntity extends LockableBlockEntity {
    @SuppressWarnings("unchecked")
    public BrownCopperLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.BROWN_COPPER_LANTERN, blockPos, blockState);
    }
}