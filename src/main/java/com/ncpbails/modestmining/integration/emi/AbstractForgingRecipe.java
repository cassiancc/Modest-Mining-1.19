package com.ncpbails.modestmining.integration.emi;

import com.ncpbails.modestmining.ModestMining;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractForgingRecipe implements EmiRecipe {
    public final static ResourceLocation TEXTURE = new ResourceLocation(ModestMining.MOD_ID, "textures/gui/forge_gui_jei.png");
    final ArrayList<EmiIngredient> ingredients;
    final int cookTime;
    final EmiStack result;
    final ResourceLocation id;


    public AbstractForgingRecipe(ResourceLocation id, NonNullList<Ingredient> ingredients, ItemStack resultItem, int cookTime) {
        this.id = id;
        ArrayList<EmiIngredient> i = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            i.add(EmiIngredient.of(ingredient));
        }
        this.ingredients =i;
        this.result = EmiStack.of(resultItem);

        this.cookTime = cookTime;
    }

    @Override
    public @Nullable ResourceLocation getId() {
        return this.id;
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return ingredients;
    }

    @Override
    public List<EmiStack> getOutputs() {
        return List.of(result);
    }

    @Override
    public int getDisplayWidth() {
        return 120;
    }

    @Override
    public int getDisplayHeight() {
        return 60;
    }

    protected static void drawCookTime(int cookTime, WidgetHolder builder, int y, int width) {
        if (cookTime > 0) {
            int cookTimeSeconds = cookTime / 20;
            Component timeString = Component.translatable("emi.cooking.time", cookTimeSeconds);
            builder.addFillingArrow(63, 4, cookTime*100).tooltipText(Collections.singletonList(timeString));
        }
    }
}
