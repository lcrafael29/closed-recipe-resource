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

package com.pizzaordering.closedrecipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaordering.closedrecipe.entity.ClosedRecipe;
import com.pizzaordering.closedrecipe.service.ClosedRecipeService;

/**
 * Resource to expose closed recipe operations and handle closed recipe requests.
 * 
 * @author Rafael Lima Costa
 *
 */
@RestController
@RequestMapping("/closedrecipes")
public class ClosedRecipeController {
	
	/**
	 * Interface of closed recipe service layer.
	 */
	@Autowired
	ClosedRecipeService closedRecipeService;
	
	/**
	 * Operation for adding a closed recipe.
	 * 
	 * @param closedRecipe Closed recipe to be added on database.
	 * @return Closed recipe added on database.
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ClosedRecipe addClosedRecipe(@RequestBody ClosedRecipe closedRecipe) {
		return closedRecipeService.addClosedRecipe(closedRecipe);
	}
	
	/**
	 * Operation for getting a closed recipe.
	 * 
	 * @param id Id of closed recipe to be gotten from database.
	 * @return Closed recipe gotten from database.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ClosedRecipe getClosedRecipe(@PathVariable Integer id) {
		return closedRecipeService.getClosedRecipe(id);
	}
	
	/**
	 * Operation for updating a closed recipe.
	 * 
	 * @param closedRecipe Closed recipe to be updated on database.
	 * @return Closed recipe updated on database.
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ClosedRecipe updateClosedRecipe(@RequestBody ClosedRecipe closedRecipe) {
		return closedRecipeService.updateClosedRecipe(closedRecipe);
	}
	
	/**
	 * Operation for deleting a closed recipe.
	 * 
	 * @param id Id of closed recipe to be deleted from database.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteClosedRecipe(@PathVariable Integer id) {
		closedRecipeService.deleteClosedRecipe(id);
	}
}