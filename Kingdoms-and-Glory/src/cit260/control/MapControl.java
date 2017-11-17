/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.control;

import cit260.model.AttackScene;
import cit260.model.CapturedScene;
import cit260.model.Map;
import cit260.model.Territory;
import cit260.model.DefaultScene;
import cit260.model.ExamineCityScene;
import cit260.model.ExamineWildernesScene;
import cit260.model.Resource;
import cit260.model.SceneEnum;
import cit260.model.TerritoryEnum;

/**
 *
 * @author aaroncr-dkz
 */
public class MapControl {

    public static Map createMap(int numOfRows, int numOfColumns) {
        if (numOfRows < 0 || numOfColumns < 0) {
            return null;
        }
        
        //create the map object
        Map map = new Map();
        //save rows
        //save columns

        // create all the territories in the game
        Territory[][] locations = createLocations(numOfRows, numOfColumns);
        map.setTerritories(locations);
        
        // create the scenes and their resources. Then assign them to territories
        DefaultScene[] scenes = createScenes();
        assignScenesToLocations(map, scenes);
        
        return map;
    }
     
    private static Territory[][] createLocations(int numOfRows, int numOfColumns) {
        if (numOfRows < 0 || numOfColumns < 0) {
            return null;
        }
        
        Territory[][] locations = new Territory[numOfRows][numOfColumns];
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j <numOfColumns; j++) {
                Territory location = new Territory(i, j);
                locations[i][j] = location;
            }
        }
        return locations;
    }
    
    private static DefaultScene[] createScenes() {
           DefaultScene[] scenes = new DefaultScene[47];
           
           /*-------------------------------------------------------------------
           * Castle of Warren
           **-----------------------------------------------------------------*/
           DefaultScene CoW_Captured = new CapturedScene();
           scenes[SceneEnum.CoW_Captured.ordinal()] = CoW_Captured;
           
           /*-------------------------------------------------------------------
           * Borders of Sharom
           **-----------------------------------------------------------------*/
           DefaultScene BoS_Examine = new ExamineWildernesScene();
           Resource BoS = new Resource("Cloth", 2);
           BoS_Examine.setResource(BoS);
           scenes[SceneEnum.BoS_Examine.ordinal()] = BoS_Examine;
           
           /*-------------------------------------------------------------------
           * Sharom District
           **-----------------------------------------------------------------*/
           DefaultScene SD_Examine = new ExamineCityScene();
           DefaultScene SD_Attack = new AttackScene();
           DefaultScene SD_Captured = new CapturedScene();
           Resource SD = new Resource("Gold", 200);
           SD_Attack.setResource(SD);
           
           scenes[SceneEnum.SD_Examine.ordinal()] = SD_Examine;
           scenes[SceneEnum.SD_Attack.ordinal()] = SD_Attack;
           scenes[SceneEnum.SD_Captured.ordinal()] = SD_Captured;
           
           /*-------------------------------------------------------------------
           * Lake Jansenia
           **-----------------------------------------------------------------*/
           DefaultScene LJ_Examine = new ExamineWildernesScene();
           Resource LJ = new Resource("Wood", 2);
           LJ_Examine.setResource(LJ);
           scenes[SceneEnum.LJ_Examine.ordinal()] = LJ_Examine;

           /*-------------------------------------------------------------------
           * Pogrom Forest
           **-----------------------------------------------------------------*/
           DefaultScene PF_Examine = new ExamineWildernesScene();
           Resource PF = new Resource("Cloth", 2);
           PF_Examine.setResource(PF);
           scenes[SceneEnum.PF_Examine.ordinal()] = PF_Examine;
           
           /*-------------------------------------------------------------------
           * Deneb's Garden
           **-----------------------------------------------------------------*/
           DefaultScene DG_Examine = new ExamineWildernesScene();
           Resource DG = new Resource("Stone", 1);
           DG_Examine.setResource(DG);
           scenes[SceneEnum.DG_Examine.ordinal()] = DG_Examine;
           
           /*-------------------------------------------------------------------
           * Slums of Zenobia
           **-----------------------------------------------------------------*/
           DefaultScene SoZ_Examine = new ExamineCityScene();
           DefaultScene SoZ_Attack = new AttackScene();
           DefaultScene SoZ_Captured = new CapturedScene();
           Resource SoZ = new Resource("Gold", 300);
           SoZ_Attack.setResource(SoZ);
           
           scenes[SceneEnum.SoZ_Examine.ordinal()] = SoZ_Examine;
           scenes[SceneEnum.SoZ_Attack.ordinal()] = SoZ_Attack;
           scenes[SceneEnum.SoZ_Captured.ordinal()] = SoZ_Captured;
          
           /*-------------------------------------------------------------------
           * Island Avalon
           **-----------------------------------------------------------------*/
           DefaultScene IA_Examine = new ExamineWildernesScene();
           Resource IA = new Resource("Metal", 1);
           IA_Examine.setResource(IA);
           scenes[SceneEnum.IA_Examine.ordinal()] = IA_Examine;
           
           /*-------------------------------------------------------------------
           * Kalbi Peninsula
           **-----------------------------------------------------------------*/
           DefaultScene KP_Examine = new ExamineWildernesScene();
           Resource KP = new Resource("Stone", 2);
           KP_Examine.setResource(KP);
           scenes[SceneEnum.KP_Examine.ordinal()] = KP_Examine;
           
           /*-------------------------------------------------------------------
           * Kastolation Sea
           **-----------------------------------------------------------------*/
           DefaultScene KS_Examine = new ExamineWildernesScene();
           Resource KS = new Resource("Cloth", 4);
           KS_Examine.setResource(KS);
           scenes[SceneEnum.KS_Examine.ordinal()] = KS_Examine;
           
           /*-------------------------------------------------------------------
           * Diaspola
           **-----------------------------------------------------------------*/
           DefaultScene D_Examine = new ExamineCityScene();
           DefaultScene D_Attack = new AttackScene();
           DefaultScene D_Captured = new CapturedScene();
           Resource Dias = new Resource("Gold", 350);
           D_Attack.setResource(Dias);
           
           scenes[SceneEnum.D_Examine.ordinal()] = D_Examine;
           scenes[SceneEnum.D_Attack.ordinal()] = D_Attack;
           scenes[SceneEnum.D_Captured.ordinal()] = D_Captured;
          
           /*-------------------------------------------------------------------
           * Balmorian Ruins
           **-----------------------------------------------------------------*/
           DefaultScene BR_Examine = new ExamineWildernesScene();
           Resource BR = new Resource("Gold", 100);
           BR_Examine.setResource(BR);
           scenes[SceneEnum.BR_Examine.ordinal()] = BR_Examine;
           
           /*-------------------------------------------------------------------
           * Valley of Kastro
           **-----------------------------------------------------------------*/
           DefaultScene VoK_Examine = new ExamineWildernesScene();
           Resource VoK = new Resource("Wood", 5);
           VoK_Examine.setResource(VoK);      
           scenes[SceneEnum.VoK_Examine.ordinal()] = VoK_Examine;
           
           /*-------------------------------------------------------------------
           * City of Malano
           **-----------------------------------------------------------------*/
           DefaultScene CoM_Examine = new ExamineCityScene();
           DefaultScene CoM_Attack = new AttackScene();
           DefaultScene CoM_Captured = new CapturedScene();
           Resource CoM = new Resource("Gold", 400);
           CoM_Attack.setResource(CoM);
           
           scenes[SceneEnum.CoM_Examine.ordinal()] = CoM_Examine;
           scenes[SceneEnum.CoM_Attack.ordinal()] = CoM_Attack;
           scenes[SceneEnum.CoM_Captured.ordinal()] = CoM_Captured;
          
           /*-------------------------------------------------------------------
           * Anatalia
           **-----------------------------------------------------------------*/
           DefaultScene Ana_Examine = new ExamineCityScene();
           DefaultScene Ana_Attack = new AttackScene();
           DefaultScene Ana_Captured = new CapturedScene();
           Resource Ana = new Resource("Gold", 400);
           Ana_Attack.setResource(Ana);
           
           scenes[SceneEnum.Ana_Examine.ordinal()] = Ana_Examine;
           scenes[SceneEnum.Ana_Attack.ordinal()] = Ana_Attack;
           scenes[SceneEnum.Ana_Captured.ordinal()] = Ana_Captured;
          
           /*-------------------------------------------------------------------
           * Antanjyl
           **-----------------------------------------------------------------*/
           DefaultScene Ant_Examine = new ExamineCityScene();
           DefaultScene Ant_Attack = new AttackScene();
           DefaultScene Ant_Captured = new CapturedScene();
           Resource Ant = new Resource("Gold", 450);
           Ant_Attack.setResource(Ant);
           
           scenes[SceneEnum.Ant_Examine.ordinal()] = Ant_Examine;
           scenes[SceneEnum.Ant_Attack.ordinal()] = Ant_Attack;
           scenes[SceneEnum.Ant_Captured.ordinal()] = Ant_Captured;
          
           /*-------------------------------------------------------------------
           * The Tundra
           **-----------------------------------------------------------------*/
           DefaultScene TT_Examine = new ExamineWildernesScene();
           Resource TT = new Resource("Metal", 2);
           TT_Examine.setResource(TT);
           scenes[SceneEnum.TT_Examine.ordinal()] = TT_Examine;
          
           /*-------------------------------------------------------------------
           * Fort Allamoot
           **-----------------------------------------------------------------*/
           DefaultScene FA_Examine = new ExamineCityScene();
           DefaultScene FA_Attack = new AttackScene();
           DefaultScene FA_Captured = new CapturedScene();
           Resource FA = new Resource("Gold", 300);
           FA_Attack.setResource(FA);
          
           scenes[SceneEnum.FA_Examine.ordinal()] = FA_Examine;
           scenes[SceneEnum.FA_Attack.ordinal()] = FA_Attack;
           scenes[SceneEnum.FA_Captured.ordinal()] = FA_Captured;
           
           /*-------------------------------------------------------------------
           * Ryhean Sea
           **-----------------------------------------------------------------*/
           DefaultScene RS_Examine = new ExamineWildernesScene();
           Resource RS = new Resource("Stone", 2);
           RS_Examine.setResource(RS);
                      scenes[SceneEnum.RS_Examine.ordinal()] = RS_Examine;
           
           /*-------------------------------------------------------------------
           * Shrine of Kulyn
           **-----------------------------------------------------------------*/
           DefaultScene SoK_Examine = new ExamineWildernesScene();
           Resource SoK = new Resource("Metal", 1);
           SoK_Examine.setResource(SoK);
           scenes[SceneEnum.SoK_Examine.ordinal()] = SoK_Examine;
           
           /*-------------------------------------------------------------------
           * Dahlmud Desert
           **-----------------------------------------------------------------*/
           DefaultScene DD_Examine = new ExamineWildernesScene();
           Resource DD = new Resource("Stone", 1);
           DD_Examine.setResource(DD);
           scenes[SceneEnum.DD_Examine.ordinal()] = DD_Examine;
           
           /*-------------------------------------------------------------------
           * Fort Shulamana
           **-----------------------------------------------------------------*/
           DefaultScene FS_Examine = new ExamineCityScene();
           DefaultScene FS_Attack = new AttackScene();
           DefaultScene FS_Captured = new CapturedScene();
           Resource FS = new Resource("Gold", 500);
           FS_Attack.setResource(FS);
          
           scenes[SceneEnum.FS_Examine.ordinal()] = FS_Examine;
           scenes[SceneEnum.FS_Attack.ordinal()] = FS_Attack;
           scenes[SceneEnum.FS_Captured.ordinal()] = FS_Captured;
           
           /*-------------------------------------------------------------------
           * Xanadu
           **-----------------------------------------------------------------*/
           DefaultScene X_Examine = new ExamineCityScene();
           DefaultScene X_Attack = new AttackScene();
           DefaultScene X_Captured = new CapturedScene();
           Resource Xana = new Resource("Gold", 500);
           X_Attack.setResource(Xana);
           
           scenes[SceneEnum.X_Examine.ordinal()] = X_Examine;
           scenes[SceneEnum.X_Attack.ordinal()] = X_Attack;
           scenes[SceneEnum.X_Captured.ordinal()] = X_Captured;
          
           /*-------------------------------------------------------------------
           * Zeteginea
           **-----------------------------------------------------------------*/
           DefaultScene Z_Examine = new ExamineCityScene();
           DefaultScene Z_Attack = new AttackScene();
           DefaultScene Z_Captured = new CapturedScene();
           Resource Zete = new Resource("Gold", 750);
           Z_Attack.setResource(Zete);
           
           scenes[SceneEnum.Z_Examine.ordinal()] = Z_Examine;
           scenes[SceneEnum.Z_Attack.ordinal()] = Z_Attack;
           scenes[SceneEnum.Z_Captured.ordinal()] = Z_Captured;
          
           /*-------------------------------------------------------------------
           * Temple Shalina
           **-----------------------------------------------------------------*/
           DefaultScene TS_Examine = new ExamineCityScene();
           DefaultScene TS_Attack = new AttackScene();
           DefaultScene TS_Captured = new CapturedScene();
           Resource TS = new Resource("Gold", 1000000);
           TS_Attack.setResource(TS);
           
           scenes[SceneEnum.TS_Examine.ordinal()] = TS_Examine;
           scenes[SceneEnum.TS_Attack.ordinal()] = TS_Attack;
           scenes[SceneEnum.TS_Captured.ordinal()] = TS_Captured;

           return scenes;
    }
    
    private static void assignScenesToLocations(Map map, DefaultScene[] scenes) {
        Territory[][] locations = map.getTerritories();
        
        // create a holder for scenes
        DefaultScene[] toInsert = new DefaultScene[3];
        
        /*
        *Do the work
        */
        toInsert[0] = null;
        toInsert[1] = null;
        toInsert[2] = null;
        
        // Castle of Warren
        toInsert[0] = null;
        toInsert[1] = null;
        toInsert[2] = scenes[SceneEnum.CoW_Captured.ordinal()];
        locations[TerritoryEnum.Castle_of_Warren.getX()][TerritoryEnum.Castle_of_Warren.getY()].setScenes(scenes);
        
        // Borders of Sharom
        toInsert[0] = scenes[SceneEnum.BoS_Examine.ordinal()];
        toInsert[1] = null;
        toInsert[2] = null;
        locations[TerritoryEnum.Borders_of_Sharom.getX()][TerritoryEnum.Borders_of_Sharom.getY()].setScenes(scenes);
        
        // Sharom_District
        toInsert[0] = scenes[SceneEnum.SD_Examine.ordinal()];
        toInsert[1] = scenes[SceneEnum.SD_Attack.ordinal()];
        toInsert[2] = scenes[SceneEnum.SD_Captured.ordinal()];
        locations[TerritoryEnum.Sharom_District.getX()][TerritoryEnum.Sharom_District.getY()].setScenes(scenes);
        
        // Lake Jansenia
        toInsert[0] = scenes[SceneEnum.LJ_Examine.ordinal()];
        toInsert[1] = null;
        toInsert[2] = null;
        locations[TerritoryEnum.Lake_Jansenia.getX()][TerritoryEnum.Lake_Jansenia.getY()].setScenes(scenes);
        
        // Pogrom Forest
        toInsert[0] = scenes[SceneEnum.PF_Examine.ordinal()];
        toInsert[1] = null;
        toInsert[2] = null;
        locations[TerritoryEnum.Pogrom_Forest.getX()][TerritoryEnum.Pogrom_Forest.getY()].setScenes(scenes);
        
        // Deneb's Garden
        toInsert[0] = scenes[SceneEnum.DG_Examine.ordinal()];
        toInsert[1] = null;
        toInsert[2] = null;
        locations[TerritoryEnum.Denebs_Garden.getX()][TerritoryEnum.Denebs_Garden.getY()].setScenes(scenes);
        
        // Slums of Zenobia
        toInsert[0] = scenes[SceneEnum.SoZ_Examine.ordinal()];
        toInsert[1] = scenes[SceneEnum.SoZ_Attack.ordinal()];
        toInsert[2] = scenes[SceneEnum.SoZ_Captured.ordinal()];
        locations[TerritoryEnum.Slums_of_Zenobia.getX()][TerritoryEnum.Slums_of_Zenobia.getY()].setScenes(scenes);
        
        // Island Avalon
        toInsert[0] = scenes[SceneEnum.IA_Examine.ordinal()];
        toInsert[1] = null;
        toInsert[2] = null;
        locations[TerritoryEnum.Island_Avalon.getX()][TerritoryEnum.Island_Avalon.getY()].setScenes(scenes);
        
        // Kalbi Peninsula
        toInsert[0] = scenes[SceneEnum.KP_Examine.ordinal()];
        toInsert[1] = null;
        toInsert[2] = null;
        locations[TerritoryEnum.Kalbi_Peninsula.getX()][TerritoryEnum.Kalbi_Peninsula.getY()].setScenes(scenes);
        
        // Kastolation Sea
        toInsert[0] = scenes[SceneEnum.KS_Examine.ordinal()];
        toInsert[1] = null;
        toInsert[2] = null;
        locations[TerritoryEnum.Kastolation_Sea.getX()][TerritoryEnum.Kastolation_Sea.getY()].setScenes(scenes);
        
        // Diaspola
        toInsert[0] = scenes[SceneEnum.D_Examine.ordinal()];
        toInsert[1] = scenes[SceneEnum.D_Attack.ordinal()];
        toInsert[2] = scenes[SceneEnum.D_Captured.ordinal()];
        locations[TerritoryEnum.Diaspola.getX()][TerritoryEnum.Diaspola.getY()].setScenes(scenes);
        
        // Balmorian Ruins
        toInsert[0] = scenes[SceneEnum.BR_Examine.ordinal()];
        toInsert[1] = null;
        toInsert[2] = null;
        locations[TerritoryEnum.Balmorian_Ruins.getX()][TerritoryEnum.Balmorian_Ruins.getY()].setScenes(scenes);
        
        // Valley of Kastro
        toInsert[0] = scenes[SceneEnum.VoK_Examine.ordinal()];
        toInsert[1] = null;
        toInsert[2] = null;
        locations[TerritoryEnum.Valley_of_Kastro.getX()][TerritoryEnum.Valley_of_Kastro.getY()].setScenes(scenes);
        
        // City of Malano
        toInsert[0] = scenes[SceneEnum.CoM_Examine.ordinal()];
        toInsert[1] = scenes[SceneEnum.CoM_Attack.ordinal()];
        toInsert[2] = scenes[SceneEnum.CoM_Captured.ordinal()];
        locations[TerritoryEnum.City_of_Malano.getX()][TerritoryEnum.City_of_Malano.getY()].setScenes(scenes);
        
        // Anatalia
        toInsert[0] = scenes[SceneEnum.Ana_Examine.ordinal()];
        toInsert[1] = scenes[SceneEnum.Ana_Attack.ordinal()];
        toInsert[2] = scenes[SceneEnum.Ana_Captured.ordinal()];
        locations[TerritoryEnum.Anatalia.getX()][TerritoryEnum.Anatalia.getY()].setScenes(scenes);
        
        // Antanjyl
        toInsert[0] = scenes[SceneEnum.Ant_Examine.ordinal()];
        toInsert[1] = scenes[SceneEnum.Ant_Attack.ordinal()];
        toInsert[2] = scenes[SceneEnum.Ant_Captured.ordinal()];
        locations[TerritoryEnum.Antanjyl.getX()][TerritoryEnum.Antanjyl.getY()].setScenes(scenes);
        
        // The Tundra
        toInsert[0] = scenes[SceneEnum.TT_Examine.ordinal()];
        toInsert[1] = null;
        toInsert[2] = null;
        locations[TerritoryEnum.The_Tundra.getX()][TerritoryEnum.The_Tundra.getY()].setScenes(scenes);
        
        // Fort Allamoot
        toInsert[0] = scenes[SceneEnum.FA_Examine.ordinal()];
        toInsert[1] = scenes[SceneEnum.FA_Attack.ordinal()];
        toInsert[2] = scenes[SceneEnum.FA_Captured.ordinal()];
        locations[TerritoryEnum.Fort_Allamoot.getX()][TerritoryEnum.Fort_Allamoot.getY()].setScenes(scenes);
        
        // Ryhean Sea
        toInsert[0] = scenes[SceneEnum.RS_Examine.ordinal()];
        toInsert[1] = null;
        toInsert[2] = null;
        locations[TerritoryEnum.Ryhean_Sea.getX()][TerritoryEnum.Ryhean_Sea.getY()].setScenes(scenes);
        
        // Shrine of Kulyn
        toInsert[0] = scenes[SceneEnum.SoK_Examine.ordinal()];
        toInsert[1] = null;
        toInsert[2] = null;
        locations[TerritoryEnum.Shrine_of_Kulyn.getX()][TerritoryEnum.Shrine_of_Kulyn.getY()].setScenes(scenes);
        
        // Dahlmud Desert
        toInsert[0] = scenes[SceneEnum.DD_Examine.ordinal()];
        toInsert[1] = null;
        toInsert[2] = null;
        locations[TerritoryEnum.Dahlmud_Desert.getX()][TerritoryEnum.Dahlmud_Desert.getY()].setScenes(scenes);
        
        // Fort Shulamana
        toInsert[0] = scenes[SceneEnum.D_Examine.ordinal()];
        toInsert[1] = scenes[SceneEnum.D_Attack.ordinal()];
        toInsert[2] = scenes[SceneEnum.D_Captured.ordinal()];
        locations[TerritoryEnum.Diaspola.getX()][TerritoryEnum.Diaspola.getY()].setScenes(scenes);
        
        // Xanadu
        toInsert[0] = scenes[SceneEnum.X_Examine.ordinal()];
        toInsert[1] = scenes[SceneEnum.X_Attack.ordinal()];
        toInsert[2] = scenes[SceneEnum.X_Captured.ordinal()];
        locations[TerritoryEnum.Xanadu.getX()][TerritoryEnum.Xanadu.getY()].setScenes(scenes);
        
        // Zeteginea
        toInsert[0] = scenes[SceneEnum.Z_Examine.ordinal()];
        toInsert[1] = scenes[SceneEnum.Z_Attack.ordinal()];
        toInsert[2] = scenes[SceneEnum.Z_Captured.ordinal()];
        locations[TerritoryEnum.Zeteginea.getX()][TerritoryEnum.Zeteginea.getY()].setScenes(scenes);
        
        // Temple Shalina
        toInsert[0] = scenes[SceneEnum.TS_Examine.ordinal()];
        toInsert[1] = scenes[SceneEnum.TS_Attack.ordinal()];
        toInsert[2] = scenes[SceneEnum.TS_Captured.ordinal()];
        locations[TerritoryEnum.Temple_Shalina.getX()][TerritoryEnum.Temple_Shalina.getY()].setScenes(scenes);
        
    }
    
    public static int determineExploreResult(int charisma, int diplomacy, Boolean isGood, int randAmount) {

        if (charisma < 0 || diplomacy < 0) {
            return -100;
        } 
        else if (charisma > 6 || diplomacy > 6) {
            return -100;
        } 
        else if (randAmount < 20 || randAmount > 50) {
            return -100;
        }

        int finalAmount = 0;

        if (isGood) {
            finalAmount = randAmount + (charisma * 2);
        } 
        else {
            finalAmount = (randAmount * -1) + (diplomacy * 3);
        }

        return finalAmount;
    }
    
    public static String determineWinOrLose(int leaderValue, int armyValue, int resourceBonus, int cityValue, int enemyLeaderValue, int enemyResourceBonus) {
        
        if (leaderValue > 5 || leaderValue < 1) {

            return "error";
        }
        else if (armyValue > 10 || armyValue < 1) {
	
            return "error";
        }

        else if (resourceBonus > 1 || resourceBonus < 0) {
            
            return "error";
        }   

        else if (cityValue > 10 || cityValue < 1) {
	
            return "error";
        }
        

        else if (enemyLeaderValue > 5 || enemyLeaderValue < 1) {

            return "error";
        
        }
        
        int attackValue = (leaderValue + armyValue) + (resourceBonus); 
        int cityDefenseValue = (cityValue + enemyLeaderValue) + (enemyResourceBonus);

        if (attackValue > cityDefenseValue) {
            
            return "Win";
        }
        else {

            return "Lose";
        }
    }
}
