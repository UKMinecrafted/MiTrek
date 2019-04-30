package com.ukminecrafted.mitrek.init;

import com.ukminecrafted.mitrek.common.world.WorldProviderMitrek;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {

    public static int MITREKID;
    public static DimensionType Type;

    public static void Register() {
        MITREKID = DimensionManager.getNextFreeDimId();
        Type = DimensionType.register("mitrek", "_mitrek", MITREKID, WorldProviderMitrek.class, true);
        DimensionManager.registerDimension(MITREKID, Type);
    }
}
