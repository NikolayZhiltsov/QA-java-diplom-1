package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    Bun bun;
    private String name;
    private float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Просто бургер", 1.0F},
                {"English Bun", 8418.5F},
                {"123", 123},
                {null, 1.01F},
                {"", 999},
                {"Бургер со всем подряд", 8118.8118F},
                {"Бургер со спецсимволами #$%", 999.45F},
                {"Бургер Ксяоми (топ за свои деньги)", Float.MIN_VALUE},
                {"Илитный бургер", Float.MAX_VALUE}
        };
    }

    @Test
    public void getNameTest() {
        bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0);
    }
}
