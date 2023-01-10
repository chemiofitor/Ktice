package hlft.kubejs.tic.ktice.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemTest extends Item {
    public ItemTest() {
        super(new Settings().group(null));
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        World world = user.getWorld();
        for (int i = 0; i < 10; i++) {
            world.addParticle(ParticleTypes.GLOW_SQUID_INK, entity.getX(), entity.getEyeY(), entity.getZ(), random(world), random(world), random(world));
        }
        return super.useOnEntity(stack, user, entity, hand);
    }

    public double random(World world) {
        return world.random.nextBoolean() ? world.random.nextFloat() * 0.25 : -world.random.nextFloat() * 0.25;
    }
}
