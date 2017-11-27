/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.model;

/**
 *
 * @author aaroncr-dkz
 */
public enum TerritoryEnum {
    Castle_of_Warren(4, 4, "CW "),
    Borders_of_Sharom(3, 4, "BoS"),
    Sharom_District(4, 3, "SD "),
    Lake_Jansenia(3, 3, "LJ "),
    Pogrom_Forest(4, 2, "PF "),
    Denebs_Garden(3, 2, "DG "),
    Slums_of_Zenobia(4, 1, "SoZ"),
    Island_Avalon(3, 1, "IA "),
    Kalbi_Peninsula(4, 0, "KP "),
    Kastolation_Sea(3, 0, "KS "),
    Diaspola(2, 4, "Dia"),
    Balmorian_Ruins(2, 3, "BR "),
    Valley_of_Kastro(2, 0, "VoK"),
    City_of_Malano(2, 2, "CoM"),
    Anatalia(2, 1, "Ana"),
    Antanjyl(1, 1, "Ant"),
    The_Tundra(1, 4, "TT "),
    Fort_Allamoot(1, 3, "FA "),
    Ryhean_Sea(0, 4, "RS "),
    Shrine_of_Kulyn(0, 3, "SoK"),
    Dahlmud_Desert(1, 0, "DD "),
    Fort_Shulamana(1, 2, "FS "),
    Xanadu(0, 2, "Xan"),
    Zeteginea(0, 1, "Zet"),
    Temple_Shalina(0, 0, "TS ");
    
    private final int row;
    private final int column;
    private final String symbol;
    
    TerritoryEnum(int row, int column, String symbol) {
        this.row = row;
        this.column = column;
        this.symbol = symbol;
    }

    public int getX() {
        return row;
    }

    public int getY() {
        return column;
    }

    public String getSymbol() {
        return symbol;
    }
}
