/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.control;

import cit260.exception.GameControlException;
import cit260.model.Resource;
import cit260.model.ResourceEnum;
import java.util.ArrayList;
import kingdoms.and.glory.KingdomsAndGlory;

/**
 *
 * @author aaroncr-dkz
 */
public class ResourceControl {
    
    public static String retriveResourceData() throws GameControlException 
    {
        ArrayList<Resource> resource = KingdomsAndGlory.getCurrentGame().getResources();
        if (resource == null) {
              throw new GameControlException("An object failed to create. "
                                           + "Try restarting the program.");
          }
        
        String cloth = "Cloth: ";
        String wood = "Wood: ";
        String stone = "Stone: ";
        String metal = "Metal: ";
        String gold = "Gold: ";
        
        int numCloth = getResourceValue(ResourceEnum.Cloth.ordinal());
        int numWood = getResourceValue(ResourceEnum.Wood.ordinal());
        int numStone = getResourceValue(ResourceEnum.Stone.ordinal());
        int numMetal = getResourceValue(ResourceEnum.Metal.ordinal());
        int numGold = getResourceValue(ResourceEnum.Gold.ordinal());
         
        cloth += (": " + numCloth);
        wood += (": " + numWood);
        stone += (": " + numStone);
        metal += (": " + numMetal);
        gold += (": " + numGold);
         
        String returnString = (cloth + "\n" + wood + "\n" + stone + "\n" + metal + "\n" + gold);
         
        return returnString;
    }
    
    /*--------------------------------------------------------------------------
    * modify resource method shortcuts
    --------------------------------------------------------------------------*/
    public static void modifyResource(int amount, int type) {
        KingdomsAndGlory.getCurrentGame().getResources().get(type).modifyAmount(amount);
    }
    
    public static int getResourceValue(int type) {
        return KingdomsAndGlory.getCurrentGame().getResources().get(type).getAmount();
    }
    
    /*--------------------------------------------------------------------------
    * getter methods
    *-------------------------------------------------------------------------*/
    public static ArrayList<Resource> acquireResourceArray() {
        return KingdomsAndGlory.getCurrentGame().getResources();
    }
}
