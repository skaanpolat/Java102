public class Inventory {

    Weapon weapon;
    Armor armor;
    private boolean isFood = false;
    private boolean isWood = false;
    private boolean isWater = false;


    public Inventory () {
        this.weapon = new Weapon("Yumruk", 0, 0 , 0 );
        this.armor = new Armor(0,"Yok",0,0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public boolean isFood() {
        return isFood;
    }

    public boolean isWood() {
        return isWood;
    }

    public boolean isWater() {
        return isWater;
    }

    public void setFood(boolean food) {
        this.isFood = food;
    }

    public void setWood(boolean wood) {
        this.isWood = wood;
    }

    public void setWater(boolean water) {
        this.isWater = water;
    }
}
