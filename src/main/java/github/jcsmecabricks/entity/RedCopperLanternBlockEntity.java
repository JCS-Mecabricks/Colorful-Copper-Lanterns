package github.jcsmecabricks.entity;

import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class RedCopperLanternBlockEntity extends LockableBlockEntity {
    @SuppressWarnings("unchecked")
    public RedCopperLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.RED_COPPER_LANTERN, blockPos, blockState);
    }
}