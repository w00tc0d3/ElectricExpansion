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
