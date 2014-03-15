package net.electricexpansion;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.electricexpansion.blocks.BlockFluxFurnace;
import net.electricexpansion.network.PacketPipeline;
import net.electricexpansion.tiles.TileFluxFurnace;
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

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // register blocks, items etc
        GameRegistry.registerBlock(blockFluxFurnace, "FluxFurnace");
        GameRegistry.registerTileEntity(TileFluxFurnace.class, "tileFluxFurnace");
        
        //Teh fluids
        Fluids.coolantT1 = new Fluid("coolantTier1");
        FluidRegistry.registerFluid(Fluids.coolantT1);
        Fluids.coolantT1.setGaseous(true);
        Fluids.coolantT1.setViscosity(500);
        Fluids.coolantT1.setTemperature(295);
        Fluids.coolantT1.setLuminosity(0);
        Fluids.coolantT1.setDensity(100);
        Fluids.coolantT1.setUnlocalizedName("coolantTier1");
        
        Fluids.coolantT2 = new Fluid("coolantTier2");
        FluidRegistry.registerFluid(Fluids.coolantT2);
        Fluids.coolantT2.setGaseous(false);
        
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
