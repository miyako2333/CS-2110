package xb_test;

public class test1 {
	static void q(int n) {
	    try {
	        int x= 10 / (n / 5);
	    } catch (ArithmeticException e) {
	        System.out.println("yes");
	        char c= "bb".charAt(n);
	    } catch (IndexOutOfBoundsException e) {
	      System.out.println("noo");
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		q(2);
	}

}
