import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumBlogSignUpTest {
    private WebDriver driver;
@BeforeTest
    public void start() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

    //1. Open the browser
    driver = new ChromeDriver();

    //2. Input the URL
    driver.get("https://selenium-blog.herokuapp.com/");
    //Test 1 - Verify user is redirected to landing page
    if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
        //Pass
        System.out.println("Correct Landing Page");
    else
        //Fail
        System.out.println("Wrong Landing page");

    //3. Click on sign up button
    driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
    Thread.sleep(5000);
    }

@Test (priority = 0)
    public void PositiveTest() throws InterruptedException {
    //Test 2 - Verify user can sign up with valid details

    //4. Input Username
    driver.findElement(By.id("user_username")).sendKeys("Michaelo");
    Thread.sleep(5000);

    //5. Input E-mail
    driver.findElement(By.id("user_email")).sendKeys("michaelo@freedom.com");
    Thread.sleep(5000);

    //6. Input Password
    driver.findElement(By.id("user_password")).sendKeys("Blade23");
    Thread.sleep(5000);

    //7. Click on Sign Up Button
    driver.findElement(By.id("submit")).click();
    Thread.sleep(1000);
    }

    @Test (priority = 1)
    public void ClickUser1() throws InterruptedException {
        // Test 3- Verify user1 is present, clickable and user is directed to user1 page
        //8. Click on User1
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/users/1"))
            //Pass
            System.out.println("Correct User1 Page");
        else
            //Fail
        System.out.println("Wrong User1 Page");
        Thread.sleep(1000);
    }

    @Test (priority = 2)
    public void Learnxpath() throws InterruptedException {
        //Test 3 - Verify user is redirected to learnxpath page
        //9. Click on learnxpath
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/articles/59"))
            System.out.println("Correct learnxpath page");
        else
            //Fail
        System.out.println("Wrong learnxpath page");
        Thread.sleep(1000);
    }

    @Test (priority = 3)
    public void Logout() throws InterruptedException {
        //Test 5 - Verify user is logged out and redirected to landing page
        //10. Logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
            //Pass
            System.out.println("Correct Landing Page");
        else
            //Fail
            System.out.println("Wrong Landing Page");
    Thread.sleep(1000);
}
@Test (priority = 4)
    public void NegativeTest1() throws InterruptedException {
        //Test 6 - Verify user cannot sign up with blank field
       //Click on sign up button
       driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
       Thread.sleep(5000);

        //4. Input Username
        driver.findElement(By.id("user_username")).sendKeys("");
        Thread.sleep(5000);

        //5. Input E-mail
        driver.findElement(By.id("user_email")).sendKeys("");
        Thread.sleep(5000);

        //6. Input Password
        driver.findElement(By.id("user_password")).sendKeys("");
        Thread.sleep(5000);

        //7. Click on Sign Up Button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
    }

@Test (priority = 5)
    public void NegativeTest2() throws InterruptedException {
        //Test 7 - Verify user cannot sign up with invalid email

    driver.get("https://selenium-blog.herokuapp.com/signup");

        //4. Input Username
        driver.findElement(By.id("user_username")).sendKeys("kolade");
        Thread.sleep(5000);

        //5. Input E-mail
        driver.findElement(By.id("user_email")).sendKeys("sola2uikt");
        Thread.sleep(5000);

        //6. Input Password
        driver.findElement(By.id("user_password")).sendKeys("Bamise");
        Thread.sleep(5000);

        //7. Click on Sign Up Button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
    }

    @Test (priority = 6)
    public void NegativeTest3() throws InterruptedException {
        //Test 7 - Verify user cannot sign up with invalid username

        driver.get("https://selenium-blog.herokuapp.com/signup");

        //4. Input Username
        driver.findElement(By.id("user_username")).sendKeys("");
        Thread.sleep(5000);

        //5. Input E-mail
        driver.findElement(By.id("user_email")).sendKeys("suemenow@freedom.com");
        Thread.sleep(5000);

        //6. Input Password
        driver.findElement(By.id("user_password")).sendKeys("innovate");
        Thread.sleep(5000);

        //7. Click on Sign Up Button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
    }

    @Test (priority = 7)
    public void NegativeTest4() throws InterruptedException {
        //Test 7 - Verify user cannot sign up with invalid password

        driver.get("https://selenium-blog.herokuapp.com/signup");

        //4. Input Username
        driver.findElement(By.id("user_username")).sendKeys("Omowumi");
        Thread.sleep(5000);

        //5. Input E-mail
        driver.findElement(By.id("user_email")).sendKeys("omowumi@freedom.com");
        Thread.sleep(5000);

        //6. Input Password
        driver.findElement(By.id("user_password")).sendKeys("");
        Thread.sleep(5000);

        //7. Click on Sign Up Button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
    }
@AfterTest
    public void CloseBrowser() {
    driver.quit();
    }

}
