package github.jcsmecabricks.entity;

import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class BlackCopperLanternBlockEntity extends LockableBlockEntity {
    @SuppressWarnings("unchecked")
    public BlackCopperLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.BLACK_COPPER_LANTERN, blockPos, blockState);
    }
}