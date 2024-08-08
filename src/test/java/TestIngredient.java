import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class TestIngredient {

    @Mock
    IngredientType ingredientType;

    private IngredientType type = ingredientType;
    private String name = "Krabsburger";
    private float price =  10;

    Ingredient ingredient = new Ingredient(type, name, price);

    @Test
    public void testGetType(){
        Assert.assertEquals(type, ingredient.getType());
    }

    @Test
    public void testGetName(){
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void testGetPrice(){
        Assert.assertEquals(price, ingredient.getPrice(), 0.0);
    }
}
