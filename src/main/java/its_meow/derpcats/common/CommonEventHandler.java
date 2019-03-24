package its_meow.derpcats.common;

import its_meow.derpcats.Ref;
import its_meow.derpcats.common.entity.EntityHopCat;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Ref.MOD_ID)
public class CommonEventHandler {

    @SubscribeEvent
    public static void fallingHopCat(LivingFallEvent event) {
        if(event.getEntityLiving() instanceof EntityHopCat) {
            event.setCanceled(true);
        }
    }

}
