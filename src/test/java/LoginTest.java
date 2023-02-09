import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest{

    @Test
    public void loginSite(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();

        String produtos = driver.findElement(By.className("title")).getText().toLowerCase();
        Assertions.assertEquals(produtos,"products");
    }

    @Test
    public void senhaVazia(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.name("login-button")).click();

        String mensagemDeErro = driver.findElement(By.cssSelector("[data-test='error']"))
                                                                .getText().toUpperCase();
        Assertions.assertEquals("EPIC SADFACE: PASSWORD IS REQUIRED",mensagemDeErro);
    }
}
