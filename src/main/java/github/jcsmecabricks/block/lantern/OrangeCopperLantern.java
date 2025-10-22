package github.jcsmecabricks.block.lantern;

import com.mojang.serialization.MapCodec;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import github.jcsmecabricks.ColoredCopperLanterns;
import github.jcsmecabricks.entity.OrangeCopperLanternBlockEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

public class OrangeCopperLantern extends RedCopperLantern {
    public static final MapCodec<OrangeCopperLantern> CODEC = createCodec(OrangeCopperLantern::new);

    public OrangeCopperLantern(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new OrangeCopperLanternBlockEntity(pos, state);
    }

    @Override
    protected OrangeCopperLantern.Model createModel(BlockState initialBlockState, ServerWorld world, BlockPos pos) {
        return new OrangeCopperLantern.Model(initialBlockState, world, pos);
    }

    public static final class Model extends RedCopperLantern.Model {
        public static final ItemStack STANDING_MODEL = ItemDisplayElementUtil.getModel(Identifier.of(ColoredCopperLanterns.MOD_ID, "block/orange_copper_lantern"));
        public static final ItemStack HANGING_MODEL = ItemDisplayElementUtil.getModel(Identifier.of(ColoredCopperLanterns.MOD_ID, "block/orange_copper_hanging_lantern"));
        public static final ItemStack WALL_MODEL = ItemDisplayElementUtil.getModel(Identifier.of(ColoredCopperLanterns.MOD_ID, "block/orange_copper_wall_lantern"));

        public Model(BlockState state, ServerWorld world, BlockPos pos) {
            super(state, world, pos);
        }

        @Override
        public void init(BlockState state) {
            ModelType modelType = state.get(MODEL_TYPE);

            ItemStack model = switch (modelType) {
                case HANGING -> HANGING_MODEL;
                case WALL -> WALL_MODEL;
                case STANDING -> STANDING_MODEL;
            };

            this.lantern = ItemDisplayElementUtil.createSimple(model);
            this.lantern.setScale(new Vector3f(2f));

            if (modelType == ModelType.WALL) {
                float yaw = state.get(FACING).getPositiveHorizontalDegrees();
                this.lantern.setYaw(yaw);
            }
            this.addElement(lantern);
        }
    }
}
