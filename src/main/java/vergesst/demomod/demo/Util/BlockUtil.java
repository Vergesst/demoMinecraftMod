package vergesst.demomod.demo.Util;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import vergesst.demomod.demo.CustomizedFeatures.StringBlock;
import vergesst.demomod.demo.RequiresTool;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static vergesst.demomod.demo.GlobalData.MOD_ID;

public class BlockUtil {
    public static Block blockCreator(String namespace, String name, Material material, float hardness, float resistance, RequiresTool r) {
        return Registry.register(
                Registry.BLOCK,
                new Identifier(namespace, name),
                r == RequiresTool.doRequire ?
                        new Block(FabricBlockSettings.of(material).strength(hardness, resistance).requiresTool()):
                        new Block(FabricBlockSettings.of(material).strength(hardness, resistance))
//                used to test whether it is okay to write like sentences above
//                new Block(FabricBlockSettings.of(material).strength(hardness, resistance))
        );
    }
//    Abandoned method
//    public static <T extends Block> T blockCreator(String namespace, String name, Material material, float hardness, float resistance, RequiresTool r, Class blockClass) {
//        return Registry.register(
//                Registry.BLOCK,
//                new Identifier(namespace, name),
//                blockClass.getConstructor(material, hardness, resistance)
//        );
//    }
    @Deprecated
    public static StringBlock stringBlockCreator(String namespace, String name, Material material, float hardness, float resistance, RequiresTool r) {
        return Registry.register(
                Registry.BLOCK,
                new Identifier(namespace, name),
                r == RequiresTool.doRequire ?
                        new StringBlock(FabricBlockSettings.of(material).strength(hardness, resistance).requiresTool()):
                        new StringBlock(FabricBlockSettings.of(material).strength(hardness, resistance))
        );
    }
    public static Item blockItemCreator(String namespace, String name, Block block, ItemGroup group) {
        return Registry.register(
                Registry.ITEM,
                new Identifier(namespace, name),
                new BlockItem(block, new Item.Settings().group(group))
        );
    }
    public static <T extends Block> T blockCreator(String namespace, String name, Material material, float hardness, float resistance, RequiresTool r, Class<T> blockClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = blockClass.getDeclaredConstructor(AbstractBlock.Settings.class);
        constructor.setAccessible(true);
        return Registry.register(
                Registry.BLOCK,
                new Identifier(namespace, name),
                blockClass.cast(constructor.newInstance(
                        r == RequiresTool.doRequire ?
                                FabricBlockSettings.of(material).strength(hardness, resistance).requiresTool():
                                FabricBlockSettings.of(material).strength(hardness, resistance)
                ))
        );
    }
    public static void blockRegistry() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Block demoOre = blockCreator(MOD_ID, "demo_ore", Material.STONE, 1.0f, 25.0f, RequiresTool.doRequire);
        Item demoOreItem = blockItemCreator(MOD_ID, "demo_ore", demoOre, ItemGroup.MISC);
        Block demoBlock = blockCreator(MOD_ID, "demo_block", Material.METAL, 1.0f, 25.0f, RequiresTool.doRequire);
        Item demoBlockItem = blockItemCreator(MOD_ID, "demo_block", demoBlock, ItemGroup.MISC);
        StringBlock infestedPink = blockCreator(MOD_ID, "infested_pink", Material.METAL, 1.0f, 1.0f, RequiresTool.noRequire, StringBlock.class);
        Item infestedPinkItem = blockItemCreator(MOD_ID, "infested_pink", infestedPink, ItemGroup.MISC);
        StringBlock simpleStringBlock = blockCreator(MOD_ID, "simple_string", Material.METAL, 1.0f, 1.0f, RequiresTool.noRequire, StringBlock.class);
        Item simpleStringItem = blockItemCreator(MOD_ID, "simple_string", simpleStringBlock, ItemGroup.MISC);
    }
}
