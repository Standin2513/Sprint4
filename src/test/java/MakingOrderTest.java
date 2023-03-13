import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class MakingOrderTest {
    private WebDriver driver;
    @Before
    public void upDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\projects3\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru");
    }
    @Test
    public void makeOrderUpTest() {
        doTest(OrderPage.UP_ORDER_BUTTON);
    }
    public void doTest(By button){
        OrderPage orderTest = new OrderPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        orderTest.cookies();
        orderTest.clickButton(button);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        orderTest.enterUserData("Дмитрий", "Зеленов", "Юности 13", "Таганская", "88005553535");
        orderTest.ButtonNextClick();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        orderTest.orderDetails("05.02.2023", 2,"серый");
    }
    @Test
    public void makeOrderDownTest() {
        doTest(OrderPage.DOWN_ORDER_BUTTON);
    }
    @After
    public void closeDriver(){
        driver.quit();
    }
}