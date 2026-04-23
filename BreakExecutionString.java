package gettingStarted;

public class BreakExecutionString {

public static void main(String[] args) {
		
		String[] language = new String [] {"Java","JavaScript","Selenium","Python","Mukesh"};
		
		for(int i=0; i<language.length-1; i++) {
			if (language[i]=="Selenium") {
				System.out.println("I am 'THE SELENIUM', So BREAKING EXECUTION loop now");
				break;
			}
			else {
			System.out.println("I am not Selenium : " +language[i]);
}
		}
}
}
