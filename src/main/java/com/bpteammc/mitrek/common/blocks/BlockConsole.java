package com.bpteammc.mitrek.common.blocks;

import com.bpteammc.mitrek.client.gui.ShipGUI;
import com.bpteammc.mitrek.common.tileentity.TileEntityShip;
import com.bpteammc.mitrek.common.tileentity.TileEntityShipExterior;
import com.bpteammc.mitrek.network.NetworkManager;
import com.bpteammc.mitrek.network.packets.PacketWarp;
import com.bpteammc.mitrek.util.IHasModel;
import com.jcraft.jogg.Packet;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockConsole extends BlockBase implements ITileEntityProvider, IHasModel {
    private com.bpteammc.mitrek.network.packets.PacketWarp PacketWarp;

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            TileEntity tileEntity = world.getTileEntity(pos);
            if (!(tileEntity instanceof TileEntityShip)) {
                return false;
            }
            Minecraft.getMinecraft().displayGuiScreen(new ShipGUI());
            return true;
        }
        if (playerIn.isSneaking()) {
            if (world.isRemote) {
                PacketWarp warp = PacketWarp;
            }
        }
        return super.onBlockActivated(world, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }

    public BlockConsole(String name, Material material) {
        super(name, material);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityShip();
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.INVISIBLE;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
}
