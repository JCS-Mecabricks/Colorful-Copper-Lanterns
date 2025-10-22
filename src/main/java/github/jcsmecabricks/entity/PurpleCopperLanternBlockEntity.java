package github.jcsmecabricks.entity;

import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class PurpleCopperLanternBlockEntity extends LockableBlockEntity {
    @SuppressWarnings("unchecked")
    public PurpleCopperLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.PURPLE_COPPER_LANTERN, blockPos, blockState);
    }
}