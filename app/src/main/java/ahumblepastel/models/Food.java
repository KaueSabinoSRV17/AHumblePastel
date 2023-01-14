package ahumblepastel.models;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    private int id;
    private String name;
    private BigDecimal price;
    private List<String> ingredients;
    private String imageLink;

    public Food(int id, String name, BigDecimal price, List<String> ingredientes) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ingredients = ingredientes;
    }

}
