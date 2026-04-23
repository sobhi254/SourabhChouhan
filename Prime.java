package gettingStarted;

public class Prime {

	public static void main(String[] args) {
		System.out.println("List of PRIME numbers from 1 to 1000 are below  : ");
		for(int i=3; i<=1000; i++) {
			for(int j=2; j<i; j++){
				if (i%j==0) {
					break;
				}
				if (i%j!=0) {
					System.out.print(i + ",");
					break;
				}
			}
			
		}

	}

}