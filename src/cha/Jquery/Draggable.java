package cha.Jquery;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Draggable {
	WebDriver driver;
	@BeforeClass
	public void launch() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://jqueryui.com/demos/");
	 //driver.get("https://jqueryui.com/draggable/");
	 System.out.println("Page Title is : "+driver.getTitle());
	 System.out.println("Page URL is : "+driver.getCurrentUrl());
	 System.out.println("Page Source is : "+driver.getPageSource());
	}

 @Test(priority=-1,description="To launch Application")
 
 public void login() {
		
	 driver.get("https://jqueryui.com/draggable/");
		
		//Thread.sleep(1000);
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

		WebElement as=driver.findElement(By.id("draggable"));
		as.click();
		System.out.println("text : "+as.getText());
		Actions ac=new Actions(driver);
		ac.moveToElement(as).dragAndDropBy(as,300,230).build().perform();
		driver.switchTo().defaultContent();
}
 
 @Test(priority=2,description="Droppable")
 public void drop() {
	 
	
	  List<WebElement> p = driver.findElements(By.id("sidebar"));
	      System.out.println("Menu Items are: ");
	      //iterate through list
	      for( WebElement i: p){
	         System.out.println(i.getText());
	         }
	 driver.findElement(By.xpath("//a[text()='Droppable']")).click();
	 Actions ac=new Actions(driver);
	 driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	 WebElement as=driver.findElement(By.id("draggable"));
	 WebElement ad=driver.findElement(By.id("droppable"));
	 ac.dragAndDrop(as,ad).perform();
	 driver.switchTo().defaultContent();
 }
 @Test(priority=3,description="Resizable")
 public void resize()
 {
	 
	 driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[3]/a")).click();
		driver.switchTo().frame(0);
		WebElement resize=driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
	    Actions act=new Actions(driver);
		act.moveToElement(resize).dragAndDropBy(resize, 100, 100).build().perform();
		driver.switchTo().defaultContent();
	}
 @Test(priority=4,description="selectable")
 public void select() {
	// driver.get("https://jqueryui.com/draggable/");
	
	 driver.findElement(By.xpath("//a[text()='Selectable']")).click();
	 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
	
	 Actions act=new Actions(driver);
	 WebElement as=driver.findElement(By.xpath("//li[text()='Item 6']"));

	 act.clickAndHold(as).dragAndDropBy(as, 36, 118).release().build().perform();
	 driver.switchTo().defaultContent();
 }
 @Test(priority=5,description="sortable")
 public void sort() {
	 
	 driver.get("https://jqueryui.com/draggable/");
	
	 driver.findElement(By.xpath("//a[text()='Sortable']")).click();
	 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

	 Actions act=new Actions(driver);
	 WebElement as=driver.findElement(By.xpath("//li[2][@class='ui-state-default ui-sortable-handle']"));
	 //WebElement ad=driver.findElement(By.xpath("//li[5][@class='ui-state-default ui-sortable-handle']"));
	 act.clickAndHold(as).dragAndDropBy(as, 33, 128).release().build().perform();

 }
}
