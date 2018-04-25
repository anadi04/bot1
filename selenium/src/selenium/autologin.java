package selenium;
import java.util.List;
import java.util.concurrent.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class autologin{
	WebDriver driver=new ChromeDriver();
	public static int counter=0;
    public static String[] title=new String[100];
	public static String[] seller=new String[100];
	public static String[] id=new String[100];
	public static String[] orderdate=new String[100];
	public static String[] deldate=new String[100];
	public static String[] price=new String[100];
	public void autoLogin()
	{   
	     try {
				System.setProperty("webdriver.chrome.driver","C:\\Users\\anadi\\eclipse-workspace\\selenium\\chromedriver.exe");
				
	      
				driver.get("https://www.flipkart.com/");
				driver.findElement(By.className("_2zrpKA")).sendKeys(interface1.username);
				driver.findElement(By.className("_3v41xv")).sendKeys(interface1.flipkartpassword);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				Thread.sleep(5000);
				driver.findElement(By.className("_7UHT_c")).click();
				driver.navigate().to("https://www.flipkart.com/account/orders?link=home_orders");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   
	}
	public void parse()
	{  
		int i=0,j=0;
		List<WebElement> count_element=driver.findElements(By.cssSelector("._2AkmmA.row.NPoy5u"));
	for(WebElement e:count_element)
	{
	
		counter++;
	}
	//System.out.println(counter);
		List<WebElement> titles_element=driver.findElements(By.cssSelector("._2AkmmA.row.NPoy5u"));
		for(WebElement e:titles_element)
		{   
			i=j;
			while(i<counter)
			{
			title[i+1]=e.getText();
		//    System.out.println(e.getText());
			i++;
			}
			j++;
		}
		i=0;j=0;
		List<WebElement> seller_element=driver.findElements(By.cssSelector("a._2MePjZ"));
		for(WebElement e:seller_element)
		{
			i=j;
			while(i<counter)
			{
			seller[i+1]=e.getText();
		  //  System.out.println(e.getText());
			i++;
			}
			j++;
		}
		i=0;j=0;
		List<WebElement> orderID_element=driver.findElements(By.cssSelector("div.DgI5Zd"));
		for(WebElement e:orderID_element)
		{
			i=j;
			while(i<counter)
			{
			id[i+1]=e.getText();
		    //System.out.println(e.getText());
			i++;
			}
			j++;
		}
		i=0;j=0;
		List<WebElement> orderdate_element=driver.findElements(By.cssSelector("._1S28mS"));
		for(WebElement e:orderdate_element)
		{
			i=j;
			while(i<counter)
			{
			orderdate[i+1]=e.getText();
		    //System.out.println(e.getText());
			i++;
			}
			j++;
		}
		i=0;j=0;
		List<WebElement> deliverydate_element=driver.findElements(By.cssSelector("._3fG4KG"));
		for(WebElement e:deliverydate_element)
		{
			i=j;
			while(i<counter)
			{
			deldate[i+1]=e.getText();
		    //System.out.println(e.getText());
			i++;
			}
			j++;
		}
		i=0;j=0;
		List<WebElement> price_element=driver.findElements(By.cssSelector("div.col-6-12.Gp5Tnb"));
		for(WebElement e:price_element)
		{
			i=j;
			while(i<counter)
			{
			price[i+1]=e.getText();
		    //System.out.println(e.getText());
			i++;
			}
			j++;
		}
		i=0;j=0;
		
	}
  /*  public static void main(String[] args) {
   
    	autologin obj=new autologin();
    	obj.autoLogin();
    }*/
}