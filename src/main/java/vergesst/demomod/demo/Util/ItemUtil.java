package vergesst.demomod.demo.Util;


import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static vergesst.demomod.demo.GlobalData.MOD_ID;


public class ItemUtil {
    public static Item itemCreator(String namespace, String name, ItemGroup group) {
        return Registry.register(
                Registry.ITEM,
                new Identifier(namespace, name),
                new Item(new Item.Settings().group(group))
        );
    }

    public static void itemRegistry() {
        Item demoItem = itemCreator(MOD_ID, "demo", ItemGroup.MISC);
    }
}
