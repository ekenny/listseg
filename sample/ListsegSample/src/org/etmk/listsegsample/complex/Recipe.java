package org.etmk.listsegsample.complex;

import java.util.List;


public class Recipe {

	private Category category;
	
	private String name;
	
	private String instructions;
	
	private List<String> ingredients;
	
	private String prepTime;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public String getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}

	public Recipe(Category category, String name, String instructions,
			List<String> ingredients, String prepTime) {
		super();
		this.category = category;
		this.name = name;
		this.instructions = instructions;
		this.ingredients = ingredients;
		this.prepTime = prepTime;
	}
	
	
}
