package its_meow.derpcats.init;

import its_meow.derpcats.Ref;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModSoundEvents {

    public static SoundEvent fart;

    public static SoundEvent hit;

    public static SoundEvent death;

    public static SoundEvent grump;

    public static SoundEvent grumphit;

    public static SoundEvent grumpdeath;

    public static SoundEvent growl;

    public static SoundEvent alert;

    public static SoundEvent shutdown;

    public static SoundEvent grumphitlong;

    public static void registerSounds() {
        fart = registerSound("fart");
        hit = registerSound("hit");
        death = registerSound("death");
        grump = registerSound("grump");
        grumphit = registerSound("grumphit");
        growl = registerSound("growl");
        alert = registerSound("alert");
        shutdown = registerSound("shutdown");
        grumphitlong = registerSound("grumphitlong");
    }

    private static SoundEvent registerSound(String name) {
        ResourceLocation loc = new ResourceLocation(Ref.MOD_ID, name);
        SoundEvent event = new SoundEvent(loc);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }

}
