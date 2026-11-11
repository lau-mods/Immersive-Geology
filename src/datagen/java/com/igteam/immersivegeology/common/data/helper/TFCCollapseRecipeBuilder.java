/*
 * Muddykat
 * Copyright (c) 2024
 *
 * This code is licensed under "GNU LESSER GENERAL PUBLIC LICENSE"
 * Details can be found in the license file in the root folder of this project
 */

package com.igteam.immersivegeology.common.data.helper;

import com.google.gson.JsonArray;
import com.igteam.immersivegeology.client.helper.IGRecipeBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

public class TFCCollapseRecipeBuilder extends IGRecipeBuilder<TFCCollapseRecipeBuilder>
{
	protected TFCCollapseRecipeBuilder()
	{
		super(TFCDatagenCompat.invokeCollapseRecipe());
		addCondition(new ModLoadedCondition("tfc"));
	}

	public static TFCCollapseRecipeBuilder builder(Ingredient result)
	{
		return new TFCCollapseRecipeBuilder().addWriter(jsonObject -> {
			JsonArray blocks = new JsonArray();
			blocks.add(BuiltInRegistries.ITEM.getKey(result.getItems()[0].getItem()).toString());
			jsonObject.add("ingredient", blocks);
			// TFC 1.21.1 copies the input state when result is absent.
		});
	}
}
