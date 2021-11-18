package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class buscaquestoes {
    public static void main(String[] args) {

        File file = new File("/home/chalestristian/Projects/testedeautomacaoqa/config/chromedriver/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.get("https://opentdb.com");

        WebElement browse = driver.findElement(By.xpath("//*[@id=\"page-top\"]/section/div/div/div/a[1]"));
        browse.click();
        WebElement caixaDeBusca = driver.findElement(By.id("query"));
        caixaDeBusca.sendKeys("Science: Computers");

        Select country = new Select(driver.findElement(By.id("type")));
        country.selectByValue("Category");

        WebElement botaoBusca = driver.findElement(By.xpath("//*[@id=\"page-top\"]/div[1]/form/div/button"));
        botaoBusca.click();
    }
}