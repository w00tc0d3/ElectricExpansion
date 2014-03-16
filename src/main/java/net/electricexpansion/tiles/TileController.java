package net.electricexpansion.tiles;

import net.electricexpansion.utils.Coordinates;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;

/**
 * @author netchip
 * @since 13-4-2014
 */
public class TileController extends TileEntity {
    ArrayList<Coordinates> listConduits = new ArrayList<Coordinates>();
    World world;

    public TileController() {
        this.world = getWorldObj();
    }

    public void registerConduit(Coordinates coords) {
        listConduits.add(coords);
    }

    public void unregisterConduit() {
        // make sure we rebuild the network, we don't want weird stuff to happen.
        // this is the easiest way to prevent that
        listConduits.clear();
    }

    public void searchForEnergyConsumers() {
        TileElectricConduit tc;
        int tmpX;
        int tmpY;
        int tmpZ;
        for(int i = 0; i < listConduits.size(); i++) {
            tmpX = listConduits.get(i).getX();
            tmpY = listConduits.get(i).getY();
            tmpZ = listConduits.get(i).getZ();
            if(world.getTileEntity(tmpX, tmpY, tmpZ) instanceof TileElectricConduit) {
                tc = (TileElectricConduit) world.getTileEntity(tmpX, tmpY, tmpZ);
                for(ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
                    //TODO finish this
                }
            } else {
                unregisterConduit();
            }
        }
    }
}
