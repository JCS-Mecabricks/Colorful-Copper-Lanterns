package github.jcsmecabricks.entity;

import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class DarkGrayCopperLanternBlockEntity extends LockableBlockEntity {
    @SuppressWarnings("unchecked")
    public DarkGrayCopperLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.DARK_GRAY_COPPER_LANTERN, blockPos, blockState);
    }
}