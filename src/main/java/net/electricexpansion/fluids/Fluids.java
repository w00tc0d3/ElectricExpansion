package net.electricexpansion.fluids;

import net.minecraftforge.fluids.Fluid;

public class Fluids {

	public static Fluid coolantT1;
	public static Fluid coolantT2;

    public static void registerFluids() {
        Fluids.coolantT1.setGaseous(true);
        Fluids.coolantT1.setViscosity(500);
        Fluids.coolantT1.setTemperature(295);
        Fluids.coolantT1.setLuminosity(0);
        Fluids.coolantT1.setDensity(100);
        Fluids.coolantT1.setUnlocalizedName("coolantTier1");

        // tier 2
        Fluids.coolantT2.setGaseous(false);
    }
}
