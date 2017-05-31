package utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ReporterConfig.Property;
public class Logg 
{




	public static void main(String[] args) 
		{
			
			Logger log = Logger.getLogger("Logg");
			PropertyConfigurator.configure("log4j.properties");
			log.info("Chal ja be");
		}
}