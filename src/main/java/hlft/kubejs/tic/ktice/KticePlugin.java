package hlft.kubejs.tic.ktice;

import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.RegisterRecipeHandlersEvent;
import hlft.kubejs.tic.ktice.js.*;
import net.minecraft.util.Identifier;

public class KticePlugin extends KubeJSPlugin {
    @Override
    public void addRecipes(RegisterRecipeHandlersEvent event) {
        event.register(new Identifier("tconstruct:alloy"), AlloyJS::new);
        event.register(new Identifier("tconstruct:molding_table"), MoldingJS::new);
        event.register(new Identifier("tconstruct:molding_basin"), MoldingJS::new);
        event.register(new Identifier("tconstruct:melting"), MeltingJS::new);
        event.register(new Identifier("tconstruct:entity_melting"), EntityMeltingJS::new);
        event.register(new Identifier("tconstruct:severing"), SeveringJS::new);
    }
}
