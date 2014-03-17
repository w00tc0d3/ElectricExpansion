package net.electricexpansion.fluids;

import net.minecraftforge.fluids.Fluid;

public class Fluids {

	public static Fluid coolantT1;
	public static Fluid coolantT2;
	public static Fluid coolantT3;

    public static void registerFluids() {
    	// Tier 1
        Fluids.coolantT1.setGaseous(false);
        Fluids.coolantT1.setViscosity(1000);
        Fluids.coolantT1.setTemperature(200);
        Fluids.coolantT1.setLuminosity(0);
        Fluids.coolantT1.setDensity(1000);
        Fluids.coolantT1.setUnlocalizedName("compressedWater");

        // Tier 2
        Fluids.coolantT2.setGaseous(false);
        Fluids.coolantT2.setLuminosity(0);
        Fluids.coolantT2.setViscosity(1000);
        Fluids.coolantT2.setTemperature(160);
        Fluids.coolantT2.setDensity(1500);
        Fluids.coolantT2.setUnlocalizedName("saltedChilledWater");
        
        // Tier 3
        Fluids.coolantT3.setGaseous(true);
        Fluids.coolantT3
    }
}
