package github.jcsmecabricks.entity;

import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class LightGrayCopperLanternBlockEntity extends LockableBlockEntity {
    @SuppressWarnings("unchecked")
    public LightGrayCopperLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.LIGHT_GRAY_COPPER_LANTERN, blockPos, blockState);
    }
}