package vergesst.demomod.demo.CustomizedFeatures;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class StringBlock extends Block {
    public StringBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        this.spawnBreakParticles(world, player, pos, state);
//        player.sendMessage(Text.of(player.getEntityName()), true);
//        SilverfishEntity silverfishEntity = EntityType.SILVERFISH.create(world);
        SilverfishEntity silverfishEntity = (SilverfishEntity) EntityType.SILVERFISH.create(world);
        assert silverfishEntity != null;
        silverfishEntity.refreshPositionAndAngles((double)pos.getX() + 0.5, (double)pos.getY(), (double)pos.getZ() + 0.5, 0.0F, 0.0F);
        world.spawnEntity(silverfishEntity);
    }
    //easily to get the path, type and name of a block, returns a string
    //Or we can create an enum to include these features?
    private String getCustomizedDescription() {
    //turn to method getTranslationKey() for help!
        if(this.getTranslationKey().equals("block.demo.infested_pink")) {
            return "spawn SILVERFISH after break";
        }else {
            return this.getTranslationKey().replace("block.demo.", "");
        }
    }
    @Deprecated
    //used to add tips below the name of one block
    public void appendTooltip(String namespace, String blockName, ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText(namespace+'.'+blockName));
        tooltip.add(new TranslatableText(namespace+'.'+blockName).formatted(Formatting.RED));
    }
    @Override
    //a overrode method to present block tags in gray color below the name of a block
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
//        how to show customized information of the block(item)?
//        try to write like this:
//        tooltip.add(this.getDescription().formatted(Formatting.GRAY));
        tooltip.add(new TranslatableText(this.getCustomizedDescription()).formatted(Formatting.GRAY));
    }
}
     