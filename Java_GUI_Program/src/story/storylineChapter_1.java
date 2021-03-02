package story;
import Inventory.superItem;
import com.company.Main;
import game_Setup.UI;
import game_Setup.*;
import monsterCreatures.*;
import player.*;
import weapons.*;

public class storylineChapter_1 extends storyLineSuperClass {
    //Constructor needed to extend this class
    storylineChapter_1(){

    }
    Main game;
    UI ui = new UI();
    visibilityManager vm;
    player Player = new player();
    superMonster monster;
    ogres Ogre;
    superItem item; //This is the object for the item.
    int SilverRing;
    int merchQuest_ItemLOOT1;
    int findingMissing_Son;
    String findingMissingSon_Message;
    //String acceptMerchQ;
    //townObjective enterTownGate;

    public storylineChapter_1(Main g, UI userInterface, visibilityManager vManager){

        game = g;
        ui = userInterface;
        vm = vManager;

    }

    //This is the default setup whenever the game resets!
    public void defaultSetup(){
        Player.hp = 150;
        ui.hpNumberLabel.setText("" + Player.hp);
        //To be able to use knife from knife class
        Player.currentWeapon = new knife();
        ui.weaponNameLabel.setText(Player.currentWeapon.name);
        ui.choice1.setText("Start");
        game.nextPosition1 = "townGate";
        //Quest & Investigation items.
        SilverRing = 0;
        merchQuest_ItemLOOT1 = 0;
    }

    public void inventory_Manager(){
        ui.mainTextArea.setText("Inventory");
    }

    public void selectPosition(String nextPosition){
        switch (nextPosition){
            case "townGate": townGate(); break;
            case "Talk to the Guard": talkGuard(); break;
            case "Attack the Guard": attackGuard(); break;
            case "crossroad": crossRoad();break;
            case "North": North(); break;
            case "East": East(); break;
            case "West": West(); break;
            case "fight": fight(); break;
            case "Attack": playerAttack(); break;
            case "monsterAttack": monsterAttack(); break;
            case "win": win(); break;
            case "lose": lose(); break;
            case "toTitle": toTitle(); break;
            case "Enter Town": enterTownGate(); break;

            //To either Accept or decline merchant quests.
            case "Talk to Merchant": talkToMerchant(); break;
            case "Accept Quest": acceptMerchantQuest(); break;
            case "Decline Quest": declineMerchantQuest(); break;
            case "quest_1": merchQuest_1(); break;
            case "Right_Turn": RightTurn_Merchant(); break;
            case "investigate_Further": RightTurn_Merchant_Part2(); break;
            case "cave_Entrance": cave_Entrance(); break;
            //Fight & Attack Ogre
            case "ogre_Fight": ogre_Fight(); break;
            case "playerAttack": playerAttack_Ogre(); break;
            case "ogreAttack": ogreAttack_Player(); break;
            case "ogreDefeated": ogreDefeated(); break;
            case "playerDefeated": playerDefeated_ByOgre(); break;

            //After defeating Ogre
            case "pathway": cave_PathLeftRight_Turn(); break;
            case "cave_RightTurn": cave_RightTurn(); break;
            case "cave_LeftTurn": cave_LeftTurn();break;

            //Fighting the ogre BOSS.
            case "playerAttack_BOSS": player_AttackOgreBOSS(); break;
            case "ogreBOSS_AttackPlayer": ogreBOSS_AttackPlayer(); break;
            case "playerDefeatsBOSS": playerDefeats_OgreBOSS(); break;
            case "bossDefeatsPlayer": ogreBOSSdefeats_Player(); break;

            case "Exit Town": exitTown_MerchQuest();break;
        }
    }

    //This is begin of story!
    public void townGate(){
        ui.mainTextArea.setText("You are at the town of gate.\n Guard is standing in front of entrance.\n What do you do?");
        ui.choice1.setText("Talk to the Guard");
        ui.choice2.setText("Attack the Guard");
        ui.choice3.setText("Leave Entrance");
        ui.choice4.setText("");


        game.nextPosition1 = "Talk to the Guard";
        game.nextPosition2 = "Attack the Guard";
        game.nextPosition3 = "crossroad";
        game.nextPosition4 = "";
    }

