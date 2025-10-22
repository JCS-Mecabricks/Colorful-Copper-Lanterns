package github.jcsmecabricks.entity;

import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class DarkGrayCopperLanternBlockEntity extends LockableBlockEntity {
    @SuppressWarnings("unchecked")
    public DarkGrayCopperLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.DARK_GRAY_COPPER_LANTERN, blockPos, blockState);
    }
}