package com.ABCSample.selenium.framework;

import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

public class getLocators  {

	static Document doc;
	//static Elements e2;
	public static void main(String[] args) throws IOException {
       
//	establishConnection("https://www.edureka.co/all-courses");
     	establishConnection("https://www.adda52.com/");
//		establishConnection("https://www.fmovies.io/");

	 	//Elements textbox = searchAttribute("type","text");
	 	searchAttribute("type","text");
	 	
		System.out.println("++++++++++++CHECK BOX DATA +++++++++++++++++++++++++++");
	 	//Elements checkbox = searchAttribute("type","checkbox");
		searchAttribute("type","checkbox");
		
	 	System.out.println("++++++++++++Button BOX DATA +++++++++++++++++++++++++++");
	 	//Elements buttonkbox = searchAttribute("type","button");
	 	searchAttribute("type","button");
	 	
	 	System.out.println("++++++++++++ List BOX DATA +++++++++++++++++++++++++++");
	 	//Elements buttonkbox = searchAttribute("type","button");
	 	searchAttribute("type","list");
	 	
	 	
	 	
	 	//	    getvalue(textbox);
//	    getvalue(checkbox);
//      getLiElement(".country-search-class","data-countryname");
    
	}
	
	
	
	public static void establishConnection(String websiteURL) throws IOException
	{
		doc = Jsoup.connect(websiteURL).get();
	    String title = doc.title();
	    System.out.println("Title : " + title);
	}
	public static void getLiElement(String ClassName,String attr){
		Elements list = doc.select(".country-search-class>a");
		System.out.println(list.size());
	    for (Element l: list){
	    	System.out.println("List of css locator  : "+l.attr("data-countryname"));
		 }
	    for (int i =1;i<=list.size();i++){
	    	//System.out.println("List of css locator  : "+l.cssSelector());
	        String css= "li.country-search-class:nth-child("+i+")";
	    	System.out.println("CSS======= "+css);
		 }
	 	}
	
	public static void searchAttribute(String ele_type,String ele_value)
	{ 
		Elements e2 = doc.getElementsByAttributeValue(ele_type,ele_value);
		int count = 0;
		// System.out.println("e2: "+e2.toString());
	    for (Element ls:e2)
	    {  
		 if ((!e2.attr("id").isEmpty()))
		 { 
		  //System.out.println("PLACE HOLDER VALUE: "+e2.attr("placeholder"));
		  System.out.println("Number of Element: "+ count++);
		  System.out.println("id for the element: "+ ls.attr("id"));
		  System.out.println("Css Value: "+ls.cssSelector());
		  System.out.println("Class Value: "+ ls.attr("class"));
		  System.out.println("Value: "+ls.attr("value"));
		  System.out.println("Name: "+ls.attr("name"));
		  System.out.println("Href : "+ls.attr("href"));
		 }
		 else if (!(e2.attr("class").isEmpty()))
		 { 
		  System.out.println("e2: "+ ls.attr("class"));
		 }
	    }
      // return e2; 		 
	}
	public static String getvalue(Elements t1){
		String att_value = "";
		for (Element e1: t1){
			System.out.println("=======================FIELD NAME: "+e1.attr("name")+"==========================");
			System.out.println("=======Get ID Attr Value : ======="+ e1.attr("id"));
		    System.out.println("======Get Class Attr Value: ======"+e1.attr("class"));
		    System.out.println("======Get Value Attr    : ======"+e1.attr("value"));
		    System.out.println("====Get Css Value : ======"+e1.cssSelector());
		    System.out.println("=================================================================================");
		}	
		
		return att_value;
     }
	public static void CheckIfElementPresent(String[] locator){
		for (int i = 0; i<locator.length;i++)
		{
		  String e1 = locator[i];
		  if (e1.startsWith("id"))
		  {
		        
		  }
		  else if (e1.startsWith("class")){
			  
		  }
          else if (e1.startsWith("xpath")){
			  
		  }
          else if (e1.startsWith("css")){
			  
		  }
	    }
	}
	public static void getTableData_FormType(String form_attr,String tagtype)
	{
	  Element form = doc.getElementById("registerForm");
	  System.out.println("Form action = "+ form.attr(form_attr)); //"action"
	  Elements inputElements = form.getElementsByTag(tagtype);// "input"
	  for (Element inputElement : inputElements) 
	  {
	    String key = inputElement.attr("name");
	    String value = inputElement.attr("value");
	    System.out.println(key + " =  " + value);
	   }   	
	}
 
}