package github.jcsmecabricks.util;

import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import eu.pb4.polymer.core.api.block.PolymerBlock;
import net.fabricmc.fabric.api.networking.v1.context.PacketContext;
import net.minecraft.world.level.block.state.BlockState;

public interface TransparentTripWire extends PolymerBlock, PolymerTexturedBlock {
    BlockState TRANSPARENT_TRIPWIRE = PolymerBlockResourceUtils.requestEmpty(BlockModelType.TRIPWIRE);
    @Override
    default BlockState getPolymerBlockState(BlockState blockState, PacketContext packetContext) {
        return TRANSPARENT_TRIPWIRE;
    }
}
