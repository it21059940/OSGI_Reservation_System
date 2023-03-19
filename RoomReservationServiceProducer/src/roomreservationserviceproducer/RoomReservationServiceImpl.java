package roomreservationserviceproducer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RoomReservationServiceImpl implements RoomReservationService{
	
	    //will store the default availabilities
		public static int SingleRoomAvailability = 10;
		public static int DulexeRoomAvailability = 10;
		public static int LuxurySuiteAvailability = 5;
		
		//will store current room prices per night
		public static int SingleRoomPrice = 20000;
		public static int DulexeRoomPrice = 50000;
		public static int LuxurySuitePrice = 100000;
		
		Scanner ob = new Scanner(System.in);
		

		@Override
		public void getRoomDetails() {
			printAvailableRooms();
			printRoomPriceDetails();		
		}
		
		public void printAvailableRooms() {
			System.out.println("Avaliable room types with vacancy as at "+java.time.LocalDate.now());
			System.out.println("*********************************************************");
			System.out.println("1. Single Rooms - "+SingleRoomAvailability);
			System.out.println("2 .Deluxe Rooms - "+DulexeRoomAvailability);
			System.out.println("3 .Luxury Rooms - "+LuxurySuiteAvailability);
			System.out.println("*********************************************************");
		}

		public void printRoomPriceDetails() {
			System.out.println("Room Prices per night at "+java.time.LocalDate.now());
			System.out.println("*********************************************************");
			System.out.println("1. Single Rooms - "+SingleRoomPrice+"LKR");
			System.out.println("2. Deluxe Rooms - "+DulexeRoomPrice+"LKR");
			System.out.println("3. Luxury Rooms - "+LuxurySuitePrice+"LKR");
			System.out.println("*********************************************************");
			System.out.println("Note - Taxes may be added");
			
		}

		@Override
		public void reserveRoom() {
			System.out.println("Please enter the number of the type of room you would like to reserve:");
			ArrayList currentCustomerDetails = new ArrayList<>();
			
			int no = ob.nextInt();
			switch(no) {
				case 1:
					if(SingleRoomAvailability>0) {
						//get customer details
						int noOfRooms = this.getCustomerDetails(currentCustomerDetails);
						//calculate payment
						int basicPayment = SingleRoomPrice * noOfRooms;
						//Tax of 10%
						float finalAmount = ((10/100)*basicPayment) + basicPayment;
						
						String confirm = printPaymentConfirm(finalAmount);
						if(confirm.equalsIgnoreCase("Yes")) {
							try {
								storeReservation(currentCustomerDetails,"Single Room");
								SingleRoomAvailability = SingleRoomAvailability - noOfRooms;
							} catch (Exception e) {
								e.printStackTrace();
							}
						}else {
							return;
						}	
						
					}else {
						System.out.println("Sorry there are no single rooms available currently");
						System.out.println("Type 'Yes' if you like to reserve another type of room or "
								+ "'No' if you want to exit resrvation process");
						String confirm = ob.next();
						
						if(confirm.equalsIgnoreCase("Yes")) {
							reserveRoom();
						}else {
							return;
						}
					}
				break;
				
				case 2:
					if(DulexeRoomAvailability>0) {
						//get customer details
						int noOfRooms = this.getCustomerDetails(currentCustomerDetails);
						//calculate payment
						int basicPayment = DulexeRoomPrice * noOfRooms;
						//Tax of 10%
						float finalAmount = ((10/100)*basicPayment) + basicPayment;
						
						String confirm = printPaymentConfirm(finalAmount);
						if(confirm.equalsIgnoreCase("Yes")) {
							try {
								storeReservation(currentCustomerDetails,"Deluxe Room");
								DulexeRoomAvailability =  DulexeRoomAvailability - noOfRooms;
							} catch (Exception e) {
								e.printStackTrace();
							}
						}else {
							return;
						}
					}else {
						System.out.println("Sorry there are no deluxe rooms available currently");
						System.out.println("Type 'Yes' if you like to reserve another type of room or "
								+ "'No' if you want to exit resrvation process");
						String confirm = ob.next();
						
						if(confirm.equalsIgnoreCase("Yes")) {
							reserveRoom();
						}else {
							return;
						}
					}
				break;
				
				case 3:
					if(LuxurySuiteAvailability>0) {
						//get customer details
						int noOfRooms = this.getCustomerDetails(currentCustomerDetails);
						//calculate payment
						int basicPayment = LuxurySuitePrice * noOfRooms;
						//Tax of 10%
						float finalAmount = ((10/100)*basicPayment) + basicPayment;
						
						String confirm = printPaymentConfirm(finalAmount);
						if(confirm.equalsIgnoreCase("Yes")) {
							try {
								storeReservation(currentCustomerDetails,"Luxury Suite");
								LuxurySuiteAvailability = LuxurySuiteAvailability - noOfRooms;
							} catch (Exception e) {
								e.printStackTrace();
							}
						}else {
							return;
						}
					}else {
						System.out.println("Sorry there are no luxury suites available currently");
						System.out.println("Type 'Yes' if you like to reserve another type of room or "
								+ "'No' if you want to exit resrvation process");
						String confirm = ob.next();
						
						if(confirm.equalsIgnoreCase("Yes")) {
							reserveRoom();
						}else {
							return;
						}
					}
				break;
				
				default:
					System.out.println("Invalid number entered");
					reserveRoom();
			}
		}
		
			public int getCustomerDetails(ArrayList storeDetails) {
				
				//emptying the array list to remove previous records
				storeDetails.removeAll(storeDetails);
				int num = 0;
				
				try {
					System.out.println("Please enter your name:");
					String Name = ob.next();
					storeDetails.add(Name);
					System.out.println("Please enter your NIC number:");
					String NIC = ob.next();
					storeDetails.add(NIC);
					System.out.println("For how many rooms would you like to reserve:");
					num = ob.nextInt();
					storeDetails.add(num);
					System.out.println("Please enter your contact number or email addess:");
					String contact = ob.next();
					storeDetails.add(contact);
					
				}catch(InputMismatchException e){
					System.out.println("Wrong information entered!");
				}catch(Exception e) {
					System.out.println("An exception occured");
				}
				return num;
				
		}
		
		public String printPaymentConfirm(float finalAmount) {
			
			System.out.println("***************************************");
			System.out.println("Payment Amount - "+finalAmount+" /=");
			System.out.println("***************************************");
			System.out.println("Would you like to confirm? Type yes");
			String confirm = ob.next();
			
			return confirm;
			
		}

		public void storeReservation(ArrayList details,String roomType) throws Exception {
				//create all required files to store data (only in the first time)
			try {
				String path ="D:\\RoomReservation.txt";	
				File file = new File(path);
				boolean created = file.createNewFile();
				file.setWritable(true);
				if (created) {
				    System.out.println("Saved!");
				} else {
				    System.out.println("Saved!");
				}
				    
				writeToFile(path,details,roomType);    
			} catch (IOException e) {
				    System.out.println("Error creating file: " + e.getMessage());
			}
				
		}
			
		public void writeToFile(String path,ArrayList details,String roomType) {
				 
				 try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
					 writer.newLine();
			         writer.write("***************************************");
					 writer.newLine();
			         writer.write("Name : "+details.get(0));
			         writer.newLine();
			         writer.write("NIC : "+details.get(1));
			         writer.newLine();
			         writer.write("Room type : "+roomType);
			         writer.newLine();
			         writer.write("Num of rooms : "+details.get(2));
			         writer.newLine();
			         writer.write("Contact : "+details.get(3));
			     } catch (IOException e) {
			            System.err.println("Error writing to file " + path);
			            e.printStackTrace();
			     }
			   
			}

		@Override
		public void updateDetails() {
			
			System.out.println("Hello Admin!Please enter the updated prices of rooms below");
			//admin can set new availabilities for the 3 types of rooms
			System.out.println("Enter updated price of single room:");
			SingleRoomPrice = ob.nextInt();
			System.out.println("Enter updated price of deluxe room:");
			DulexeRoomPrice = ob.nextInt();
			System.out.println("Enter updated price of luxury room:");
			LuxurySuitePrice = ob.nextInt();
			
		}


}
