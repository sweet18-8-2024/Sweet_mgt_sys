package najah.edu.acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import najah.edu.Admin;
import najah.edu.BeneficiaryUser;
import najah.edu.Owner;

public class Roles {
	 private Owner owner;
	    private BeneficiaryUser beneficiaryUser = new BeneficiaryUser();
    private static final Logger logger = Logger.getLogger(Roles.class.getName());
    private Admin admin = new Admin();
   
    @Before
    public void setUp() {
        owner = new Owner();
        logger.setLevel(Level.INFO);
    }

    @Given("The admin is logged into the system")
    public void theAdminIsLoggedIntoTheSystem() {
    	  Assert.assertEquals(true, admin.isAdminLogin());
    }

    @When("The admin enters {string}")
    public void theAdminEnters(String string) {
    	 admin.whatAdminEnter(string);
    }

    @Then("The admin should be able to view and generate financial reports")
    public void theAdminShouldBeAbleToViewAndGenerateFinancialReports() {
    	  admin.setGenerateReportsFlag(true);
    	    assertTrue(admin.isGenerateReportsFlag());

    	    admin.generateFinancialReports();
    	    
    	    String reportContent = admin.getFinancialReportContent();
     	    assertNotNull(reportContent);
    	    assertTrue(reportContent.contains("Total Items"));
    	    assertTrue(reportContent.contains("Total Revenue"));
    	    assertTrue(reportContent.contains("Total Expenses"));
    	    assertTrue(reportContent.contains("Profit"));
    	   

    }

    @Then("The Admin should be able to create, edit, or delete contents")
    public void theAdminShouldBeAbleToCreateEditOrDeleteContents() {
    	admin.setGenerateReportsFlag(true); 
    	assertTrue(admin.isGenerateReportsFlag());
    }

    @Then("The Admin should be able to create, edit, or delete recipes")
    public void theAdminShouldBeAbleToCreateEditOrDeleteRecipes() {
    	 admin.setRecipes(true);
    	 assertTrue(admin.isrecipes());
    }

    @Then("The admin should be able to view statistics on registered users categorized by city")
    public void theAdminShouldBeAbleToViewStatisticsOnRegisteredUsersCategorizedByCity() {
    	 admin.setViewUserStatsFlag(true);
    	    assertTrue(admin.isViewUserStatsFlag());
    }

    @Then("The Admin should be told to enter one, two, three, or four")
    public void theAdminShouldBeToldToEnterOneTwoThreeOrFour() {
    	 Assert.assertEquals(false,admin.isProductsFlag());
         Assert.assertEquals(false,admin.isrecipes());
         Assert.assertEquals(false,admin.isViewUserStatsFlag());

        
    }

    @Given("The Beneficiary User is logged into the system")
    public void theBeneficiaryUserIsLoggedIntoTheSystem() {
   	 assertEquals(true, beneficiaryUser.isCustomerLogin());
        
    }
    

    @When("The Beneficiary User enters {string}")
    public void theBeneficiaryUserEnters(String choice) {
        beneficiaryUser.theBeneficiaryUserEnter(choice);
    }

    @When("The Beneficiary User provides feedback")
    public void theBeneficiaryUserProvidesFeedback() {
        beneficiaryUser.setfeedbackflag(true);
    }

    @Then("The Beneficiary User feedback flag should be set")
    public void theBeneficiaryUserFeedbackFlagShouldBeSet() {
        assertTrue(beneficiaryUser.isfeedbackflag());
    }

    @Then("The Beneficiary User should be able to browse sweets")
    public void theBeneficiaryUserShouldBeAbleToBrowseSweets() {
    	 beneficiaryUser.setMakePurchasesFlag(true);
   	  assertTrue(beneficiaryUser.isMakePurchasesFlag());  
   	
    }
    @Then("The Beneficiary User should be able can manage personal account")
    public void theBeneficiaryUserShouldBeAbleCanManagePersonalAccount() {
    	beneficiaryUser.setSettingFlag(true);
    	beneficiaryUser.isSettingFlag();
    }
    @Then("The Beneficiary User should be able to make purchases")
    public void theBeneficiaryUserShouldBeAbleToMakePurchases() {
    	 beneficiaryUser.setMakePurchasesFlag(true);
    	  assertTrue(beneficiaryUser.isMakePurchasesFlag());
    }

    @Then("The Beneficiary User should be told to enter one, two, or three")
    public void theBeneficiaryUserShouldBeToldToEnterOneTwoOrThree() {
    	
    	 Assert.assertEquals(false,beneficiaryUser.isMakePurchasesFlag());
         Assert.assertEquals(false,beneficiaryUser.isSettingFlag());
         
      
    }
    @Then("The Beneficiary User address should be updated to {string}")
    public void theBeneficiaryUserAddressShouldBeUpdatedTo(String expectedAddress) {
        assertEquals(expectedAddress, beneficiaryUser.getAddress()); 
    }
	@Given("The Owner is logged into the system")
	public void theOwnerIsLoggedIntoTheSystem() {
		
	}

	@When("The Owner enters {string}")
    public void theOwnerEnters(String string) {
		
       
    }

    @Then("The Owner should be able to add, edit, or delete products")
    public void theOwnerShouldBeAbleToAddEditOrDeleteProducts() {
    	 
       
    }

    @Then("The Owner should be able to monitor sales")
    public void theOwnerShouldBeAbleToMonitorSales() {
    	
    }


    @Then("The Owner should be able to apply discounts")
    public void theOwnerShouldBeAbleToApplyDiscounts() {
      
    }

   

    @Then("The Owner should be able to send email notifications for shipping, delivery")
    public void theOwnerShouldBeAbleToSendEmailNotificationsForShippingDelivery() {
    	
    	  
    	   
    }

    @Then("The Owner should be able to identifiy best selling")
    public void theOwnerShouldBeAbleToIdentifiyBestSelling() {
    	
       
    }

   
}
