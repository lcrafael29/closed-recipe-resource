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

package com.pizzaordering.closedrecipe.data;

import org.springframework.data.repository.CrudRepository;

import com.pizzaordering.closedrecipe.entity.ClosedRecipe;

/**
 * Interface of closed recipe repository layer.
 * 
 * @author Rafael Lima Costa
 *
 */
public interface ClosedRecipeRepository extends CrudRepository<ClosedRecipe, Integer> {
}