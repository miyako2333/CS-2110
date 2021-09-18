package coursework3;
import static coursework3.Filehandler.read;
import static coursework3.Filehandler.writting;
import java.util.Scanner;

/*READ ME: Use this class as your main class, and create your menu here
Your menu should then call the appropriate methods in the SkillSorter class
You need to complete the other classes, including the empty methods.
/*
*/
public class CW3Main {
    SkillSorter test = new SkillSorter();
    Scanner s = new Scanner(System.in);
    //initialize the object of SkillSorter and Scanner
    
    public static void main(String[] args){
        CW3Main run = new CW3Main();      
    }
    
    
    public CW3Main(){
        System.out.println("This is a volunteer management system.\n"
                + "There are five groups and the limitation is 500\n"
                + "Each volunteer has three skills which represented by five letters from A to E\n");
        //create a guide when run the program
        read(test);
        while(true){
            menu();
        }
    }
    //Construct and run your menu here.
    //You MUST call methods in SkillSorter from your menu
    //and complete the methods in SkillSorter 
    //DO NOT write the methods, eg addVolunteer, in THIS class.
    //Call and use the ones in SkillSorter.
    
    private void menu(){
        topMenu();
        String in = s.nextLine();
        switch(in){ //use to switch each number when input
            case "1":
                Volunteer tempCase1 = new Volunteer(askSkills());
                //create a temp volunteer object
                test.addVolunteer(tempCase1);
                System.out.println("finfish");
                break;
            case "2":
                String skillCase2 = askSkills();
                int from = askGroupNumber("move from")-1;
                //the order of group should be 0 to 4 while we input 1 to 5
                int to = askGroupNumber("move to")-1;
                //the same as above one
                test.moveVolunteer(skillCase2,test.getCommunityGroups().get(from),test.getCommunityGroups().get(to));
                System.out.println("finfish");
                break;
            case "3":
                String skillCase3 = askSkills();
                int DeleteFrom = askGroupNumber("delete")-1;
                test.deleteVolunteer(skillCase3, test.getCommunityGroups().get(DeleteFrom));
                System.out.println("finfish");
                break;
            case "4":
                test.deleteAllVolunteers();
                System.out.println("finfish");
                break;
            case "5":
                System.out.println("Group 1\t\tGroup 2\t\tGroup 3\t\tGroup 4\t\tGroup 5");
                //display each group in a row
                for(int a = 0;a<=4;a++){    //it calculate all the skills firstly
                    test.getCommunityGroups().get(a).addUpSkills();
                }
                for(int i = 0;i<=4;i++){
                    System.out.println("Skill "+(char)(i+65)+": "+test.getCommunityGroups().get(0).skills[i]+"\t"+"Skill "+(char)(i+65)+": "+test.getCommunityGroups().get(1).skills[i]+"\t"+"Skill "+(char)(i+65)+": "+test.getCommunityGroups().get(2).skills[i]+"\t"+"Skill "+(char)(i+65)+": "+test.getCommunityGroups().get(3).skills[i]+"\t"+"Skill "+(char)(i+65)+": "+test.getCommunityGroups().get(4).skills[i]+"\t");
                    /* i is from 0 to 4, so i+65 should be the ASCII order of the alphabet A to E
                    We want to display each group in a row, so we println a series code.
                    The difference among them is the number in the get() and the skills[i] which represented total of five letters.
                    */ 
                }
                System.out.println(test.getCommunityGroups().get(0).howManyVolunteers()*3+"\t\t"+test.getCommunityGroups().get(1).howManyVolunteers()*3+"\t\t"+test.getCommunityGroups().get(2).howManyVolunteers()*3+"\t\t"+test.getCommunityGroups().get(3).howManyVolunteers()*3+"\t\t"+test.getCommunityGroups().get(4).howManyVolunteers()*3+"\t\t");
                //Then we display the total numbers of each group.
                //we use the howManyVolunteers() to get numbers of total volunteers.
                //Since we want to get total of skills, we multiple it three times.
                System.out.println("finfish");
                break;
            case "6":
                System.out.println("The program will exit.");
                for (int i = 0; i < test.getCommunityGroups().size(); i++){
                    writting(i+1,test.getCommunityGroups().get(i).Group);
                    //loop to write each group
                }
                System.exit(0);
            case "7":
                for(int i=0;i<20;i++){
                    Volunteer x = new Volunteer(sortSkills(testadd()));
                    test.addVolunteer(x);
                }
                
            default:
                System.out.println("It should be a in the list.");
            //if any input doesn't meet the requirement, it will prompt.
        }
    }
    
    private void topMenu(){
        System.out.println("\nPlease choose an option below:");
        System.out.println("1. add a volunteer.");
        System.out.println("2. move a volunteer.");
        System.out.println("3. delete a volunteer.");
        System.out.println("4. delete all volunteers.");
        System.out.println("5. display the Volunteers.");
        System.out.println("6. save and exit.");
    }
    //this method aims to display the menu to prompt users
    
    private String askSkills(){
        boolean con = true;
        String skill = "default";//initialize the skill with a default value
        do{
            System.out.println("Please input the skills of volunteer you want to change. e.g. ABE"
                    + "\nThe single skill should from A to E");
            skill = s.nextLine();
            con = !judgeSkillSet(skill);
            //if do not meet the requirement, ask again
        }while(con);
        return sortSkills(skill);
        //return the sorted skills
    }
    //judge if the skills input meet the requirement
    
    private int askGroupNumber(String ask){
        boolean con = false;
        int number = 0;
        do{
            System.out.println("Please input the group you want to "+ask+". e.g.3");
            String in = s.nextLine();
            //judge if it is  a number
            try{
                number = Integer.parseInt(in);
                con = false;
            }
            catch(NumberFormatException e){
                con = true;
            }
            if (!(number>=1&&number<=5)){//judge if it is from 1 to 5 
                con = true;
            }
        }while(con); //if not, input again
        return number;
    }
    
    private String sortSkills(String input){
        //firstly we divide the input into three String
        String first = input.substring(0,1);
        String second = input.substring(1,2);
        String third = input.substring(2,3);
        //Then we use charAt compare the order of character
        //compare first and second, if the first is larger, exchange them
        if(input.charAt(0)>input.charAt(1)){
            String temp = first;
            first = second;
            second = temp;
            input = first+second+third;
        }
        //compare first and third, if the first is larger, exchange them
        if(input.charAt(0)>input.charAt(2)){
            String temp = first;
            first = third;
            third = temp;
            input = first+second+third;
        }
        //compare second and third, if the first is second, exchange them
        if(input.charAt(1)>input.charAt(2)){
            String temp = second;
            second = third;
            third = temp;
            input = first+second+third; //re-combine the input String
        }
        
        return input;
    }
    //this method aims to sort the input skills. e.g. CEA to ACE
    
    
    private boolean judgeSkillSet(String input){
        if(!(input.length()==3)){
            return false;
        }
        else{
            for(int i = 0; i < 3; i++){
                if(!(input.charAt(i)>=65 && input.charAt(i)<=69)){
                    return false;
                }
            }
        }
        return true;
    }
    //judge if the skills input meet the requirement
    
    private String testadd(){
        String[] str = {"A","B","C","D","E"};
        String[] ch = new String[3];
        for(int i=0;i<ch.length;i++)
        {
        int index;
        index=(int)(Math.random()*(str.length));
        ch[i]=str[index];
        
        }
        return ch[0]+ch[1]+ch[2];
    }
    

}
