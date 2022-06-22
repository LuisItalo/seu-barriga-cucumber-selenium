package runner;

import com.google.j2objc.annotations.Weak;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/inserir_conta.feature",  //procura local das features
        glue = "steps",                                 //procura local dos steps
        tags = "~@ignore",                                 //escolhe ou ignora cenario a executar teste (@esse / ~@ignore)
        plugin = "pretty",
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        strict = false,
        dryRun = false
)

public class RunnerTest {
    @BeforeClass
    public static void reset(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me/");
        driver.findElement(By.id("email")).sendKeys("luisitalomoreirasouza@gmail.com");
        driver.findElement(By.id("senha")).sendKeys("123456");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("reset")).click();
        driver.quit();

    }

}
