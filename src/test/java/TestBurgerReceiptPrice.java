

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

@RunWith(Parameterized.class)
public class TestBurgerReceiptPrice {

    private String nameBun;
    private float priceBun;
    private IngredientType type;
    private String nameIngredient;
    private float priceIngredient;

    public TestBurgerReceiptPrice(String nameBun, float priceBun, IngredientType type, String nameIngredient, float priceIngredient) {
        this.nameBun = nameBun;
        this.priceBun = priceBun;
        this.type = type;
        this.nameIngredient = nameIngredient;
        this.priceIngredient = priceIngredient;
    }


    @Parameterized.Parameters ()
    public static Object[][] TestGetFoodLionReceiptPrice() {
        return new Object[][]{
                {"Bulka", 10.00F, IngredientType.SAUCE,"Salsa",5.00F},
                {"Baton", 10.00F, IngredientType.SAUCE,"Sriracha",5.00F},
                {"Hleb", 10.00F, IngredientType.FILLING,"Woster",5.00F},
        };
    }

    private int index = new Random().nextInt(9);

    Burger burger = new Burger();
    Bun bunSpy;
    Ingredient ingredientSpy;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        Bun bun = new Bun(nameBun, priceBun);
        bunSpy = Mockito.spy(bun);
        Ingredient ingredient = new Ingredient(type, nameIngredient, priceIngredient);
        ingredientSpy = Mockito.spy(ingredient);

        burger.setBuns(bunSpy);
        for(int i=0; i<=index; i++){
            burger.addIngredient(ingredientSpy);
        }
    }

    @Test
    public void testGetPrice(){
        float totalPrice = (priceBun*2)+(priceIngredient*(index+1));
       Assert.assertEquals(totalPrice, burger.getPrice(), 0.0);
    }

    @Test
    public void testGetReceipt(){
        Assert.assertNotNull(burger.getReceipt());
    }
}
