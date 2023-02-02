import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageScooter {

    private WebDriver driver;
    //урл
    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru";
    //Принять куки
    private static final By ACCEPT_COOKIES = By.xpath("//*[@id=\"rcc-confirm-button\"]");
    //Верхняя кнопка заказать
    public static final By UP_ORDER_BUTTON = By.className("Header_Button__28dPOg");
    //Нижняя кнопка заказать
    public static final By DOWN_ORDER_BUTTON = By.className("Button_UltraBig__UU3Lp");

    public  HomePageScooter (WebDriver driver){
        this.driver = driver;
    }

    public void cookies(){
        driver.findElement(ACCEPT_COOKIES).click();
    }
    public void clickButton(By button){
        driver.findElement(button).click();
    }

}
