package hlft.kubejs.tic.ktice.js;

import dev.latvian.mods.kubejs.item.ItemStackJS;
import dev.latvian.mods.kubejs.recipe.RecipeExceptionJS;
import dev.latvian.mods.kubejs.recipe.RecipeJS;
import dev.latvian.mods.kubejs.util.ListJS;

public class MoldingJS extends RecipeJS {
    @Override
    public void create(ListJS args) {
        outputItems.add(parseResultItem(args.get(0)));
        json.add("material", ItemStackJS.of((ListJS.orSelf(args.get(1)).get(0))).toResultJson());
        json.add("pattern", ItemStackJS.of((ListJS.orSelf(args.get(2)).get(0))).toResultJson());

        if (outputItems.isEmpty()) {
            throw new RecipeExceptionJS("Molding recipe can't have no result!");
        }
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
