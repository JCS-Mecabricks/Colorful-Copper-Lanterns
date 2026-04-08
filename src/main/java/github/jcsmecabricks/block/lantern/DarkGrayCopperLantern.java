package github.jcsmecabricks.block.lantern;

import com.mojang.serialization.MapCodec;
import eu.pb4.factorytools.api.util.LazyItemStack;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import github.jcsmecabricks.ColoredCopperLanterns;
import github.jcsmecabricks.entity.DarkGrayCopperLanternBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

public class DarkGrayCopperLantern extends RedCopperLantern {
    public static final MapCodec<DarkGrayCopperLantern> CODEC = simpleCodec(DarkGrayCopperLantern::new);

    public DarkGrayCopperLantern(BlockBehaviour.Properties settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DarkGrayCopperLanternBlockEntity(pos, state);
    }

    @Override
    protected DarkGrayCopperLantern.Model createModel(BlockState initialBlockState, ServerLevel world, BlockPos pos) {
        return new DarkGrayCopperLantern.Model(initialBlockState, world, pos);
    }

    public static final class Model extends RedCopperLantern.Model {
        public static final LazyItemStack STANDING_MODEL = ItemDisplayElementUtil.getModel(Identifier.fromNamespaceAndPath(ColoredCopperLanterns.MOD_ID, "block/dark_gray_copper_lantern"));
        public static final LazyItemStack HANGING_MODEL = ItemDisplayElementUtil.getModel(Identifier.fromNamespaceAndPath(ColoredCopperLanterns.MOD_ID, "block/dark_gray_copper_hanging_lantern"));
        public static final LazyItemStack WALL_MODEL = ItemDisplayElementUtil.getModel(Identifier.fromNamespaceAndPath(ColoredCopperLanterns.MOD_ID, "block/dark_gray_copper_wall_lantern"));

        public Model(BlockState state, ServerLevel world, BlockPos pos) {
            super(state, world, pos);
        }

        @Override
        public void init(BlockState state) {
            ModelType modelType = state.getValue(MODEL_TYPE);

            LazyItemStack model = switch (modelType) {
                case HANGING -> HANGING_MODEL;
                case WALL -> WALL_MODEL;
                case STANDING -> STANDING_MODEL;
            };

            this.lantern = ItemDisplayElementUtil.createSimple(model);
            this.lantern.setScale(new Vector3f(2f));

            if (modelType == ModelType.WALL) {
                float yaw = state.getValue(FACING).toYRot();
                this.lantern.setYaw(yaw);
            }
            this.addElement(lantern);
        }
    }
}
