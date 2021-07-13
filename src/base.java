import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.AppiumDriver;

public class base {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		// Configurar conexion con app
		File appDir = new File("src");
        File app = new File(appDir, "app-debug.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "CarlosEmulador");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		// Para automatizar android 
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL ("http://127.0.0.1:4723/wd/hub"),cap);	
		 
		// Se Declara variable Rut
		MobileElement Rut;
		MobileElement Clave;
		MobileElement Ingresar;
		
		// Se incluye funcion de tiempo implicita
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// Enviamos los datos al elemento rut    		    
		Rut = driver.findElementByXPath("//*[@class='android.widget.EditText' and @index=0]");
        Rut.sendKeys("17.593.638-6");
        
        // Enviamos los datos al elemento clave
        
        Clave = driver.findElementByXPath("//*[@class='android.widget.EditText' and @text='••••']");
        Clave.sendKeys("1234");
        
        // Presionamos sobre el boton ingresar
        
        Ingresar = driver.findElementByXPath("//*[@class='android.widget.Button' and @text='Ingresar']");
        Ingresar.click();
        
				   
		}
	}




