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

package com.pizzaordering.closedrecipe.serviceImpl;

import java.util.Map;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaordering.closedrecipe.data.ClosedRecipeIngredientRepository;
import com.pizzaordering.closedrecipe.data.ClosedRecipeRepository;
import com.pizzaordering.closedrecipe.entity.ClosedRecipe;
import com.pizzaordering.closedrecipe.entity.ClosedRecipeIngredient;
import com.pizzaordering.closedrecipe.entity.ClosedRecipeIngredientId;
import com.pizzaordering.closedrecipe.service.ClosedRecipeService;

/**
 * Implementation of closed recipe service layer interface.
 * 
 * @author Rafael Lima Costa
 *
 */
@Service
public class ClosedRecipeServiceImpl implements ClosedRecipeService {
	
	/**
	 * Interface of closed recipe repository layer.
	 */
	@Autowired
	ClosedRecipeRepository closedRecipeRepository;
	
	/**
	 * Interface of closed recipe repository layer.
	 */
	@Autowired
	ClosedRecipeIngredientRepository closedRecipeIngredientRepository;
	
	/*
	 * Save closed recipe on database.
	 */
	public ClosedRecipe addClosedRecipe(ClosedRecipe closedRecipe) {
		Map<Long, ClosedRecipeIngredient> closedRecipeIngredientMap = null;
		ClosedRecipeIngredient closedRecipeIngredient = null;
		
		closedRecipeIngredientMap = closedRecipe.getClosedRecipeIngredientMap();
		
		closedRecipe.setClosedRecipeIngredientMap(null);
		closedRecipe = closedRecipeRepository.save(closedRecipe);
		
		if (closedRecipeIngredientMap != null) {
			for (Long ingredientId : closedRecipeIngredientMap.keySet()) {
				closedRecipeIngredient = closedRecipeIngredientMap.get(ingredientId);
				closedRecipeIngredient.setClosedRecipeIngredientId(new ClosedRecipeIngredientId());
				closedRecipeIngredient.getClosedRecipeIngredientId().setIngredientId(ingredientId);
				closedRecipeIngredient.getClosedRecipeIngredientId().setClosedRecipe(closedRecipe);
			}
			
			closedRecipeIngredientRepository.saveAll(closedRecipeIngredientMap.values());
			
			closedRecipe.setClosedRecipeIngredientMap(closedRecipeIngredientMap);
		}
		
		return closedRecipe;
	}
	
	/*
	 * Get closed recipe from database.
	 */
	public ClosedRecipe getClosedRecipe(Integer id) {
		ClosedRecipe closedRecipe = null;
		
		closedRecipe = closedRecipeRepository.findById(id).get();
		
		Hibernate.initialize(closedRecipe.getClosedRecipeIngredientMap());
		
		return closedRecipe;
	}
	
	/*
	 * Update closed recipe on database.
	 */
	public ClosedRecipe updateClosedRecipe(ClosedRecipe closedRecipe) {
		Map<Long, ClosedRecipeIngredient> closedRecipeIngredientMap = null;
		ClosedRecipeIngredient closedRecipeIngredient = null;
		
		closedRecipeIngredientMap = closedRecipe.getClosedRecipeIngredientMap();
		
		closedRecipe.setClosedRecipeIngredientMap(null);
		closedRecipe = closedRecipeRepository.save(closedRecipe);
		
		if (closedRecipeIngredientMap != null) {
			for (Long ingredientId : closedRecipeIngredientMap.keySet()) {
				closedRecipeIngredient = closedRecipeIngredientMap.get(ingredientId);
				closedRecipeIngredient.setClosedRecipeIngredientId(new ClosedRecipeIngredientId());
				closedRecipeIngredient.getClosedRecipeIngredientId().setIngredientId(ingredientId);
				closedRecipeIngredient.getClosedRecipeIngredientId().setClosedRecipe(closedRecipe);
			}
			
			closedRecipeIngredientRepository.saveAll(closedRecipeIngredientMap.values());
			
			closedRecipe.setClosedRecipeIngredientMap(closedRecipeIngredientMap);
		}
		
		return closedRecipe;
	}
	
	/*
	 * Delete closed recipe from database.
	 */
	public void deleteClosedRecipe(Integer id) {
		closedRecipeRepository.deleteById(id);
	}
}