package net.electricexpansion.blocks;

        import cpw.mods.fml.relauncher.Side;
        import cpw.mods.fml.relauncher.SideOnly;
        import net.electricexpansion.ElectricExpansion;
        import net.minecraft.block.Block;
        import net.minecraft.block.material.Material;
        import net.minecraft.client.renderer.texture.IIconRegister;
        import net.minecraft.creativetab.CreativeTabs;
        import net.minecraft.tileentity.TileEntity;
        import net.minecraft.util.IIcon;
        import net.minecraft.world.World;
        import net.electricexpansion.tiles.TileElectricConduit;

public class BlockElectricConduit extends Block {

    public BlockElectricConduit() {
        super(Material.iron);
        this.setCreativeTab(CreativeTabs.tabBlock);
        setBlockTextureName(ElectricExpansion.modID + ":" + "conduit_all");
        setStepSound(Block.soundTypeStone);
        setHardness(6.50F);
    }

    @Override
    public boolean hasTileEntity(int meta) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileElectricConduit();
    }


}
