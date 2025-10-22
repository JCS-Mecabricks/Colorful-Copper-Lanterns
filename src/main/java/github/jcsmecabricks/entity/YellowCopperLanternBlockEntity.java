package github.jcsmecabricks.entity;

import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class YellowCopperLanternBlockEntity extends LockableBlockEntity {
    @SuppressWarnings("unchecked")
    public YellowCopperLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.YELLOW_COPPER_LANTERN, blockPos, blockState);
    }
}