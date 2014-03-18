package net.electricexpansion.fluids;

import net.minecraftforge.fluids.Fluid;

public class Fluids {

	public static Fluid coolantT1;
	public static Fluid coolantT2;
	public static Fluid coolantT3;
	public static Fluid coolantT4;

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
        Fluids.coolantT2.setUnlocalizedName("salinatedChilledWater");
        
        // Tier 3
        Fluids.coolantT3.setGaseous(true);
        Fluids.coolantT3.setLuminosity(0);
        Fluids.coolantT3.setViscosity(554);
        Fluids.coolantT3.setTemperature(100);
        Fluids.coolantT3.setDensity(100);
        Fluids.coolantT3.setUnlocalizedName("liquidNitrogen");
        
        // Tier 4
        Fluids.coolantT4.setGaseous(true);
        Fluids.coolantT4.setLuminosity(0);
        Fluids.coolantT4.setViscosity(300);
        Fluids.coolantT4.setTemperature(20);
        Fluids.coolantT4.setDensity(100);
        Fluids.coolantT4.setUnlocalizedName("liquidHelium");
        
        System.out.println("Fluids initialized sucessfully!");
    }
}
