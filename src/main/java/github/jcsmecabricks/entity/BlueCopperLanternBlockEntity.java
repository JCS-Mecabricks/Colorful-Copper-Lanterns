package github.jcsmecabricks.entity;

import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class BlueCopperLanternBlockEntity extends LockableBlockEntity {
    @SuppressWarnings("unchecked")
    public BlueCopperLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.BLUE_COPPER_LANTERN, blockPos, blockState);
    }
}