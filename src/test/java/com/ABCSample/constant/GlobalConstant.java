package com.ABCSample.constant;


public class GlobalConstant {
	
	public enum FileNames {
		TestDataRelativePath("src/test/resources/testdata/"),
		UserProperties("User"),
		CustomerProperties("Customer"),
		TestdataProperties("TestData");
		
		private String value;
		private FileNames(String value) {
			this.value = value;
		}
		
		public String toString() {
			return value;
		}
	}

}
