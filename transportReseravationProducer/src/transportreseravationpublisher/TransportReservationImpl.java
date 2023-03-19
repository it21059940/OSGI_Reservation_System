package transportreseravationpublisher;

import java.util.Scanner;

public class TransportReservationImpl implements TransportReservation{

	@Override
	public void dislayVehiclePackageDetails() {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to the Vehicle revservation section of Lemon Hotell Plc ");
		
		System.out.println("All the vehicle categories of our hotel.");
		System.out.println("===============================================================================================");
		System.out.println("		Vehicle No.		Vehicle type");
		System.out.println("		    1          	Car ");
		System.out.println("		    2          	Van ");
		System.out.println("		    3          	Bike ");
		System.out.println("		    0           Exit  ");
		System.out.println("===============================================================================================");		
	}

	@Override
	public void vehiclePackageSelection() {
		// TODO Auto-generated method stub
		Scanner ve = new Scanner(System.in);
		
		int vehiclecategories;
		int vehicleType;
		int days = 0;
		int packagePrice1 = 0;
		String name;
		
		System.out.println("Enter your name: ");
		name = ve.next();
		
		System.out.println("Enter vehicle category number you want: ");
		vehiclecategories = ve.nextInt();
		
		if(vehiclecategories == 1) {
			int CarTot = 0;
			
			System.out.println("								----You select the Car category----											");
			System.out.println("==============================================================================================================");
			System.out.println("Car type NO.  		Car type        			  Package(Less than 2 days)    Package(More than 2 days)");
			System.out.println("    1          Economy(alto, maruti, nano..)     	  Rs.  2000.00                Rs.  2000.00 + tax    ");
			System.out.println("    2          Normal(Axio, Prius, Aqua ...)     	  Rs.  5000.00                Rs.  5000.00 + tax  	  ");
			System.out.println("    3          Luxury(BMW, Bwnz, Premio ..)     	  Rs. 10000.00                Rs. 10000.00 + tax   "); 
			System.out.println("===============================================================================================================");			
			System.out.println("    0 - Exit   ");
			System.out.println("Enter the car type you want? ");
			vehicleType = ve.nextInt();
			
			if(vehicleType == 1) {
				int tax = 750;
				packagePrice1 = 2000;
				System.out.println("Enter number of days? ");
				days = ve.nextInt();
				
				CarTot = calculateTotalAmount(days, packagePrice1, tax);
				
			}else if(vehicleType == 2) {
				int tax = 1200;
				packagePrice1 = 2000;
				System.out.println("Enter number of days? ");
				days = ve.nextInt();
				
				CarTot = calculateTotalAmount(days, packagePrice1, tax);
				
			}else if(vehicleType == 3) {	
				int tax = 3000;
				packagePrice1 = 10000;
				System.out.println("Enter number of days? ");
				days = ve.nextInt();
				
				CarTot = calculateTotalAmount(days, packagePrice1, tax);
			}else if(vehicleType == 0) {
				Scanner confi = new Scanner(System.in);
				char confirm;
				
				System.out.println("Do you want to move to the vehicle category menu (Y / N) : ");
				confirm = confi.next().charAt(0);
				
				if(confirm == 'Y' || confirm == 'y') {
					System.out.println("Back to the main menu");
					dislayVehiclePackageDetails();
					System.out.println("");
				}
				
			}else {
				System.out.println("Invalid car type.......");
			}
			
			displayUserDetails(name, days, CarTot);
			
		}else if(vehiclecategories == 2) {
			int vanTot = 0;
			
			System.out.println("							----You select the Van category----										");
			System.out.println("=====================================================================================================");
			System.out.println("Van type NO.  		No. of seats      	Package(Less than 2 days) 		 Package(More than 2 days)");
			System.out.println("    1        		 6 - 8 seats     	 	Rs.  18000.00                	Rs.  18000.00 + tax    ");
			System.out.println("    2        		10 - 14 seats  	  		Rs.  25000.00                	Rs.  25000.00 + tax  	  ");
			System.out.println("=====================================================================================================");
			System.out.println("    0 - Exit   ");
			System.out.println("Enter the van type you want? ");
			vehicleType = ve.nextInt();
			
			if(vehicleType == 1) {
				int tax = 8000;
				packagePrice1 = 18000;
				System.out.println("Enter number of days? ");
				days = ve.nextInt();

				calculateTotalAmount(days, packagePrice1, tax);
				
			}else if(vehicleType == 2) {
				int tax = 10000;
				packagePrice1 = 25000;
				System.out.println("Enter number of days? ");
				days = ve.nextInt();

				calculateTotalAmount(days, packagePrice1, tax);
			}else if(vehicleType == 0){
				Scanner confi = new Scanner(System.in);
				char confirm;
				
				System.out.println("Do you want to move to the vehicle category menu (Y / N) : ");
				confirm = confi.next().charAt(0);
				
				if(confirm == 'Y' || confirm == 'y') {
					System.out.println("Back to the main menu");
					dislayVehiclePackageDetails();
					System.out.println("");
				}
				
			}else {
				System.out.println("Invalid van type....");
			}
			displayUserDetails(name, days, vanTot);
			
			
		}else if(vehiclecategories == 3) {
			int bikeTot = 0;
			
			System.out.println("                         ----You select the Bike category----									");
			System.out.println("=================================================================================================");
			System.out.println("Van type NO.  		Capacity      	Package(Less than 2 days) 		 Package(More than 2 days)");
			System.out.println("    1        		  >250     	 	Rs.  2000.00                	Rs.  2000.00 + tax    ");
			System.out.println("    2        		 <= 250	  		Rs.  3500.00                	Rs.  3500.00 + tax  	  ");
			System.out.println("=================================================================================================");
			System.out.println("    0 - Exit   ");
			System.out.println("Enter the bike type you want? ");
			vehicleType = ve.nextInt();
			
			if(vehicleType == 1) {
				int tax = 1000;
				packagePrice1 = 2000;
				System.out.println("Enter number of days? ");
				days = ve.nextInt();
				
				calculateTotalAmount(days, packagePrice1, tax);
				
			}else if(vehicleType == 2) {
				int tax = 1000;
				packagePrice1 = 3500;
				System.out.println("Enter number of days? ");
				days = ve.nextInt();
				
				calculateTotalAmount(days, packagePrice1, tax);
			}else if(vehicleType == 0) {
				Scanner confi = new Scanner(System.in);
				char confirm;
				
				System.out.println("Do you want to move to the vehicle category menu (Y / N) : ");
				confirm = confi.next().charAt(0);
				
				if(confirm == 'Y' || confirm == 'y') {
					System.out.println("You are in the main menu at now!!!!!!");
					System.out.println("");
					dislayVehiclePackageDetails();
					System.out.println("");		
				}
				
			}else {
				System.out.println("Invalid bike type...");
			}
			displayUserDetails(name, days, bikeTot);
			
		}else if(vehiclecategories == 0) {
			
			Scanner confi = new Scanner(System.in);
			char confirm;
			
			System.out.println("Do you want to move to the vehicle category menu (Y / N) : ");
			confirm = confi.next().charAt(0);
			
			if(confirm == 'Y' || confirm == 'y') {
				System.out.println("Back to the main menu");
				dislayVehiclePackageDetails();
				System.out.println("");
			}
		}
		
	}
	
	public void displayUserDetails(String name, int day, int totalAmount) {
		System.out.println("Guest name: " + name);
		System.out.println("No of days : " + day);
		System.out.println("Total amount : " + totalAmount);
	}
	
	public int calculateTotalAmount(int days, int packagePrice, int tax) {
		int totalAmount = 0;
		
		if(days <= 2) {
			totalAmount = packagePrice;
		}else {
			totalAmount = packagePrice + (tax * (days - 2));
		}
		return totalAmount;
	}

}
