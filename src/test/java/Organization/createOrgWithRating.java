package Organization;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Rosava.Generic.BaseClass;
import com.crm.Rosava.ObjectRepository.CreateOrgInformation;
import com.crm.Rosava.ObjectRepository.CreateOrganization;
import com.crm.Rosava.ObjectRepository.Home;
import com.crm.Rosava.ObjectRepository.organizations;

/**
 * 
 * @author Bharath Kumar
 *
 */

@Listeners(com.crm.Rosava.Generic.Listener_Imp.class)
public class createOrgWithRating extends BaseClass {
@Test(groups="RegressionTest")
public void createWithRating() throws Throwable
{
	/*step_1: read teat data from excel*/
	int num = java.RandomNum();
	String name = excel.getExcelData("sheet1", 0, 0);
	String orgName=name+num;
	util.implicitelywait(driver);
	/*step_2: Navigate to organization page*/
	Home home=new Home(driver);
	home.getOrganizationTab().click();
	
	/*step_3: Navigate to create new organization page*/
	organizations org=new organizations(driver);
	util.elementtobeclicable(driver, org.getCreateOrgBtn());
	org.getCreateOrgBtn().click();
	
	/*step_4: enter all details and click on save*/
	CreateOrganization createOrg=new CreateOrganization(driver);
	createOrg.getOrganizationNameEdt().sendKeys(orgName);
	util.dropdownselect(createOrg.getRatingBropdown(), "Active");
	createOrg.getSaveBtn().click();
	
	/*step_5: Validation*/
	CreateOrgInformation coi = new CreateOrgInformation(driver);
    util.visibilityofelement(driver, coi.getsuccessfulMsg());
    String actSusccessMsg = coi.getsuccessfulMsg().getText();		    
    Assert.assertTrue(actSusccessMsg.contains(orgName));
}
}
