package xb_test;

public class Counter {
	    int count;
	    public void decrement() {
	        count= count - 1;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter c1= new Counter();
		Counter c2= new Counter();
		c1.decrement();
		c1= c2;
		c1.decrement();
		c1= new Counter();
		c2.decrement();
		int b= c2.count;
		System.out.print(b);
		}
}
