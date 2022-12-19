package hlft.kubejs.tic.ktice;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(Ktice.MOD_ID)
public class Ktice {
    public static final String MOD_ID = "ktice";

    public Ktice() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
