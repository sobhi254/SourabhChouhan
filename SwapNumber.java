package gettingStarted;

public class SwapNumber {

	public static void main(String[] args)
    {
 
        int a = 10, b = 20;
 
        System.out.println("Before Swap");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
 
        int temp = a;
        a = b;
        b = temp;
 
        System.out.println("After swap");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}