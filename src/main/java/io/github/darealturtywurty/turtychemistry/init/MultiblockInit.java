package io.github.darealturtywurty.turtychemistry.init;

import io.github.darealturtywurty.turtychemistry.TurtyChemistry;
import io.github.darealturtywurty.turtychemistry.block.ClayAlloyFurnaceBlock;
import io.github.darealturtywurty.turtychemistry.block.FoundryBlock;
import io.github.darealturtywurty.turtylib.TurtyLib;
import io.github.darealturtywurty.turtylib.core.multiblock.Multiblock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class MultiblockInit {
    public static final DeferredRegister<Multiblock> MULTIBLOCKS = DeferredRegister.create(
            TurtyLib.MULTIBLOCK_REGISTRY_KEY, TurtyChemistry.MODID);

    public static final RegistryObject<Multiblock> CLAY_ALLOY_FURNACE = MULTIBLOCKS.register("clay_alloy_furnace",
            () -> new Multiblock(
                    Multiblock.Builder.start()
                            .aisle("AA", "AA")
                            .aisle("AA", "AA")
                            .aisle("CC", "CB")
                            .where('A', BlockStatePredicate.forBlock(Blocks.TERRACOTTA))
                            .where('B', BlockStatePredicate.forBlock(Blocks.FLOWER_POT))
                            .where('C', BlockBehaviour.BlockStateBase::isAir)
                            .finish()
                            .controller(0, 0, 0, BlockInit.CLAY_ALLOY_FURNACE.get().defaultBlockState())
                            .useFunction(($0, level, blockPos, player, $1, $2, $3) -> ClayAlloyFurnaceBlock.use(level,
                                    blockPos, player))
            )
    );

    public static final RegistryObject<Multiblock> FOUNDRY = MULTIBLOCKS.register("foundry",
            () -> new Multiblock(
                    Multiblock.Builder.start()
                            .aisle("III","III","III")
                            .aisle("III","IAI","IEI")
                            .aisle("III","III","III")
                            .where('I',BlockStatePredicate.forBlock(Blocks.IRON_BLOCK))
                            .where('A', BlockBehaviour.BlockStateBase::isAir)
                            .where('E',BlockStatePredicate.forBlock(BlockInit.RUTHENIUM_BLOCK.get()))
                            .finish()
                            .controller(0,0,0,BlockInit.FOUNDRY_BLOCK.get().defaultBlockState())
                            .useFunction((blockState, level, blockPos, player, interactionHand, blockHitResult,
                                    vec3i) -> FoundryBlock.use(level,blockPos,player))
            ));
}
