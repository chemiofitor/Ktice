package hlft.kubejs.tic.ktice.js;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dev.latvian.mods.kubejs.fluid.FluidStackJS;
import dev.latvian.mods.kubejs.recipe.RecipeExceptionJS;
import dev.latvian.mods.kubejs.recipe.RecipeJS;
import dev.latvian.mods.kubejs.util.ListJS;

public class AlloyJS extends RecipeJS {
    public FluidStackJS outputFluid;

    @Override
    public void create(ListJS args) {
        if ((ListJS.orSelf(args.get(0)).get(0)) instanceof FluidStackJS fluid)
            outputFluid = fluid;

        JsonArray array = new JsonArray();
        for (Object o : ListJS.orSelf(args.get(1))) {
            if (o instanceof FluidStackJS js) {
                array.add(createFluid(js.getId(), (int) js.getAmount()));
            }
        }
        json.add("inputs", array);

        json.addProperty("temperature", Math.max(0, ((Number)args.get(2)).intValue()));

        if (outputFluid == null) {
            throw new RecipeExceptionJS("Alloy recipe can't have no result!");
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

    public JsonObject createFluid(String id, int amount) {
        JsonObject o = new JsonObject();

        if (id.startsWith("#")) {
            o.addProperty("tag", id.substring(1));
        } else {
            o.addProperty("name", id);
        }

        o.addProperty("amount", amount);
        return o;
    }
}
