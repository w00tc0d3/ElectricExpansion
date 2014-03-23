package net.electricexpansion;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.electricexpansion.blocks.BlockController;
import net.electricexpansion.blocks.BlockElectricConduit;
import net.electricexpansion.blocks.BlockFluxFurnace;
import net.electricexpansion.network.PacketPipeline;
import net.electricexpansion.tiles.TileElectricConduit;
import net.electricexpansion.tiles.TileFluxFurnace;
import net.electricexpansion.tiles.TileController;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.electricexpansion.fluids.*;

@Mod(modid = ElectricExpansion.modID, version = ElectricExpansion.VERSION)
public class ElectricExpansion {
    @Mod.Instance
    public static ElectricExpansion instance;
    public static final String modID = "ElectricExpansion";
    public static final String VERSION = "0.1-alpha";

    // packet handling
    public static final PacketPipeline packetPipeline = new PacketPipeline();

    public final static Block blockFluxFurnace = new BlockFluxFurnace().setBlockName("FluxFurnace");
    public final static Block blockElectricConduit = new BlockElectricConduit().setBlockName("ElectricConduit");
    public final static Block blockController = new BlockController().setBlockName("Controller");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // register blocks, items etc
    	
    	// Teh blocks and TileEntities
        GameRegistry.registerBlock(blockFluxFurnace, "FluxFurnace");
        GameRegistry.registerTileEntity(TileFluxFurnace.class, "tileFluxFurnace");
        GameRegistry.registerBlock(blockElectricConduit, "ElectricConduit");
        GameRegistry.registerTileEntity(TileElectricConduit.class, "tileElectricConduit");
        GameRegistry.registerBlock(blockController, "Controller");
        GameRegistry.registerTileEntity(TileController.class, "tileController");
        
        //Teh fluids
        Fluids.coolantT1 = new Fluid("coolantTier1");
        FluidRegistry.registerFluid(Fluids.coolantT1);

        Fluids.coolantT2 = new Fluid("coolantTier2");
        FluidRegistry.registerFluid(Fluids.coolantT2);
        
        Fluids.coolantT3 = new Fluid("coolantTier3");
        FluidRegistry.registerFluid(Fluids.coolantT3);
        
        Fluids.coolantT4 = new Fluid("coolantTier4");
        FluidRegistry.registerFluid(Fluids.coolantT4);
        
        // This method gives the fluids properties such as densities and stuff, mainly to not look so ugly. :p
        Fluids.registerFluids();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // localization and recipe registering
        packetPipeline.initialise();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        packetPipeline.postInitialise();
    }
}
