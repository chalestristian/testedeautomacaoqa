package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.List;
import java.lang.String;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class listagemquestao {
    public static WebDriver driver = null;
    public static void main(String[] args) {
        File file = new File("/home/chalestristian/Projects/testedeautomacaoqa/config/chromedriver/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        WebDriver driver = new ChromeDriver();
        driver.get("https://opentdb.com/");

        driver.findElement(By.xpath("//*[@id=\"page-top\"]/section/div/div/div/a[1]")).click();

        driver.findElement(By.name("query")).sendKeys("Science: Computers");
        Select type = new Select(driver.findElement(By.name("type")));
        type.selectByVisibleText("Category");

        driver.findElement(By.cssSelector("button.btn")).click();
        WebElement targetRows = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody"));
        List<WebElement> targetRowsList = targetRows.findElements(By.tagName("tr"));

        System.out.println("Total number of Rows in the table are : "+ targetRowsList.size());

        WebElement targetPagination = driver.findElement(By.xpath("//ul[@class='pagination pagination-lg']"));
        Boolean paginationExists = targetPagination.findElements(By.tagName("li")).size() > 0;

        if(paginationExists){

            System.out.println("Pagination Controller Exists!");
            driver.findElement(By.xpath("//*[@id=\"page-top\"]/div[2]/center/ul/li[2]/a")).click();

            if(driver.getCurrentUrl().toString().equals("https://opentdb.com/browse.php?page=2&query=Science:%20Computers&type=Category")) {
                System.out.println("Pagination Controller Exists and Works");

            }else {

                System.out.println("Pagination Controller Exists but, don't Work");
            }
        }else{

            System.out.println("Pagination Controller Doesn't Exists!");
        }
        driver.close();
    }
}
