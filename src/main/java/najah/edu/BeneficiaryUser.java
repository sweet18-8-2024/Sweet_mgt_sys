package najah.edu;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class BeneficiaryUser {
    private static final Logger logger = Logger.getLogger(BeneficiaryUser.class.getName());
    public static final String BOLD = "\u001B[1m";
    public static final String RESET_COLOR = "\u001B[0m";
	 private static final String CONTENT_FILE_PATH = "src/main/resources/myData/content.txt";
	 private static final String ENTER_YOUR_CHOICE = "Enter your choice: ";
	
	 private Gmail gmail;
    Order order =new Order();
   Owner owner = new Owner();
   public String getUserName() {
       return userName;
   }
   public void theBeneficiaryUserEnter(String Choice) {
	   if (Choice.equals("1")){
		   setBrowseProductsFlag(true);
       } else if (Choice.equals("2")) {
    	   setMakePurchasesFlag(true);
       } 
       else {
    	            setBrowseProductsFlag(false);
           setMakePurchasesFlag(false);
       }
   }
   public int getNumberOfLine() {
       return numberOfLine;
   }

   public void setNumberOfLine(int numberOfLine) {
       this.numberOfLine = numberOfLine;
   }

   int  numberOfLine;
   public void setUserName(String userName) {
       this.userName = userName;
   }

   public Gmail getGmail() {
       return gmail;
   }

   public void setGmail(String gmail) {
       Gmail1 = gmail;
   }

   public String getPassword() {
       return Password;
   }

   public void setPassword(String password) {
       Password = password;
   }

   public String getAddress() {
       return address;
   }

   public void setAddress(String address) {
       this.address = address;
   }

   public int getId() {
       return id;
   }

   public void setId(int id) {
       this.id = id;
   }

   public String getPhone() {
       return phone;
   }
   public void setPhone(String newPhone) {
	    this.phone = newPhone;
	}


   String userName;
   String Gmail1;
   String Password;
   String address;
   int id;
   String phone;
   public void setCustomerLogin(boolean customerLogin) {
       this.customerLogin = customerLogin;
   }
   private boolean customerLogin ;
   private boolean browseProductsFlag;
   public boolean isSettingFlag() {
       return settingFlag;
   }
   public boolean isfeedbackflag() {
	  return feedbackFlag;
   }
   public BeneficiaryUser(String userName, String email, String password, String address, int id, String phone) {
       this.userName = userName;
       this.gmail = new Gmail(email);
       this.Password = password;
       this.address = address;
       this.id = id;
       this.phone = phone;
   
   }
   public void setfeedbackflag(boolean feedbackflag) {
	   this.feedbackFlag=feedbackflag;

   }

   public void setSettingFlag(boolean settingFlag) {
       this.settingFlag = settingFlag;
   }

   public boolean settingFlag;

  
   public void setBrowseProductsFlag(boolean browseProductsFlag) {
       this.browseProductsFlag = browseProductsFlag;
   }

   public boolean isMakePurchasesFlag() {
       return makePurchasesFlag;
   }

   public void setMakePurchasesFlag(boolean makePurchasesFlag) {
       this.makePurchasesFlag = makePurchasesFlag;
   }


   private boolean  feedbackFlag;

   private boolean makePurchasesFlag;
   public BeneficiaryUser() {
       customerLogin = true;
       browseProductsFlag=false;
       makePurchasesFlag=false;
       settingFlag=false;
   }

   public boolean isCustomerLogin() {
       return customerLogin;
   }


   public void userAccountMenu(){
       if (browseProductsFlag){
         
         
       }
       else if (makePurchasesFlag) {
           
           order.makePurchasesMenu();
   
       }
    
       else {
           logger.log(Level.WARNING,BOLD+"\u001B[31mInvalid choice! Please enter a valid choice."+RESET_COLOR);
  
       }
   }

   private List<String> readProductsFromFile() {
       List<String> products = new ArrayList<>();
       try (BufferedReader reader = new BufferedReader(new FileReader(CONTENT_FILE_PATH))) {
           String line;
           while ((line = reader.readLine()) != null) {
               products.add(line);
           }
       } catch (IOException e) {
           logger.log(Level.SEVERE, "Error reading the products file.", e);
       }
       return products;
   }

  



  public void printCustomerAccount(){

   }
public void addNewCustomer(){

}



public void setTheCustomerIs(int numberOfLineCustomer){
       setNumberOfLine(numberOfLineCustomer);
}
  

public void deleteLine() {
   try {
       RandomAccessFile raf = new RandomAccessFile("src/main/resources/myData/BeneficiaryData.txt", "rw");
       long start = 0;
       long currentPos = raf.getFilePointer();
       int currentLine = -1;


   } catch (IOException e) {
       throw new RuntimeException(e);
   }

}


   public boolean isBrowseProductsFlag() {
       return browseProductsFlag;
   }

   public List<String> searchProductsByName(String name) {
       return searchProductsByCriteria(name);
   }

   public List<String> searchProductsByID(String id) {
       return searchProductsByCriteria(id);
   }

   public List<String> searchProductsByDescription(String description) {
       return searchProductsByCriteria(description);
   }

   public List<String> searchProductsByAvailability(String availability) {
       return searchProductsByCriteria(availability);
   }

   private List<String> searchProductsByCriteria(String criteria) {
      
           }
     
  
    private int parseInteger(String value) {
	    try {
	        return Integer.parseInt(value);
	    } catch (NumberFormatException e) {
	        logger.log(Level.WARNING, "Invalid number format: " + value, e);
	        return -1; // or any default value that makes sense for your application
	    }
	}
}
