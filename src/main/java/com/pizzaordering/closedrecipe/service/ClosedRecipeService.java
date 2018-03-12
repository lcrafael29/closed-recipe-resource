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

package com.pizzaordering.closedrecipe.service;

import com.pizzaordering.closedrecipe.entity.ClosedRecipe;

/**
 * Interface of closed recipe service layer.
 * 
 * @author Rafael Lima Costa
 *
 */
public interface ClosedRecipeService {
	
	/**
	 * Operation for adding a closed recipe.
	 * 
	 * @param closedRecipe Closed recipe to be added on database.
	 * @return Closed recipe added on database.
	 */
	public ClosedRecipe addClosedRecipe(ClosedRecipe closedRecipe);
	
	/**
	 * Operation for getting a closed recipe.
	 * 
	 * @param id Id of closed recipe to be gotten from database.
	 * @return Closed recipe gotten from database.
	 */
	public ClosedRecipe getClosedRecipe(Integer id);
	
	/**
	 * Operation for updating a closed recipe.
	 * 
	 * @param closedRecipe Closed recipe to be updated on database.
	 * @return Closed recipe updated on database.
	 */
	public ClosedRecipe updateClosedRecipe(ClosedRecipe closedRecipe);
	
	/**
	 * Operation for deleting a closed recipe.
	 * 
	 * @param id Id of closed recipe to be deleted from database.
	 */
	public void deleteClosedRecipe(Integer id);
}