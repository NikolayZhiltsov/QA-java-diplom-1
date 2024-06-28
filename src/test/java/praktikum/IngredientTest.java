package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    IngredientType ingredientType;
    Ingredient ingredient;
    private String name;
    private float price;

    public IngredientTest(IngredientType ingredientType, String name, float price){
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.FILLING, "Тестовая начинка из филе подгоревшей жёппки тестировщика", 988},
                {IngredientType.SAUCE, "Тестовый соус из слёз тестировщика", 100500.15F}
        };
    }

    @Test
    public void getPriceTest() {
        ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getIngredientTypeTest() {
        ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(ingredientType, ingredient.getType());
    }
}
