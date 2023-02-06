import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class OrderPage {
    private WebDriver driver;
    public static final By UP_ORDER_BUTTON = By.xpath(".//button[text()='Заказать]");//Верхняя кнопка заказать
    public static final By DOWN_ORDER_BUTTON = By.className("Button_UltraBig__UU3Lp");//Нижняя кнопка заказать
    private By accept_cookies = By.xpath("//*[@id=\"rcc-confirm-button\"]"); // Принять куки
    //Имя
    public void clickButton(By button){
        driver.findElement(button).click();
    }
    private static final By NAME_FIELD = By.xpath(".//input[@placeholder='* Имя']");
    //Фамилия
    private static final By SECOND_NAME_FIELD = By.xpath(".//input[@placeholder='* Фамилия']");
    //Адрес
    private static final By ADDRESS_FIELD = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Станция метро
    private static final By METRO_FIELD = By.className("select-search");

    //Номер телефона
    private static final By PHONE_NUMBER_FIELD = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private static final By BUTTON_NEXT = By.xpath(".//button[text()='Далее']");
    //_______________________________________________Форма про аренду__________________________________________________//
    //Когда привезти
    private static final By DATE_OF_DELIVERY_FIELD = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Срок аренды
    private static final By RENT_TIME_FIELD = By.className("Dropdown-placeholder");
    //цвет самоката: 1. черный; 2. серый
    private static final By BLACK_COLOR_SCOOTER = By.xpath(".//input[@id='black']");
    private static final By GRAY_COLOR_SCOOTER = By.xpath(".//input[@id='grey']");
    //Кнопка заказать
    private static final By ORDER_BUTTON = By.xpath(".//button[2][text()='Заказать']");
    //Потдвердить заказ
    private static final By ACCEPT_ORDER = By.xpath(".//button[text()='Да']");
    private static final By SHOW_STATUS = By.xpath(".//button[text()='Посмотреть статус']");
    private static final By ORDER_IS_PROCESSED = By.className("Order_Modal__YZ-d3");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    public void cookies(){
        driver.findElement(accept_cookies).click();
    }

    public void enterName(String name) {
        driver.findElement(NAME_FIELD).click();
        driver.findElement(NAME_FIELD).sendKeys(name);
    }

    public void enterSecondName(String secondName) {
        driver.findElement(SECOND_NAME_FIELD).click();
        driver.findElement(SECOND_NAME_FIELD).sendKeys(secondName);
    }

    public void enterAddress(String address) {
        driver.findElement(ADDRESS_FIELD).click();
        driver.findElement(ADDRESS_FIELD).sendKeys(address);
    }

    public void enterMetro(String metro) {
        driver.findElement(METRO_FIELD).click();
        driver.findElement(By.xpath("//*[.='"+ metro + "']")).click();
    }

    public void enterPhone(String phoneNum) {
        driver.findElement(PHONE_NUMBER_FIELD).click();
        driver.findElement(PHONE_NUMBER_FIELD).sendKeys(phoneNum);
    }

    public void enterUserData(String name, String secondName, String address, String metro, String phone) {
        enterName(name);
        enterSecondName(secondName);
        enterAddress(address);
        enterMetro(metro);
        enterPhone(phone);
    }

    public void ButtonNextClick() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(BUTTON_NEXT).click();
    }

    public void enterDateOfDelivery(String dayOfTheMonth) {
        driver.findElement(DATE_OF_DELIVERY_FIELD).click();
        driver.findElement(By.xpath(".//input[@placeholder='* Когда привезти самокат']")).sendKeys(dayOfTheMonth);
        driver.findElement(By.className("App_App__15LM-")).click();
    }

    public void enterRentTime(int countOfDays) {
        driver.findElement(RENT_TIME_FIELD).click();
        driver.findElement(By.xpath(".//div[" + countOfDays + "][@class='Dropdown-option']")).click();
    }

    public void enterColor(String color) {
        if(color.equals("черный")){
            driver.findElement(BLACK_COLOR_SCOOTER).click();
        } else if ( color.equals("серый")) {
            driver.findElement(GRAY_COLOR_SCOOTER).click();
        }
    }
    public void OrderButtonClick(){
        driver.findElement(ORDER_BUTTON).click();
    }
    public void AcceptOrderClick(){
        driver.findElement(ACCEPT_ORDER).click();
    }
    public void showStatusClick(){
        driver.findElement(SHOW_STATUS).click();
    }
    public void orderDetails( String dayOfTheMonth, int countOfDays, String color){
        enterDateOfDelivery(dayOfTheMonth);
        enterRentTime(countOfDays);
        enterColor(color);
        OrderButtonClick();
        AcceptOrderClick();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.className("ORDER_IS_PROCESSED")));
        showStatusClick();
        assertTrue(driver.findElement(ORDER_IS_PROCESSED).isDisplayed());







    }
}
