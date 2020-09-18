package com.instagram.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.instagram.entity.InstagramUser;
import com.instagram.service.InstagramService;
import com.instagram.service.InstagramServiceInterface;

public class InstagramController implements InstagramControllerInterface {
	
	private InstagramServiceInterface is;
	
	public InstagramController() {
		is=new InstagramService();
	}

	public void createProfile() throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your Name : ");
		String name=br.readLine();
		
		System.out.println("Enter your Password : ");
		String password=br.readLine();
		
		System.out.println("Enter your Email : ");
		String email=br.readLine();
		
		System.out.println("Enter your Address : ");
		String address=br.readLine();
		
		InstagramUser iu=new InstagramUser();
		iu.setName(name);
		iu.setPassword(password);
		iu.setEmail(email);
		iu.setAddress(address);
		
		
		int i=is.createprofileService(iu);//we should not transfer concrete data
		
		if(i>0) {
			System.out.println("profile created");
		}
		else {
			System.out.println("could not create profile");
		}

	}

	public void editProfile()throws Exception {
		viewProfile();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("press 1 to edit name");
		System.out.println("press 2 to edit password");
		System.out.println("press 3 to edit email");
		System.out.println("press 4 to edit address");
		
		System.out.println("enter your choice ");
		int i=Integer.parseInt(br.readLine());
		
		
		//InstagramControllerInterface fi=new InstagramController();
		String name="Ashutosh";
		
		switch(i) {
		
		case 1: editProfilebypassword(name);
			break;
		case 2:editProfilebyemail();
			break;
		case 3:editProfilebyaddress();
			break;
		
		
		default:System.out.println("wrong choice");
		
		}
		is.editprofileService();

	}

	private void editProfilebyaddress() {
		// TODO Auto-generated method stub
		
	}

	private void editProfilebyemail() {
		// TODO Auto-generated method stub
		
	}

	

	private void editProfilebypassword(String name)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter new password : ");
		String password=br.readLine();
		
		InstagramUser iu=new InstagramUser(); //this object is used for transfering data from controller to service
		iu.setName(name);
		iu.setPassword(password);
		
		int i=is.editprofilebyname(iu);
		if(i>0) {
			System.out.println("profile edited");
		}
		
	}

	public void deleteProfile() throws Exception{
		is.deleteprofileService();

	}

	public void searchProfile()throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Name to search profile : ");
		String name=br.readLine();
		
		InstagramUser iu=new InstagramUser(); //this object is used for transfering data from controller to service
		iu.setName(name);
		
		List<InstagramUser> uu=is.searchprofileService(iu);
		
		System.out.println(uu.size()+"  users found");
		
		for(InstagramUser u:uu) {
			System.out.println("****************************************");
			System.out.println("Name is : "+u.getName());
			System.out.println("Password is : "+u.getPassword());
			System.out.println("Email is : "+u.getEmail());
			System.out.println("Address is : "+u.getAddress());
			System.out.println("****************************************");
		}

	}

	public void viewAllProfile() throws Exception{
		List<InstagramUser> uu=is.viewallprofileService();
		System.out.println(uu.size()+"  users found");
		
		for(InstagramUser u:uu) {
			System.out.println("****************************************");
			System.out.println("Name is : "+u.getName());
			System.out.println("Password is : "+u.getPassword());
			System.out.println("Email is : "+u.getEmail());
			System.out.println("Address is : "+u.getAddress());
			System.out.println("****************************************");
		}

	}

	public void viewProfile()throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Name to view profile : ");
		String name=br.readLine();
		
		InstagramUser iu=new InstagramUser(); //this object is used for transfering data from controller to service
		iu.setName(name);
		
		
		InstagramUser uu=is.viewprofileService(iu);//this object is used for taking data from service to controller
		if(uu!=null) {
			System.out.println("User Information is below");
			System.out.println("Name is : "+uu.getName());
			System.out.println("Password is : "+uu.getPassword());
			System.out.println("Email is : "+uu.getEmail());
			System.out.println("Address is : "+uu.getAddress());
		}
		else {
			System.out.println("User with Name : "+name+" not exist");
		}

	}

	public void createcustomtable() throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter table name ");
		String name=br.readLine();
		
		System.out.println("how many column");
		int i=Integer.parseInt(br.readLine());
		
		for(int j=1;j<=i;j++) {
			System.out.println("Enter "+j+" column name");
			String cname=br.readLine();
			System.out.println("Enter "+j+" column data type");
			String cdata=br.readLine();
			System.out.println("Enter "+j+" column size");
			String csize=br.readLine();
		}
		
	}

}

















