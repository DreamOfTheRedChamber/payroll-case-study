import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldTest {
    @Test
    public void testHelloWorld()
    {
        HelloWorld instance = new HelloWorld();
        assertEquals("HELLOWORLD", instance.getHelloWorld());
    }
}
