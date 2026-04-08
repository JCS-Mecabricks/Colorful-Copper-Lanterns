package github.jcsmecabricks.entity;

import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class WhiteCopperLanternBlockEntity extends LockableBlockEntity {
    @SuppressWarnings("unchecked")
    public WhiteCopperLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.WHITE_COPPER_LANTERN, blockPos, blockState);
    }
}