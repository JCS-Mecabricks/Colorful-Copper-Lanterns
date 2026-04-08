package github.jcsmecabricks.entity;

import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class BlueCopperLanternBlockEntity extends LockableBlockEntity {
    @SuppressWarnings("unchecked")
    public BlueCopperLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.BLUE_COPPER_LANTERN, blockPos, blockState);
    }
}