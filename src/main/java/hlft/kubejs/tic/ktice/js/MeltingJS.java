package hlft.kubejs.tic.ktice.js;

import dev.latvian.mods.kubejs.fluid.FluidStackJS;
import dev.latvian.mods.kubejs.item.ItemStackJS;
import dev.latvian.mods.kubejs.recipe.RecipeExceptionJS;
import dev.latvian.mods.kubejs.recipe.RecipeJS;
import dev.latvian.mods.kubejs.util.ListJS;

public class MeltingJS extends RecipeJS {
    public FluidStackJS outputFluid;

    @Override
    public void create(ListJS args) {
        if ((ListJS.orSelf(args.get(0)).get(0)) instanceof FluidStackJS fluid)
            outputFluid = fluid;
        json.add("ingredient", ItemStackJS.of((ListJS.orSelf(args.get(1)).get(0))).toResultJson());

        json.addProperty("temperature", Math.max(0, ((Number)args.get(2)).intValue()));
        json.addProperty("time", Math.max(0, ((Number)args.get(3)).intValue()));

        if (outputFluid == null) {
            throw new RecipeExceptionJS("Melting recipe can't have no result!");
        }
    }

    @Override
    public void deserialize() {
        outputFluid = FluidStackJS.of(json.get("result"));
    }

    @Override
    public void serialize() {
        if (serializeOutputs) {
            json.add("result", outputFluid.toJson());
        }
    }
}
