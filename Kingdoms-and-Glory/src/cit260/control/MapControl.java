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
import cit260.model.SceneArrayEnum;
import cit260.model.SceneEnum;
import cit260.model.TerritoryEnum;
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

        // set the symbols for each location
        setLocationSymbols(locations);

        // set the locations to the map
        map.setTerritories(locations);

        // create the scenes and their resources. Then assign them to territories
        DefaultScene[] scenes = createScenes();
        assignScenesToLocations(map, scenes);

        System.out.println(map.getTerritories()[TerritoryEnum.Castle_of_Warren.getX()][TerritoryEnum.Castle_of_Warren.getY()].getScenes()[SceneArrayEnum.CapturedScene.ordinal()].getDescription());

        return map;
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

    private static Territory[][] setLocationSymbols(Territory[][] locations) {
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

        return locations;
    }

    private static DefaultScene[] createScenes() {
        DefaultScene[] scenes = new DefaultScene[47];

        /*-------------------------------------------------------------------
           * Castle of Warren
           **-----------------------------------------------------------------*/
        CapturedScene CoW_Captured = new CapturedScene();
        CoW_Captured.setDescription("The Castle of the Seer Warren Moon.");
        scenes[SceneEnum.CoW_Captured.ordinal()] = CoW_Captured;

        /*-------------------------------------------------------------------
           * Borders of Sharom
           **-----------------------------------------------------------------*/
        ExamineWildernesScene BoS_Examine = new ExamineWildernesScene();
        Resource BoS = new Resource("Cloth", 2);

        BoS_Examine.setResource(BoS);
        BoS_Examine.setDescription("The borders of the Sharom District");

        scenes[SceneEnum.BoS_Examine.ordinal()] = BoS_Examine;

        /*-------------------------------------------------------------------
           * Sharom District
           **-----------------------------------------------------------------*/
        ExamineCityScene SD_Examine = new ExamineCityScene();
        AttackScene SD_Attack = new AttackScene();
        CapturedScene SD_Captured = new CapturedScene();

        Resource SD = new Resource("Gold", 200);
        SD_Attack.setResource(SD);
        SD_Examine.setDescription("The Independent District of Sharom.");
        SD_Examine.setEstimatedOpposition(50);
        SD_Examine.setResourcesNeeded("Stone");

        scenes[SceneEnum.SD_Examine.ordinal()] = SD_Examine;
        scenes[SceneEnum.SD_Attack.ordinal()] = SD_Attack;
        scenes[SceneEnum.SD_Captured.ordinal()] = SD_Captured;

        /*-------------------------------------------------------------------
           * Lake Jansenia
           **-----------------------------------------------------------------*/
        ExamineWildernesScene LJ_Examine = new ExamineWildernesScene();
        Resource LJ = new Resource("Wood", 2);

        LJ_Examine.setResource(LJ);
        LJ_Examine.setDescription("Beautiful lake country where the Zenobian"
                + " nobality once vacationed.");

        scenes[SceneEnum.LJ_Examine.ordinal()] = LJ_Examine;

        /*-------------------------------------------------------------------
           * Pogrom Forest
           **-----------------------------------------------------------------*/
        ExamineWildernesScene PF_Examine = new ExamineWildernesScene();

        Resource PF = new Resource("Cloth", 2);
        PF_Examine.setResource(PF);
        PF_Examine.setDescription("This old forest is filled with the lost "
                + "souls of those who were killed here.");

        scenes[SceneEnum.PF_Examine.ordinal()] = PF_Examine;

        /*-------------------------------------------------------------------
           * Deneb's Garden
           **-----------------------------------------------------------------*/
        ExamineWildernesScene DG_Examine = new ExamineWildernesScene();
        Resource DG = new Resource("Stone", 1);

        DG_Examine.setResource(DG);
        DG_Examine.setDescription("Region watched over by the beutiful witch"
                + " Deneb.");

        scenes[SceneEnum.DG_Examine.ordinal()] = DG_Examine;

        /*-------------------------------------------------------------------
           * Slums of Zenobia
           **-----------------------------------------------------------------*/
        ExamineCityScene SoZ_Examine = new ExamineCityScene();
        AttackScene SoZ_Attack = new AttackScene();
        CapturedScene SoZ_Captured = new CapturedScene();
        Resource SoZ = new Resource("Gold", 300);
        SoZ_Attack.setResource(SoZ);

        scenes[SceneEnum.SoZ_Examine.ordinal()] = SoZ_Examine;
        scenes[SceneEnum.SoZ_Attack.ordinal()] = SoZ_Attack;
        scenes[SceneEnum.SoZ_Captured.ordinal()] = SoZ_Captured;

        /*-------------------------------------------------------------------
           * Island Avalon
           **-----------------------------------------------------------------*/
        ExamineWildernesScene IA_Examine = new ExamineWildernesScene();
        Resource IA = new Resource("Metal", 1);
        IA_Examine.setResource(IA);
        scenes[SceneEnum.IA_Examine.ordinal()] = IA_Examine;

        /*-------------------------------------------------------------------
           * Kalbi Peninsula
           **-----------------------------------------------------------------*/
        ExamineWildernesScene KP_Examine = new ExamineWildernesScene();
        Resource KP = new Resource("Stone", 2);
        KP_Examine.setResource(KP);
        scenes[SceneEnum.KP_Examine.ordinal()] = KP_Examine;

        /*-------------------------------------------------------------------
           * Kastolation Sea
           **-----------------------------------------------------------------*/
        ExamineWildernesScene KS_Examine = new ExamineWildernesScene();
        Resource KS = new Resource("Cloth", 4);
        KS_Examine.setResource(KS);
        scenes[SceneEnum.KS_Examine.ordinal()] = KS_Examine;

        /*-------------------------------------------------------------------
           * Diaspola
           **-----------------------------------------------------------------*/
        ExamineCityScene D_Examine = new ExamineCityScene();
        AttackScene D_Attack = new AttackScene();
        CapturedScene D_Captured = new CapturedScene();
        Resource Dias = new Resource("Gold", 350);
        D_Attack.setResource(Dias);

        scenes[SceneEnum.D_Examine.ordinal()] = D_Examine;
        scenes[SceneEnum.D_Attack.ordinal()] = D_Attack;
        scenes[SceneEnum.D_Captured.ordinal()] = D_Captured;

        /*-------------------------------------------------------------------
           * Balmorian Ruins
           **-----------------------------------------------------------------*/
        ExamineWildernesScene BR_Examine = new ExamineWildernesScene();
        Resource BR = new Resource("Gold", 100);
        BR_Examine.setResource(BR);
        scenes[SceneEnum.BR_Examine.ordinal()] = BR_Examine;

        /*-------------------------------------------------------------------
           * Valley of Kastro
           **-----------------------------------------------------------------*/
        ExamineWildernesScene VoK_Examine = new ExamineWildernesScene();
        Resource VoK = new Resource("Wood", 5);
        VoK_Examine.setResource(VoK);
        scenes[SceneEnum.VoK_Examine.ordinal()] = VoK_Examine;

        /*-------------------------------------------------------------------
           * City of Malano
           **-----------------------------------------------------------------*/
        ExamineCityScene CoM_Examine = new ExamineCityScene();
        AttackScene CoM_Attack = new AttackScene();
        CapturedScene CoM_Captured = new CapturedScene();
        Resource CoM = new Resource("Gold", 400);
        CoM_Attack.setResource(CoM);

        scenes[SceneEnum.CoM_Examine.ordinal()] = CoM_Examine;
        scenes[SceneEnum.CoM_Attack.ordinal()] = CoM_Attack;
        scenes[SceneEnum.CoM_Captured.ordinal()] = CoM_Captured;

        /*-------------------------------------------------------------------
           * Anatalia
           **-----------------------------------------------------------------*/
        ExamineCityScene Ana_Examine = new ExamineCityScene();
        AttackScene Ana_Attack = new AttackScene();
        CapturedScene Ana_Captured = new CapturedScene();
        Resource Ana = new Resource("Gold", 400);
        Ana_Attack.setResource(Ana);

        scenes[SceneEnum.Ana_Examine.ordinal()] = Ana_Examine;
        scenes[SceneEnum.Ana_Attack.ordinal()] = Ana_Attack;
        scenes[SceneEnum.Ana_Captured.ordinal()] = Ana_Captured;

        /*-------------------------------------------------------------------
           * Antanjyl
           **-----------------------------------------------------------------*/
        ExamineCityScene Ant_Examine = new ExamineCityScene();
        AttackScene Ant_Attack = new AttackScene();
        CapturedScene Ant_Captured = new CapturedScene();
        Resource Ant = new Resource("Gold", 450);
        Ant_Attack.setResource(Ant);

        scenes[SceneEnum.Ant_Examine.ordinal()] = Ant_Examine;
        scenes[SceneEnum.Ant_Attack.ordinal()] = Ant_Attack;
        scenes[SceneEnum.Ant_Captured.ordinal()] = Ant_Captured;

        /*-------------------------------------------------------------------
           * The Tundra
           **-----------------------------------------------------------------*/
        ExamineWildernesScene TT_Examine = new ExamineWildernesScene();
        Resource TT = new Resource("Metal", 2);
        TT_Examine.setResource(TT);
        scenes[SceneEnum.TT_Examine.ordinal()] = TT_Examine;

        /*-------------------------------------------------------------------
           * Fort Allamoot
           **-----------------------------------------------------------------*/
        ExamineCityScene FA_Examine = new ExamineCityScene();
        AttackScene FA_Attack = new AttackScene();
        CapturedScene FA_Captured = new CapturedScene();
        Resource FA = new Resource("Gold", 300);
        FA_Attack.setResource(FA);

        scenes[SceneEnum.FA_Examine.ordinal()] = FA_Examine;
        scenes[SceneEnum.FA_Attack.ordinal()] = FA_Attack;
        scenes[SceneEnum.FA_Captured.ordinal()] = FA_Captured;

        /*-------------------------------------------------------------------
           * Ryhean Sea
           **-----------------------------------------------------------------*/
        ExamineWildernesScene RS_Examine = new ExamineWildernesScene();
        Resource RS = new Resource("Stone", 2);
        RS_Examine.setResource(RS);
        scenes[SceneEnum.RS_Examine.ordinal()] = RS_Examine;

        /*-------------------------------------------------------------------
           * Shrine of Kulyn
           **-----------------------------------------------------------------*/
        ExamineWildernesScene SoK_Examine = new ExamineWildernesScene();
        Resource SoK = new Resource("Metal", 1);
        SoK_Examine.setResource(SoK);
        scenes[SceneEnum.SoK_Examine.ordinal()] = SoK_Examine;

        /*-------------------------------------------------------------------
           * Dahlmud Desert
           **-----------------------------------------------------------------*/
        ExamineWildernesScene DD_Examine = new ExamineWildernesScene();
        Resource DD = new Resource("Stone", 1);
        DD_Examine.setResource(DD);
        scenes[SceneEnum.DD_Examine.ordinal()] = DD_Examine;

        /*-------------------------------------------------------------------
           * Fort Shulamana
           **-----------------------------------------------------------------*/
        ExamineCityScene FS_Examine = new ExamineCityScene();
        AttackScene FS_Attack = new AttackScene();
        CapturedScene FS_Captured = new CapturedScene();
        Resource FS = new Resource("Gold", 500);
        FS_Attack.setResource(FS);

        scenes[SceneEnum.FS_Examine.ordinal()] = FS_Examine;
        scenes[SceneEnum.FS_Attack.ordinal()] = FS_Attack;
        scenes[SceneEnum.FS_Captured.ordinal()] = FS_Captured;

        /*-------------------------------------------------------------------
           * Xanadu
           **-----------------------------------------------------------------*/
        ExamineCityScene X_Examine = new ExamineCityScene();
        AttackScene X_Attack = new AttackScene();
        CapturedScene X_Captured = new CapturedScene();
        Resource Xana = new Resource("Gold", 500);
        X_Attack.setResource(Xana);

        scenes[SceneEnum.X_Examine.ordinal()] = X_Examine;
        scenes[SceneEnum.X_Attack.ordinal()] = X_Attack;
        scenes[SceneEnum.X_Captured.ordinal()] = X_Captured;

        /*-------------------------------------------------------------------
           * Zeteginea
           **-----------------------------------------------------------------*/
        ExamineCityScene Z_Examine = new ExamineCityScene();
        AttackScene Z_Attack = new AttackScene();
        CapturedScene Z_Captured = new CapturedScene();
        Resource Zete = new Resource("Gold", 750);
        Z_Attack.setResource(Zete);

        scenes[SceneEnum.Z_Examine.ordinal()] = Z_Examine;
        scenes[SceneEnum.Z_Attack.ordinal()] = Z_Attack;
        scenes[SceneEnum.Z_Captured.ordinal()] = Z_Captured;

        /*-------------------------------------------------------------------
           * Temple Shalina
           **-----------------------------------------------------------------*/
        ExamineCityScene TS_Examine = new ExamineCityScene();
        AttackScene TS_Attack = new AttackScene();
        CapturedScene TS_Captured = new CapturedScene();
        Resource TS = new Resource("Gold", 1000000);
        TS_Attack.setResource(TS);

        scenes[SceneEnum.TS_Examine.ordinal()] = TS_Examine;
        scenes[SceneEnum.TS_Attack.ordinal()] = TS_Attack;
        scenes[SceneEnum.TS_Captured.ordinal()] = TS_Captured;

        return scenes;
    }

    private static void assignScenesToLocations(Map map, DefaultScene[] scenes) {
        Territory[][] locations = map.getTerritories();

        // Castle of Warren
        DefaultScene[] insertCoW = new DefaultScene[3];
        insertCoW[0] = null;
        insertCoW[1] = null;
        insertCoW[2] = scenes[SceneEnum.CoW_Captured.ordinal()];
        locations[TerritoryEnum.Castle_of_Warren.getX()][TerritoryEnum.Castle_of_Warren.getY()].setScenes(insertCoW);

        //System.out.println(scenes[SceneEnum.CoW_Captured.ordinal()].getDescription());
        //System.out.println(locations[TerritoryEnum.Castle_of_Warren.getX()][TerritoryEnum.Castle_of_Warren.getY()].getScenes()[SceneArrayEnum.CapturedScene.ordinal()].getDescription());
        // Borders of Sharom
        DefaultScene[] insertBoS = new DefaultScene[3];
        insertBoS[0] = scenes[SceneEnum.BoS_Examine.ordinal()];
        insertBoS[1] = null;
        insertBoS[2] = null;
        locations[TerritoryEnum.Borders_of_Sharom.getX()][TerritoryEnum.Borders_of_Sharom.getY()].setScenes(insertBoS);

        // Sharom_District
        DefaultScene[] insertSD = new DefaultScene[3];
        insertSD[0] = scenes[SceneEnum.SD_Examine.ordinal()];
        insertSD[1] = scenes[SceneEnum.SD_Attack.ordinal()];
        insertSD[2] = scenes[SceneEnum.SD_Captured.ordinal()];
        locations[TerritoryEnum.Sharom_District.getX()][TerritoryEnum.Sharom_District.getY()].setScenes(insertSD);

        // Lake Jansenia
        DefaultScene[] insertLJ = new DefaultScene[3];
        insertLJ[0] = scenes[SceneEnum.LJ_Examine.ordinal()];
        insertLJ[1] = null;
        insertLJ[2] = null;
        locations[TerritoryEnum.Lake_Jansenia.getX()][TerritoryEnum.Lake_Jansenia.getY()].setScenes(insertLJ);

        // Pogrom Forest
        DefaultScene[] insertPF = new DefaultScene[3];
        insertPF[0] = scenes[SceneEnum.PF_Examine.ordinal()];
        insertPF[1] = null;
        insertPF[2] = null;
        locations[TerritoryEnum.Pogrom_Forest.getX()][TerritoryEnum.Pogrom_Forest.getY()].setScenes(insertPF);

        // Deneb's Garden
        DefaultScene[] insertDG = new DefaultScene[3];
        insertDG[0] = scenes[SceneEnum.DG_Examine.ordinal()];
        insertDG[1] = null;
        insertDG[2] = null;
        locations[TerritoryEnum.Denebs_Garden.getX()][TerritoryEnum.Denebs_Garden.getY()].setScenes(insertDG);

        // Slums of Zenobia
        DefaultScene[] insertSoZ = new DefaultScene[3];
        insertSoZ[0] = scenes[SceneEnum.SoZ_Examine.ordinal()];
        insertSoZ[1] = scenes[SceneEnum.SoZ_Attack.ordinal()];
        insertSoZ[2] = scenes[SceneEnum.SoZ_Captured.ordinal()];
        locations[TerritoryEnum.Slums_of_Zenobia.getX()][TerritoryEnum.Slums_of_Zenobia.getY()].setScenes(insertSoZ);

        // Island Avalon
        DefaultScene[] insertIA = new DefaultScene[3];
        insertIA[0] = scenes[SceneEnum.IA_Examine.ordinal()];
        insertIA[1] = null;
        insertIA[2] = null;
        locations[TerritoryEnum.Island_Avalon.getX()][TerritoryEnum.Island_Avalon.getY()].setScenes(insertIA);

        // Kalbi Peninsula
        DefaultScene[] insertKP = new DefaultScene[3];
        insertKP[0] = scenes[SceneEnum.KP_Examine.ordinal()];
        insertKP[1] = null;
        insertKP[2] = null;
        locations[TerritoryEnum.Kalbi_Peninsula.getX()][TerritoryEnum.Kalbi_Peninsula.getY()].setScenes(insertKP);

        // Kastolation Sea
        DefaultScene[] insertKS = new DefaultScene[3];
        insertKS[0] = scenes[SceneEnum.KS_Examine.ordinal()];
        insertKS[1] = null;
        insertKS[2] = null;
        locations[TerritoryEnum.Kastolation_Sea.getX()][TerritoryEnum.Kastolation_Sea.getY()].setScenes(insertKS);

        // Diaspola
        DefaultScene[] insertDia = new DefaultScene[3];
        insertDia[0] = scenes[SceneEnum.D_Examine.ordinal()];
        insertDia[1] = scenes[SceneEnum.D_Attack.ordinal()];
        insertDia[2] = scenes[SceneEnum.D_Captured.ordinal()];
        locations[TerritoryEnum.Diaspola.getX()][TerritoryEnum.Diaspola.getY()].setScenes(insertDia);

        // Balmorian Ruins
        DefaultScene[] insertBR = new DefaultScene[3];
        insertBR[0] = scenes[SceneEnum.BR_Examine.ordinal()];
        insertBR[1] = null;
        insertBR[2] = null;
        locations[TerritoryEnum.Balmorian_Ruins.getX()][TerritoryEnum.Balmorian_Ruins.getY()].setScenes(insertBR);

        // Valley of Kastro
        DefaultScene[] insertVoK = new DefaultScene[3];
        insertVoK[0] = scenes[SceneEnum.VoK_Examine.ordinal()];
        insertVoK[1] = null;
        insertVoK[2] = null;
        locations[TerritoryEnum.Valley_of_Kastro.getX()][TerritoryEnum.Valley_of_Kastro.getY()].setScenes(insertVoK);

        // City of Malano
        DefaultScene[] insertCoM = new DefaultScene[3];
        insertCoM[0] = scenes[SceneEnum.CoM_Examine.ordinal()];
        insertCoM[1] = scenes[SceneEnum.CoM_Attack.ordinal()];
        insertCoM[2] = scenes[SceneEnum.CoM_Captured.ordinal()];
        locations[TerritoryEnum.City_of_Malano.getX()][TerritoryEnum.City_of_Malano.getY()].setScenes(insertCoM);

        // Anatalia
        DefaultScene[] insertAna = new DefaultScene[3];
        insertAna[0] = scenes[SceneEnum.Ana_Examine.ordinal()];
        insertAna[1] = scenes[SceneEnum.Ana_Attack.ordinal()];
        insertAna[2] = scenes[SceneEnum.Ana_Captured.ordinal()];
        locations[TerritoryEnum.Anatalia.getX()][TerritoryEnum.Anatalia.getY()].setScenes(insertAna);

        // Antanjyl
        DefaultScene[] insertAnt = new DefaultScene[3];
        insertAnt[0] = scenes[SceneEnum.Ant_Examine.ordinal()];
        insertAnt[1] = scenes[SceneEnum.Ant_Attack.ordinal()];
        insertAnt[2] = scenes[SceneEnum.Ant_Captured.ordinal()];
        locations[TerritoryEnum.Antanjyl.getX()][TerritoryEnum.Antanjyl.getY()].setScenes(insertAnt);

        // The Tundra
        DefaultScene[] insertTT = new DefaultScene[3];
        insertTT[0] = scenes[SceneEnum.TT_Examine.ordinal()];
        insertTT[1] = null;
        insertTT[2] = null;
        locations[TerritoryEnum.The_Tundra.getX()][TerritoryEnum.The_Tundra.getY()].setScenes(insertTT);

        // Fort Allamoot
        DefaultScene[] insertFA = new DefaultScene[3];
        insertFA[0] = scenes[SceneEnum.FA_Examine.ordinal()];
        insertFA[1] = scenes[SceneEnum.FA_Attack.ordinal()];
        insertFA[2] = scenes[SceneEnum.FA_Captured.ordinal()];
        locations[TerritoryEnum.Fort_Allamoot.getX()][TerritoryEnum.Fort_Allamoot.getY()].setScenes(insertFA);

        // Ryhean Sea
        DefaultScene[] insertRS = new DefaultScene[3];
        insertRS[0] = scenes[SceneEnum.RS_Examine.ordinal()];
        insertRS[1] = null;
        insertRS[2] = null;
        locations[TerritoryEnum.Ryhean_Sea.getX()][TerritoryEnum.Ryhean_Sea.getY()].setScenes(insertRS);

        // Shrine of Kulyn
        DefaultScene[] insertSoK = new DefaultScene[3];
        insertSoK[0] = scenes[SceneEnum.SoK_Examine.ordinal()];
        insertSoK[1] = null;
        insertSoK[2] = null;
        locations[TerritoryEnum.Shrine_of_Kulyn.getX()][TerritoryEnum.Shrine_of_Kulyn.getY()].setScenes(insertSoK);

        // Dahlmud Desert
        DefaultScene[] insertDD = new DefaultScene[3];
        insertDD[0] = scenes[SceneEnum.DD_Examine.ordinal()];
        insertDD[1] = null;
        insertDD[2] = null;
        locations[TerritoryEnum.Dahlmud_Desert.getX()][TerritoryEnum.Dahlmud_Desert.getY()].setScenes(insertDD);

        // Fort Shulamana
        DefaultScene[] insertFS = new DefaultScene[3];
        insertFS[0] = scenes[SceneEnum.FS_Examine.ordinal()];
        insertFS[1] = scenes[SceneEnum.FS_Attack.ordinal()];
        insertFS[2] = scenes[SceneEnum.FS_Captured.ordinal()];
        locations[TerritoryEnum.Fort_Shulamana.getX()][TerritoryEnum.Fort_Shulamana.getY()].setScenes(insertFS);

        // Xanadu
        DefaultScene[] insertXan = new DefaultScene[3];
        insertXan[0] = scenes[SceneEnum.X_Examine.ordinal()];
        insertXan[1] = scenes[SceneEnum.X_Attack.ordinal()];
        insertXan[2] = scenes[SceneEnum.X_Captured.ordinal()];
        locations[TerritoryEnum.Xanadu.getX()][TerritoryEnum.Xanadu.getY()].setScenes(insertXan);

        // Zeteginea
        DefaultScene[] insertZet = new DefaultScene[3];
        insertZet[0] = scenes[SceneEnum.Z_Examine.ordinal()];
        insertZet[1] = scenes[SceneEnum.Z_Attack.ordinal()];
        insertZet[2] = scenes[SceneEnum.Z_Captured.ordinal()];
        locations[TerritoryEnum.Zeteginea.getX()][TerritoryEnum.Zeteginea.getY()].setScenes(insertZet);

        // Temple Shalina
        DefaultScene[] insertTS = new DefaultScene[3];
        insertTS[0] = scenes[SceneEnum.TS_Examine.ordinal()];
        insertTS[1] = scenes[SceneEnum.TS_Attack.ordinal()];
        insertTS[2] = scenes[SceneEnum.TS_Captured.ordinal()];
        locations[TerritoryEnum.Temple_Shalina.getX()][TerritoryEnum.Temple_Shalina.getY()].setScenes(insertTS);

    }
}
