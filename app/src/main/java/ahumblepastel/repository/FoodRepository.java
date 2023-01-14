package ahumblepastel.repository;

import java.util.List;

import ahumblepastel.models.Food;

public interface FoodRepository {
   public Food getFoodById(int id);
   public List<Food> getMany();
}
