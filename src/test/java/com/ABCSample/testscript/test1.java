package com.ABCSample.testscript;

public class test1 {

	private String name;
	
	public test1(String name){
		System.out.println("Print name:"+ name);
	}
	public static void addtest() {

//		String name = "1234abce";
//		String num = name.replaceAll("[0-9]","");
//		System.out.println(num);

		int num = 5;
 		int mid = num/2;
        int flag = 0;	
		for(int i =2; i<mid;i++){
	       if (num%i==0)
	       {
			System.out.println("not prime");
	        flag++;
			break;
	       }
		} 
	     if (flag ==0)  {
	    	   System.out.println("prime");
		    
	       }
	       
	     }
	}


