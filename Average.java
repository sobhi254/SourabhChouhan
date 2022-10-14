package gettingStarted;

public class Average {

	public static void main(String[] args) {
	
			double arr[]= {10,90.78,111,8989,7876};
			double sum=0;
			
			for(int i=0; i<arr.length; i++) {
				sum=sum + arr[i];
			}
			double average=sum/arr.length;
	System.out.println("AVERAGE of elements is  : "+ average);
		}

	}
