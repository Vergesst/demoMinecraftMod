package vergesst.demomod.demo.Global;

import net.minecraft.block.Block;

import vergesst.demomod.demo.CusBlock.InfestedBlock;
import vergesst.demomod.demo.Util.BlockUtil;

import java.lang.reflect.InvocationTargetException;

import static vergesst.demomod.demo.Demo.MOD_ID;

public class GlobalBlocks {
    public static InfestedBlock INFESTED_PINK;
    public static Block PURPLE_ORE;
    public static Block PURPLE_BLOCK;

    public static void blockRegister() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        INFESTED_PINK = BlockUtil.blockCreator(MOD_ID, "infested_pink", 1.0F, 13.0F, vergesst.demomod.demo.CusBlock.InfestedBlock.class);
        PURPLE_ORE = BlockUtil.blockCreator(MOD_ID, "purple_ore", 5.0F, 25.0F);
        PURPLE_BLOCK = BlockUtil.blockCreator(MOD_ID, "purple_block", 5.0F, 25.0F);
    }
}
