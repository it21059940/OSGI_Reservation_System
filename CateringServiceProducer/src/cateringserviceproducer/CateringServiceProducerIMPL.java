package cateringserviceproducer;

import java.util.HashMap;
import java.util.Scanner;

public class CateringServiceProducerIMPL implements CateringServiceProducer {

	Scanner input = new Scanner(System.in);
	int menu;
	int ServiceNo;
	String name;
	String address;
	@Override
	public void showIntroduction() {
		String Intro = "We Warmly Welocme You To Lemon Holdings Catering Service System ";
		System.out.println(Intro);
		System.out.println("Please Enter Your Name to Get Started !");
		name = input.next();
		System.out.println("Hello "+name+" !!");
		System.out.println("Please Enter Your Address :");
		address = input.next();
		
	}

	@Override
	public int getServiceChoise() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Please Enter Service No You Want :");
		System.out.println("1. Indoor Party"); 
		System.out.println("2. Outdoor Party");
		System.out.println("3. Wedding");
		System.out.println("4. Other");
		ServiceNo = input.nextInt();
		
		return ServiceNo;
	}

	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		switch(ServiceNo) {
		case 1:{
			System.out.println("|----------------------------------------------------|");
			System.out.println("|----            Indoor Party Menus              ----|");
			System.out.println("|----------------------------------------------------|");
			System.out.println("|  -- Menu 1 --  |   -- Menu 2 --  |   -- Menu 3 --  |");
			System.out.println("|----------------------------------------------------|");
			System.out.println("| Rice & Curry   | Fried Rice      | Biriyani        |");
			System.out.println("| White Rice     | Roast Chiecken  | Roast Chicken   |");
			System.out.println("| Chicken Curry  | Chillie Paste   | Egg             |");
			System.out.println("| Brinjo         | Chopsy          | Chille Paste    |");
			System.out.println("| Dhal Curry     | Cashew          | Minchi          |");
			System.out.println("| Cashew         |                 | Chatni          |");
			System.out.println("| Papadam        |                 |                 |");
			System.out.println("|                |                 |                 |");
			System.out.println("|       Rs.200.00|        Rs.300.00|        Rs.400.00|");
			System.out.println("|----------------------------------------------------|");
			break;
			}
		case 2:{
			System.out.println("|----------------------------------------------------|");
			System.out.println("|----            Outdoor Party Menus             ----|");
			System.out.println("|----------------------------------------------------|");
			System.out.println("|  -- Menu 1 --  |   -- Menu 2 --  |   -- Menu 3 --  |");
			System.out.println("|----------------------------------------------------|");
			System.out.println("| Rice & Curry   | Fried Rice      | Biriyani        |");
			System.out.println("| White Rice     | Roast Chiecken  | Roast Chicken   |");
			System.out.println("| Chicken Curry  | Chillie Paste   | Egg             |");
			System.out.println("| Brinjo         | Chopsy          | Chille Paste    |");
			System.out.println("| Dhal Curry     | Cashew          | Minchi          |");
			System.out.println("| Cashew         |                 | Chatni          |");
			System.out.println("| Papadam        |                 |                 |");
			System.out.println("|                |                 |                 |");
			System.out.println("|       Rs.200.00|        Rs.300.00|        Rs.400.00|");
			System.out.println("|----------------------------------------------------|");
			break;
			}
		case 3:{
			System.out.println("|----------------------------------------------------|");
			System.out.println("|----            Wedding Party Menus             ----|");
			System.out.println("|----------------------------------------------------|");
			System.out.println("|  -- Menu 1 --  |   -- Menu 2 --  |   -- Menu 3 --  |");
			System.out.println("|----------------------------------------------------|");
			System.out.println("| Rice & Curry   | Fried Rice      | Biriyani        |");
			System.out.println("| White Rice     | Roast Chiecken  | Roast Chicken   |");
			System.out.println("| Chicken Curry  | Chillie Paste   | Egg             |");
			System.out.println("| Brinjo         | Chopsy          | Chille Paste    |");
			System.out.println("| Dhal Curry     | Cashew          | Minchi          |");
			System.out.println("| Cashew         |                 | Chatni          |");
			System.out.println("| Papadam        |                 |                 |");
			System.out.println("|                |                 |                 |");
			System.out.println("|       Rs.200.00|        Rs.300.00|        Rs.400.00|");
			System.out.println("|----------------------------------------------------|");
			break;
			}
		case 4:{
			System.out.println("|----------------------------------------------------|");
			System.out.println("|----            Other Party Menus             ----|");
			System.out.println("|----------------------------------------------------|");
			System.out.println("|  -- Menu 1 --  |   -- Menu 2 --  |   -- Menu 3 --  |");
			System.out.println("|----------------------------------------------------|");
			System.out.println("| Rice & Curry   | Fried Rice      | Biriyani        |");
			System.out.println("| White Rice     | Roast Chiecken  | Roast Chicken   |");
			System.out.println("| Chicken Curry  | Chillie Paste   | Egg             |");
			System.out.println("| Brinjo         | Chopsy          | Chille Paste    |");
			System.out.println("| Dhal Curry     | Cashew          | Minchi          |");
			System.out.println("| Cashew         |                 | Chatni          |");
			System.out.println("| Papadam        |                 |                 |");
			System.out.println("|                |                 |                 |");
			System.out.println("|       Rs.200.00|        Rs.300.00|        Rs.400.00|");
			System.out.println("|----------------------------------------------------|");
			break;
			
			}
		}
		System.out.println("Enter Menu You Want :");
		menu = input.nextInt();
		
	}

	@Override
	public void calculateBill() {
		// TODO Auto-generated method stub
		float tot = 0;
		float tax = 0;
		System.out.println("Enter No Of People :");
		int amount = input.nextInt();
		switch(menu) {
		case 1:{
			tot = 200 * amount;
			tax = tot + (tot/100*10);
			break;
			}
		case 2:{
			tot = 300 * amount;
			tax = tot + (tot/100*10);
			break;
		}
		case 3:{
			tot = 400 * amount;
			tax = tot + (tot/100*10);
			break;
			}
		}
		System.out.println("-------------------------------------");
		System.out.println("| Name    :" + name+"                ");
		System.out.println("| Amount  :" + amount+"              ");
		System.out.println("| Address :"+ address+"              ");
		System.out.println("| Total Cost           :     "+ tot+"     ");
		System.out.println("| (10% Service Charge Added)         ");
		System.out.println("| Total amount To Paid :     "+ tax+"    ");
		System.out.println("-------------------------------------");
	}

}
