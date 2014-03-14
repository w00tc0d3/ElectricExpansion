package net.electricexpansion.tiles;

import net.minecraft.tileentity.TileEntity;

/**
 * @author netchip
 * @since 13-3-2014
 */
public class TileElectricConduit extends TileEntity {
    TileController currentController;

    public void setController(TileController controller) {
        this.currentController = controller;
    }

    public TileController getController() {
        return currentController;
    }

    public void registerAtController() {

    }

    public void unregisterAtController() {

    }
}
