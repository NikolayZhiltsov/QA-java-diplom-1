package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    IngredientType ingredientType;

    @Test
    public void sauceTest() {
        ingredientType = ingredientType.SAUCE;
        assertEquals("SAUCE", ingredientType.name());
    }

    @Test
    public void fillingTest() {
        ingredientType = ingredientType.FILLING;
        assertEquals("FILLING", ingredientType.name());
    }
}
