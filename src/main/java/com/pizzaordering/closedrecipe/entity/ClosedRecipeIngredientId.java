/**
 * Pizza Ordering Application
 * 
 * HTTP REST Microservices that handle ordering, deals and inventory
 * 
 * FastSpring Coding Challenge
 * 
 * Rafael Lima Costa
 * March of 2018
 * Santa Barbara, CA, USA
 */

package com.pizzaordering.closedrecipe.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Closed recipe ingredient composite id.
 * 
 * @author Rafael Lima Costa
 *
 */
@Embeddable
public class ClosedRecipeIngredientId implements Serializable {
	
	/**
	 * Serial version UID for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id of ingredient.
	 */
	@Column(name = "ingredient_id", nullable = false)
	@JsonIgnore
	private Long ingredientId;
	
	/**
	 * Closed recipe.
	 */
	@ManyToOne
	@JoinColumn(name = "closed_recipe_id", nullable = false)
	@JsonIgnore
	private ClosedRecipe closedRecipe;
	
	/**
	 * Constructor.
	 */
	public ClosedRecipeIngredientId() {
	}

	/**
	 * Get id of ingredient.
	 * 
	 * @return Id of ingredient.
	 */
	public Long getIngredientId() {
		return ingredientId;
	}

	/**
	 * Set id of ingredient.
	 * 
	 * @param ingredientId Id of ingredient.
	 */
	public void setIngredientId(Long ingredientId) {
		this.ingredientId = ingredientId;
	}

	/**
	 * Get closed recipe.
	 * 
	 * @return Closed recipe.
	 */
	public ClosedRecipe getClosedRecipe() {
		return closedRecipe;
	}

	/**
	 * Set closed recipe.
	 * 
	 * @param closedRecipe Closed recipe.
	 */
	public void setClosedRecipe(ClosedRecipe closedRecipe) {
		this.closedRecipe = closedRecipe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((closedRecipe == null) ? 0 : closedRecipe.hashCode());
		result = prime * result + ((ingredientId == null) ? 0 : ingredientId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClosedRecipeIngredientId other = (ClosedRecipeIngredientId) obj;
		if (closedRecipe == null) {
			if (other.closedRecipe != null)
				return false;
		} else if (!closedRecipe.equals(other.closedRecipe))
			return false;
		if (ingredientId == null) {
			if (other.ingredientId != null)
				return false;
		} else if (!ingredientId.equals(other.ingredientId))
			return false;
		return true;
	}
}