package com.mtit.service;

public class MemberModel {
	String name;
	String password;
	String email;
	double pckg;
	
	MemberModel(String name,String password,String email,double pckg){
		this.name = name;
		this.password = password;
		this.email = email;
		this.pckg = pckg;
	}
}
