package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"seleniumgluecode"},
        plugin = {"json:test/report/cucumber_report.json"}

)




public class Testrunner {

@AfterClass
    public static void finish(){

    try {
        System.out.println("Generando Reporte");
        String[] cmd = {"cmd.exe", "/c","npm run report"};
        Runtime.getRuntime().exec(cmd);
        System.out.println("Reporte generado exitosamente");
    }catch (Exception ex){
        ex.printStackTrace();
    }
}

}
