package hlft.kubejs.tic.ktice;

import hlft.kubejs.tic.ktice.item.ItemTest;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Ktice implements ModInitializer {
    public static final String MOD_ID = "ktice";

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "test"), new ItemTest());
    }
}