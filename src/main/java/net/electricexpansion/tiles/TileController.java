package net.electricexpansion.tiles;

import cofh.api.energy.IEnergyHandler;
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
    ArrayList<Coordinates> listEnergyHandlers = new ArrayList<Coordinates>();

    public TileController() {
    }

    public void registerConduit(Coordinates coords) {
        listConduits.add(coords);
    }

    public void unregisterConduit() {
        // make sure we rebuild the network, we don't want weird stuff to happen.
        // this is the easiest way to prevent that
        listConduits.clear();
    }

    protected void registerEnergyHandler(TileEntity te) {
        if(te == null)
            return;
        listEnergyHandlers.add(new Coordinates(te.xCoord, te.yCoord, te.zCoord));
    }

    public void searchForEnergyHandlers() {
        TileElectricConduit tc;
        int tmpX;
        int tmpY;
        int tmpZ;
        for(int i = 0; i < listConduits.size(); i++) {
            tmpX = listConduits.get(i).getX();
            tmpY = listConduits.get(i).getY();
            tmpZ = listConduits.get(i).getZ();
            if(worldObj.getTileEntity(tmpX, tmpY, tmpZ) instanceof TileElectricConduit) {
                tc = (TileElectricConduit) worldObj.getTileEntity(tmpX, tmpY, tmpZ);
                for(ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
                    if(worldObj.getTileEntity(tmpX + dir.offsetX, tmpY + dir.offsetY, tmpZ + dir.offsetZ) == null)
                        break;
                    if(worldObj.getTileEntity(tmpX + dir.offsetX, tmpY + dir.offsetY, tmpZ + dir.offsetZ) instanceof IEnergyHandler)
                        registerEnergyHandler(worldObj.getTileEntity(tmpX + dir.offsetX, tmpY + dir.offsetY, tmpZ + dir.offsetZ));
                }
            } else {
                unregisterConduit();
            }
        }
    }
}
