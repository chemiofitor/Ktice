package hlft.kubejs.tic.ktice.js;

import com.google.gson.JsonObject;
import dev.latvian.mods.kubejs.recipe.RecipeJS;
import dev.latvian.mods.kubejs.util.ListJS;

public class SeveringJS extends RecipeJS {
    @Override
    public void create(ListJS args) {
        outputItems.add(parseResultItem(args.get(0)));

        JsonObject object = new JsonObject();
        if (args.get(1) instanceof String s)
            object.addProperty("type", s);

        json.add("entity", object);
    }

    @Override
    public void deserialize() {
        outputItems.add(parseResultItem(json.get("result")));
    }

    @Override
    public void serialize() {
        if (serializeOutputs) {
            json.addProperty("result", outputItems.get(0).getId());
        }
    }
}
