package github.jcsmecabricks.entity;

import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class CyanCopperLanternBlockEntity extends LockableBlockEntity {
    @SuppressWarnings("unchecked")
    public CyanCopperLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.CYAN_COPPER_LANTERN, blockPos, blockState);
    }
}