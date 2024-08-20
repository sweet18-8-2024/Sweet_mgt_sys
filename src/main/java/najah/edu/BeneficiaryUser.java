package najah.edu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

import java.util.logging.Logger;
public class BeneficiaryUser {
    private static final String FILE_PATH = "src/main/resources/myData/BeneficiaryData.txt";
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

   public void Customer_menu (String CostName) {
       setUserName(CostName);
       setBrowseProductsFlag(false);
       setMakePurchasesFlag(false);
       setSettingFlag(false);
       int choice;
       Scanner scanner = new Scanner(System.in);
       logger.log(Level.INFO, "\n\u001B[32m" + " -------  Welcome " +  CostName  + " ---------" + "\n" +
               "|                                  |\n" +
               "|      1. Browse products           |\n" +
               "|      2. Make purchases            |\n" +
               "|      3. Manage personal account   |\n" +
               "|      4. Provide feedback          |\n" +  
               "|                                  |\n" +
               "-----------------------------------\n");
    logger.log(Level.INFO, ENTER_YOUR_CHOICE + RESET_COLOR);


       choice = scanner.nextInt();
       if (choice == 1) {
           browseProductsFlag = true;
           BrowseProductsMenu();
       } else if (choice == 2) {
           makePurchasesFlag = true;
           userAccountMenu();

       } else if (choice == 3) {
    	   settingFlag = true;
    	   managePersonalAccount();

       }
       else if (choice == 4) {
    	   feedback();
    	   feedbackFlag = true;

       }
      
       else {
    	    logger.log(Level.WARNING,BOLD + "\u001B[31mInvalid choice! Please enter one, two, or three.\u001B[0m");
    	}
   }
  
   public void managePersonalAccount() {
	    Scanner scanner = new Scanner(System.in);
	    logger.log(Level.INFO, "Enter your email: ");
	    String email = scanner.nextLine(); 

	    while (true) {
	        logger.log(Level.INFO, "\n\u001B[32m" + " -------  Manage Personal Account  ---------" + "\n" +
	                "|                                  |\n" +
	                "|      1. Edit name                |\n" +
	                "|      2. Edit email               |\n" +
	                "|      3. Edit password            |\n" +
	                "|      4. Edit address             |\n" +
	                "|      5. Edit phone number        |\n" +
	                "|      6. Back                     |\n" +
	                "|                                  |\n" +
	                "-----------------------------------\n");
	        logger.log(Level.INFO, ENTER_YOUR_CHOICE + RESET_COLOR);

	    }
	}


   public void userAccountMenu(){
       if (browseProductsFlag){
           BrowseProductsMenu();
           back();
       }
       else if (makePurchasesFlag) {
           
           order.makePurchasesMenu();
           back();
       }
       
       
     
       else {
           logger.log(Level.WARNING,BOLD+"\u001B[31mInvalid choice! Please enter a valid choice."+RESET_COLOR);
           back();
       }
   }
   public void back() {
       logger.log(Level.INFO, """

               1) back\s
               2) Exit""");
       int choice;
       Scanner scanner = new Scanner(System.in);
       choice = scanner.nextInt();
       if (choice == 1)
           Customer_menu(getUserName());
       System.exit(0);
   }

   public void BrowseProductsMenu() {
       Scanner scanner = new Scanner(System.in);
        boolean running = true;

    while (running) {
        logger.log(Level.INFO, """
              
              \u001B[35m---------------------------------
              |                                    |
              |      1. Show all products          |
              |      2. Search products            |
              |      3. Back                       |
              |      4. Exit                       |  
              |                                    | 
              --------------------------------------
              """);
        logger.log(Level.INFO, ENTER_YOUR_CHOICE + RESET_COLOR);
        
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


   public void menuCustomerAdmin() {
       int choice;
       Scanner scanner = new Scanner(System.in);
       logger.log(Level.INFO,"\n\u001B[33m"+"----- Manage BeneficiaryUser Accounts -----"+"\n"+
               "|                                    |\n" +
               "|     1. View user accounts.     |\n"+
               "|     2. Add user Account.       |\n"+
               "|     3. Delete user Account.    |\n"+
               "|                                    |\n"+
               "-------------------------------------\n");
       logger.log(Level.INFO,ENTER_YOUR_CHOICE+RESET_COLOR);
       choice = scanner.nextInt();
       if (choice == 1) {
           printCustomerAccount();
       } else if (choice == 2) {
           addNewCustomer();
       } else if (choice == 3) {

       } else {
           logger.log(Level.WARNING,BOLD+"\u001B[31mInvalid choice! Please enter a valid choice."+RESET_COLOR);
       }
   }
  public void printCustomerAccount(){

   }
public void addNewCustomer(){

}


   public boolean truepass (String pass, String ConfirmPass){
       if(pass.equals(ConfirmPass)){
           return true;
       }
       return false;
   }
  public void writeToFile(String dataToWrite, String fileName) {
    try (RandomAccessFile file = new RandomAccessFile("src/main/resources/myData/" + fileName + ".txt", "rw")) {
        file.seek(file.length());
        file.writeBytes(dataToWrite);
    } catch (IOException e) {
        e.printStackTrace();
    }
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

       while (currentLine < getNumberOfLine()){
           start = currentPos;
           raf.readLine();
           currentPos = raf.getFilePointer();
           currentLine++;
       }

       long end = raf.length();
       byte[] remainingBytes = new byte[(int) (end - currentPos)];
       raf.read(remainingBytes);

       raf.seek(start);
       raf.write(remainingBytes);
       raf.setLength(start + remainingBytes.length);
       raf.close();

   } catch (IOException e) {
       throw new RuntimeException(e);
   }

}
   
   private List<Product> products;

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
       List<String> products = readProductsFromFile();
       List<String> matchedProducts = new ArrayList<>();
       for (String product : products) {
           if (product.toLowerCase().contains(criteria.toLowerCase())) {
               matchedProducts.add(product);
           }
       }
       return matchedProducts;
   }

   public void searchTheCustomerNewLine() {
       int count=-1;
       try (RandomAccessFile ref = new RandomAccessFile("src/main/resources/myData/content.txt", "rw")) {
           String s;
           String isd= String.valueOf(getId());
           while ((s = ref.readLine()) != null) {
               count=count+1;
               String[] productInfo = s.split(",");
               if (isd.equals(productInfo[4]))
               {
                   setUserName(productInfo[0]);
                   setNumberOfLine(count);
                   return;
               }
           }
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }
public void feedback() {
    Scanner scanner = new Scanner(System.in);
    logger.log(Level.INFO, "\n\u001B[32m" + "----- Provide Feedback -----" + "\n" +
               "Please enter your feedback below:" + RESET_COLOR);
    String userFeedback = scanner.nextLine();

    String feedbackFilePath = "src/main/resources/myData/Feedback.txt";

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(feedbackFilePath, true))) {
        writer.write(userFeedback);
        writer.newLine();
        logger.log(Level.INFO, "\u001B[32mThank you for your feedback!\u001B[0m");
    } catch (IOException e) {
        logger.log(Level.SEVERE, BOLD + "\u001B[31mError writing feedback: " + e.getMessage() + RESET_COLOR);
    }
}
}
