package io.github.bpteammc.mitrek.util.helper;

import io.github.bpteammc.mitrek.common.damage.IDamageSource;
import io.github.bpteammc.mitrek.common.entity.EntityBeam;
import io.github.bpteammc.mitrek.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ShootWeapon {

    public static void Beam(EntityPlayer entityplayer, World worldIn, ItemStack stack) {
        if (worldIn.isRemote && !entityplayer.isSneaking() && entityplayer.getHeldItemOffhand().getItem() != ModItems.TOS_PHASER) {
            //entityplayer.playSound(SoundsHandler.GAUNTLET_HUM, 1, 1);
        }
        ShootWeapon.ShootBeam(entityplayer, worldIn, 100, 1,0 ,5);
    }

    public static void ShootBeam(EntityPlayer entityplayer, World worldIn, int damage, int r, int g, int b) {
        Vec3d v3 = entityplayer.getLook(1);
        EntityBeam beam = new EntityBeam(worldIn, entityplayer, damage, IDamageSource.BEAM, new Vec3d(r, g, b));
        beam.shoot(v3.x, v3.y, v3.z, 1.5F, (float) 0);
        worldIn.spawnEntity(beam);
    }
}