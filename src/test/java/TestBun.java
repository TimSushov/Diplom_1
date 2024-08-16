import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class TestBun {

    private String name = "Krabsburger";
    private float price = 10.0F;

    Bun bun = new Bun(name, price);

    @Test
    public void testGetName(){
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void testGetPrice(){
        Assert.assertEquals(price, bun.getPrice(), 0.0);
    }

}
