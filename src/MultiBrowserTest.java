import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

/**
 * Project-5 - ProjectName : com-utimateqa
 * BaseUrl = https://courses.ultimateqa.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Sign In’ link
 * 7. Print the current url
 * 8. Enter the email to email field.
 * 9. Enter the password to password field.
 * 10. Click on Login Button.
 * 11. Navigate to baseUrl.
 * 12. Navigate forward to Homepage.
 * 13. Navigate back to baseUrl.
 * 14. Refresh the page.
 * 15. Close the browser.
 */





public class MultiBrowserTest {
    static String browser = "Chrome";
    static String baseUrl = "https://courses.ultimateqa.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        //using Scanner Declaration
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter broswer name : ");
        String browser = scanner.nextLine();
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        //Open the Url
        driver.get(baseUrl);
        //We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Print title of the page
        System.out.println("The tilte of the page : " + driver.getTitle());
        //Print the current Url
        System.out.println("The current Url : " + driver.getCurrentUrl());
        //Print the page source
        System.out.println("The source: " + driver.getPageSource());
        //click on 'sign in' link
        driver.findElement(By.linkText("Sign In")).click();
        //Print the current Url
        System.out.println("The current Url : " + driver.getCurrentUrl());
        //Enter email to email field
        driver.findElement(By.id("user[email]")).sendKeys("Prime123@gmail.com");
        //Enter the password to password field.
        driver.findElement(By.name("user[password]")).sendKeys("Prime123");
        //Click on Login Button.
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        //Navigate to baseUrl
        driver.navigate().to(baseUrl);
        // Navigate forward to Homepage
        driver.navigate().forward();
        //Navigate back to login page
        driver.navigate().back();
        //Refresh the page
        driver.navigate().refresh();
        //Close the browser
        driver.quit();

    }
}
