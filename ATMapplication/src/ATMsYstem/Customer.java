package ATMsYstem;

import java.util.Scanner;

public class Customer {
	
	// creating attributes
	private String customerName;
	private long customerAadharNumber;
	private String customerAddrress;
	private long customerContactInfo;

	// default constructor
	public Customer() {}
	
	public Customer(String customerName, long customerAadharNumber, String customerAddrress, long customerContactInfo) {
		super();
		this.customerName = customerName;
		this.customerAadharNumber = customerAadharNumber;
		this.customerAddrress = customerAddrress;
		this.customerContactInfo = customerContactInfo;
	}

	

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerAadharNumber() {
		return customerAadharNumber;
	}

	public void setCustomerAadharNumber(long customerAadharNumber) {
		this.customerAadharNumber = customerAadharNumber;
	}

	public String getCustomerAddrress() {
		return customerAddrress;
	}

	public void setCustomerAddrress(String customerAddrress) {
		this.customerAddrress = customerAddrress;
	}

	public long getCustomerContactInfo() {
		return customerContactInfo;
	}

	public void setCustomerContactInfo(long customerContactInfo) {
		this.customerContactInfo = customerContactInfo;
	}

	

	public void CreateCustomer() {
		// to generate accountdetails

		BankAccount customerBankDetails = new BankAccount();
					customerBankDetails.accountGenerator();

		// to generate atm card and pin
		ATMCard customerATMdetails = new ATMCard();
				customerATMdetails.ATMpinGenerator();
				customerATMdetails.ATMcardGenerator();
				
		// taking input as new customer details
		Scanner input = new Scanner(System.in);

		System.out.println("Enter Your Name: ");
		customerName = input.nextLine();

		while (true) {
			System.out.println("Enter your Aadhar Number (11 digits): ");
			customerAadharNumber = input.nextLong();
			input.nextLine(); // Consume newline
			if (isValidAadharNumber(customerAadharNumber)) {
				break; // Exit the loop if the Aadhar number is valid
			} else {
				System.out.println("Invalid Aadhar Number. Please enter a valid 11-digit Aadhar Number.");
			}
		}
		System.out.println("Enter your Address(State,District,City or Village,PinCode): ");
		customerAddrress = input.nextLine();

		while (true) {
			System.out.println("Enter your Contact Number (10 digits): ");
			customerContactInfo = input.nextLong();
			input.nextLine(); // Consume newline
			if (isValidContactNumber(customerContactInfo)) {
				break; // Exit the loop if the contact number is valid
			} else {
				System.out.println("Invalid Contact Number. Please enter a valid 10-digit Contact Number.");
			}
		}

	
	}

	private static boolean isValidAadharNumber(long number) {
		return (number >= 10000000000L && number <= 99999999999L);
	}

	private static boolean isValidContactNumber(long number) {
		return (number >= 1000000000L && number <= 9999999999L);
	}
}