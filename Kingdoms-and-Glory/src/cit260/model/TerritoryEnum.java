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
    Castle_of_Warren(4, 4),
    Borders_of_Sharom(3, 4),
    Sharom_District(4, 3),
    Lake_Jansenia(3, 3),
    Pogrom_Forest(4, 2),
    Denebs_Garden(3, 2),
    Slums_of_Zenobia(4, 1),
    Island_Avalon(3, 1),
    Kalbi_Peninsula(4, 0),
    Kastolation_Sea(3, 0),
    Diaspola(2, 4),
    Balmorian_Ruins(2, 3),
    Valley_of_Kastro(2, 0),
    City_of_Malano(2, 2),
    Anatalia(2, 1),
    Antanjyl(1, 1),
    The_Tundra(1, 4),
    Fort_Allamoot(1, 3),
    Ryhean_Sea(0, 4),
    Shrine_of_Kulyn(0, 3),
    Dahlmud_Desert(1, 0),
    Fort_Shulamana(1, 2),
    Xanadu(0, 2),
    Zeteginea(0, 1),
    Temple_Shalina(0, 0);
    
    private final int row;
    private final int column;
    
    TerritoryEnum(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getX() {
        return row;
    }

    public int getY() {
        return column;
    }
    
    
}
