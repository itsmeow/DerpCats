package its_meow.derpcats.config;

import org.apache.logging.log4j.Level;

import its_meow.derpcats.DerpCatsMod;
import net.minecraftforge.common.config.Configuration;

public class DerpCatsConfig {

    public static int dimId = 5704;

    public static void readConfig() {
        Configuration cfg = DerpCatsMod.config;
        try {
            cfg.load();
            initConfig(cfg);
        } catch(Exception e1) {
            DerpCatsMod.logger.log(Level.ERROR, "Problem Loading Config!!", e1);
        } finally {
            if(cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initConfig(Configuration cfg) {
        cfg.addCustomCategoryComment("Dimension", "Dimension Config");
        dimId = cfg.getInt("dimId", "Dimension", 5704, -9999, 9999,
                "Dimension ID for catland. Do not set to 5705 if you are using CloneLand.");
    }

}
