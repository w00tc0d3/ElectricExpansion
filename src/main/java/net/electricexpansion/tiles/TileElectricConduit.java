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
    Coordinates coords;
    World world;

    public TileElectricConduit() {
        this.world = this.getWorldObj();
    }

    public void setController(TileController controller) {
        this.currentController = controller;
    }

    public TileController getController() {
        return currentController;
    }

    public void passCoordinates(TileElectricConduit te) {
        te.setController(currentController);
    }

    public void setCoordinates() {
        
    }

    public void registerAtController() {
        currentController.registerConduit(coords);
    }

    public void unregisterAtController() {
        currentController.unregisterConduit();
    }
}
