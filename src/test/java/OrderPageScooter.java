import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class OrderPageScooter {
    private WebDriver driver;
    private String phoneNum;

    private String date;


    //Имя
    private static final By NAME_FIELD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    //Фамилия
    private static final By SECOND_NAME_FIELD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    //Адрес
    private static final By ADDRESS_FIELD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    //Станция метро
    private static final By METRO_FIELD = By.className("select-search");
    private static final By SELECT_METRO = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[7]");
    //Номер телефона
    private static final By PHONE_NUMBER_FIELD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    private static final By BUTTON_NEXT = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");


    //_______________________________________________Форма про аренду__________________________________________________//
    //Когда привезти
    private static final By DATE_OF_DELIVERY_FIELD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/input");
    private static final By SET_DELIVERY_DATE = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[7]");
    //Срок аренды
    private static final By RENT_TIME_FIELD = By.className("Dropdown-placeholder");
    private static final By LEASE_TERM = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[2]");

    //цвет самоката: 1. черный; 2. серый
    private static final By BLACK_COLOR_SCOOTER = By.xpath("//*[@id=\"black\"]");
    private static final By GRAY_COLOR_SCOOTER = By.xpath("//*[@id=\"grey\"]");
    //Кнопка заказать
    private static final By ORDER_BUTTON = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    //Потдвердить заказ
    private static final By ACCEPT_ORDER = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");

    public OrderPageScooter(WebDriver driver) {
        this.driver = driver;
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
        driver.findElement(By.xpath("//*[.='Таганская']")).click();
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

    public void enterDateOfDelivery() {
        driver.findElement(DATE_OF_DELIVERY_FIELD).click();
        driver.findElement(By.className("react-datepicker__day--today")).click();

    }

    public void enterRentTime() {
        driver.findElement(RENT_TIME_FIELD).click();
        driver.findElement(LEASE_TERM).click();


    }

    public void enterColor() {
        driver.findElement(BLACK_COLOR_SCOOTER).click(); // <- закоментить, если нужно выбрать другой чекбокс
        //driver.findElement(GRAY_COLOR_SCOOTER).click(); //<- раскоментить, если нужно выбрать этот чек бокс

    }
    public void OrderButtonClick(){
      driver.findElement(ORDER_BUTTON).click();
    }
    public void AcceptOrderClick(){
        driver.findElement(ACCEPT_ORDER).click();
    }
    public void orderDetails(){
        enterDateOfDelivery();
        enterRentTime();
        enterColor();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        OrderButtonClick();
        AcceptOrderClick();



    }
}
