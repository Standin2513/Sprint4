import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FAQTest {
    private WebDriver driver;

    @Before
    public void upDriverGoogle() {
        System.setProperty("webdriver.chrome.driver", "D:\\projects3\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru");
    }

    @Test
    public void test() {
        MainPage mainPageTest = new MainPage(driver);
        mainPageTest.cookies();
        WebElement element = driver.findElement(By.className("accordion"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        mainPageTest.equalsAnswer();
    }

    //закрываю браузер
    @After
    public void tearDown() {
        driver.close();
    }
}
