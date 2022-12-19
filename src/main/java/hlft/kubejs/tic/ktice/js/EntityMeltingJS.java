package hlft.kubejs.tic.ktice.js;

import com.google.gson.JsonObject;
import dev.latvian.mods.kubejs.fluid.FluidStackJS;
import dev.latvian.mods.kubejs.recipe.RecipeJS;
import dev.latvian.mods.kubejs.util.ListJS;

public class EntityMeltingJS extends RecipeJS {
    public FluidStackJS outputFluid;

    @Override
    public void create(ListJS args) {
        if ((ListJS.orSelf(args.get(0)).get(0)) instanceof FluidStackJS fluid)
            outputFluid = fluid;

        JsonObject object = new JsonObject();
        if (args.get(1) instanceof String s)
            object.addProperty("type", s);

        json.add("entity", object);

        json.addProperty("damage", Math.max(0, ((Number)args.get(2)).intValue()));
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
