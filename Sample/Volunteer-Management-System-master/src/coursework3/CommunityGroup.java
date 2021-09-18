//DO NOT CHANGE THIS PACKAGE
package coursework3;

import cw3interfaces.CommunityGroupInterface;
import java.util.ArrayList;


//DO NOT CHANGE THIS NAME
public class CommunityGroup implements CommunityGroupInterface {
    ArrayList<Volunteer> Group = new ArrayList<>();
    int[] skills = new int[5];
    //create array to store each skill in a group
    public CommunityGroup(){
        
    }
    
    
 //COMPLETE THIS CLASS    
    
    public void addUpSkills(){
        skills = new int[5];
        for(int i = 0;i<Group.size();i++){
            for (char s: Group.get(i).skill){
                skills[s-65]++;
                //s represent A to E in ASCII which is from 65 to 69
                //s-65 is from 0 to 4
            }
        }
    }
    //add up the skills
    
 //these public methods need to form the interface 
// DO NOT CHANGE ANY OF THESE METHOD NAMES, RETURN VALUES, OR ARGUMENTS   
    @Override
    public int howManyVolunteers(){
        //return the total number of volunteers in this community group
        //COMPLETE CODE HERE
        return Group.size();
    }
    
    @Override
    public String getSkillsTotals(){
        // return the total number of each skill in a String, example:
        //Skill A: 13, Skill B: 20, Skill C: 23, Skill D: 5, Skill E: 41
        //COMPLETE CODE HERE
        addUpSkills();
        //add up all the skills before get total
        
        return "Skill A: "+skills[0]+", Skill B: "+skills[1]+", Skill C: "+skills[2]+", Skill D: "+skills[3]+", Skill E: "+skills[4];
    }
            
    
    
    
    

}
