package game_Setup;

public class visibilityManager {
    UI ui;

    //Constructor
    public visibilityManager(UI userInterface){
        ui = userInterface;
    }


    public void showTitleScreen(){
        //This is to show the title screen!
        ui.titleNameLabel.setVisible(true);
        ui.startButton.setVisible(true);

        //To hide the game screen
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
    }

    public void titleToTown(){

        //Hide the title screen
        ui.titleNamePanel.setVisible(false);
        ui.startButton.setVisible(false);

        //Show game screen
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
    }

}