    public void talkGuard(){
        if(SilverRing == 0){
            ui.mainTextArea.setText("Guard: Hello Stranger, You are not permitted to enter our town at this time.");
            ui.choice1.setText("Leave");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "townGate";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if(SilverRing == 1){
            ending();
        }
    }

    public void attackGuard(){
        ui.mainTextArea.setText("Guard: I am sorry traveler you may not enter our town at this time.\n (You have lost 3 from your health)");
        Player.hp = Player.hp - 3;
        ui.hpNumberLabel.setText("" + Player.hp);
        ui.choice1.setText("Leave Entrance");
        ui.choice2.setText("");
        ui.choice3.setText("");

        game.nextPosition1 = "townGate";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void crossRoad(){
        ui.mainTextArea.setText("You have now came across a crossroad.\n Heading South is heading back to the town.\n You can choose one of the three paths.");
        ui.choice1.setText("Go North");
        ui.choice2.setText("Go East");
        ui.choice3.setText("Go West");
        ui.choice4.setText("Town Gate");

        game.nextPosition1 = "North";
        game.nextPosition2 = "East";
        game.nextPosition3 = "West";
        game.nextPosition4 = "townGate";
    }

    public void North(){
        ui.mainTextArea.setText("You arrive at the riverside.\n As you drink from the sacred water.\n (Your health is healed)");
        Player.hp = (Player.hp + new java.util.Random().nextInt(30));
        ui.hpNumberLabel.setText("" + Player.hp);
        ui.choice1.setText("Leave");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossroad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void East(){
        int rand = new java.util.Random().nextInt(100);
        if(rand < 55){
            Player.currentWeapon = new longSword();
        }
        else{
            Player.currentWeapon = new twoHanded_Axe();
        }
        ui.mainTextArea.setText("You have encountered a weapon on the floor of some sort.\n You have received a " + Player.currentWeapon.name);
        //Player.currentWeapon = new longSword(); //To change the weapon of the player.
        ui.weaponNameLabel.setText(Player.currentWeapon.name);
        ui.choice1.setText("Go West");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossroad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void West(){
        int i = new java.util.Random().nextInt(100); //It is going to pick a number between 1 & 100!
        if(i < 25){
            monster = new goblin();
        }
        else if (i < 55){
            monster = new troll();
        }
        else{
            monster = new spider();
        }
        //monster = new goblin(); //REMINDER: YOu can do this to get monster on this path.
        ui.mainTextArea.setText("You have encountered a " + monster.name + "!");
        ui.choice1.setText("Fight");
        ui.choice2.setText("Run Away");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "fight";
        game.nextPosition2 = "crossroad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void fight(){
        ui.mainTextArea.setText(monster.name + ": " + monster.hp + "\n\nWhat do you do?");
        ui.choice1.setText("Fight");
        ui.choice2.setText("Run Away");
        ui.choice3.setText("");

        game.nextPosition1 = "Attack";
        game.nextPosition2 = "crossroad";
        game.nextPosition3 = "";
        //game.nextPosition4 = "";
    }

    public void playerAttack(){
        int playerDmg = new java.util.Random().nextInt(Player.currentWeapon.damage); //So it will pick up a damage base on the type of weapon.

        ui.mainTextArea.setText("You attacked " + monster.name + " and gave " + playerDmg + " points of damage.");

        monster.hp = monster.hp - playerDmg;
        ui.mainTextArea.setText(monster.name + ": " + monster.hp);
        ui.choice1.setText("Attack");
        ui.choice2.setText("Leave");
        ui.choice3.setText("");


        if(monster.hp > 0){
            ui.mainTextArea.setText("You attacked " + monster.name + " and gave " + playerDmg + " points of damage.");
            game.nextPosition1 = "monsterAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if(monster.hp < 1){
            ui.mainTextArea.setText("You defeated the " + monster.name);
            game.nextPosition1 = "win";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        game.nextPosition2 = "crossroad";
    }

    public void monsterAttack(){
        int monsterDamage = new java.util.Random().nextInt(monster.attack);

        //REMINDER: This is to display the message of the attack.
        ui.mainTextArea.setText(monster.attack_Message + "\n You received " + monsterDamage + " points of damage.");

        Player.hp = Player.hp - monsterDamage;
        ui.mainTextArea.setText(monster.name + ": " + monster.hp);
        ui.hpNumberLabel.setText("" + Player.hp);

        ui.choice1.setText("Attack");
        ui.choice2.setText("Leave");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if(Player.hp > 0){
            Player.hp = Player.hp - monsterDamage;
            ui.mainTextArea.setText(monster.attack_Message +"\n You recieved " + monsterDamage + " points of damage.");
            game.nextPosition1 = "Attack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if(Player.hp < 1){
            game.nextPosition1 = "lose";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        game.nextPosition2 = "crossroad";
    }

    public void win(){
        ui.mainTextArea.setText("You have defeated the " + monster.name + "!\nThe monster dropped a ring!\n\n (You have obtained a Silver Ring)");
        SilverRing = 1;
        ui.choice1.setText("Leave");
        ui.choice2.setText("");
        ui.choice3.setText("");

        game.nextPosition1 = "crossroad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        //game.nextPosition4 = "";
    }

    public void lose(){
        ui.mainTextArea.setText("You have died!\n\n Game Over!");
        ui.choice1.setText("Main Menu");
        ui.choice2.setText("");
        ui.choice3.setText("");

        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        //game.nextPosition4 = "";
    }

    //Ending of the first story!
    public void ending(){
        ui.mainTextArea.setText("Guard: You have defeated the goblin that haunts our town!\n It seems you are worthy of being the hero of our town!\n\n Welcome to our town\n THE END");
        ui.choice1.setText("Enter Town");
        ui.choice2.setText("Main Menu");

        game.nextPosition1 = "Enter Town";
        game.nextPosition2 = "toTitle";
        //game.nextPosition2 = "townGate";


        ui.choice1.setVisible(true);
        //ui.choice2.setVisible(false);
        //ui.choice3.setVisible(false);
        //ui.choice4.setVisible(false);
    }

    //Beginning of the actual storyline!
    public void enterTownGate(){
        ui.mainTextArea.setText("You have entered the town.\n You have came across two path.\n");

        ui.choice1.setText("Talk to Merchant");
        ui.choice2.setText("Talk to Blacksmith");
        ui.choice3.setText("Leave quad area?");

        game.nextPosition1 = "Talk to Merchant";
        game.nextPosition2 = "Talk to Blacksmith";
        game.nextPosition3 = "townGate";
    }

    public void talkToMerchant(){
        ui.mainTextArea.setText("Hello hero of this town.\n I have a quest for you.\n Do you want to accept.");

        ui.choice1.setText("Accept Quest");
        ui.choice2.setText("Decline Quest");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "Accept Quest";
        game.nextPosition2 = "Decline Quest";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void acceptMerchantQuest(){
        ui.mainTextArea.setText("I sent my son into the forest to grab me some herbs, but he has not came back for awhile now.\n So i am worried that some thing might have happened to him. I need you to go check on him.");


        ui.choice1.setText("Okay");
        ui.choice2.setText("");

        game.nextPosition1 = "Exit Town";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void exitTown_MerchQuest(){
        ui.mainTextArea.setText("Do you want to leave town? \n To embark on your journey");


        ui.choice1.setText("Leave Town");
        ui.choice2.setText("Not Yet");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "quest_1";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void declineMerchantQuest(){
        ui.mainTextArea.setText("Got'cha, I'll see you around traveler");
        //The text on choices
        ui.choice1.setText("Okay");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        //This is the decision that is made when choosing what to do!
        game.nextPosition1 = "Enter Town";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void merchQuest_1(){
        ui.mainTextArea.setText("(Checkpoint updated!)\nyou come across a path where you must decide to go next!\n At the entrance of the gate");
        ui.choice1.setText("Right Turn");
        ui.choice2.setText("Left Turn");
        ui.choice3.setText("Go back to town");
        ui.choice4.setText("");

        game.nextPosition1 = "Right_Turn";
        game.nextPosition2 = "Left Turn";
        game.nextPosition3 = "townGate";
        game.nextPosition4 = "";
    }

    public void RightTurn_Merchant(){
        ui.mainTextArea.setText("You have now made a right turn, and you see some foot steps of a person... \n Then you investigate further to, discover an object on the floor \n You have now obtained a necklace. Which may lead to more clues.");

        ui.choice1.setText("Investigate Some More");
        ui.choice2.setText("Leave Path");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "investigate_Further";
        game.nextPosition2 = "quest_1";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void RightTurn_Merchant_Part2(){
        ui.mainTextArea.setText("As you walk further into the forest you see giant footsteps becoming more recent \n then to find yourself upon a newly creature! \n You find yourself in front of the den of an ogre.");

        ui.choice1.setText("Keep Moving");
        ui.choice2.setText("Leave Cave");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "cave_Entrance";
        game.nextPosition2 = "quest_1";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void cave_Entrance(){
        ui.mainTextArea.setText("You have entered a cave, and you see a creature near you in the cave.\n Do you want to enter the cave?");

        ui.choice1.setText("Enter Cave");
        ui.choice2.setText("Leave");
        ui.choice3.setText("");
        ui.choice1.setText("");

        game.nextPosition1 = "ogre_Fight";
        game.nextPosition2 = "investigate_Further";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void ogre_Fight(){
        monster = new ogres();
        ui.mainTextArea.setText("You have encountered a new creature!\n Oh! You have encountered an Ogre!\n Do you want to attack?\n");

        ui.choice1.setText("Fight");
        ui.choice2.setText("Leave");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "playerAttack";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void playerAttack_Ogre(){
        int playerDmg = new java.util.Random().nextInt(Player.currentWeapon.damage);


        ui.mainTextArea.setText(monster.name + " HP: " + monster.hp);

        ui.choice1.setText("Attack");
        ui.choice2.setText("Run Away");
        ui.choice3.setText("");
        ui.choice4.setText("");

        ui.mainTextArea.setText("You attacked " + monster.name + " and gave " + playerDmg + " points of damage.");

        monster.hp = monster.hp - playerDmg;
        ui.mainTextArea.setText(monster.name + ": " + monster.hp);
        ui.choice1.setText("Attack");
        ui.choice2.setText("Leave");
        ui.choice3.setText("");


        if(monster.hp > 0){
            ui.mainTextArea.setText("You attacked " + monster.name + " and gave " + playerDmg + " points of damage.");
            monster.hp = monster.hp - playerDmg;
            ui.mainTextArea.setText("HP: " + monster.hp);
            game.nextPosition1 = "ogreAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if(monster.hp < 1){
            ui.mainTextArea.setText("You defeated the " + monster.name);
            game.nextPosition1 = "ogreDefeated";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        game.nextPosition2 = "cave_Entrance";
    }

    public void ogreAttack_Player(){
        //monster = new ogres();
        int monsterDamage = new java.util.Random().nextInt(monster.attack);

        //REMINDER: This is to display the message of the attack.
        ui.mainTextArea.setText(monster.name + "HP: " + monster.hp + "\n" + monster.attack_Message + "\n You received " + monsterDamage + " points of damage.");

        Player.hp = Player.hp - monsterDamage;
        ui.mainTextArea.setText(monster.name + ": " + monster.hp);
        ui.hpNumberLabel.setText("" + Player.hp);

        ui.choice1.setText("Attack");
        ui.choice2.setText("Leave");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if(Player.hp > 0){
            Player.hp = Player.hp - monsterDamage;
            ui.mainTextArea.setText(monster.attack_Message +"\n You received " + monsterDamage + " points of damage.");
            game.nextPosition1 = "playerAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if(Player.hp < 1){
            game.nextPosition1 = "playerDefeated";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        game.nextPosition2 = "cave_Entrance";
    }

    public void ogreDefeated(){
        ui.mainTextArea.setText("You have defeated the " + monster.name + "\n" + "You have obtained an item!" + "\n\n" + "It is a Thief Knife!\n" + "Do you want to continue?");
        merchQuest_ItemLOOT1 = 1;

        ui.choice1.setText("Continue");
        ui.choice2.setText("Go back to Town");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "";
        game.nextPosition2 = "Enter Town";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void playerDefeated_ByOgre(){
        ui.mainTextArea.setText("You have died.\n\n");

        ui.choice1.setText("Continue to Checkpoint");
        ui.choice2.setText("Back to Title");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "quest_1";
        game.nextPosition2 = "toTitle";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void cave_PathLeftRight_Turn(){
        ui.mainTextArea.setText("You come across a path that gives you an option to turn right or left\n" + "Do you want to turn Right or Left?");

        ui.choice1.setText("Take a right turn");
        ui.choice2.setText("Take a Left Turn");
        ui.choice3.setText("Go back to cave Entrance");
        ui.choice4.setText("");

        game.nextPosition1 = "cave_RightTurn";
        game.nextPosition2 = "cave_LeftTurn";
        game.nextPosition3 = "cave_Entrance";
        game.nextPosition4 = "";

    }
    public void cave_RightTurn(){
        ui.mainTextArea.setText("");
    }

    public void cave_LeftTurn(){
        monster = new ogreLeaderBOSS_1();
        ui.mainTextArea.setText("You see the missing son in a cage, but near him you see the leader of the Ogres.\n"
                + "standing near him, as he looks behind him, he sees you in front of the giant tyrant!\n Do you want to Fight the BOSS?");

        ui.choice1.setText("Fight BOSS");
        ui.choice2.setText("Run Away!");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void player_AttackOgreBOSS(){
        int playerDmg = new java.util.Random().nextInt(Player.currentWeapon.damage);

    }
    public void ogreBOSS_AttackPlayer(){
        int monsterDmg = new java.util.Random().nextInt(monster.attack + monster.currentWeapon);

    }

    public void playerDefeats_OgreBOSS(){

    }

    public void ogreBOSSdefeats_Player(){

    }






    //This will set everything back to the default setting, and the title screen again.
    public void toTitle(){
        vm.showTitleScreen();
        vm.titleToTown();
        defaultSetup();
        townGate();
    }
}