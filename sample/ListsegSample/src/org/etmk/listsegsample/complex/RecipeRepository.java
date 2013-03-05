package org.etmk.listsegsample.complex;

import java.util.ArrayList;
import java.util.List;


public class RecipeRepository {

	
	private List<Recipe> recipes;
	
	public List<Recipe> getRecipes()
	{
		if (recipes == null) {
			recipes = new ArrayList<Recipe>();
			
			for (int c = 0; c < categories.length; c++)
			{
				for (int i = 0; i < 10; i++)
				{
					Recipe r = new Recipe(new Category(categories[c]), categories[c] + "-recipe " + i, "open package.  eat.", null, "45 sec");
					recipes.add(r);
				}
			}
		}
		return recipes;
	}
	
	private String[] categories = new String[]{"Appetizers", "Beers", "Cheeses", "Meats", "Non-nutritive", "No-cook", "Popcorn", "Zebra Dishes"};
	
	
}
