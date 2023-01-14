package ahumblepastel.service;

import java.util.List;

import ahumblepastel.models.Food;
import ahumblepastel.repository.FoodRepository;

public class FoodService {
    
    private FoodRepository repository;

    public FoodService(FoodRepository repository) {
        this.repository = repository;
    }

    public Food getFoodById(int id) {
        return repository.getFoodById(id);
    }

    public List<Food> listAllFoods() {
        return repository.getMany();
    }

}
