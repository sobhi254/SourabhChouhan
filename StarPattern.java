package gettingStarted;

public class StarPattern {

	public static void main(String[] args) {
		
		System.out.println("Below is STAR pattern  : ");
		
		for(int i=0; i<6; i++) {
			
			for(int j=0; j<=i; j++){
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
