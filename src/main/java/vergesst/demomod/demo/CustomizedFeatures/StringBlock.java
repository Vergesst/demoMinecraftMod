package vergesst.demomod.demo.CustomizedFeatures;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.InfestedBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class StringBlock extends Block {
    public StringBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        this.spawnBreakParticles(world, player, pos, state);
        player.sendMessage(Text.of(player.getEntityName()), true);
        SilverfishEntity silverfishEntity = (SilverfishEntity) EntityType.SILVERFISH.create(world);
        assert silverfishEntity != null;
        silverfishEntity.refreshPositionAndAngles((double)pos.getX() + 0.5, (double)pos.getY(), (double)pos.getZ() + 0.5, 0.0F, 0.0F);
//        SilverfishEntity silverfishEntity = EntityType.SILVERFISH.create(world);
        world.spawnEntity(silverfishEntity);
    }
    public void onPlace(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        SilverfishEntity silverfishEntity = (SilverfishEntity) EntityType.SILVERFISH.create(world);
        assert silverfishEntity != null;
        silverfishEntity.refreshPositionAndAngles((double)pos.getX() + 0.5, (double)pos.getY(), (double)pos.getZ() + 0.5, 0.0F, 0.0F);
        world.spawnEntity(silverfishEntity);
    }
}
