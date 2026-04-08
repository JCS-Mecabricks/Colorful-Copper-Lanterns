package github.jcsmecabricks.entity;

import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class LimeCopperLanternBlockEntity extends LockableBlockEntity {
    @SuppressWarnings("unchecked")
    public LimeCopperLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.LIME_COPPER_LANTERN, blockPos, blockState);
    }
}