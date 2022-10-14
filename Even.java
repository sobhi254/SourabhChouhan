package gettingStarted;

public class Even {

	public static void main(String[] args) {
		
		System.out.println("List of EVEN numbers from 1 to 200 are below  : ");
		for(int i=0; i<=200; i++) {
			if (i%2==0)
			{
				System.out.print(i + ",");
			}
		}

	}

}
