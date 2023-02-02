import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class HomePageScooter {

    private WebDriver driver;
    //Принять куки
    private static final By ACCEPT_COOKIES = By.xpath("//*[@id=\"rcc-confirm-button\"]");
    //Верхняя кнопка заказать
    public static final By UP_ORDER_BUTTON = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]");
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




    public void equalsAnswer(){
        String[] Asnwers = {
                "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                "Да, обязательно. Всем самокатов! И Москве, и Московской области.",
        };
        System.out.println(Arrays.toString(Asnwers));

        for(int i =0; i < 8; i++){
            try {
                driver.findElement(By.id("accordion__heading-"+ i +"")).click();
                WebElement text = driver.findElement(By.xpath("//p[text()='"+Asnwers[i]+"']"));
                System.out.println(text);
            } catch (NoSuchElementException e) {
                System.out.println("Ошибка:" + e);
            }
        }
    }
}
