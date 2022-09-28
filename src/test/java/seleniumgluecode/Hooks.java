package seleniumgluecode;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import runner.browser_manager.DriverManager;
import runner.browser_manager.DriverManagerFactory;
import runner.browser_manager.DriverType;

public class Hooks {


    private static int contadorEscenario=0;
    @Before

    public void Comienzo(){
        contadorEscenario++;
        System.out.println("Se esta ejecutando el escenario "+contadorEscenario);





    }

    @After
    public void Final(){
        System.out.println("Se ejecuto correctamente el escenario "+contadorEscenario);



    }


}
