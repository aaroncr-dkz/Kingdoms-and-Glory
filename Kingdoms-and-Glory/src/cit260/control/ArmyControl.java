/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.control;

import cit260.exception.ArmyControlException;
import cit260.model.Army;
import cit260.model.ArmyMember;
import java.util.ArrayList;
import kingdoms.and.glory.KingdomsAndGlory;

/**
 *
 * @author aaroncr-dkz
 */
public class ArmyControl {

    public static String retrieveArmyData() throws ArmyControlException
    {
          ArrayList<ArmyMember> army = KingdomsAndGlory.getCurrentGame().getArmy().getArmyMembers();
          if (army == null) {
              throw new ArmyControlException("ERROR: An object failed to create. "
                                           + "Try restarting the program.");
          }
          
          String returnString = "\n";
          
          String footmen = "Footmen: ";
          String siege = "Siege: ";
          String specialists = "Specialists: ";
          
          int numFootmen = 0;
          int numSiege = 0;
          int numSpecialist = 0;
          
          int powFootmen = 0;
          int powSiege = 0;
          int powSpecialist = 0;
                  
        
        for (ArmyMember member : army) {
            switch(member.getClassification()) {
                case "Footman":
                    numFootmen += 1;
                    powFootmen += member.getPower();
                    break;
                case "Siege":
                    numSiege += 1;
                    powSiege += member.getPower();
                    break;
                case "Specialist":
                    numSpecialist += 1;
                    powSpecialist += member.getPower();
                    break;
                case "Unique":
                    
                    break;
                    
            }
        }
        
        acquireTheArmy().setNumSoldiers(numFootmen + numSiege + numSpecialist);
        acquireTheArmy().setMilitaryPower(powFootmen + powSiege + powSpecialist);
        
        long totalNum = KingdomsAndGlory.getCurrentGame().getArmy().getNumSoldiers();
        int totalPow = KingdomsAndGlory.getCurrentGame().getArmy().getMilitaryPower();
        
        footmen += (numFootmen + "\n  Power: " + powFootmen);
        siege += (numSiege  + "\nPower: " + powSiege);
        specialists += (numSpecialist  + "\n      Power: " + powSpecialist);
        
        returnString += (footmen + "\n\n" + siege + "\n\n" + specialists + "\n\n" + "Total Army Size: "
                        + totalNum + "\nTotal Militray Power: " + totalPow + "\n");
        
        return returnString;
    }
    
    /*--------------------------------------------------------------------------
    * buy/sell methods
    *-------------------------------------------------------------------------*/
    public static void sellArmy(int numToDismiss, String type) {
        ArrayList<ArmyMember> members = acquireTheArmyMembers();
        ArrayList<ArmyMember> deleteCandidates = new ArrayList();
        
        for (ArmyMember member : members) {
            if(member.getClassification().equals(type)) {
                deleteCandidates.add(member);
            }
        }
        
        int i = 0;
        for (ArmyMember dismissed : deleteCandidates) {
            if (i >= numToDismiss) {
                return;
            }
            members.remove(dismissed);
            i++;
        }
    }
    
    public static void buyArmy(int numOfRecruits, int power, String type) {
        for(int i = 0; i < numOfRecruits; i++) {
            ArmyMember recruit = new ArmyMember(power, type);
            acquireTheArmyMembers().add(recruit);
        }
    }
    
    /*--------------------------------------------------------------------------
    * getter methods
    *-------------------------------------------------------------------------*/
    public static Army acquireTheArmy() {
        return KingdomsAndGlory.getCurrentGame().getArmy();
    }
    
    public static ArrayList<ArmyMember> acquireTheArmyMembers() {
        return acquireTheArmy().getArmyMembers();
    }
    
    public static int numberOf(String type) {
        ArrayList<ArmyMember> members = acquireTheArmy().getArmyMembers();
        int num = 0;
        
        for(ArmyMember member : members) {
            if(member.getClassification().equals(type)) {
                num += 1;
            }
        }
        return num;
    }
}
