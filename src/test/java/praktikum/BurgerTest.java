package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Before
    public void setBurger() {
        burger = new Burger();
    }

    @Test
    public void setBunTest(){
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest(){
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredientTest(){
        String expectedIngredient = "Тестовая начинка из непригодившейся параметризации";
        String baseIngredient = "Тестовый соус из моков и стабов";
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, baseIngredient,9994.45F));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, expectedIngredient, 851));
        burger.moveIngredient(0,1);
        assertEquals(expectedIngredient, burger.ingredients.get(0).name);

    }

    @Test
    public void getPriceTest(){
        float basePrice = 584;
        float expectedPrice = basePrice * 2 + basePrice;
        Mockito.when(bun.getPrice()).thenReturn(basePrice);
        Mockito.when(ingredient.getPrice()).thenReturn(basePrice);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptBurgerTest() {
        burger.setBuns(bun);
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Тестовая начинка из непригодившейся параметризации", 851));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Тестовый соус из моков и стабов",9994.45F));
        String expectedReceipt = burger.getReceipt();
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}
