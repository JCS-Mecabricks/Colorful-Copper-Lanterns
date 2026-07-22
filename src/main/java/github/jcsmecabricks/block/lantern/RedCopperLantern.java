package github.jcsmecabricks.block.lantern;

import com.mojang.serialization.MapCodec;
import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.factorytools.api.util.LazyItemStack;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import github.jcsmecabricks.ColoredCopperLanterns;
import github.jcsmecabricks.entity.RedCopperLanternBlockEntity;
import github.jcsmecabricks.registry.config.ColorfulCopperLanternsConfig;
import github.jcsmecabricks.util.TransparentTripWire;
import net.fabricmc.fabric.api.networking.v1.context.PacketContext;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.Containers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

//Credit to the Colorful Lanterns mod code to help make this mod.
public class RedCopperLantern extends BaseEntityBlock implements TransparentTripWire, FactoryBlock, EntityBlock {
    public static final BooleanProperty HANGING = BlockStateProperties.HANGING;
    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final EnumProperty<ModelType> MODEL_TYPE = EnumProperty.create("model_type", ModelType.class);
    public static final MapCodec<RedCopperLantern> CODEC = simpleCodec(RedCopperLantern::new);
    private RedCopperLantern.Model model;

    public enum ModelType implements StringRepresentable {
        STANDING("standing"),
        HANGING("hanging"),
        WALL("wall");

        private final String name;

        ModelType(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }

    public RedCopperLantern(Properties settings) {
        super(settings
                .noOcclusion()
                .lightLevel(state -> 15)
        );
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(HANGING, false)
                .setValue(FACING, Direction.NORTH)
                .setValue(MODEL_TYPE, ModelType.STANDING));
    }

    protected RedCopperLantern(Properties settings, boolean isSubclass) {
        super(settings
                .noOcclusion()
                .lightLevel(state -> 15)
        );
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(HANGING, false)
                .setValue(FACING, Direction.NORTH)
                .setValue(MODEL_TYPE, ModelType.STANDING));
    }

    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, PacketContext context) {
        return Blocks.COPPER_LANTERN.waxed().unaffected().defaultBlockState();
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Level world = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        Direction playerFacing = ctx.getHorizontalDirection().getOpposite();
        Direction clickedFace = ctx.getClickedFace();

        if (ColorfulCopperLanternsConfig.get().PolyDecorationsLanterns && clickedFace.getAxis().isHorizontal()) {
            BlockState wallState = this.defaultBlockState()
                    .setValue(HANGING, false)
                    .setValue(FACING, clickedFace)
                    .setValue(MODEL_TYPE, ModelType.WALL);
            if (wallState.canSurvive(world, pos)) {
                return wallState;
            }
        }

        // Hanging
        if (clickedFace == Direction.DOWN) {
            BlockState hangingState = this.defaultBlockState()
                    .setValue(HANGING, true)
                    .setValue(FACING, playerFacing)
                    .setValue(MODEL_TYPE, ModelType.HANGING);
            if (hangingState.canSurvive(world, pos)) {
                return hangingState;
            }
        }

        // Standing
        BlockState standingState = this.defaultBlockState()
                .setValue(HANGING, false)
                .setValue(FACING, playerFacing)
                .setValue(MODEL_TYPE, ModelType.STANDING);
        return standingState.canSurvive(world, pos) ? standingState : null;
    }


    @Override
    protected boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        ModelType modelType = state.getValue(MODEL_TYPE);
        Direction facing = state.getValue(FACING);
        if (modelType == ModelType.HANGING) {
            return Block.canSupportCenter(world, pos.above(), Direction.DOWN);
        } else if (modelType == ModelType.WALL) {
            return Block.canSupportCenter(world, pos.relative(facing.getOpposite()), facing);
        } else {
            return Block.canSupportCenter(world, pos.below(), Direction.UP);
        }
    }

    @Override
    public BlockState updateShape(BlockState state, LevelReader world, ScheduledTickAccess tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        if (!state.canSurvive(world, pos)) {
            if (world instanceof Level actualWorld) {
                actualWorld.scheduleTick(pos, this, 1);
            }
        }
        return super.updateShape(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (!this.canSurvive(state, world, pos)) {
            world.destroyBlock(pos, true);
        }
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state, @org.jspecify.annotations.Nullable PacketContext packetContext) {
        boolean isHanging = state.getValue(HANGING);
        return Blocks.COPPER_LANTERN.waxed().unaffected().defaultBlockState().setValue(BlockStateProperties.HANGING, isHanging);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new RedCopperLanternBlockEntity(pos, state);
    }

    @Override
    protected void affectNeighborsAfterRemoval(BlockState state, ServerLevel world, BlockPos pos, boolean moved) {
        Containers.updateNeighboursAfterDestroy(state, world, pos);
        super.affectNeighborsAfterRemoval(state, world, pos, moved);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HANGING, FACING, MODEL_TYPE);
        super.createBlockStateDefinition(builder);
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerLevel world, BlockPos pos, BlockState initialBlockState) {
        model = createModel(initialBlockState, world, pos);
        return model;
    }

    @Override
    public boolean tickElementHolder(ServerLevel world, BlockPos pos, BlockState initialBlockState) {
        this.model.tick();
        return true;
    }

    protected RedCopperLantern.Model createModel(BlockState initialBlockState, ServerLevel world, BlockPos pos) {
        return new RedCopperLantern.Model(initialBlockState, world, pos);
    }

    public static class Model extends BlockModel {
        public static final LazyItemStack STANDING_MODEL = ItemDisplayElementUtil.getModel(Identifier.fromNamespaceAndPath(ColoredCopperLanterns.MOD_ID, "block/red_copper_lantern"));
        public static final LazyItemStack HANGING_MODEL = ItemDisplayElementUtil.getModel(Identifier.fromNamespaceAndPath(ColoredCopperLanterns.MOD_ID, "block/red_copper_hanging_lantern"));
        public static final LazyItemStack WALL_MODEL = ItemDisplayElementUtil.getModel(Identifier.fromNamespaceAndPath(ColoredCopperLanterns.MOD_ID, "block/red_copper_wall_lantern"));
        public ItemDisplayElement lantern;
        public ServerLevel world;
        public BlockPos pos;

        public Model(BlockState state, ServerLevel world, BlockPos pos) {
            this.world = world;
            this.pos = pos;
            init(state);
        }

        public void init(BlockState state) {
            ModelType modelType = state.getValue(MODEL_TYPE);
            Direction facing = state.getValue(FACING);

            LazyItemStack model = switch (modelType) {
                case HANGING -> HANGING_MODEL;
                case WALL -> WALL_MODEL;
                case STANDING -> STANDING_MODEL;
            };

            this.lantern = ItemDisplayElementUtil.createSimple(model);
            this.lantern.setScale(new Vector3f(2f));

            if (modelType == ModelType.WALL) {
                float yaw = facing.toYRot();
                this.lantern.setYaw(yaw);
            }
            this.addElement(lantern);
        }
    }
}
