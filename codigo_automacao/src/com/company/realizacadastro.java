package com.company;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.io.File;


public class realizacadastro {
    public static void main(String[] args) {
        File file = new File("/home/chalestristian/Projects/testedeautomacaoqa/config/chromedriver/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();

        driver.get("https://opentdb.com/");

        WebElement login = driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[5]/a"));
        login.click();

        WebElement register = driver.findElement(By.xpath("//*[@id=\"page-top\"]/div[2]/form/div[4]/a"));
        register.click();


        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("luroassendo23");


        WebElement password  = driver.findElement(By.id("password"));
        password.sendKeys("Alface123");


        WebElement password_again = driver.findElement(By.id("password_again"));
        password_again.sendKeys("Alface123");


        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("luisassrasosendo@gmail.com");

        WebElement registrar = driver.findElement(By.xpath("//*[@id=\"page-top\"]/div[2]/form/button"));
        registrar.click();

    }

}
