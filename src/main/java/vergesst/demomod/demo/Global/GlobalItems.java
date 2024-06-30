package vergesst.demomod.demo.Global;

import net.minecraft.item.*;
import vergesst.demomod.demo.Feature.purpleNetheriteItem;
import vergesst.demomod.demo.Util.ArmorUtil;
import vergesst.demomod.demo.Util.BlockUtil;
import vergesst.demomod.demo.Util.ItemUtil;
import vergesst.demomod.demo.Util.ToolUtil;

import java.lang.reflect.InvocationTargetException;

import static vergesst.demomod.demo.Demo.MOD_ID;

public class GlobalItems {
//    like class ITEMS in minecraft, the globalItems class here is aimed for better management of items in this modification

    public static Item ORE_DASH;
    public static Item PURPLE_NETHERITE_INGOT;
    public static Item PURPLE_HELMET;
    public static Item INFESTED_PINK;
    public static Item PURPLE_ORE;
    public static Item PURPLE_BLOCK;

    public static ToolItem PURPLE_PICKAXE;

//    to register items like the original ItemUtil class
    public static void itemRegister() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ORE_DASH = ItemUtil.itemCreator(MOD_ID, "purple_ore_dash", ItemGroups.INGREDIENTS, Items.NETHERITE_INGOT);
        PURPLE_NETHERITE_INGOT = ItemUtil.itemCreator(MOD_ID, "purple_netherite_ingot", purpleNetheriteItem.class, ItemGroups.INGREDIENTS, Items.NETHERITE_INGOT);
        PURPLE_HELMET = ArmorUtil.armorCreator(MOD_ID, "purple_netherite_helmet", ItemGroups.COMBAT, Items.NETHERITE_BOOTS, GlobalMaterials.PURPLE_NETHERITE, ArmorItem.Type.HELMET);

        //From blocks
        INFESTED_PINK = BlockUtil.blockItemCreator("demo", MOD_ID, "infested_pink", GlobalBlocks.INFESTED_PINK);
        PURPLE_BLOCK = BlockUtil.blockItemCreator(MOD_ID, "purple_block", GlobalBlocks.PURPLE_BLOCK, ItemGroups.BUILDING_BLOCKS, Items.NETHERITE_BLOCK);
        PURPLE_ORE = BlockUtil.blockItemCreator(MOD_ID, "purple_ore", GlobalBlocks.PURPLE_ORE, ItemGroups.NATURAL, Items.DEEPSLATE_DIAMOND_ORE);

        //Tools
        PURPLE_PICKAXE = ToolUtil.toolCreator("purple_pickaxe", GlobalToolMaterial.PURPLE_NETHERITE, 15, 0.1F, PickaxeItem.class);
    }
}
