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
public enum ActorEnum {
    Usar("Usar", ""),
    Gilbert("Gilbert", ""),
    Sirius("Sirius", "Werewolf of Lake Jansenia"),
    Kapella("Kapella", ""),
    Deneb("Deneb", ""),
    Debonair("Debonair", "General who guards the old capital"),
    Gares("Gares", "A Black Knight who never removes his armor"),
    Figaro("Figaro", ""),
    Porkyus("Porkyus", ""),
    Albeleo("Albeleo", ""),
    Ares("Ares", ""),
    Apros("Apros", ""),
    Omicron("Omicron", ""),
    Galf("Galf", ""),
    Mizal("Mizal", ""),
    Pollux("Pollux", ""),
    Castor("Castor", ""),
    Randalls("Randalls", ""),
    Previa("Previa", ""),
    Procyon("Procyon", ""),
    Luvalon("Luvalon", ""),
    Hikash("Hikash", "");
    
    private final String name;
    private final String description;
    
    ActorEnum(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    
}
