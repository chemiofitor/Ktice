package hlft.kubejs.tic.ktice.js;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import dev.latvian.mods.kubejs.fluid.FluidStackJS;
import dev.latvian.mods.kubejs.recipe.RecipeExceptionJS;
import dev.latvian.mods.kubejs.recipe.RecipeJS;
import dev.latvian.mods.kubejs.util.ListJS;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.mantle.recipe.ingredient.FluidIngredient;

import java.util.ArrayList;

public class AlloyJS extends RecipeJS {
    public ArrayList<FluidIngredient> inputFluids = new ArrayList<>();
    public FluidStackJS outputFluid;

    @Override
    public void create(ListJS args) {
        if ((ListJS.orSelf(args.get(0)).get(0)) instanceof FluidStackJS fluid)
            outputFluid = fluid;

        for (Object o : ListJS.orSelf(args.get(1))) {
            if (o instanceof FluidStackJS) {
                inputFluids.add(fluidFrom((FluidStackJS) o));
            }
        }

        json.addProperty("temperature", Math.max(0, ((Number)args.get(2)).intValue()));

        if (outputFluid == null) {
            throw new RecipeExceptionJS("Alloy recipe can't have no result!");
        }

        if (inputFluids.isEmpty()) {
            throw new RecipeExceptionJS("Alloy recipe can't have no fluid!");
        }
    }

    @Override
    public void deserialize() {
        outputFluid = FluidStackJS.of(json.get("result"));
        if (json.get("inputs").isJsonArray()) {
            for (JsonElement o : (JsonArray) json.get("inputs")) {
                inputFluids.add(fluidFrom(FluidStackJS.of(o)));
            }
        }
    }

    @Override
    public void serialize() {
        if (serializeOutputs) {
            json.add("result", outputFluid.toJson());
        }

        if (serializeInputs) {
            JsonArray in = new JsonArray();

            for (FluidIngredient fluid : inputFluids) {
                in.add(fluid.serialize());
            }

            json.add("inputs", in);
        }
    }

    public FluidIngredient fluidFrom(FluidStackJS fs) {
        return FluidIngredient.of(new FluidStack(fs.getFluid(), (int) fs.getAmount(), fs.getNbt()));
    }
}
