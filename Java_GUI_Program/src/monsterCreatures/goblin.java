package monsterCreatures;

public class goblin extends superMonster {

    public goblin(){
        name = "Goblin";
        hp = 5;
        monsterWeapon = "One - Handed Sword";
        attack = 6;
        currentWeapon = attack;
        attack_Message = "The goblin attacks with there sword!";
        monsterLoot = "Silver Ring";
        monsterLoot_Num = 1;
    }
}