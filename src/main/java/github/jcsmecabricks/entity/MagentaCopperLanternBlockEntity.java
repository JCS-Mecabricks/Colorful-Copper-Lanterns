package github.jcsmecabricks.entity;

import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class MagentaCopperLanternBlockEntity extends LockableBlockEntity {
    @SuppressWarnings("unchecked")
    public MagentaCopperLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.MAGENTA_COPPER_LANTERN, blockPos, blockState);
    }
}