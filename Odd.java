package gettingStarted;

public class Odd {

	public static void main(String[] args) {
		System.out.println("List of ODD numbers from 1 to 50 are below  : ");
		for(int i=0; i<=50; i++) {
			if (i%2 !=0)
			{
				System.out.print(i + ",");
			}
		}

	}

}