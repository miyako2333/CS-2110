/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Hongyi.Wu
 */
public class Filehandler {
    
    public static void writting(int Group,ArrayList<Volunteer> group){
        File file = new File("Group"+Group+".txt");
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(file, false));
            for(Volunteer vol:group){
                fw.write(vol.SkillSet);
                fw.newLine();
            }
            System.out.println("Volunteer in Group "+Group+" written to file");
            fw.flush();
            fw.close();
            } 
            catch (IOException e) {
            System.out.println("Error writing to file");
            }
    }
    
    public static void read(SkillSorter in){
        for(int i = 0; i < 5; i++){
           File file = new File("Group"+(i+1)+".txt");
        String line = "";
        try {
            BufferedReader fr = new BufferedReader(new FileReader(file));
            while ( (line = fr.readLine() ) != null) {        
                in.getCommunityGroups().get(i).Group.add(new Volunteer(line));
            }
          fr.close();     
        } 
        catch (IOException e) {
          System.out.println("No volunteer to read for Group "+(i+1)+".");
        } 
        }
    }
}

