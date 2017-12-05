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
    Castle_of_Warren(4, 4, "Castle of Warren", "CW "),
    Borders_of_Sharom(3, 4, "Borders of Sharom", "BoS"),
    Sharom_District(4, 3, "Sharom District", "SD "),
    Lake_Jansenia(3, 3, "Lake Jansenia", "LJ "),
    Pogrom_Forest(4, 2, "Pogrom Forest", "PF "),
    Denebs_Garden(3, 2, "Deneb's Garden", "DG "),
    Slums_of_Zenobia(4, 1, "Slums of Zenobia", "SoZ"),
    Island_Avalon(3, 1, "Island Avalon", "IA "),
    Kalbi_Peninsula(4, 0, "Kalbi Peninsula", "KP "),
    Kastolation_Sea(3, 0, "Kastolation Sea", "KS "),
    Diaspola(2, 4, "Diaspola", "Dia"),
    Balmorian_Ruins(2, 3, "Balmorian Ruins", "BR "),
    Valley_of_Kastro(2, 0, "Valley of Kastro", "VoK"),
    City_of_Malano(2, 2, "City of Malano", "CoM"),
    Anatalia(2, 1, "Anatalia", "Ana"),
    Antanjyl(1, 1, "Antanjyl", "Ant"),
    The_Tundra(1, 4, "The Tundra", "TT "),
    Fort_Allamoot(1, 3, "Fort Allamoot", "FA "),
    Ryhean_Sea(0, 4, "Ryhean Sea", "RS "),
    Shrine_of_Kulyn(0, 3, "Shrine of Kulyn", "SoK"),
    Dahlmud_Desert(1, 0, "Dahlmud Desert", "DD "),
    Fort_Shulamana(1, 2, "Fort Shulamana", "FS "),
    Xanadu(0, 2, "Xanadu", "Xan"),
    Zeteginea(0, 1, "Zeteginea", "Zet"),
    Temple_Shalina(0, 0, "Temple Shalina", "TS ");
    
    private final int row;
    private final int column;
    private final String name;
    private final String symbol;
    
    TerritoryEnum(int row, int column, String name, String symbol) {
        this.row = row;
        this.column = column;
        this.name = name;
        this.symbol = symbol;
    }

    public int getX() {
        return row;
    }

    public int getY() {
        return column;
    }
    
    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
}
