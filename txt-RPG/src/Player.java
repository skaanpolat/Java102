import java.util.Scanner;

public class Player {

    Scanner scanner = new Scanner(System.in);

    private String name;
    private String playerCharName;
    private int playerDamage;
    private int playerHealth;
    private int playerBaseHealth;
    private int playerMoney;
    private int playerCharChoice;
    private Inventory inventory;


    Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void charSelector() {
        GameChar[] gameChars = {new Samurai(), new Archer(), new Knight()};

        for (GameChar gameChar : gameChars) {
            gameChar.showCharInfo();
        }
        setPlayerCharChoice(scanner.nextInt());

        switch (getPlayerCharChoice()) {

            case 1:
                playerSetter(new Samurai());
                showPlayerInfo();
                break;

            case 2:
                playerSetter(new Archer());
                showPlayerInfo();
                break;

            case 3:
                playerSetter(new Knight());
                showPlayerInfo();
                break;

            default:
                System.out.println("\nGeçerli bir seçim yapmadınız!!\nVarsayılan olarak atanan seçim ŞOVALYE\n\n");
                playerSetter(new Knight());
                showPlayerInfo();

        }

    }

    public void playerSetter(GameChar gameChar) {
        this.setPlayerCharName(gameChar.getCharName());
        this.setPlayerDamage(gameChar.getCharDamage());
        this.setPlayerBaseHealth(gameChar.getCharHealth());
        this.setPlayerHealth(gameChar.getCharHealth());
        this.setPlayerMoney(gameChar.getCharMoney());

    }

    public void showPlayerInfo() {
        System.out.println("Oyuncu adı : " + this.getPlayerName() +
                "\nKarakter : " + this.getPlayerCharName() +
                "\nSağlık : " + this.getPlayerHealth() +
                "\nHasar : " + this.getPlayerDamage() +
                "\nPara : " + this.getPlayerMoney() + "\n");
    }

    public void shortPlayerInfo() {
        System.out.println("\n--------------OYUNCU DURUMU--------------\n" +
                "\nKarakter : " + this.getPlayerCharName() +
                "\nSağlık : " + this.getPlayerHealth() +
                "\nHasar : " + (this.getPlayerDamage()) +
                "\nPara : " + this.getPlayerMoney() +
                "\nMevcut Silah : " + this.getInventory().getWeapon().getName() +
                "\nMevcut Zırh : " + this.getInventory().getArmor().getName() +
                "\n-----------------------------------------\n\n");
    }


    public String getPlayerName() {
        return name;
    }

    public void setPlayerName(String name) {
        this.name = name;
    }

    public String getPlayerCharName() {
        return playerCharName;
    }

    public void setPlayerCharName(String playerCharName) {
        this.playerCharName = playerCharName;
    }

    public int getPlayerCharChoice() {
        return playerCharChoice;
    }

    public void setPlayerCharChoice(int playerCharChoice) {
        this.playerCharChoice = playerCharChoice;
    }

    public int getPlayerDamage() {
        return playerDamage + this.getInventory().getWeapon().getDamage();
    }

    public void setPlayerDamage(int charDamage) {
        this.playerDamage = charDamage;
    }

    public int getPlayerHealth() {
        return playerHealth + this.getInventory().getArmor().getDefenseValue();
    }

    public void setPlayerHealth(int charHealth) {
        this.playerHealth = charHealth;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }

    public void setPlayerMoney(int charMoney) {
        this.playerMoney = charMoney;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getPlayerBaseHealth() {
        return playerBaseHealth;
    }

    public void setPlayerBaseHealth(int playerBaseHealth) {
        this.playerBaseHealth = playerBaseHealth;
    }
}
