package github.jcsmecabricks.entity;

import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class WhiteCopperLanternBlockEntity extends LockableBlockEntity {
    @SuppressWarnings("unchecked")
    public WhiteCopperLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.WHITE_COPPER_LANTERN, blockPos, blockState);
    }
}