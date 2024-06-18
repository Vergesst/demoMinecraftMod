package vergesst.demomod.demo;

import net.fabricmc.api.ModInitializer;
import vergesst.demomod.demo.Util.BlockUtil;
import vergesst.demomod.demo.Util.ItemUtil;

import java.lang.reflect.InvocationTargetException;

public class Demo implements ModInitializer {

    @Override
    public void onInitialize(){
        try {
            ItemUtil.itemRegistry();
            BlockUtil.blockRegistry();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
