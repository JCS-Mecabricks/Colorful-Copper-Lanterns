package github.jcsmecabricks.block.lantern;

import com.mojang.serialization.MapCodec;
import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import github.jcsmecabricks.ColoredCopperLanterns;
import github.jcsmecabricks.entity.RedCopperLanternBlockEntity;
import github.jcsmecabricks.registry.config.ColorfulCopperLanternsConfig;
import github.jcsmecabricks.util.TransparentTripWire;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import xyz.nucleoid.packettweaker.PacketContext;

//Credit to the Colorful Lanterns mod code to help make this mod.
public class RedCopperLantern extends BlockWithEntity implements TransparentTripWire, FactoryBlock, BlockEntityProvider {
    public static final BooleanProperty HANGING = Properties.HANGING;
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    public static final EnumProperty<ModelType> MODEL_TYPE = EnumProperty.of("model_type", ModelType.class);
    public static final MapCodec<RedCopperLantern> CODEC = createCodec(RedCopperLantern::new);
    private RedCopperLantern.Model model;

    public enum ModelType implements StringIdentifiable {
        STANDING("standing"),
        HANGING("hanging"),
        WALL("wall");

        private final String name;

        ModelType(String name) {
            this.name = name;
        }

        @Override
        public String asString() {
            return this.name;
        }
    }

    public RedCopperLantern(Settings settings) {
        super(settings
                .nonOpaque()
                .luminance(state -> 15)
        );
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(HANGING, false)
                .with(FACING, Direction.NORTH)
                .with(MODEL_TYPE, ModelType.STANDING));
    }

    protected RedCopperLantern(Settings settings, boolean isSubclass) {
        super(settings
                .nonOpaque()
                .luminance(state -> 15)
        );
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(HANGING, false)
                .with(FACING, Direction.NORTH)
                .with(MODEL_TYPE, ModelType.STANDING));
    }

    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, PacketContext context) {
        return Blocks.COPPER_LANTERNS.unaffected().getDefaultState();
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        World world = ctx.getWorld();
        BlockPos pos = ctx.getBlockPos();
        Direction playerFacing = ctx.getHorizontalPlayerFacing().getOpposite();
        Direction clickedFace = ctx.getSide();

        if (ColorfulCopperLanternsConfig.get().PolyDecorationsLanterns && clickedFace.getAxis().isHorizontal()) {
            BlockState wallState = this.getDefaultState()
                    .with(HANGING, false)
                    .with(FACING, clickedFace)
                    .with(MODEL_TYPE, ModelType.WALL);
            if (wallState.canPlaceAt(world, pos)) {
                return wallState;
            }
        }

        // Hanging
        if (clickedFace == Direction.DOWN) {
            BlockState hangingState = this.getDefaultState()
                    .with(HANGING, true)
                    .with(FACING, playerFacing)
                    .with(MODEL_TYPE, ModelType.HANGING);
            if (hangingState.canPlaceAt(world, pos)) {
                return hangingState;
            }
        }

        // Standing
        BlockState standingState = this.getDefaultState()
                .with(HANGING, false)
                .with(FACING, playerFacing)
                .with(MODEL_TYPE, ModelType.STANDING);
        return standingState.canPlaceAt(world, pos) ? standingState : null;
    }


    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        ModelType modelType = state.get(MODEL_TYPE);
        Direction facing = state.get(FACING);
        if (modelType == ModelType.HANGING) {
            return Block.sideCoversSmallSquare(world, pos.up(), Direction.DOWN);
        } else if (modelType == ModelType.WALL) {
            return Block.sideCoversSmallSquare(world, pos.offset(facing.getOpposite()), facing);
        } else {
            return Block.sideCoversSmallSquare(world, pos.down(), Direction.UP);
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        if (!state.canPlaceAt(world, pos)) {
            if (world instanceof World actualWorld) {
                actualWorld.scheduleBlockTick(pos, this, 1);
            }
        }
        return super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!this.canPlaceAt(state, world, pos)) {
            world.breakBlock(pos, true);
        }
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state, PacketContext context) {
        boolean isHanging = state.get(HANGING);
        return Blocks.COPPER_LANTERNS.unaffected().getDefaultState().with(net.minecraft.state.property.Properties.HANGING, isHanging);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RedCopperLanternBlockEntity(pos, state);
    }

    @Override
    protected void onStateReplaced(BlockState state, ServerWorld world, BlockPos pos, boolean moved) {
        ItemScatterer.onStateReplaced(state, world, pos);
        super.onStateReplaced(state, world, pos, moved);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HANGING, FACING, MODEL_TYPE);
        super.appendProperties(builder);
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        model = createModel(initialBlockState, world, pos);
        return model;
    }

    @Override
    public boolean tickElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        this.model.tick();
        return true;
    }

    protected RedCopperLantern.Model createModel(BlockState initialBlockState, ServerWorld world, BlockPos pos) {
        return new RedCopperLantern.Model(initialBlockState, world, pos);
    }

    public static class Model extends BlockModel {
        public static final ItemStack STANDING_MODEL = ItemDisplayElementUtil.getModel(Identifier.of(ColoredCopperLanterns.MOD_ID, "block/red_copper_lantern"));
        public static final ItemStack HANGING_MODEL = ItemDisplayElementUtil.getModel(Identifier.of(ColoredCopperLanterns.MOD_ID, "block/red_copper_hanging_lantern"));
        public static final ItemStack WALL_MODEL = ItemDisplayElementUtil.getModel(Identifier.of(ColoredCopperLanterns.MOD_ID, "block/red_copper_wall_lantern"));
        public ItemDisplayElement lantern;
        public ServerWorld world;
        public BlockPos pos;

        public Model(BlockState state, ServerWorld world, BlockPos pos) {
            this.world = world;
            this.pos = pos;
            init(state);
        }

        public void init(BlockState state) {
            ModelType modelType = state.get(MODEL_TYPE);
            Direction facing = state.get(FACING);

            ItemStack model = switch (modelType) {
                case HANGING -> HANGING_MODEL;
                case WALL -> WALL_MODEL;
                case STANDING -> STANDING_MODEL;
            };

            this.lantern = ItemDisplayElementUtil.createSimple(model);
            this.lantern.setScale(new Vector3f(2f));

            if (modelType == ModelType.WALL) {
                float yaw = facing.getPositiveHorizontalDegrees();
                this.lantern.setYaw(yaw);
            }
            this.addElement(lantern);
        }
    }
}
