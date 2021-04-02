package files_handling;

import org.testng.annotations.Test;

public class Readdatafrommaven {
@Test
public void sample1()
{
	String URL=System.getProperty("url");
	String USERNAME=System.getProperty("username");
	String PASSWORD=System.getProperty("password");
	
	System.out.println(URL);
	System.out.println(USERNAME);
	System.out.println(PASSWORD);
}
}
