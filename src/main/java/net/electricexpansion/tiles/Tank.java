/*package net.electricexpansion.tiles;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidTank;

public class Tank implements IFluidTank {
    private String name;
    private FluidStack fluid;
    private int capacity;

    public Tank(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        if(fluid == null)
            tag.setString("empty", "");
        else
            fluid.writeToNBT(tag);
        return tag;
    }

    public Tank readFromNBT(NBTTagCompound tag) {
        if(!tag.hasKey("empty")) {
            FluidStack fluid = FluidStack.loadFluidStackFromNBT(tag);
            if(fluid != null)
                this.fluid = fluid;
        }
        return this;
    }

    @Override
    public FluidStack getFluid() {
        return fluid;
    }

    @Override
    public int getFluidAmount() {
        if(fluid != null)
            return fluid.amount;
        return 0;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public FluidTankInfo getInfo() {
        return new FluidTankInfo(fluid, capacity);
    }

    @Override
    public int fill(FluidStack resource, boolean doFill) {
        if(resource == null)
            return 0;

        if(!doFill) {
            /* simulate tank filling here */ /*
        }

        int filled = 0;

        if(fluid == null) {
            fluid = new FluidStack(resource, Math.min(capacity, resource.amount))
            return fluid.amount;
        }

        if(!fluid.isFluidEqual(resource))
            return 0;

        int amountFree = capacity - fluid.amount;

        if(resource.amount < amountFree) {
            fluid.amount += resource.amount;
            filled = resource.amount;
        } else {
            fluid.amount = capacity;
        }

        return filled;
    }

    @Override
    public FluidStack drain(int maxDrain, boolean doDrain) {
        return null;
    }
}*/
