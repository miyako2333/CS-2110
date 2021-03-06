package a1;
/** NetId: bx83. Time spent: 5 hours, 00 minutes. <br>
What I thought about this assignment: Some parts are still not so clear and difficult to understand.<br><br>
An instance maintains info about tan Elephant. */

public class Elephant { 
	//Nickname (a String). Name given to this Elephant, a String of length > 0
	private String eName;
	//Year of birth (an int). Must be >= 2000.
	private int eYear;
	//Month of birth (an int). In range 1..12 with 1 being January, etc.
	private int eMonth;
	//Gender of this Elephant (a char). 'F' means female and 'M' means male.
	private char eGender;
	//Mother (an Elephant). Mother of this elephant??null if unknown.
	private Elephant eMother;
	//Father (an Elephant). Father of this ??null if unknown.
	private Elephant eFather;
	//Number of known children of this Elephant.
	private int numChild;
	
	/* Constructor: an instance with nickname n, gender g, birth year y, and birth month m.
	Its parents are unknown, and it has no children.
	Precondition: n has at least 1 character, y >= 2000, m is in 1..12, and g is 'F' for
	female or 'M' for male.
	*/
	public Elephant(String n, char g, int y, int m) {
		assert n.length() >= 1;
		assert g == 'F' || g =='M';
		assert y >= 2000;
		assert m >= 1 && m <= 12;
		eName = n;
		eYear = y;
		eMonth = m;
		eGender = g;
		}
	//= this elephant's nickname
	public String name(){
		return eName;
	}
	//= the value of "this elephant is a female"
	public boolean isFemale() {
		return eGender == 'F';
	}
	//= the date of birth of this elephant. In the form "month/year", with no blanks, e.g. "6/2007"
	public String date() {
		return String.valueOf(eMonth)+"/"+String.valueOf(eYear);
	}
	//= this elephant's mother (null if unknown)
	public Elephant mom() {
		return eMother;
	}
	//= this elephant's father (null if unknown)
	public Elephant dad() {
		return eFather;
	}
	//= the number of children of this elephant
	public int children() {
		return numChild;
	}
	/*Add e as this elephant's mother.
	Precondition: this elephant??s mother is unknown and e is female.*/
	public void addMom(Elephant e) {
		assert eMother == null;
		assert e.isFemale();
		eMother = e;
		e.numChild ++;
	}
	/*Add e as this elephant's father.
	Precondition: this elephant??s father is unknown and e is female.*/
	public void addDad(Elephant e) {
		assert eFather == null;
		assert !e.isFemale();
		eFather = e;
		e.numChild ++;
	}
	
	/*Constructor: an elephant with nickname n, gender g, birth year y, birth month
	m, mother ma, and father pa.
	Precondition: n has at least 1 character, y >= 2000, g is 'F' for female or
	'M' for male, m is in 1..12, ma is a female, and pa is a male.*/
	public Elephant(String n, char g, int y, int m, Elephant ma, Elephant pa) {
		assert n.length() >= 1;
		assert g == 'F' || g =='M';
		assert y >= 2000;
		assert m >= 1 && m <= 12;
		//assert ma.isFemale() || ma == null;
		//assert !pa.isFemale() || pa == null;
		eName = n;
		eYear = y;
		eMonth = m;
		eGender = g;
		eMother = ma;
		eFather = pa;
	}
	
	/*Return value of "this elephant is older than e."
	Precondition: e is not null.*/
	public boolean isOlder(Elephant e) {
		return eYear < e.eYear;
	}
	/*Return value of "this elephant and e are siblings." (note:
	if e is null they can't be siblings, so false is returned).*/
	public boolean areSibs(Elephant e) {
		boolean Nnull = eFather == e.eFather || eMother == e.eMother;
		boolean Ynull = eFather !=  null || eMother != null;
		return Nnull && Ynull;
	}
	
}
