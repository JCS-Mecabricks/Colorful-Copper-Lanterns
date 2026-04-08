package github.jcsmecabricks.entity;

import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class MagentaCopperLanternBlockEntity extends LockableBlockEntity {
    @SuppressWarnings("unchecked")
    public MagentaCopperLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.MAGENTA_COPPER_LANTERN, blockPos, blockState);
    }
}