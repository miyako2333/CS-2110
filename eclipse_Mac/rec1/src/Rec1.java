import java.util.ArrayList;

public class Rec1 {

	public static boolean containsVowel(String s) {
		return s.contains("a") || s.contains("e")|| s.contains("i")|| s.contains("o")|| s.contains("u");
	}
	
	public static String dateToString(int d, int m, int y) {
		ArrayList<String> month = new ArrayList<String>();
		month.add("January");month.add("February");month.add("March");month.add("April");
		month.add("May");month.add("June");month.add("July");month.add("August");
		month.add("September");month.add("October");month.add("November");month.add("December");
		String date=(d+" "+month.get(m-1)+" "+y);
		return date;
	}
	public static boolean stringE(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i,i+1).contains("e")) {
				count++;
			}
		}
		return count>1 ;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(containsVowel("Hello world!"));
		System.out.println(containsVowel("Hll wrld!"));
		System.out.println(dateToString(31,10,2021));
		System.out.println(dateToString(28,2,2018));
		System.out.println(stringE("Helle"));
		System.out.println(stringE("Hlle"));
	}
}
