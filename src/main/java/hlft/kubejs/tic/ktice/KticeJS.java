package hlft.kubejs.tic.ktice;

import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.RegisterRecipeHandlersEvent;
import hlft.kubejs.tic.ktice.js.*;
import net.minecraft.resources.ResourceLocation;

public class KticeJS extends KubeJSPlugin {
    @Override
    public void addRecipes(RegisterRecipeHandlersEvent event) {
        event.register(new ResourceLocation("tconstruct:alloy"), AlloyJS::new);
        event.register(new ResourceLocation("tconstruct:molding_table"), MoldingJS::new);
        event.register(new ResourceLocation("tconstruct:molding_basin"), MoldingJS::new);
        event.register(new ResourceLocation("tconstruct:melting"), MeltingJS::new);
        event.register(new ResourceLocation("tconstruct:entity_melting"), EntityMeltingJS::new);
        event.register(new ResourceLocation("tconstruct:severing"), SeveringJS::new);
    }
}
