package gettingStarted;

public class Student {

	public static void main(String[] args) {
		
		int[] marks = new int [] {25, 45, 55, 95, 80};
		
		for(int i=0; i<marks.length-1; i++) {
			if (marks[i] > 80) {
				System.out.println("Marks above 80 is : " +marks[i]);
			}
		}

	}

}
