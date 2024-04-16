import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemsTest {
    ItemsTest items;
    @Before
    public void setUp() throws Exception{
        items = new ItemsTest();
    }
    @Test
    public void getName() throws Exception{
        String expected = "Milk";
        Items items = new Items("Milk", "3.23", "05/24/2024","Food" );
        String actual = items.getName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void setName() throws Exception{
        String expected = "Tom";
        Items items = new Items("Milk", "3.23", "05/24/2024","Food" );
        items.setName("Tom");
        String actual = items.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPrice() throws Exception{
        Double expected = 9.00;
        Items items = new Items("Milk", "9.00", "05/24/2024","Food" );
        String actual = items.getPrice();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void setPrice() throws Exception{
        Double expected = 3.23;
        Items items = new Items("Milk", "9.00", "05/24/2024","Food" );
        items.setPrice("3.23");
        String actual = items.getPrice();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getType() throws Exception{
        String expected = "Food";
        Items items = new Items("Milk", "9.00", "05/24/2024","Food" );
        String actual = items.getType();
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void setTypes() throws Exception{
        String expected = "Drinks";
        Items items = new Items("Milk", "9.00", "05/24/2024","Food" );
        items.setType("Drinks");
        String actual = items.getType();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getExpiration(){
        String expected = "04/16/2024";
        Items items = new Items("Milk", "9.00", "04/16/2024","Food" );
        String actual = items.getExpiration();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void setExpiration(){
        String expected = "04/15/2024";
        Items items = new Items("Milk", "9.00", "04/16/2024","Food" );
        items.setExpiration("04/15/2024");
        String actual = items.getExpiration();
        Assert.assertEquals(expected, actual);
    }

}