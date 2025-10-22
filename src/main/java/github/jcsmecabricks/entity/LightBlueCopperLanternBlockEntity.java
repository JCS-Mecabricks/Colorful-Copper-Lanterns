package github.jcsmecabricks.entity;

import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class LightBlueCopperLanternBlockEntity extends LockableBlockEntity {
    @SuppressWarnings("unchecked")
    public LightBlueCopperLanternBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.LIGHT_BLUE_COPPER_LANTERN, blockPos, blockState);
    }
}