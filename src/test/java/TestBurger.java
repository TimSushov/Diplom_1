import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import org.mockito.Mock;

import java.util.Random;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {

    private int index = 2 + new Random().nextInt(9);

    Burger burger = new Burger();

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Before
    public void addIngredient(){
        for(int i=0; i<=index; i++){
            burger.addIngredient(ingredient);
        }
    }

    @Test
    public void testRemoveIngredient(){
        burger.removeIngredient(index);
    }

    @Test
    public void testMoveIngredient(){
        burger.moveIngredient(index, index-1);
    }
}
