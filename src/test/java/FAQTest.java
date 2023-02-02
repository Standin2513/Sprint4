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
    public void upDriver()

    {
        System.setProperty("webdriver.chrome.driver", "D:\\projects3\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");
        driver.findElement(By.xpath("//*[@id=\"rcc-confirm-button\"]")).click();
    }

    @Test
    public void test() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[5]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);


    }
};
