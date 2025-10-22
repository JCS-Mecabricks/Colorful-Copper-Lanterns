package github.jcsmecabricks.entity;

import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class PinkCopperLanternBlockEntity extends LockableBlockEntity {
    @SuppressWarnings("unchecked")
    public PinkCopperLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.PINK_COPPER_LANTERN, blockPos, blockState);
    }
}