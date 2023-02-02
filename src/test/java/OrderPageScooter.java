import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPageScooter {
    private WebDriver driver;





    //Имя
    private static final By NAME_FIELD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    //Фамилия
    private static final By SECOND_NAME_FIELD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    //Адрес
    private static final By ADDRESS_FIELD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    //Станция метро
    private static final By METRO_FIELD = By.className("select-search");

    //Номер телефона
    private static final By PHONE_NUMBER_FIELD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    private static final By BUTTON_NEXT = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");



    //_______________________________________________Форма про аренду__________________________________________________//
    //Когда привезти
    private static final By DATE_OF_DELIVERY_FIELD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/input");

    //Срок аренды
    private static final By RENT_TIME_FIELD = By.className("Dropdown-placeholder");


    //цвет самоката: 1. черный; 2. серый
    private static final By BLACK_COLOR_SCOOTER = By.xpath("//*[@id=\"black\"]");
    private static final By GRAY_COLOR_SCOOTER = By.xpath("//*[@id=\"grey\"]");
    //Кнопка заказать
    private static final By ORDER_BUTTON = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    //Потдвердить заказ
    private static final By ACCEPT_ORDER = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");
    private static final By SHOW_STATUS = By.xpath(".//button[text()='Посмотреть статус'");

    private By orderIsProcessed = By.className("Order_Modal__YZ-d3");



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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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
        if(countOfDays == 1){
            driver.findElement(By.xpath(".//div[1][@class='Dropdown-option']")).click();
        } else if (countOfDays == 2) {
            driver.findElement(By.xpath(".//div[2][@class='Dropdown-option']")).click();
        } else if (countOfDays == 3) {
            driver.findElement(By.xpath(".//div[3][@class='Dropdown-option']")).click();
        } else if (countOfDays == 4) {
            driver.findElement(By.xpath(".//div[4][@class='Dropdown-option']")).click();
        } else if (countOfDays == 5) {
            driver.findElement(By.xpath(".//div[5][@class='Dropdown-option']")).click();
        } else if (countOfDays == 6) {
            driver.findElement(By.xpath(".//div[6][@class='Dropdown-option']")).click();
        } else {
            driver.findElement(By.xpath(".//div[7][@class='Dropdown-option']")).click();
        }

    }

    public void enterColor(String color) {
        if(color == "черный"){
            driver.findElement(BLACK_COLOR_SCOOTER).click();
        } else if ( color == "серый") {
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
    public void orderProcessed(){
        driver.findElement(orderIsProcessed).click();
    }


    public void orderDetails( String dayOfTheMonth, int countOfDays, String color){
        enterDateOfDelivery(dayOfTheMonth);
        enterRentTime(countOfDays);
        enterColor(color);
        OrderButtonClick();
        AcceptOrderClick();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.className("orderIsProcessed")));
        showStatusClick();







    }
}
