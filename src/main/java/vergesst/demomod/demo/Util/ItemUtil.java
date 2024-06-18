package vergesst.demomod.demo.Util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import vergesst.demomod.demo.CustomizedFeatures.customizedItem;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static vergesst.demomod.demo.GlobalData.MOD_ID;

public class ItemUtil {
    public static Item itemCreator(String namespace, String name, ItemGroup group) {
        return Registry.register(
                Registry.ITEM,
                new Identifier(namespace, name),
                new Item(new Item.Settings().group(group))
        );
    }
    public static <T extends Item> T itemCreator(String namespace, String name, ItemGroup group, Class<T> itemClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = itemClass.getConstructor(Item.Settings.class);
        return Registry.register(
                Registry.ITEM,
                new Identifier(namespace, name),
                itemClass.cast(constructor.newInstance(new Item.Settings().group(group)))
        );
    }

    public static void itemRegistry() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Item demoItem = itemCreator(MOD_ID, "demo", ItemGroup.MISC);
        customizedItem customizedItem = itemCreator(MOD_ID, "cus_item", ItemGroup.MISC, vergesst.demomod.demo.CustomizedFeatures.customizedItem.class);
        Item purpleOreDash = itemCreator(MOD_ID, "purple_ore_dash", ItemGroup.MISC);
        Item purpleNetherite = itemCreator(MOD_ID, "purple_netherite_ingot", ItemGroup.MISC);
    }
}
