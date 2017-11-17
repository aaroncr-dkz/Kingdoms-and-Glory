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
    Usar("Usar", "A captain of the bandits in the Sharmom region."),
    Gilbert("Gilbert", "Governor of Sharom who surrendered to the enemy without a fight."),
    Sirius("Sirius", "The werewolf of Lake Jansenia."),
    Kapella("Kapella", "A mage who practiced rituals to summon the undead and demons."),
    Deneb("Deneb", "Alluring witch with an odd taste for pumpkings."),
    Debonair("Debonair", "General who guards the old capital."),
    Gares("Gares", "A black knight who never removes his armor."),
    Figaro("Figaro", "General sent on a mission which was doomed to fail."),
    Porkyus("Porkyus", "Leader of the mermaids."),
    Albeleo("Albeleo", "A mage who was oppsessed with the power of reincarnation."),
    Ares("Ares", "A bounty hunter looking for a runaway."),
    Apros("Apros", "A duke who betrayed his kingdom."),
    Omicron("Omicron", "Ex-bishop who delved into forbidden necromancy."),
    Galf("Galf", "Ancient demon who was once sealed away."),
    Mizal("Mizal", "A fallen angel who has exiled themselves for their crimes."),
    Pollux("Pollux", "Half-giant and twin borther of Castor."),
    Castor("Castor", "Half-giant and twin brother of Pollux"),
    Randalls("Randalls", "A cardnial of little faith. Used his money to purchase his status."),
    Previa("Previa", "General sent to find an ancient artifact."),
    Procyon("Procyon", "An assassin who killed his ruler so that history would remember him."),
    Luvalon("Luvalon", "General who was entrusted to protect the last line of defense."),
    Hikash("Hikash", "Overlord of Xanadu. A man who would die for his honor.");
    
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
