package net.electricexpansion.blocks;

import net.electricexpansion.ElectricExpansion;
import net.electricexpansion.tiles.TileController;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockController extends Block{

	public BlockController() {
		super(Material.iron);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(ElectricExpansion.modID + ":" + "controller_all");
		setStepSound(soundTypeMetal);
		setHardness(10F);
	}
	
	@Override
	public boolean hasTileEntity(int meta) {
		return true;
	}
	
	
	public TileEntity createTileEntity(World world, int metadata) {
		return new TileController();
	}
	
}
