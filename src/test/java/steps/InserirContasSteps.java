package steps;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.gl.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class InserirContasSteps {

    private WebDriver driver;

    @Dado("^que desejo adicionar uma conta$")
    public void que_desejo_adicionar_uma_conta() throws Throwable {
        driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me/");
        driver.findElement(By.id("email")).sendKeys("luisitalomoreirasouza@gmail.com");
        driver.findElement(By.name("senha")).sendKeys("123456");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Adicionar")).click();

    }

    @Quando("^adiciona a conta \"([^\"]*)\"$")
    public void adiciona_a_conta(String arg1) throws Throwable {
        driver.findElement(By.id("nome")).sendKeys(arg1);
        driver.findElement(By.tagName("button")).click();
    }
//
//    @Dado("^que estou acessando a aplicacao$")
//    public void que_estou_acessando_a_aplicacao() throws Throwable {
//        driver = new ChromeDriver();
//        driver.get("https://seubarriga.wcaquino.me/logout");
//    }
//
//    @Quando("^informo o usuario \"([^\"]*)\"$")
//    public void informo_o_usuario(String arg1) throws Throwable {
//        driver.findElement(By.id("email")).sendKeys(arg1);
//
//    }
//
//    @Quando("^a senha \"([^\"]*)\"$")
//    public void a_senha(String arg1) throws Throwable {
//        driver.findElement(By.id("senha")).sendKeys(arg1);
//
//    }
//
//    @Quando("^seleciona entrar$")
//    public void seleciona_entrar() throws Throwable {
//        driver.findElement(By.tagName("button")).click();
//
//    }
//
//    @Entao("^visualizo a pagina inicial$")
//    public void visualizo_a_pagina_inicial() throws Throwable {
//       String texto = driver.findElement(By.xpath("//div[contains(text(),'Bem vindo, italo luis!')]")).getText();
//        Assert.assertEquals("Bem vindo, italo luis!", texto);
//    }
//
//    @Quando("^seleciono Contas$")
//    public void seleciono_Contas() throws Throwable {
//        driver.findElement(By.xpath("//body/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]")).click();
//    }
//
//    @Quando("^seleciona Adicionar$")
//    public void seleciona_Adicionar() throws Throwable {
//        driver.findElement(By.xpath("//a[contains(text(),'Adicionar')]")).click();
//
//    }
//
//    @Quando("^informa a conta \"([^\"]*)\"$")
//    public void informa_a_conta(String arg1) throws Throwable {
//        driver.findElement(By.id("nome")).sendKeys(arg1);
//
//    }
//
//    @Quando("^seleciono Salvar$")
//    public void seleciono_Salvar() throws Throwable {
//        driver.findElement(By.xpath("//button[contains(text(),'Salvar')]")).click();
//
//    }
//
//    @Entao("^a conta e inserida com sucesso$")
//    public void a_conta_e_inserida_com_sucesso() throws Throwable {
//        String texto = driver.findElement(By.xpath("//div[contains(text(),'Conta adicionada com sucesso!')]")).getText();
//        Assert.assertEquals("Conta adicionada com sucesso!", texto);
//    }
//
//    @Entao("^vou notificar que a conta e obrigatoria$")
//    public void vou_notificar_que_a_conta_e_obrigatoria() throws Throwable {
//       String texto = driver.findElement(By.xpath("//div[contains(text(),'Informe o nome da conta')]")).getText();
//       Assert.assertEquals("Informe o nome da conta", texto);
//    }
//
//    @Entao("^sou notificado que ja existe conta com esse nome$")
//    public void sou_notificado_que_ja_existe_conta_com_esse_nome() throws Throwable {
//        String texto = driver.findElement(By.xpath("//div[contains(text(),'Já existe uma conta com esse nome!')]")).getText();
//        Assert.assertEquals("Já existe uma conta com esse nome!", texto);
//    }
//
    @Entao("^recebo a mensagem \"([^\"]*)\"$")
    public void receboAMensagem(String arg1) throws Throwable {
        String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();
        Assert.assertEquals(arg1, texto);
    }
//
//
//
////        @Before                  //antecede o cenario
////        public void inicio(){
////            System.out.println("comecando aqui");
////        }
        @After(order = 1)
        public void screeshot(Scenario cenario) throws IOException {
            File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(file, new File("target/screenshots/"+cenario.getId()+".jpg"));
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        @After (order = 0)                    //apos os cenario
        public void fecharBrowser() {
            driver.quit();
        }
}
