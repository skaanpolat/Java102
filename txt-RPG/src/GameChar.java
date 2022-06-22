public abstract class GameChar {

    private final int charID;
    private String charName;
    private int charDamage;
    private int charHealth;
    private int charMoney;


    public GameChar(int charID, String charName, int charDamage, int charHealth, int charMoney) {
        this.charID = charID;
        this.charName = charName;
        this.charDamage = charDamage;
        this.charHealth = charHealth;
        this.charMoney = charMoney;
    }


    public void showCharInfo(){
        System.out.println( getCharID() + ") " + getCharName() +" => Sağlık : "+ getCharHealth() + " | Hasar : " + getCharDamage()+ " |Para : " + getCharMoney());
    }

    public int getCharID() {
        return charID;
    }

    public String getCharName() {
        return charName;
    }

    public int getCharDamage() {
        return charDamage;
    }

    public int getCharHealth() {
        return charHealth;
    }

    public int getCharMoney() {
        return charMoney;
    }


}
