package com.mtit.service;

import java.util.Scanner;

public class ServicePublishImpl implements ServicePublish {

	Scanner sc= new Scanner(System.in);
	Connect connect =new Connect();
	@Override
	public String publishServce() {
		return "Execute the publish service of SericePublisher";
	}

	@Override
	public void showMenu() {
		String welcomeText = "Hello! Welcome to MYNSA GYM.To Continue please select\n1 to register to system,\n2 to login to system\n3 to see our pacakges";
		System.out.println(welcomeText);
		
	}

	@Override
	public int getSelectedMenuItem() {
		
		return sc.nextInt();
	}

	@Override
	public void executeMenu(int choice) {
		switch(choice) {
		case 1:
			registerToGym();
			break;
		case 2:
			login();
			break;
		case 3:
			showPackages();
			break;
		default:
			System.out.println("Invalid option");
		}
		
	}
	
	@Override
	public void registerToGym() {
		System.out.println();
		System.out.print("Enter your name : ");
		String name = sc.next();
		System.out.println();
		System.out.print("Enter your email : ");
		String email = sc.next();
		System.out.println();
		System.out.print("Enter your password : ");
		String password = sc.next();
		System.out.println();
		showPackages();
		System.out.print("Enter your choosed pacakge : ");
		int pacakge = sc.nextInt();
		
		connect.insertUserDataToDb(email, password, name, pacakge);
		
		
	}

	@Override
	public void showPackages() {
		String pacakgeText = "----------- Our pacakges -------------";
		String pacakgeText1 = "1. Monthly LKR 1500";
		String pacakgeText2 = "6 Month Package LKR 6500";
		String pacakgeText3 = "12 Month Package LKR 10000";
		System.out.println(pacakgeText);
		System.out.println(pacakgeText1);
		System.out.println(pacakgeText2);
		System.out.println(pacakgeText3);
		System.out.println("----------------------------------------");
	}

	@Override
	public void login() {
		System.out.print("Enter your email : ");
		String email = sc.next();
		System.out.println();
		System.out.print("Enter your password : ");
		String password = sc.next();
		System.out.println();
		
		connect.login(email, password);
		
	}

	

}
