package com.baisylia.modestmining.integration.jei;

import com.baisylia.modestmining.recipe.AbstractForgeRecipe;
import com.baisylia.modestmining.recipe.ForgeShapedRecipe;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.baisylia.modestmining.ModestMining;
import com.baisylia.modestmining.block.ModBlocks;
import mezz.jei.api.constants.ModIds;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.IShapedRecipe;

import java.util.ArrayList;
import java.util.List;

public class ForgingRecipeCategory implements IRecipeCategory<AbstractForgeRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(ModestMining.MOD_ID, "forging");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(ModestMining.MOD_ID, "textures/gui/forge_gui_jei.png");

    private final IDrawable background;
    private final IDrawable icon;
    private final int regularCookTime = 400;
    private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;
    protected final IDrawableStatic staticFlame;
    protected final IDrawableAnimated animatedFlame;

    public ForgingRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 120, 60);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.FORGE.get()));
        this.cachedArrows = CacheBuilder.newBuilder()
                .maximumSize(25)
                .build(new CacheLoader<>() {
                    @Override
                    public IDrawableAnimated load(Integer cookTime) {
                        return helper.drawableBuilder(TEXTURE, 123, 0, 23, 18)
                                .buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
                    }
                });
        staticFlame = helper.createDrawable(new ResourceLocation(ModIds.JEI_ID, "textures/gui/gui_vanilla.png"), 82, 114, 14, 14);
        animatedFlame = helper.createAnimatedDrawable(staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);

    }

    @Override
    public void draw(AbstractForgeRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics poseStack, double mouseX, double mouseY) {
        animatedFlame.draw(poseStack, 66, 23);
        IDrawableAnimated arrow = getArrow(recipe);
        arrow.draw(poseStack, 63, 4);
        drawCookTime(recipe, poseStack, 50);
    }

    protected void drawCookTime(AbstractForgeRecipe recipe, GuiGraphics guiGraphics, int y) {
        int cookTime = recipe.getCookTime();
        if (cookTime > 0) {
            int cookTimeSeconds = cookTime / 20;
            Component timeString = Component.translatable("gui.jei.category.smelting.time.seconds", cookTimeSeconds);
            Minecraft minecraft = Minecraft.getInstance();
            Font fontRenderer = minecraft.font;
            int stringWidth = fontRenderer.width(timeString);
            guiGraphics.drawString(fontRenderer, timeString, getWidth() - stringWidth, y, 0xFF808080, false);
        }
    }

    protected IDrawableAnimated getArrow(AbstractForgeRecipe recipe) {
        int cookTime = recipe.getCookTime();
        if (cookTime <= 0) {
            cookTime = regularCookTime;
        }
        return this.cachedArrows.getUnchecked(cookTime);
    }

    @Override
    public RecipeType<AbstractForgeRecipe> getRecipeType() {
        return JEIModestMiningPlugin.FORGING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("recipe.modestmining.forging");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, AbstractForgeRecipe recipe, IFocusGroup focuses) {
        int offset = 0;
        List<Ingredient> ingredients = padIngredients(recipe);
        if (!(recipe instanceof IShapedRecipe<?>)) {
            if (canFit(ingredients, 1, 3)) {
                offset -= 1;
            }
            if (canFit(ingredients,3, 1)) {
                offset -= 3;
            }
        }

        for (int i = 0; i < 9; i++) {
            int x = i % 3 * 18;
            int y = i / 3 * 18;

            int index = i + offset;
            IRecipeSlotBuilder slot = builder.addSlot(RecipeIngredientRole.INPUT, x+3, y+5);
            if (index >= 0 && index < ingredients.size()) {
                slot.addIngredients(ingredients.get(index));
            }
        }

        builder.addSlot(RecipeIngredientRole.OUTPUT, 97, 6).addItemStack(recipe.getResultItem(RegistryAccess.EMPTY));
    }

    private static List<Ingredient> padIngredients(AbstractForgeRecipe recipe) {
        if (recipe instanceof ForgeShapedRecipe shapedRecipe) {
            List<Ingredient> result = new ArrayList<>();
            int index = 0;
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    if (x >= shapedRecipe.getWidth() || y >= shapedRecipe.getHeight() || index >= recipe.getIngredients().size()) {
                        result.add(Ingredient.of());
                    } else {
                        result.add(recipe.getIngredients().get(index++));
                    }
                }
            }
            return result;
        }
        return recipe.getIngredients();
    }

    public boolean canFit(List<Ingredient> input, int width, int height) {
        if (input.size() > 9) return false;

        for (int i = 0; i < input.size(); i++) {
            int x = i % 3;
            int y = i / 3;
            if (!input.get(i).isEmpty() && (x >= width || y >= height)) return false;
        }
        return true;
    }
}