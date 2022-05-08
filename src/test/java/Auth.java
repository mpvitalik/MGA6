import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class Auth {
    public static void main(String[] args) throws NoSuchElementException, InterruptedException {
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
        WebElement nickName = driver.findElement(By.xpath("//div[@id=\"headerControlPanel\"]/div[1]/div[1]/ul/li[1]/a"));
        String nickNameText = nickName.getText();
        Assert.assertEquals("sashamga2", nickNameText);

        driver.quit();
    }
}
