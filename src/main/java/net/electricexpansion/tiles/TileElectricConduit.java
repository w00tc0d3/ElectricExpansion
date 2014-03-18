package net.electricexpansion.tiles;

import net.electricexpansion.utils.Coordinates;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * @author netchip
 * @since 13-3-2014
 */
public class TileElectricConduit extends TileEntity {
    TileController currentController;

    public TileElectricConduit() {
    }

    public void setController(TileController controller) {
        this.currentController = controller;
    }

    public TileController getController() {
        return currentController;
    }

    // pass coordinates to next block
    public void passCoordinates(TileElectricConduit te) {
        te.setController(currentController);
    }

    public void registerAtController() {
        currentController.registerConduit(this);
    }

    public void unregisterAtController() {
        currentController.unregisterConduit();
    }
}
