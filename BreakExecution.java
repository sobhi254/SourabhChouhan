package gettingStarted;

public class BreakExecution {

public static void main(String[] args) {
		
		int[] marks = new int [] {12, 34, 66, 85, 900};
		
		for(int i=0; i<marks.length-1; i++) {
			if (marks[i]==85) {
				System.out.println("I am number : 85, So BREAKING EXECUTION loop now");
				break;
			}
			else {
			System.out.println("I am number : " +marks[i]);
		}

		}
		}
}

