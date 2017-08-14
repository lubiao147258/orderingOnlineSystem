package com.lb.util;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckEmail {
	
	
	public static boolean emailCheck(String email){
		String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";    
		Pattern regex = Pattern.compile(check);    
		Matcher matcher = regex.matcher(email);    
		boolean isMatched = matcher.matches();    
		//System.out.println(isMatched);    		
		return isMatched;		
	}
	/*
	public static void main(String[] args) {
		Scanner in = new  Scanner(System.in);
		String email = in.nextLine();
		if(emailCheck(email)){
			System.out.println("邮箱格式ok");
		}else{
			System.out.println("budui");
		}
	}*/

}
