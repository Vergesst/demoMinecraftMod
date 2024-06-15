package vergesst.demomod.demo;

import net.fabricmc.api.ModInitializer;
import vergesst.demomod.demo.Util.BlockUtil;
import vergesst.demomod.demo.Util.ItemUtil;

public class Demo implements ModInitializer {

    @Override
    public void onInitialize() {
        ItemUtil.itemRegistry();
        BlockUtil.blockRegistry();
    }
}
