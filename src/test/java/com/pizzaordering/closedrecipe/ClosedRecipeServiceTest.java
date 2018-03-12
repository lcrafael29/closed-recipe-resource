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

package com.pizzaordering.closedrecipe;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pizzaordering.closedrecipe.data.ClosedRecipeIngredientRepository;
import com.pizzaordering.closedrecipe.data.ClosedRecipeRepository;
import com.pizzaordering.closedrecipe.entity.ClosedRecipe;
import com.pizzaordering.closedrecipe.entity.ClosedRecipeIngredient;
import com.pizzaordering.closedrecipe.entity.ClosedRecipeIngredientId;
import com.pizzaordering.closedrecipe.service.ClosedRecipeService;

/**
 * Unit test of closed recipe service layer.
 * 
 * @author Rafael Lima Costa
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClosedRecipeServiceTest {
	
	/**
	 * Interface of closed recipe service layer.
	 */
	@Autowired
	ClosedRecipeService closedRecipeService;
	
	/**
	 * Interface of closed recipe repository layer mocked.
	 */
	@MockBean
	ClosedRecipeRepository closedRecipeRepository;
	
	/**
	 * Interface of closed recipe ingredient repository layer mocked.
	 */
	@MockBean
	ClosedRecipeIngredientRepository closedRecipeIngredientRepository;
	
	/**
	 * Test add closed recipe method:
	 * 
	 * > Mock database calls of this flow.
	 * > Test method sending input and comparing returned output with expected output.
	 */
	@Test
	public void addClosedRecipeTest() {
		ClosedRecipe closedRecipe = null;
		ClosedRecipe closedRecipeSaved = null;
		ClosedRecipeIngredient closedRecipeIngredient = null;
		Map<Long, ClosedRecipeIngredient> closedRecipeIngredientMap;
		ClosedRecipe closedRecipeExpected = null;
		
		// Mock closedRecipeRepository.save(closedRecipe) call.
		closedRecipe = new ClosedRecipe();
		closedRecipe.setDescription("Calabresa");
		
		closedRecipeSaved = new ClosedRecipe();
		closedRecipeSaved.setId(1);
		closedRecipeSaved.setDescription("Calabresa");
		
		Mockito.when(closedRecipeRepository.save(closedRecipe)).thenReturn(closedRecipeSaved);
		
		// Mock closedRecipeIngredientRepository.saveAll(closedRecipeIngredientMap.values()) call.
		closedRecipeIngredient = new ClosedRecipeIngredient();
		closedRecipeIngredient.setClosedRecipeIngredientId(new ClosedRecipeIngredientId());
		closedRecipeIngredient.getClosedRecipeIngredientId().setIngredientId(1L);
		closedRecipeIngredient.getClosedRecipeIngredientId().setClosedRecipe(closedRecipeSaved);
		closedRecipeIngredient.setPortionQuantity(3);
		
		closedRecipeIngredientMap = new HashMap<Long, ClosedRecipeIngredient>();
		closedRecipeIngredientMap.put(1L, closedRecipeIngredient);
		
		closedRecipeIngredient = new ClosedRecipeIngredient();
		closedRecipeIngredient.setClosedRecipeIngredientId(new ClosedRecipeIngredientId());
		closedRecipeIngredient.getClosedRecipeIngredientId().setIngredientId(2L);
		closedRecipeIngredient.getClosedRecipeIngredientId().setClosedRecipe(closedRecipeSaved);
		closedRecipeIngredient.setPortionQuantity(5);
		
		closedRecipeIngredientMap.put(2L, closedRecipeIngredient);
		
		Mockito.when(closedRecipeIngredientRepository.saveAll(closedRecipeIngredientMap.values())).thenReturn(closedRecipeIngredientMap.values());
		
		// Input.
		closedRecipe = new ClosedRecipe();
		closedRecipe.setDescription("Calabresa");
		
		closedRecipeIngredient = new ClosedRecipeIngredient();
		closedRecipeIngredient.setPortionQuantity(3);
		
		closedRecipeIngredientMap = new HashMap<Long, ClosedRecipeIngredient>();
		closedRecipeIngredientMap.put(1L, closedRecipeIngredient);
		
		closedRecipeIngredient = new ClosedRecipeIngredient();
		closedRecipeIngredient.setPortionQuantity(5);
		
		closedRecipeIngredientMap.put(2L, closedRecipeIngredient);
		
		closedRecipe.setClosedRecipeIngredientMap(closedRecipeIngredientMap);
		
		// Output.
		closedRecipeExpected = new ClosedRecipe();
		closedRecipeExpected.setId(1);
		closedRecipeExpected.setDescription("Calabresa");
		
		closedRecipeIngredient = new ClosedRecipeIngredient();
		closedRecipeIngredient.setClosedRecipeIngredientId(new ClosedRecipeIngredientId());
		closedRecipeIngredient.getClosedRecipeIngredientId().setIngredientId(1L);
		closedRecipeIngredient.getClosedRecipeIngredientId().setClosedRecipe(closedRecipeExpected);
		closedRecipeIngredient.setPortionQuantity(3);
		
		closedRecipeIngredientMap = new HashMap<Long, ClosedRecipeIngredient>();
		closedRecipeIngredientMap.put(1L, closedRecipeIngredient);
		
		closedRecipeIngredient = new ClosedRecipeIngredient();
		closedRecipeIngredient.setClosedRecipeIngredientId(new ClosedRecipeIngredientId());
		closedRecipeIngredient.getClosedRecipeIngredientId().setIngredientId(2L);
		closedRecipeIngredient.getClosedRecipeIngredientId().setClosedRecipe(closedRecipeExpected);
		closedRecipeIngredient.setPortionQuantity(5);
		
		closedRecipeIngredientMap.put(2L, closedRecipeIngredient);
		
		closedRecipeExpected.setClosedRecipeIngredientMap(closedRecipeIngredientMap);
		
		// Test.
		assertThat(closedRecipeService.addClosedRecipe(closedRecipe)).isEqualTo(closedRecipeExpected);
	}
	
	/**
	 * Test update closed recipe method:
	 * 
	 * > Mock database calls of this flow.
	 * > Test method sending input and comparing returned output with expected output.
	 */
	@Test
	public void updateClosedRecipeTest() {
		ClosedRecipe closedRecipe = null;
		ClosedRecipeIngredient closedRecipeIngredient = null;
		Map<Long, ClosedRecipeIngredient> closedRecipeIngredientMap;
		ClosedRecipe closedRecipeExpected = null;
		
		// Mock closedRecipeRepository.save(closedRecipe) call.
		closedRecipe = new ClosedRecipe();
		closedRecipe.setId(1);
		closedRecipe.setDescription("Calabresa");
		
		Mockito.when(closedRecipeRepository.save(closedRecipe)).thenReturn(closedRecipe);
		
		// Mock closedRecipeIngredientRepository.saveAll(closedRecipeIngredientMap.values()) call.
		closedRecipeIngredient = new ClosedRecipeIngredient();
		closedRecipeIngredient.setClosedRecipeIngredientId(new ClosedRecipeIngredientId());
		closedRecipeIngredient.getClosedRecipeIngredientId().setIngredientId(1L);
		closedRecipeIngredient.getClosedRecipeIngredientId().setClosedRecipe(closedRecipe);
		closedRecipeIngredient.setPortionQuantity(3);
		
		closedRecipeIngredientMap = new HashMap<Long, ClosedRecipeIngredient>();
		closedRecipeIngredientMap.put(1L, closedRecipeIngredient);
		
		closedRecipeIngredient = new ClosedRecipeIngredient();
		closedRecipeIngredient.setClosedRecipeIngredientId(new ClosedRecipeIngredientId());
		closedRecipeIngredient.getClosedRecipeIngredientId().setIngredientId(2L);
		closedRecipeIngredient.getClosedRecipeIngredientId().setClosedRecipe(closedRecipe);
		closedRecipeIngredient.setPortionQuantity(5);
		
		closedRecipeIngredientMap.put(2L, closedRecipeIngredient);
		
		Mockito.when(closedRecipeIngredientRepository.saveAll(closedRecipeIngredientMap.values())).thenReturn(closedRecipeIngredientMap.values());
		
		// Input.
		closedRecipe = new ClosedRecipe();
		closedRecipe.setId(1);
		closedRecipe.setDescription("Calabresa");
		
		closedRecipeIngredient = new ClosedRecipeIngredient();
		closedRecipeIngredient.setPortionQuantity(3);
		
		closedRecipeIngredientMap = new HashMap<Long, ClosedRecipeIngredient>();
		closedRecipeIngredientMap.put(1L, closedRecipeIngredient);
		
		closedRecipeIngredient = new ClosedRecipeIngredient();
		closedRecipeIngredient.setPortionQuantity(5);
		
		closedRecipeIngredientMap.put(2L, closedRecipeIngredient);
		
		closedRecipe.setClosedRecipeIngredientMap(closedRecipeIngredientMap);
		
		// Output.
		closedRecipeExpected = new ClosedRecipe();
		closedRecipeExpected.setId(1);
		closedRecipeExpected.setDescription("Calabresa");
		
		closedRecipeIngredient = new ClosedRecipeIngredient();
		closedRecipeIngredient.setClosedRecipeIngredientId(new ClosedRecipeIngredientId());
		closedRecipeIngredient.getClosedRecipeIngredientId().setIngredientId(1L);
		closedRecipeIngredient.getClosedRecipeIngredientId().setClosedRecipe(closedRecipeExpected);
		closedRecipeIngredient.setPortionQuantity(3);
		
		closedRecipeIngredientMap = new HashMap<Long, ClosedRecipeIngredient>();
		closedRecipeIngredientMap.put(1L, closedRecipeIngredient);
		
		closedRecipeIngredient = new ClosedRecipeIngredient();
		closedRecipeIngredient.setClosedRecipeIngredientId(new ClosedRecipeIngredientId());
		closedRecipeIngredient.getClosedRecipeIngredientId().setIngredientId(2L);
		closedRecipeIngredient.getClosedRecipeIngredientId().setClosedRecipe(closedRecipeExpected);
		closedRecipeIngredient.setPortionQuantity(5);
		
		closedRecipeIngredientMap.put(2L, closedRecipeIngredient);
		
		closedRecipeExpected.setClosedRecipeIngredientMap(closedRecipeIngredientMap);
		
		// Test.
		assertThat(closedRecipeService.updateClosedRecipe(closedRecipe)).isEqualTo(closedRecipeExpected);
	}
}