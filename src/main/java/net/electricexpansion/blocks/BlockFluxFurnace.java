package net.electricexpansion.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.electricexpansion.ElectricExpansion;
import net.electricexpansion.tiles.TileFluxFurnace;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockFluxFurnace extends Block {
    @SideOnly(Side.CLIENT)
    private IIcon topIcon;
    @SideOnly(Side.CLIENT)
    private IIcon frontIcon;
    @SideOnly(Side.CLIENT)
    private IIcon otherIcon;

    public BlockFluxFurnace() {
        super(Material.iron);
        this.setCreativeTab(CreativeTabs.tabBlock);
        setStepSound(Block.soundTypeStone);
        setHardness(10.0F);
    }

    @Override
    public boolean hasTileEntity(int meta) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileFluxFurnace();
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase livingBase, ItemStack itemStack) {
        super.onBlockPlacedBy(world, x, y, z, livingBase, itemStack);

        ForgeDirection[] orientationTable = { ForgeDirection.SOUTH,
                ForgeDirection.WEST, ForgeDirection.NORTH, ForgeDirection.EAST };
        int orientationIndex = MathHelper
                .floor_double((livingBase.rotationYaw + 45.0) / 90.0) & 3;

        // ForgeDirection direction = ForgeDirection.getOrientation(MathHelper.floor_double(livingBase.rotationYaw * 4.0F / 360.0F + 0.5D) & 3);
        world.setBlockMetadataWithNotify(x, y, z, orientationTable[orientationIndex].getOpposite().ordinal(), 1);
    }	

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        frontIcon = iconRegister.registerIcon(ElectricExpansion.modID + ":" + "fluxfurnace_front");
        topIcon = iconRegister.registerIcon(ElectricExpansion.modID + ":" + "fluxfurnace_top");
        otherIcon = iconRegister.registerIcon(ElectricExpansion.modID + ":" + "fluxfurnace_side");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (meta == 0 && side == 3)
            return frontIcon;
        if (side == meta && side > 1)
            return frontIcon;

        return topIcon;
    }
}
