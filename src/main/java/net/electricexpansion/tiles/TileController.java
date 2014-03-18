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

    public void registerConduit(TileElectricConduit tileElectricConduit) {
        if(tileElectricConduit == null)
            return;
        listConduits.add(new Coordinates(tileElectricConduit.xCoord, tileElectricConduit.yCoord, tileElectricConduit.zCoord));
    }

    public void unregisterConduit() {
        // Make sure we rebuild the network, we don't want weird stuff to happen.
        // This is the easiest way to prevent that
        //TODO make this not rebuild the whole network, but scan parts.
        listConduits.clear();
    }

    protected void registerEnergyHandler(TileEntity te) {
        if(te == null)
            return;
        listEnergyHandlers.add(new Coordinates(te.xCoord, te.yCoord, te.zCoord));
    }

    public void searchForEnergyHandlers() {
        int tmpX;
        int tmpY;
        int tmpZ;
        for(int i = 0; i < listConduits.size(); i++) {
            tmpX = listConduits.get(i).getX();
            tmpY = listConduits.get(i).getY();
            tmpZ = listConduits.get(i).getZ();
            if(worldObj.getTileEntity(tmpX, tmpY, tmpZ) instanceof TileElectricConduit) {
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
