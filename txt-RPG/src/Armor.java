public class Armor {

    private int id;
    private String name;
    private int defenseValue;
    private int price;


    public Armor(int id, String name, int defenseValue, int price) {
        this.id = id;
        this.name = name;
        this.defenseValue = defenseValue;
        this.price = price;
    }

    public static Armor[] armors(){
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor(1,"Hafif",2,15);
        armorList[1] = new Armor(2,"Orta",3,25);
        armorList[2] = new Armor(3,"Ağır",7,40);

        return armorList;
    }

    public static Armor getArmorByID(int id){

        for(Armor a : Armor.armors()){
            if (a.getId() == id){
                return a;
            }
        }
        return null;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefenseValue() {
        return defenseValue;
    }

    public void setDefenseValue(int defenseValue) {
        this.defenseValue = defenseValue;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
