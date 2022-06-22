import java.util.Random;

public class Mine extends UnsafeLocation {

    private int randomSnakeQuantity = randomSnakeQuantity();

    public Mine(Player player) {
        super(player, "Maden", new Snake(), "award", 0);
        super.setMaxEnemyQuantity(randomSnakeQuantity);
    }

    @Override
    public boolean onLocation() {
        System.out.println("Bulunduğunuz Mekan : " + this.getName().toUpperCase() + "!\n" +
                "Burada " + randomSnakeQuantity() + " adet " + this.getEnemy().getEnemyName() + " olduğu biliniyor..\n" +
                "Ne yapacağına karar vermelisin!\n" +
                "\n1) Savaş\n" +
                "2) Uzaklaş\n");

        int actionChoice = scanner.nextInt();

        if (actionChoice == 1 && combat(randomSnakeQuantity())) {
            System.out.print("Şu an burada bulunan tüm düşmanları yendin ");
            itemLottery();
            System.out.println("\nAma merak etmene gerek yok. Daha sonra geldiğinde bu lanet yerde yenileri mutlaka olacaktır!!\n");

            return true;
        }

        if (this.getPlayer().getPlayerHealth() <= 0) {
            return false;
        }

        while (actionChoice > 2 || actionChoice < 1) {
            System.out.println("Geçerli bir seçim yapmalısınız! ");
            actionChoice = scanner.nextInt();

        }

        switch (actionChoice) {

            case 1:
                combat(randomSnakeQuantity());
                break;
        }

        return true;

    }

    @Override
    public boolean combat(int randomSnakeQuantity) {
        return super.combat(randomSnakeQuantity);
    }

    public void itemLottery() {
        Random random = new Random();
        int dice = random.nextInt(101);
        int innerDice;

        if (dice <= 44) {
            System.out.println(" ve üstlerinden hiç bir şey düşmedi!");
        }
        if (dice >= 45 && dice <= 60) {

            innerDice = random.nextInt(101);

            if (innerDice <= 50) {
                this.getPlayer().getInventory().setArmor(Armor.getArmorByID(1));
                System.out.println("ve " + this.getEnemy().getEnemyName() + " 'Hafif Zırh' düşürdü!");
            }
            if (innerDice > 50 && innerDice <= 80) {
                this.getPlayer().getInventory().setArmor(Armor.getArmorByID(2));
                System.out.println("ve " + this.getEnemy().getEnemyName() + " 'Orta Zırh' düşürdü!");
            }
            if (innerDice > 80 && innerDice <= 100) {
                this.getPlayer().getInventory().setArmor(Armor.getArmorByID(3));
                System.out.println("ve " + this.getEnemy().getEnemyName() + " 'Ağır Zırh' düşürdü!");

            }
        }

        if (dice > 60 && dice <= 75) {

            innerDice = random.nextInt(101);

            if (innerDice <= 50) {
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponByID(1));
                System.out.println("ve " + this.getEnemy().getEnemyName() + " Tabanca düşürdü!");
            }
            if (innerDice > 50 && innerDice <= 80) {
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponByID(2));
                System.out.println("ve " + this.getEnemy().getEnemyName() + " Kılıç düşürdü!");
            }
            if (innerDice > 80 && innerDice <= 100) {
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponByID(3));
                System.out.println("ve " + this.getEnemy().getEnemyName() + " Tüfek düşürdü!");

            }
        }

        if (dice > 75 && dice <= 100) {

            innerDice = random.nextInt(101);

            if (innerDice <= 50) {
                this.getPlayer().setPlayerMoney(this.getPlayer().getPlayerMoney() + 1);
                System.out.println("ve " + this.getEnemy().getEnemyName() + " 1 para düşürdü!");
                System.out.println("Güncel para miktarın : " + this.getPlayer().getPlayerMoney());
            }
            if (innerDice > 50 && innerDice <= 80) {
                this.getPlayer().setPlayerMoney(this.getPlayer().getPlayerMoney() + 5);
                System.out.println("ve " + this.getEnemy().getEnemyName() + " 5 para düşürdü!");
                System.out.println("Güncel para miktarın : " + this.getPlayer().getPlayerMoney());
            }
            if (innerDice > 80 && innerDice <= 100) {
                this.getPlayer().setPlayerMoney(this.getPlayer().getPlayerMoney() + 10);
                System.out.println("ve " + this.getEnemy().getEnemyName() + " 10 para düşürdü!");
                System.out.println("Güncel para miktarın : " + this.getPlayer().getPlayerMoney());

            }
        }


    }

    public int randomSnakeQuantity() {
        Random random = new Random();
        int range = 5 - 1 + 1;
        return (random.nextInt(range) + 1);
    }

}
