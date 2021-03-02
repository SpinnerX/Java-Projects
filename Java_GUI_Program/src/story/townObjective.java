package story;
import com.company.Main;
import game_Setup.UI;
import game_Setup.*;
import monsterCreatures.*;
import player.*;
import weapons.*;

public class townObjective extends storylineChapter_1{
    Main game;
    UI ui;
    visibilityManager vm;
    player Player;
    superMonster monster;
    int swordLoot;

    public townObjective(Main g, UI userInterface, visibilityManager vManager){
        game = g;
        ui = userInterface;
        vm = vManager;
    }

    public void selectionPosition(String nextPosition){
        switch (nextPosition){
            case "Enter Town": enterTownGate(); break;
            case "Talk to Merchant": talkToMerchant(); break;
            case "Talk to Blacksmith": break;
            case "Accept Quest": acceptMerchantQuest(); break;
            case "Decline Quest": declineMerchantQuest(); break;
        }
    }

    public void enterTownGate(){
        ui.mainTextArea.setText("You have entered the town.\n You have came across two path.\n");

        ui.choice1.setText("Talk to Merchant");
        ui.choice2.setText("Talk to Blacksmith");

        game.nextPosition1 = "Talk to Merchant";
        game.nextPosition2 = "Talk to Blacksmith";
    }

    public void talkToMerchant(){
        ui.mainTextArea.setText("Hello hero of this town.\n I have a quest for you.\n Do you want to accept.");

        ui.choice1.setText("Accept Quest");
        ui.choice2.setText("Decline Quest");

        game.nextPosition1 = "Accept Quest";
        game.nextPosition2 = "Decline Quest";
    }

    public void acceptMerchantQuest(){
        ui.mainTextArea.setText("I sent my son into the forest to grab me some herbs, but he has not came back for awhile now.");
        ui.mainTextArea.setText("So i am worried that some thing might have happened to him. I need you to go check on him.");

        ui.choice1.setText("Okay");
        ui.choice2.setText("");

        game.nextPosition1 = "Okay";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void declineMerchantQuest(){
        ui.mainTextArea.setText("Got'cha, Ill see you around traveler");

        ui.choice1.setText("Okay");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "enterTownGate";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }


}