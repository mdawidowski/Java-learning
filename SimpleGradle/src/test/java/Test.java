import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void testSum(){
        int first = 3;
        int second = 4;
        int calc;
        Assert.assertEquals(first + second, calc = new Calculate().add(first, second));
    }
}
