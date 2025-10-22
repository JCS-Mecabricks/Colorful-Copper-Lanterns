package github.jcsmecabricks.entity;

import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class BrownCopperLanternBlockEntity extends LockableBlockEntity {
    @SuppressWarnings("unchecked")
    public BrownCopperLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.BROWN_COPPER_LANTERN, blockPos, blockState);
    }
}