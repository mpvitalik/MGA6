import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cashier {
    @Test
    public void testCashier() throws NoSuchElementException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/vitalii/IdeaProjects/wd/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rc.conquestador.com/en-int/login");

        WebElement mail = driver.findElement(By.xpath("//div[@id=\"page-container\"]/div[1]/div/form/div[1]/div[1]/div/span/input"));
        WebElement password = driver.findElement(By.xpath("//div[@id=\"page-container\"]/div[1]/div/form/div[1]/div[2]/div/span/input"));
        WebElement button = driver.findElement(By.xpath("//div[@id=\"page-container\"]/div[1]/div/form/div[2]/div/div/button"));

        mail.click();
        mail.sendKeys("ivanaleksandrov2012@gmail.com");
        password.click();
        password.sendKeys("qqq111qqq");
        button.click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@id=\"headerControlPanel\"]/div[1]/div[1]/ul/li[4]/a")).click();
        Thread.sleep(5000);

        //Проверка, что касса загрузилась
        driver.switchTo().frame(driver.findElement(By.id("cashIframe")));
        Assert.assertEquals("All payment methods", driver.findElement(By.xpath("//div[@id=\"cabbagino\"]/div[2]/div/h4")).getText());

        driver.quit();
    }
//    public static void main(String[] args) throws NoSuchElementException, InterruptedException {
//
//    }
}
