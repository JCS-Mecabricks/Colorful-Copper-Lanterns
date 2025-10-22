package github.jcsmecabricks.entity;

import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class LimeCopperLanternBlockEntity extends LockableBlockEntity {
    @SuppressWarnings("unchecked")
    public LimeCopperLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.LIME_COPPER_LANTERN, blockPos, blockState);
    }
}