import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    public void fecharNavegador(){
        driver.quit();
    }

//    @Test
//    public void openBronwser(){
//        driver.get("http://www.google.com");
//        driver.findElement(By.cssSelector("[title=Pesquisar]")).sendKeys("Ola");
//        driver.findElement(By.cssSelector("[title=Pesquisar]")).sendKeys(Keys.ENTER);
//
//        String resultado = driver.findElement(By.tagName("body")).getText();
//        boolean contemSignificado = resultado.contains("Dicionário");
//        System.out.println(resultado);
//        Assertions.assertTrue(contemSignificado);
//        driver.quit();
//        }


}

