import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageScooter {

    private WebDriver driver;
    private By accept_cookies = By.xpath("//*[@id=\"rcc-confirm-button\"]"); //Принять куки
    public static final By UP_ORDER_BUTTON = By.xpath(".//button[text()='Заказать]");//Верхняя кнопка заказать
    public static final By DOWN_ORDER_BUTTON = By.className("Button_UltraBig__UU3Lp");//Нижняя кнопка заказать
    public  HomePageScooter (WebDriver driver){
        this.driver = driver;
    }
    public void cookies(){
        driver.findElement(accept_cookies).click();
    }
    public void clickButton(By button){
        driver.findElement(button).click();
    }

    String first_answer = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    String second_answer = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    String third_answer = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    String fourth_answer = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    String fifth_answer = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    String sixth_answer = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    String seventh_answer = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    String eighth_answer = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    String[] Answers = {
            first_answer,
            second_answer,
            third_answer,
            fourth_answer,
            fifth_answer,
            sixth_answer,
            seventh_answer,
            eighth_answer,
    };
    public void equalsAnswer(){
        for(int i =0; i <= Answers.length - 1; i++){
            try {
                driver.findElement(By.id("accordion__heading-"+ i +"")).click();
                driver.findElement(By.xpath("//p[text()='"+Answers[i]+"']"));
                System.out.println("При нажатии на "+ (i + 1) + " пункт, появляется сообщение: "+ Answers[i]);
            } catch (NoSuchElementException e) {
                System.out.println("Ошибка:" + e);
            }
        }
    }
}
