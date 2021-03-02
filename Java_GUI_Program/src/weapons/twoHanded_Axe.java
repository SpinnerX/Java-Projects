package weapons;

public class twoHanded_Axe extends superWeapon{
    public twoHanded_Axe(){
        name = "Axe";
        damage = new java.util.Random().nextInt(60);
    }
}
