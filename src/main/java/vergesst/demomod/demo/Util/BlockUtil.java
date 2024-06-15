package vergesst.demomod.demo.Util;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.lwjgl.system.CallbackI;
import vergesst.demomod.demo.CustomizedFeatures.StringBlock;
import vergesst.demomod.demo.RequiresTool;

import static vergesst.demomod.demo.GlobalData.MOD_ID;

public class BlockUtil {
    public static Block blockCreator(String namespace, String name, Material material, float hardness, float resistance, RequiresTool r) {
        return Registry.register(
                Registry.BLOCK,
                new Identifier(namespace, name),
                r == RequiresTool.doRequire ?
                        new Block(FabricBlockSettings.of(material).strength(hardness, resistance).requiresTool())
                        :new Block(FabricBlockSettings.of(material).strength(hardness, resistance))
//                new Block(FabricBlockSettings.of(material).strength(hardness, resistance))
        );
    }
//    所以如何能在方法中创建一个未知类型的参数
//    public static <T extends Block> T blockCreator(String namespace, String name, Material material, float hardness, float resistance, RequiresTool r, T customizedBlock) {
//        return Registry.register(
//                Registry.BLOCK,
//                new Identifier(namespace, name),
//                customizedBlock
//        );
//    }
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
    public static void blockRegistry() {
        Block demoOre = blockCreator(MOD_ID, "demo_ore", Material.STONE, 1.0f, 25.0f, RequiresTool.doRequire);
        Item demoOreItem = blockItemCreator(MOD_ID, "demo_ore", demoOre, ItemGroup.MISC);
        Block demoBlock = blockCreator(MOD_ID, "demo_block", Material.METAL, 1.0f, 25.0f, RequiresTool.doRequire);
        Item demoBlockItem = blockItemCreator(MOD_ID, "demo_block", demoBlock, ItemGroup.MISC);
        StringBlock stringBlock = stringBlockCreator(MOD_ID, "string_block", Material.METAL, 4.0f, 5.0f, RequiresTool.doRequire);
        Item stringBlockItem = blockItemCreator(MOD_ID, "string_block", stringBlock, ItemGroup.MISC);
    }
}
