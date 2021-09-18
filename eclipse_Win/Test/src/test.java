
public class test {

	void q(int n) {
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
		System.out.println(q(1));
	}
}
