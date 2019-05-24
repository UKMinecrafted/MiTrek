package com.bpteammc.mitrek.common.tileentity;

import com.bpteammc.mitrek.util.helper.Teleporter;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class TileEntityShipTransporter extends TileEntity implements ITickable {

    private BlockPos exteriorpos = BlockPos.ORIGIN;
    private int exteriordimension = 0;

    public void ExitShip(EntityPlayerMP player) {
        /*if ()*/
        {
            world.getMinecraftServer().getPlayerList().transferPlayerToDimension(player, getExteriordimension(), new Teleporter(new BlockPos(pos.getX(), pos.getY(), pos.getZ())));
            player.connection.setPlayerLocation(getExteriorpos().getX(), getExteriorpos().getY() + 1, getExteriorpos().getZ(), 1, 1);
        }/*else{
        }*/
    }

    public BlockPos getExteriorpos() {
        return exteriorpos;
    }

    public int getExteriordimension() {
        return exteriordimension;
    }

    @Override
    public void update() {
        if (!world.isRemote) {
            World dim = world.getMinecraftServer().getWorld(exteriordimension);

        }
    }
}