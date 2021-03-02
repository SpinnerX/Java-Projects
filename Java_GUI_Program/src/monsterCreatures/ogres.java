package monsterCreatures;

public class ogres extends superMonster{
    public ogres(){
        name = "Ogre";
        hp = 90;
        monsterWeapon = "Double-Sided Sword";
        attack = 45;
        currentWeapon = attack;
        attack_Message = "Ogre strikes you with its one handed Axe.";
    }
}
