package xb_test;

public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 0;
		int x = 1;
		int[] b = {1,2,3,4,5,6,7,8,9};
		while (k<b.length){
			k ++;
			x = x * b[k];
		}
		System.out.println(x);
	}

}
