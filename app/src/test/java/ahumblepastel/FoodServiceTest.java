package ahumblepastel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ahumblepastel.models.Food;
import ahumblepastel.repository.FoodRepository;
import ahumblepastel.service.FoodService;

public class FoodServiceTest {

    @Mock
    private FoodRepository repository;
   
    private FoodService underTest;


    @BeforeEach
    void setup() {
        repository = mock(FoodRepository.class);
        underTest = new FoodService(repository);
    }
    
    @Test
    @DisplayName("Should return a Food from a repository")
    void shouldReturnAFoodFromARepository() {

        // Given...
        List<String> ingredients = List.of(
            "Ham",
            "Cheese",
            "Tomato",
            "Oregano"
        );

        var expectedFood = new Food(
            1,
            "Pizza Pastel",
            BigDecimal.valueOf(5.50),
            ingredients
        );

        when(repository.getFoodById(expectedFood.getId()))
            .thenReturn(expectedFood);
        
        // When...
        Food actualFood = underTest.getFoodById(expectedFood.getId());

        // Verify...
        assertEquals(expectedFood, actualFood);
        verify(repository, times(1)).getFoodById(expectedFood.getId());

    }

    @Test
    @DisplayName("Should return a list of Food, for the front end")
    void shouldReturnAListOfFoodForTheFronEnd() {
    
        // Given...
        List<String> ingredients = List.of(
            "Ham",
            "Cheese",
            "Tomato",
            "Oregano"
        );

        List<Food> expectedFoodList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            expectedFoodList.add(new Food(
                i,
                i + "° Pastel",
                BigDecimal.valueOf(5.50),
                ingredients
            ));
        }

        when(repository.getMany())
            .thenReturn(expectedFoodList);
    
        // When...
        List<Food> actualFood = underTest.listAllFoods();
    
        // Then...
        assertEquals(expectedFoodList, actualFood);
        verify(repository, times(1)).getMany(); // The Repository has been called

        assertEquals(4, actualFood.size()); //The size of the list is correct
    
    }
    


}
