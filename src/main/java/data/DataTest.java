package data;

import org.testng.annotations.DataProvider;

public class DataTest {
    @DataProvider
    public static Object[][] getCert(){
        return new Object[][]{
                {"45924126","true"},
                {"111111111","false"},
                {"70240235","true"},

        };
    }
}