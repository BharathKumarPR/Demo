package files_handling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Readdatafromfile {
@Test
public void sample_test() throws IOException
{
	FileInputStream fis=new FileInputStream("./userdata.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	String URL= pobj.getProperty("URL");
	String USERNAME= pobj.getProperty("USERNAME");
	String PASSWORD= pobj.getProperty("PASSWORD");
	System.out.println(URL);
	System.out.println(USERNAME);
	System.out.println(PASSWORD);
}
}

