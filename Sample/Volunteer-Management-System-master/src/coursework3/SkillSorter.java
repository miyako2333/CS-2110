//DO NOT CHANGE THIS PACKAGE
package coursework3;
import cw3interfaces.SkillSorterInterface;
import java.util.ArrayList;
import java.util.ListIterator;

//DO NOT CHANGE THIS NAME
public class SkillSorter implements SkillSorterInterface{
     private ArrayList<CommunityGroup> myGroups = new ArrayList<>();
    
    //COMPLETE THIS CLASS
    public SkillSorter(){
        for(int i=0;i<5;i++){
            myGroups.add(new CommunityGroup());
        }
        //create five groups when create a SkillSorter object
    }
    
//these public methods need to form the interface 
// DO NOT CHANGE ANY OF THESE METHOD NAMES, RETURN VALUES, OR ARGUMENTS
    @Override
    public void addVolunteer(Volunteer vol){
        //add a volunteer to a Community Group USING YOUR SORTING ALGORITHM
        //COMPLETE CODE HERE
       // int addGroupNumber = (int) (Math.random()*5); for test
        double avg[] = new double[5];
        for(int i = 0; i < avg.length; i++){
           int sum = 0;
           for(int j = 0; j < 5; j++){
               sum += myGroups.get(i).skills[j];
            }
           avg[i] = sum/5;
        }
       //calculate the averge of skills in five groups
       
        double preVariance[] = new double[5];
        for(int i = 0; i < preVariance.length; i++){
            for(int j = 0; j < 5; j++){
                preVariance[i] += Math.pow(myGroups.get(i).skills[j]-avg[i],2);
            }
        }
       //calculate the variance of skills in five groups
       
        double postVariance[] = new double[5];
        for(int i = 0; i < preVariance.length; i++){
            int change1 = vol.skill[0]-65;
            int change2 = vol.skill[1]-65;
            int change3 = vol.skill[2]-65;
           //vol.skill is a array of char. The element there has ASCII order
           //e.g. A-65 == 0
            for(int j = 0; j < 5; j++){
                if(j==change1||j==change2||j==change3){
                   //so here we judge if j==change to change the method we calculate the variance
                    postVariance[i] += Math.pow(myGroups.get(i).skills[j]+1-(avg[i]+0.6),2);
                   //avg should plus 0.6 for 3/5 = 0.6
                }
                else{
                    postVariance[i] += Math.pow(myGroups.get(i).skills[j]-(avg[i]+0.6),2);
                    //if the alphabet is not the user input, it calculate in another way
                }  
            }
        }
       
       
        double D_valueOfVar[] = new double[5];
        for(int i = 0; i < 5; i++){
            D_valueOfVar[i] = postVariance[i]-preVariance[i];
        }
        //Then we calculate the difference beween original variance and the post-input variance for each group
       
       
       double D_valueOfTotal[] = new double[5];
       int TotalofVolunteer = 0;
       for(int i = 0; i < D_valueOfTotal.length; i++){
           TotalofVolunteer += myGroups.get(i).howManyVolunteers();
           //add up all the volunteers
       }
       double avgOfVolunteer = TotalofVolunteer/5;
       double TotalVariance = 0;
       for(int i = 0; i < D_valueOfTotal.length; i++){
           TotalVariance += Math.pow(myGroups.get(i).howManyVolunteers()-avgOfVolunteer,2);
       }//calculate the variance among the present Groups
       double postTotalVariance[] = new double[5];
       for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if (i==j){
                    postTotalVariance[i] += Math.pow(myGroups.get(j).howManyVolunteers()+1-(avgOfVolunteer+0.2),2);
                }
                else{
                    postTotalVariance[i] += Math.pow(myGroups.get(j).howManyVolunteers()-(avgOfVolunteer+0.2),2);
                }
            }
       }
       //calculate five variance for the new volunteer in five group in store in array. The method is similar to above.
       for(int i = 0; i < 5; i++){
           D_valueOfTotal[i] = postTotalVariance[i]-TotalVariance;
       }
       //calculate the difference beween original variance and the post-input variance for volunteers
       double totalCalculate[] = new double[5];
       for(int i = 0; i < 5; i++){
           totalCalculate[i] = D_valueOfVar[i]+D_valueOfTotal[i]/3;
           //add the two difference and weight two parts. According to experienment,D_valueOfTotal/3 could be a better choice.
       }
       
       double min = 999;//initialize the value;
       int num = -1;
       //default of num is -1
       for(int i = 0; i < 5; i++){
           //search for the array of totalCalculate, and choose the minimum one
            if(myGroups.get(i).Group.size()<500){
                //if the Group has been full, it can not be chosen.
                if (totalCalculate[i]<min){
                min = totalCalculate[i];
                num = i;
                }
            }
       }
       //get which group to add
        if(num==-1){
            //it means no group is chosen, thus all the groups are full.
            System.out.println("All the groups are full");
        }
        else{
            myGroups.get(num).Group.add(vol);
        }     
        
    }
    
    @Override
    public void moveVolunteer(String skillSet, CommunityGroup from, CommunityGroup to){
        //move a volunteer with this skillset (eg AAA, BCD) from one CommunityGroup to another
        //COMPLETE CODE HERE
        boolean con = true;
        ListIterator it = from.Group.listIterator();
        while(it.hasNext()&&con){
            //if it has next and it have not find any suitable volunteer, it will continue to find
            Volunteer temp = (Volunteer) it.next();
            if(temp.SkillSet.equals(skillSet)){
                con = false;
            }
        }
        deleteVolunteer(skillSet, from);
        if(con){
            //if con do not change to false, which means it do not find volunteer in the group user want to move
            System.out.println("error add because of no volunteers with the skills");
        }
        else if(to.Group.size()==500){
            System.out.println("The Group is full");
        }
        else{
            to.Group.add(new Volunteer(skillSet));
        }
        
    }
    
    @Override
    public void deleteVolunteer(String skillSet, CommunityGroup from){
        //delete a volunteer with this skillset from this CommunityGroup
        //COMPLETE CODE HERE
        boolean continueIt = true;
        ListIterator it = from.Group.listIterator();
        if(!it.hasNext()){
            System.out.println("no any Volunteers here!");
        }
        while(it.hasNext()&&continueIt){
            //if it has next and it have not find any suitable volunteer, it will continue to find
            Volunteer temp = (Volunteer) it.next();
            //pick up the volunteer in the arraylist 
            if(temp.SkillSet.equals(skillSet)){
                it.remove();
                continueIt = false;
            }
            else{
                System.out.println("error delete. There is no Volunteer with the skills");
            }
        }
    }
    
    @Override
    public void deleteAllVolunteers(){
        // delete all volunteers from all CommunityGroups
        //COMPLETE CODE HERE
        myGroups.clear();
        for(int i=0;i<5;i++){
            myGroups.add(new CommunityGroup());
        }
    }

    @Override
    public ArrayList<CommunityGroup> getCommunityGroups(){
        //return an ArrayList of all this application's CommunityGroups
        return myGroups;
    }
    
   
   
}
