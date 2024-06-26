package vergesst.demomod.demo.CustomizedFeatures;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class customizedItem extends Item {

    public customizedItem(Item.Settings settings) {
        super(settings);
    }
    public String getCustomizedDescription() {
        return this.getTranslationKey();
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText(this.getCustomizedDescription()).formatted(Formatting.RED));
    }
}
