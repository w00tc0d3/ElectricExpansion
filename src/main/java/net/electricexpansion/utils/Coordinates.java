package net.electricexpansion.utils;

/**
 * @author netchip
 * @since 14-3-2014
 **/
public class Coordinates {
    private int x;
    private int y;
    private int z;

    public Coordinates(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null)
            return false;

        if(o instanceof Coordinates) {
            if(((Coordinates) o).getX() == this.x && ((Coordinates) o).getY() == this.y && ((Coordinates) o).getZ() == this.z)
                return true;
        }
        return false;
    }
}
