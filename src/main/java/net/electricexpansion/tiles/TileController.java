package net.electricexpansion.tiles;

import net.electricexpansion.utils.Coordinates;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;

/**
 * @author netchip
 * @since 13-4-2014
 */
public class TileController extends TileEntity {
    ArrayList<Coordinates> listConduits = new ArrayList<Coordinates>();

    public void registerConduit(Coordinates coords) {
        listConduits.add(coords);
    }

    public void unregisterConduit() {
        // make sure we rebuild the network, we don't want weird stuff to happen.
        // this is the easiest way to prevent that
        listConduits.clear();
    }

    public void searchForEnergyConsumers() {

    }
}
