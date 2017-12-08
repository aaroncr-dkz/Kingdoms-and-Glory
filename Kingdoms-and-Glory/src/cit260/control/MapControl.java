/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.control;

import cit260.exception.MapControlException;
import cit260.model.Actor;
import cit260.model.AttackScene;
import cit260.model.CapturedScene;
import cit260.model.Map;
import cit260.model.Territory;
import cit260.model.DefaultScene;
import cit260.model.ExamineCityScene;
import cit260.model.ExamineWildernesScene;
import cit260.model.Game;
import cit260.model.Resource;
import cit260.model.SceneEnum;
import cit260.model.TerritoryEnum;
import java.util.Random;
import kingdoms.and.glory.KingdomsAndGlory;

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

        // set the names for each location
        setLocationNames(locations);
        
        // set the symbols for each location
        setLocationSymbols(locations);

        // set the locations to the map
        map.setTerritories(locations);

        // create the scenes and their resources. Then assign them to territories
        createAndAssignScenes(map);

        return map;
    }
    
    public static void movePlayerActor(Actor actor, int newRow, int newColumn) throws MapControlException {
        if(actor == null) {
            throw new MapControlException("That actor does not exist. Try moving a differnt actor");
        }
        
        if (newRow < 0 || newRow > 4 || newColumn < 0 || newColumn > 4) {
            throw new MapControlException("Selected destination is out of bounds.");
        }
        
        Game game = KingdomsAndGlory.getCurrentGame();
        Map map = game.getMap();
        Territory[][] locations = map.getTerritories();
        
        int currentRow = acquirePlayerCurrentRow();
        int currentColumn = acquirePlayerCurrentColumn();
        Territory oldLocation = locations[currentRow][currentColumn];
        
        Territory newLocation = locations[newRow][newColumn];
        
        actor.setLocation(newLocation);
        
        // go through the process of moving into a new territory
        if(newLocation.getVisited() != true) {
            
            // we cannot move into a city we haven't conquered
            if(newLocation.getSceneAttack() != null) {
                actor.setLocation(oldLocation);
                throw new MapControlException("You must attack an enemy controlled territory before you can move into it\n");
            }
            
            // we have entered a wilderness
            else {
                Random rand = new Random();
                int  n = rand.nextInt(30) + 20; // random number from 20 to 50
                
                int result = determineExploreResult(2, 2, true, n);
                newLocation.setVisited(true);
            }
            
        }
        
        
        //DefaultScene scene = newLocation.getScenes()[0];
        
        //return scene;
    }

    public static int determineExploreResult(int charisma, int diplomacy, Boolean isGood, int randAmount) {

        if (charisma < 0 || diplomacy < 0) {
            return -100;
        } else if (charisma > 6 || diplomacy > 6) {
            return -100;
        } else if (randAmount < 20 || randAmount > 50) {
            return -100;
        }

        int finalAmount = 0;

        if (isGood) {
            finalAmount = randAmount + (charisma * 2);
        } else {
            finalAmount = (randAmount * -1) + (diplomacy * 3);
        }

        return finalAmount;
    }

    public static String determineWinOrLose(int leaderValue, int armyValue, int resourceBonus, int cityValue, int enemyLeaderValue, int enemyResourceBonus) {

        if (leaderValue > 5 || leaderValue < 1) {

            return "error";
        } else if (armyValue > 10 || armyValue < 1) {

            return "error";
        } else if (resourceBonus > 1 || resourceBonus < 0) {

            return "error";
        } else if (cityValue > 10 || cityValue < 1) {

            return "error";
        } else if (enemyLeaderValue > 5 || enemyLeaderValue < 1) {

            return "error";

        }

        int attackValue = (leaderValue + armyValue) + (resourceBonus);
        int cityDefenseValue = (cityValue + enemyLeaderValue) + (enemyResourceBonus);

        if (attackValue > cityDefenseValue) {

            return "Win";
        } else {

            return "Lose";
        }
    }

    /*--------------------------------------------------------------------------
    * getter methods
    *-------------------------------------------------------------------------*/
    public static int acquirePlayerCurrentRow() {
        return KingdomsAndGlory.getPlayer().getPlayerCharacter().getLocation().getRow();
    }

    public static int acquirePlayerCurrentColumn() {
        return KingdomsAndGlory.getPlayer().getPlayerCharacter().getLocation().getColumn();
    }

    public static Territory[][] acquireGameTerritories() {
        return KingdomsAndGlory.getCurrentGame().getMap().getTerritories();
    }

    /*--------------------------------------------------------------------------
    * helper methods for CreateMap
    *-------------------------------------------------------------------------*/
    private static Territory[][] createLocations(int numOfRows, int numOfColumns) {
        if (numOfRows < 0 || numOfColumns < 0) {
            return null;
        }

        Territory[][] locations = new Territory[numOfRows][numOfColumns];
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfColumns; j++) {
                Territory location = new Territory(i, j);
                locations[i][j] = location;
            }
        }

        // alter the beginning territory's visited state
        locations[TerritoryEnum.Castle_of_Warren.getX()][TerritoryEnum.Castle_of_Warren.getY()].setVisited(true);

        return locations;
    }
    
    private static void setLocationNames(Territory[][] locations) {
        locations[TerritoryEnum.Castle_of_Warren.getX()][TerritoryEnum.Castle_of_Warren.getY()].setName(TerritoryEnum.Castle_of_Warren.getName());
        locations[TerritoryEnum.Borders_of_Sharom.getX()][TerritoryEnum.Borders_of_Sharom.getY()].setName(TerritoryEnum.Borders_of_Sharom.getName());
        locations[TerritoryEnum.Sharom_District.getX()][TerritoryEnum.Sharom_District.getY()].setName(TerritoryEnum.Sharom_District.getName());
        locations[TerritoryEnum.Lake_Jansenia.getX()][TerritoryEnum.Lake_Jansenia.getY()].setName(TerritoryEnum.Lake_Jansenia.getName());
        locations[TerritoryEnum.Pogrom_Forest.getX()][TerritoryEnum.Pogrom_Forest.getY()].setName(TerritoryEnum.Pogrom_Forest.getName());
        locations[TerritoryEnum.Denebs_Garden.getX()][TerritoryEnum.Denebs_Garden.getY()].setName(TerritoryEnum.Denebs_Garden.getName());
        locations[TerritoryEnum.Slums_of_Zenobia.getX()][TerritoryEnum.Slums_of_Zenobia.getY()].setName(TerritoryEnum.Slums_of_Zenobia.getName());
        locations[TerritoryEnum.Island_Avalon.getX()][TerritoryEnum.Island_Avalon.getY()].setName(TerritoryEnum.Island_Avalon.getName());
        locations[TerritoryEnum.Kalbi_Peninsula.getX()][TerritoryEnum.Kalbi_Peninsula.getY()].setName(TerritoryEnum.Kalbi_Peninsula.getName());
        locations[TerritoryEnum.Kastolation_Sea.getX()][TerritoryEnum.Kastolation_Sea.getY()].setName(TerritoryEnum.Kastolation_Sea.getName());
        locations[TerritoryEnum.Diaspola.getX()][TerritoryEnum.Diaspola.getY()].setName(TerritoryEnum.Diaspola.getName());
        locations[TerritoryEnum.Balmorian_Ruins.getX()][TerritoryEnum.Balmorian_Ruins.getY()].setName(TerritoryEnum.Balmorian_Ruins.getName());
        locations[TerritoryEnum.Valley_of_Kastro.getX()][TerritoryEnum.Valley_of_Kastro.getY()].setName(TerritoryEnum.Valley_of_Kastro.getName());
        locations[TerritoryEnum.City_of_Malano.getX()][TerritoryEnum.City_of_Malano.getY()].setName(TerritoryEnum.City_of_Malano.getName());
        locations[TerritoryEnum.Anatalia.getX()][TerritoryEnum.Anatalia.getY()].setName(TerritoryEnum.Anatalia.getName());
        locations[TerritoryEnum.Antanjyl.getX()][TerritoryEnum.Antanjyl.getY()].setName(TerritoryEnum.Antanjyl.getName());
        locations[TerritoryEnum.The_Tundra.getX()][TerritoryEnum.The_Tundra.getY()].setName(TerritoryEnum.The_Tundra.getName());
        locations[TerritoryEnum.Fort_Allamoot.getX()][TerritoryEnum.Fort_Allamoot.getY()].setName(TerritoryEnum.Fort_Allamoot.getName());
        locations[TerritoryEnum.Ryhean_Sea.getX()][TerritoryEnum.Ryhean_Sea.getY()].setName(TerritoryEnum.Ryhean_Sea.getName());
        locations[TerritoryEnum.Shrine_of_Kulyn.getX()][TerritoryEnum.Shrine_of_Kulyn.getY()].setName(TerritoryEnum.Shrine_of_Kulyn.getName());
        locations[TerritoryEnum.Dahlmud_Desert.getX()][TerritoryEnum.Dahlmud_Desert.getY()].setName(TerritoryEnum.Dahlmud_Desert.getName());
        locations[TerritoryEnum.Fort_Shulamana.getX()][TerritoryEnum.Fort_Shulamana.getY()].setName(TerritoryEnum.Fort_Shulamana.getName());
        locations[TerritoryEnum.Xanadu.getX()][TerritoryEnum.Xanadu.getY()].setName(TerritoryEnum.Xanadu.getName());
        locations[TerritoryEnum.Zeteginea.getX()][TerritoryEnum.Zeteginea.getY()].setName(TerritoryEnum.Zeteginea.getName());
        locations[TerritoryEnum.Temple_Shalina.getX()][TerritoryEnum.Temple_Shalina.getY()].setName(TerritoryEnum.Temple_Shalina.getName());
    }

    private static void setLocationSymbols(Territory[][] locations) {
        locations[TerritoryEnum.Castle_of_Warren.getX()][TerritoryEnum.Castle_of_Warren.getY()].setSymbol(TerritoryEnum.Castle_of_Warren.getSymbol());
        locations[TerritoryEnum.Borders_of_Sharom.getX()][TerritoryEnum.Borders_of_Sharom.getY()].setSymbol(TerritoryEnum.Borders_of_Sharom.getSymbol());
        locations[TerritoryEnum.Sharom_District.getX()][TerritoryEnum.Sharom_District.getY()].setSymbol(TerritoryEnum.Sharom_District.getSymbol());
        locations[TerritoryEnum.Lake_Jansenia.getX()][TerritoryEnum.Lake_Jansenia.getY()].setSymbol(TerritoryEnum.Lake_Jansenia.getSymbol());
        locations[TerritoryEnum.Pogrom_Forest.getX()][TerritoryEnum.Pogrom_Forest.getY()].setSymbol(TerritoryEnum.Pogrom_Forest.getSymbol());
        locations[TerritoryEnum.Denebs_Garden.getX()][TerritoryEnum.Denebs_Garden.getY()].setSymbol(TerritoryEnum.Denebs_Garden.getSymbol());
        locations[TerritoryEnum.Slums_of_Zenobia.getX()][TerritoryEnum.Slums_of_Zenobia.getY()].setSymbol(TerritoryEnum.Slums_of_Zenobia.getSymbol());
        locations[TerritoryEnum.Island_Avalon.getX()][TerritoryEnum.Island_Avalon.getY()].setSymbol(TerritoryEnum.Island_Avalon.getSymbol());
        locations[TerritoryEnum.Kalbi_Peninsula.getX()][TerritoryEnum.Kalbi_Peninsula.getY()].setSymbol(TerritoryEnum.Kalbi_Peninsula.getSymbol());
        locations[TerritoryEnum.Kastolation_Sea.getX()][TerritoryEnum.Kastolation_Sea.getY()].setSymbol(TerritoryEnum.Kastolation_Sea.getSymbol());
        locations[TerritoryEnum.Diaspola.getX()][TerritoryEnum.Diaspola.getY()].setSymbol(TerritoryEnum.Diaspola.getSymbol());
        locations[TerritoryEnum.Balmorian_Ruins.getX()][TerritoryEnum.Balmorian_Ruins.getY()].setSymbol(TerritoryEnum.Balmorian_Ruins.getSymbol());
        locations[TerritoryEnum.Valley_of_Kastro.getX()][TerritoryEnum.Valley_of_Kastro.getY()].setSymbol(TerritoryEnum.Valley_of_Kastro.getSymbol());
        locations[TerritoryEnum.City_of_Malano.getX()][TerritoryEnum.City_of_Malano.getY()].setSymbol(TerritoryEnum.City_of_Malano.getSymbol());
        locations[TerritoryEnum.Anatalia.getX()][TerritoryEnum.Anatalia.getY()].setSymbol(TerritoryEnum.Anatalia.getSymbol());
        locations[TerritoryEnum.Antanjyl.getX()][TerritoryEnum.Antanjyl.getY()].setSymbol(TerritoryEnum.Antanjyl.getSymbol());
        locations[TerritoryEnum.The_Tundra.getX()][TerritoryEnum.The_Tundra.getY()].setSymbol(TerritoryEnum.The_Tundra.getSymbol());
        locations[TerritoryEnum.Fort_Allamoot.getX()][TerritoryEnum.Fort_Allamoot.getY()].setSymbol(TerritoryEnum.Fort_Allamoot.getSymbol());
        locations[TerritoryEnum.Ryhean_Sea.getX()][TerritoryEnum.Ryhean_Sea.getY()].setSymbol(TerritoryEnum.Ryhean_Sea.getSymbol());
        locations[TerritoryEnum.Shrine_of_Kulyn.getX()][TerritoryEnum.Shrine_of_Kulyn.getY()].setSymbol(TerritoryEnum.Shrine_of_Kulyn.getSymbol());
        locations[TerritoryEnum.Dahlmud_Desert.getX()][TerritoryEnum.Dahlmud_Desert.getY()].setSymbol(TerritoryEnum.Dahlmud_Desert.getSymbol());
        locations[TerritoryEnum.Fort_Shulamana.getX()][TerritoryEnum.Fort_Shulamana.getY()].setSymbol(TerritoryEnum.Fort_Shulamana.getSymbol());
        locations[TerritoryEnum.Xanadu.getX()][TerritoryEnum.Xanadu.getY()].setSymbol(TerritoryEnum.Xanadu.getSymbol());
        locations[TerritoryEnum.Zeteginea.getX()][TerritoryEnum.Zeteginea.getY()].setSymbol(TerritoryEnum.Zeteginea.getSymbol());
        locations[TerritoryEnum.Temple_Shalina.getX()][TerritoryEnum.Temple_Shalina.getY()].setSymbol(TerritoryEnum.Temple_Shalina.getSymbol());
    }

    private static void createAndAssignScenes(Map map) {
        Territory[][] locations = map.getTerritories();

        /*----------------------------------------------------------------------
        * Castle of Warren
        **--------------------------------------------------------------------*/
        ExamineCityScene CoW_Examine = new ExamineCityScene();
        
        CapturedScene CoW_Captured = new CapturedScene();
        CoW_Captured.setDescription("The Castle of the Seer Warren Moon.");
        
        locations[TerritoryEnum.Castle_of_Warren.getX()][TerritoryEnum.Castle_of_Warren.getY()].setSceneExamineWilderness(null);
        locations[TerritoryEnum.Castle_of_Warren.getX()][TerritoryEnum.Castle_of_Warren.getY()].setSceneExamineCity(CoW_Examine);
        locations[TerritoryEnum.Castle_of_Warren.getX()][TerritoryEnum.Castle_of_Warren.getY()].setSceneAttack(null);
        locations[TerritoryEnum.Castle_of_Warren.getX()][TerritoryEnum.Castle_of_Warren.getY()].setSceneCaptured(CoW_Captured);

        /*----------------------------------------------------------------------
        * Borders of Sharom
        **--------------------------------------------------------------------*/
        ExamineWildernesScene BoS_Examine = new ExamineWildernesScene();
        Resource BoS = new Resource("Cloth", 2);

        BoS_Examine.setResource(BoS);
        BoS_Examine.setDescription("The borders of the Sharom District.");
        
        locations[TerritoryEnum.Borders_of_Sharom.getX()][TerritoryEnum.Borders_of_Sharom.getY()].setSceneExamineWilderness(BoS_Examine);
        locations[TerritoryEnum.Borders_of_Sharom.getX()][TerritoryEnum.Borders_of_Sharom.getY()].setSceneExamineCity(null);
        locations[TerritoryEnum.Borders_of_Sharom.getX()][TerritoryEnum.Borders_of_Sharom.getY()].setSceneAttack(null);
        locations[TerritoryEnum.Borders_of_Sharom.getX()][TerritoryEnum.Borders_of_Sharom.getY()].setSceneCaptured(null);

        /*----------------------------------------------------------------------
        * Sharom District
        **--------------------------------------------------------------------*/
        ExamineCityScene SD_Examine = new ExamineCityScene();
        AttackScene SD_Attack = new AttackScene();
        CapturedScene SD_Captured = new CapturedScene();

        Resource SD = new Resource("Gold", 200);
        SD_Attack.setResource(SD);
        SD_Examine.setDescription("The Independent District of Sharom.");
        SD_Examine.setEstimatedOpposition(50);
        SD_Examine.setResourcesNeeded("Stone");
        
        locations[TerritoryEnum.Sharom_District.getX()][TerritoryEnum.Sharom_District.getY()].setSceneExamineWilderness(null);
        locations[TerritoryEnum.Sharom_District.getX()][TerritoryEnum.Sharom_District.getY()].setSceneExamineCity(SD_Examine);
        locations[TerritoryEnum.Sharom_District.getX()][TerritoryEnum.Sharom_District.getY()].setSceneAttack(SD_Attack);
        locations[TerritoryEnum.Sharom_District.getX()][TerritoryEnum.Sharom_District.getY()].setSceneCaptured(SD_Captured);
        
        /*----------------------------------------------------------------------
        * Lake Jansenia
        **--------------------------------------------------------------------*/
        ExamineWildernesScene LJ_Examine = new ExamineWildernesScene();
        Resource LJ = new Resource("Wood", 2);

        LJ_Examine.setResource(LJ);
        LJ_Examine.setDescription("Beautiful lake country where the Zenobian"
                + " nobality once vacationed.");

        locations[TerritoryEnum.Lake_Jansenia.getX()][TerritoryEnum.Lake_Jansenia.getY()].setSceneExamineWilderness(LJ_Examine);
        locations[TerritoryEnum.Lake_Jansenia.getX()][TerritoryEnum.Lake_Jansenia.getY()].setSceneExamineCity(null);
        locations[TerritoryEnum.Lake_Jansenia.getX()][TerritoryEnum.Lake_Jansenia.getY()].setSceneAttack(null);
        locations[TerritoryEnum.Lake_Jansenia.getX()][TerritoryEnum.Lake_Jansenia.getY()].setSceneCaptured(null);

        /*----------------------------------------------------------------------
        * Pogrom Forest
        **--------------------------------------------------------------------*/
        ExamineWildernesScene PF_Examine = new ExamineWildernesScene();

        Resource PF = new Resource("Cloth", 2);
        PF_Examine.setResource(PF);
        PF_Examine.setDescription("This old forest is filled with the lost "
                + "souls of those who were killed here.");
        
        locations[TerritoryEnum.Pogrom_Forest.getX()][TerritoryEnum.Pogrom_Forest.getY()].setSceneExamineWilderness(PF_Examine);
        locations[TerritoryEnum.Pogrom_Forest.getX()][TerritoryEnum.Pogrom_Forest.getY()].setSceneExamineCity(null);
        locations[TerritoryEnum.Pogrom_Forest.getX()][TerritoryEnum.Pogrom_Forest.getY()].setSceneAttack(null);
        locations[TerritoryEnum.Pogrom_Forest.getX()][TerritoryEnum.Pogrom_Forest.getY()].setSceneCaptured(null);

        /*----------------------------------------------------------------------
        * Deneb's Garden
        **--------------------------------------------------------------------*/
        ExamineWildernesScene DG_Examine = new ExamineWildernesScene();
        Resource DG = new Resource("Stone", 1);

        DG_Examine.setResource(DG);
        DG_Examine.setDescription("Region watched over by the beutiful witch"
                + " Deneb.");
        
        locations[TerritoryEnum.Denebs_Garden.getX()][TerritoryEnum.Denebs_Garden.getY()].setSceneExamineWilderness(DG_Examine);
        locations[TerritoryEnum.Denebs_Garden.getX()][TerritoryEnum.Denebs_Garden.getY()].setSceneExamineCity(null);
        locations[TerritoryEnum.Denebs_Garden.getX()][TerritoryEnum.Denebs_Garden.getY()].setSceneAttack(null);
        locations[TerritoryEnum.Denebs_Garden.getX()][TerritoryEnum.Denebs_Garden.getY()].setSceneCaptured(null);

        /*----------------------------------------------------------------------
        * Slums of Zenobia
        **--------------------------------------------------------------------*/
        ExamineCityScene SoZ_Examine = new ExamineCityScene();
        AttackScene SoZ_Attack = new AttackScene();
        CapturedScene SoZ_Captured = new CapturedScene();
        
        Resource SoZ = new Resource("Gold", 300);
        SoZ_Attack.setResource(SoZ);
        SoZ_Examine.setDescription("The old capital of Zenobia. The city has quickly " + 
                                   "fallen into decay and is now a shadow of its " + 
                                   "former glory");
        
        locations[TerritoryEnum.Slums_of_Zenobia.getX()][TerritoryEnum.Slums_of_Zenobia.getY()].setSceneExamineWilderness(null);
        locations[TerritoryEnum.Slums_of_Zenobia.getX()][TerritoryEnum.Slums_of_Zenobia.getY()].setSceneExamineCity(SoZ_Examine);
        locations[TerritoryEnum.Slums_of_Zenobia.getX()][TerritoryEnum.Slums_of_Zenobia.getY()].setSceneAttack(SoZ_Attack);
        locations[TerritoryEnum.Slums_of_Zenobia.getX()][TerritoryEnum.Slums_of_Zenobia.getY()].setSceneCaptured(SoZ_Captured);

        /*----------------------------------------------------------------------
        * Island Avalon
        **--------------------------------------------------------------------*/
        ExamineWildernesScene IA_Examine = new ExamineWildernesScene();
        Resource IA = new Resource("Metal", 1);
        
        IA_Examine.setResource(IA);
        IA_Examine.setDescription("Neutral island inhabited by monks and priests " + 
                                  "of the Church of Roshfel");
        
        locations[TerritoryEnum.Island_Avalon.getX()][TerritoryEnum.Island_Avalon.getY()].setSceneExamineWilderness(IA_Examine);
        locations[TerritoryEnum.Island_Avalon.getX()][TerritoryEnum.Island_Avalon.getY()].setSceneExamineWilderness(null);
        locations[TerritoryEnum.Island_Avalon.getX()][TerritoryEnum.Island_Avalon.getY()].setSceneExamineWilderness(null);
        locations[TerritoryEnum.Island_Avalon.getX()][TerritoryEnum.Island_Avalon.getY()].setSceneExamineWilderness(null);

        /*----------------------------------------------------------------------
        * Kalbi Peninsula
        **--------------------------------------------------------------------*/
        ExamineWildernesScene KP_Examine = new ExamineWildernesScene();
        Resource KP = new Resource("Stone", 2);
        
        KP_Examine.setResource(KP);
        KP_Examine.setDescription("This peninsula has been eternally locked in an " + 
                                  "endless winter");
        
        locations[TerritoryEnum.Kalbi_Peninsula.getX()][TerritoryEnum.Kalbi_Peninsula.getY()].setSceneExamineWilderness(KP_Examine);
        locations[TerritoryEnum.Kalbi_Peninsula.getX()][TerritoryEnum.Kalbi_Peninsula.getY()].setSceneExamineCity(null);
        locations[TerritoryEnum.Kalbi_Peninsula.getX()][TerritoryEnum.Kalbi_Peninsula.getY()].setSceneAttack(null);
        locations[TerritoryEnum.Kalbi_Peninsula.getX()][TerritoryEnum.Kalbi_Peninsula.getY()].setSceneCaptured(null);

        /*----------------------------------------------------------------------
        * Kastolation Sea
        **--------------------------------------------------------------------*/
        ExamineWildernesScene KS_Examine = new ExamineWildernesScene();
        Resource KS = new Resource("Cloth", 4);
        
        KS_Examine.setResource(KS);
        KS_Examine.setDescription("This sea is home to many mermaids");
        
        locations[TerritoryEnum.Kastolation_Sea.getX()][TerritoryEnum.Kastolation_Sea.getY()].setSceneExamineWilderness(KS_Examine);
        locations[TerritoryEnum.Kastolation_Sea.getX()][TerritoryEnum.Kastolation_Sea.getY()].setSceneExamineCity(null);
        locations[TerritoryEnum.Kastolation_Sea.getX()][TerritoryEnum.Kastolation_Sea.getY()].setSceneAttack(null);
        locations[TerritoryEnum.Kastolation_Sea.getX()][TerritoryEnum.Kastolation_Sea.getY()].setSceneCaptured(null);

        /*----------------------------------------------------------------------
        * Diaspola
        **--------------------------------------------------------------------*/
        ExamineCityScene D_Examine = new ExamineCityScene();
        AttackScene D_Attack = new AttackScene();
        CapturedScene D_Captured = new CapturedScene();
        
        Resource Dias = new Resource("Gold", 350);
        D_Attack.setResource(Dias);
        D_Examine.setDescription("Political dissidents and other criminals were " + 
                                 "sentenced here for life in prison. Many innocent " + 
                                 "of any crime");
        
        locations[TerritoryEnum.Diaspola.getX()][TerritoryEnum.Diaspola.getY()].setSceneExamineWilderness(null);
        locations[TerritoryEnum.Diaspola.getX()][TerritoryEnum.Diaspola.getY()].setSceneExamineCity(D_Examine);
        locations[TerritoryEnum.Diaspola.getX()][TerritoryEnum.Diaspola.getY()].setSceneAttack(D_Attack);
        locations[TerritoryEnum.Diaspola.getX()][TerritoryEnum.Diaspola.getY()].setSceneCaptured(D_Captured);

        /*----------------------------------------------------------------------
        * Balmorian Ruins
        **--------------------------------------------------------------------*/
        ExamineWildernesScene BR_Examine = new ExamineWildernesScene();
        Resource BR = new Resource("Gold", 100);
        
        BR_Examine.setResource(BR);
        BR_Examine.setDescription("Ruins of an ancient civilization dot this family. " + 
                                  " Wizards frequent this place in a quest to find " +
                                  "great secrets of magic.");
        
        locations[TerritoryEnum.Balmorian_Ruins.getX()][TerritoryEnum.Balmorian_Ruins.getY()].setSceneExamineWilderness(BR_Examine);
        locations[TerritoryEnum.Balmorian_Ruins.getX()][TerritoryEnum.Balmorian_Ruins.getY()].setSceneExamineCity(null);
        locations[TerritoryEnum.Balmorian_Ruins.getX()][TerritoryEnum.Balmorian_Ruins.getY()].setSceneAttack(null);
        locations[TerritoryEnum.Balmorian_Ruins.getX()][TerritoryEnum.Balmorian_Ruins.getY()].setSceneCaptured(null);

        /*----------------------------------------------------------------------
        * Valley of Kastro
        **--------------------------------------------------------------------*/
        ExamineWildernesScene VoK_Examine = new ExamineWildernesScene();
        Resource VoK = new Resource("Wood", 5);
        
        VoK_Examine.setResource(VoK);
        VoK_Examine.setDescription("The Kastro river flows from the land of Palatinus " + 
                                   "in the west into this valley");
        
        locations[TerritoryEnum.Valley_of_Kastro.getX()][TerritoryEnum.Valley_of_Kastro.getY()].setSceneExamineWilderness(VoK_Examine);
        locations[TerritoryEnum.Valley_of_Kastro.getX()][TerritoryEnum.Valley_of_Kastro.getY()].setSceneExamineCity(null);
        locations[TerritoryEnum.Valley_of_Kastro.getX()][TerritoryEnum.Valley_of_Kastro.getY()].setSceneAttack(null);
        locations[TerritoryEnum.Valley_of_Kastro.getX()][TerritoryEnum.Valley_of_Kastro.getY()].setSceneCaptured(null);

        /*----------------------------------------------------------------------
        * City of Malano
        **--------------------------------------------------------------------*/
        ExamineCityScene CoM_Examine = new ExamineCityScene();
        AttackScene CoM_Attack = new AttackScene();
        CapturedScene CoM_Captured = new CapturedScene();
        
        Resource CoM = new Resource("Gold", 400);
        CoM_Attack.setResource(CoM);
        CoM_Examine.setDescription("");
        
        locations[TerritoryEnum.City_of_Malano.getX()][TerritoryEnum.City_of_Malano.getY()].setSceneExamineWilderness(null);
        locations[TerritoryEnum.City_of_Malano.getX()][TerritoryEnum.City_of_Malano.getY()].setSceneExamineCity(CoM_Examine);
        locations[TerritoryEnum.City_of_Malano.getX()][TerritoryEnum.City_of_Malano.getY()].setSceneAttack(CoM_Attack);
        locations[TerritoryEnum.City_of_Malano.getX()][TerritoryEnum.City_of_Malano.getY()].setSceneCaptured(CoM_Captured);

        /*----------------------------------------------------------------------
        * Anatalia
        **--------------------------------------------------------------------*/
        ExamineCityScene Ana_Examine = new ExamineCityScene();
        AttackScene Ana_Attack = new AttackScene();
        CapturedScene Ana_Captured = new CapturedScene();
        
        Resource Ana = new Resource("Gold", 400);
        Ana_Attack.setResource(Ana);
        Ana_Examine.setDescription("This region was a forbidden land, now overrun " +
                                   "by the undead.");
        
        locations[TerritoryEnum.Anatalia.getX()][TerritoryEnum.Anatalia.getY()].setSceneExamineWilderness(null);
        locations[TerritoryEnum.Anatalia.getX()][TerritoryEnum.Anatalia.getY()].setSceneExamineCity(Ana_Examine);
        locations[TerritoryEnum.Anatalia.getX()][TerritoryEnum.Anatalia.getY()].setSceneAttack(Ana_Attack);
        locations[TerritoryEnum.Anatalia.getX()][TerritoryEnum.Anatalia.getY()].setSceneCaptured(Ana_Captured);

        /*----------------------------------------------------------------------
        * Antanjyl
        **--------------------------------------------------------------------*/
        ExamineCityScene Ant_Examine = new ExamineCityScene();
        AttackScene Ant_Attack = new AttackScene();
        CapturedScene Ant_Captured = new CapturedScene();
        
        Resource Ant = new Resource("Gold", 450);
        Ant_Attack.setResource(Ant);
        Ant_Examine.setDescription("Rumors speak of a demon sealed within the mountains " +
                                   "of this realm.");
        
        locations[TerritoryEnum.Antanjyl.getX()][TerritoryEnum.Antanjyl.getY()].setSceneExamineWilderness(null);
        locations[TerritoryEnum.Antanjyl.getX()][TerritoryEnum.Antanjyl.getY()].setSceneExamineCity(Ant_Examine);
        locations[TerritoryEnum.Antanjyl.getX()][TerritoryEnum.Antanjyl.getY()].setSceneAttack(Ant_Attack);
        locations[TerritoryEnum.Antanjyl.getX()][TerritoryEnum.Antanjyl.getY()].setSceneCaptured(Ant_Captured);

        /*----------------------------------------------------------------------
        * The Tundra
        **--------------------------------------------------------------------*/
        ExamineWildernesScene TT_Examine = new ExamineWildernesScene();
        Resource TT = new Resource("Metal", 2);
        
        TT_Examine.setResource(TT);
        TT_Examine.setDescription("A frozen wasteland where it is said a fallen " + 
                                  "angel weeps");
        
        locations[TerritoryEnum.The_Tundra.getX()][TerritoryEnum.The_Tundra.getY()].setSceneExamineWilderness(TT_Examine);
        locations[TerritoryEnum.The_Tundra.getX()][TerritoryEnum.The_Tundra.getY()].setSceneExamineCity(null);
        locations[TerritoryEnum.The_Tundra.getX()][TerritoryEnum.The_Tundra.getY()].setSceneAttack(null);
        locations[TerritoryEnum.The_Tundra.getX()][TerritoryEnum.The_Tundra.getY()].setSceneCaptured(null);

        /*----------------------------------------------------------------------
        * Fort Allamoot
        **--------------------------------------------------------------------*/
        ExamineCityScene FA_Examine = new ExamineCityScene();
        AttackScene FA_Attack = new AttackScene();
        CapturedScene FA_Captured = new CapturedScene();
        
        Resource FA = new Resource("Gold", 300);
        FA_Attack.setResource(FA);
        FA_Examine.setDescription("Built to guard the way to the north, this citadel " + 
                                  "has never fallen");
        
        locations[TerritoryEnum.Fort_Allamoot.getX()][TerritoryEnum.Fort_Allamoot.getY()].setSceneExamineWilderness(null);
        locations[TerritoryEnum.Fort_Allamoot.getX()][TerritoryEnum.Fort_Allamoot.getY()].setSceneExamineCity(FA_Examine);
        locations[TerritoryEnum.Fort_Allamoot.getX()][TerritoryEnum.Fort_Allamoot.getY()].setSceneAttack(FA_Attack);
        locations[TerritoryEnum.Fort_Allamoot.getX()][TerritoryEnum.Fort_Allamoot.getY()].setSceneCaptured(FA_Captured);

        /*----------------------------------------------------------------------
        * Ryhean Sea
        **--------------------------------------------------------------------*/
        ExamineWildernesScene RS_Examine = new ExamineWildernesScene();
        Resource RS = new Resource("Stone", 2);
        
        RS_Examine.setResource(RS);
        RS_Examine.setDescription("The region is known as the gateway to the north. " + 
                                  "Sailors travel to distant lands starting here");
        
        locations[TerritoryEnum.Ryhean_Sea.getX()][TerritoryEnum.Ryhean_Sea.getY()].setSceneExamineWilderness(RS_Examine);
        locations[TerritoryEnum.Ryhean_Sea.getX()][TerritoryEnum.Ryhean_Sea.getY()].setSceneExamineCity(null);
        locations[TerritoryEnum.Ryhean_Sea.getX()][TerritoryEnum.Ryhean_Sea.getY()].setSceneAttack(null);
        locations[TerritoryEnum.Ryhean_Sea.getX()][TerritoryEnum.Ryhean_Sea.getY()].setSceneCaptured(null);

        /*----------------------------------------------------------------------
        * Shrine of Kulyn
        **--------------------------------------------------------------------*/
        ExamineWildernesScene SoK_Examine = new ExamineWildernesScene();
        Resource SoK = new Resource("Metal", 1);
        
        SoK_Examine.setResource(SoK);
        SoK_Examine.setDescription("An old sanctuary to an unknown diety.");
        
        locations[TerritoryEnum.Shrine_of_Kulyn.getX()][TerritoryEnum.Shrine_of_Kulyn.getY()].setSceneExamineWilderness(SoK_Examine);
        locations[TerritoryEnum.Shrine_of_Kulyn.getX()][TerritoryEnum.Shrine_of_Kulyn.getY()].setSceneExamineCity(null);
        locations[TerritoryEnum.Shrine_of_Kulyn.getX()][TerritoryEnum.Shrine_of_Kulyn.getY()].setSceneAttack(null);
        locations[TerritoryEnum.Shrine_of_Kulyn.getX()][TerritoryEnum.Shrine_of_Kulyn.getY()].setSceneCaptured(null);

        /*----------------------------------------------------------------------
        * Dahlmud Desert
        **--------------------------------------------------------------------*/
        ExamineWildernesScene DD_Examine = new ExamineWildernesScene();
        Resource DD = new Resource("Stone", 1);
        
        DD_Examine.setResource(DD);
        DD_Examine.setDescription("This burning desert was once home to an another, " + 
                                  "older kingdom which has long since been buried " + 
                                  "beneath the sands");
        
        locations[TerritoryEnum.Dahlmud_Desert.getX()][TerritoryEnum.Dahlmud_Desert.getY()].setSceneExamineWilderness(DD_Examine);
        locations[TerritoryEnum.Dahlmud_Desert.getX()][TerritoryEnum.Dahlmud_Desert.getY()].setSceneExamineCity(null);
        locations[TerritoryEnum.Dahlmud_Desert.getX()][TerritoryEnum.Dahlmud_Desert.getY()].setSceneAttack(null);
        locations[TerritoryEnum.Dahlmud_Desert.getX()][TerritoryEnum.Dahlmud_Desert.getY()].setSceneCaptured(null);

        /*----------------------------------------------------------------------
        * Fort Shulamana
        **--------------------------------------------------------------------*/
        ExamineCityScene FS_Examine = new ExamineCityScene();
        AttackScene FS_Attack = new AttackScene();
        CapturedScene FS_Captured = new CapturedScene();
        
        Resource FS = new Resource("Gold", 500);
        FS_Attack.setResource(FS);
        FS_Examine.setDescription("A fortress built by the northerners. Surrounded " + 
                                  "by volcanos");
        
        locations[TerritoryEnum.Fort_Shulamana.getX()][TerritoryEnum.Fort_Shulamana.getY()].setSceneExamineWilderness(null);
        locations[TerritoryEnum.Fort_Shulamana.getX()][TerritoryEnum.Fort_Shulamana.getY()].setSceneExamineCity(FS_Examine);
        locations[TerritoryEnum.Fort_Shulamana.getX()][TerritoryEnum.Fort_Shulamana.getY()].setSceneAttack(FS_Attack);
        locations[TerritoryEnum.Fort_Shulamana.getX()][TerritoryEnum.Fort_Shulamana.getY()].setSceneCaptured(FS_Captured);

        /*----------------------------------------------------------------------
        * Xanadu
        **--------------------------------------------------------------------*/
        ExamineCityScene X_Examine = new ExamineCityScene();
        AttackScene X_Attack = new AttackScene();
        CapturedScene X_Captured = new CapturedScene();
        
        Resource Xana = new Resource("Gold", 500);
        X_Attack.setResource(Xana);
        X_Examine.setDescription("A royal city, built to house the officers and " + 
                                 "knights of the kingdom");
        
        locations[TerritoryEnum.Xanadu.getX()][TerritoryEnum.Xanadu.getY()].setSceneExamineWilderness(null);
        locations[TerritoryEnum.Xanadu.getX()][TerritoryEnum.Xanadu.getY()].setSceneExamineCity(X_Examine);
        locations[TerritoryEnum.Xanadu.getX()][TerritoryEnum.Xanadu.getY()].setSceneAttack(X_Attack);
        locations[TerritoryEnum.Xanadu.getX()][TerritoryEnum.Xanadu.getY()].setSceneCaptured(X_Captured);

        /*----------------------------------------------------------------------
        * Zeteginea
        **--------------------------------------------------------------------*/
        ExamineCityScene Z_Examine = new ExamineCityScene();
        AttackScene Z_Attack = new AttackScene();
        CapturedScene Z_Captured = new CapturedScene();
        
        Resource Zete = new Resource("Gold", 750);
        Z_Attack.setResource(Zete);
        Z_Examine.setDescription("The new capital, built by a queen from long ago "
                               + " who was later revealed to have gone mad");
        
        locations[TerritoryEnum.Zeteginea.getX()][TerritoryEnum.Zeteginea.getY()].setSceneExamineWilderness(null);
        locations[TerritoryEnum.Zeteginea.getX()][TerritoryEnum.Zeteginea.getY()].setSceneExamineCity(Z_Examine);
        locations[TerritoryEnum.Zeteginea.getX()][TerritoryEnum.Zeteginea.getY()].setSceneAttack(Z_Attack);
        locations[TerritoryEnum.Zeteginea.getX()][TerritoryEnum.Zeteginea.getY()].setSceneCaptured(Z_Captured);
        
        /*----------------------------------------------------------------------
        * Temple Shalina
        **--------------------------------------------------------------------*/
        ExamineCityScene TS_Examine = new ExamineCityScene();
        AttackScene TS_Attack = new AttackScene();
        CapturedScene TS_Captured = new CapturedScene();
        
        Resource TS = new Resource("Gold", 1000000);
        TS_Attack.setResource(TS);
        TS_Examine.setDescription("An old temple believed to be dedicated to darkness." +
                                  "Its location was kept secret for many generations");
        
        locations[TerritoryEnum.Temple_Shalina.getX()][TerritoryEnum.Temple_Shalina.getY()].setSceneExamineWilderness(null);
        locations[TerritoryEnum.Temple_Shalina.getX()][TerritoryEnum.Temple_Shalina.getY()].setSceneExamineCity(TS_Examine);
        locations[TerritoryEnum.Temple_Shalina.getX()][TerritoryEnum.Temple_Shalina.getY()].setSceneAttack(TS_Attack);
        locations[TerritoryEnum.Temple_Shalina.getX()][TerritoryEnum.Temple_Shalina.getY()].setSceneCaptured(TS_Captured);
    }
}
