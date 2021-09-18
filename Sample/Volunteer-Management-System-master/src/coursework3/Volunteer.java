//DO NOT CHANGE THIS PACKAGE
package coursework3;

import cw3interfaces.VolunteerInterface;



//DO NOT CHANGE THIS NAME
public class Volunteer implements VolunteerInterface {
    String SkillSet;
    char[] skill = new char[3];
    //create a char array to store 
    public Volunteer(String input){
        System.out.println("Volunteer has been created.");
        SkillSet = input;
        //store the 3 skill into one value
        skill[0]=SkillSet.charAt(0);
        skill[1]=SkillSet.charAt(1);
        skill[2]=SkillSet.charAt(2);
        //divide the skill into 3 pieces, thus helping solve later problems
    }
//COMPLETE THIS CLASS      
//these public methods need to form the interface 
// DO NOT CHANGE ANY OF THESE METHOD NAMES, RETURN VALUES, OR ARGUMENTS   
    @Override
    public String getSkillSet(){
        //COMPLETE CODE HERE
        //returns a String of this volunteers skills, eg BBB, ABC, CDD etc
        return SkillSet;
    }
    
}
