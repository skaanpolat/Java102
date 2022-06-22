import java.util.Random;

public abstract class UnsafeLocation extends Location {

    private Enemy enemy;
    private String award;
    private int maxEnemyQuantity = 3;
    private int ranMobQty = this.randomEnemyQuantity();

    public UnsafeLocation(Player player, String name, Enemy enemy, String award, int maxEnemyQuantity) {
        super(player, name);
        this.enemy = enemy;
        this.award = award;
        this.maxEnemyQuantity = maxEnemyQuantity;
    }


    @Override
    public boolean onLocation() {

        System.out.println("Bulunduğunuz Mekan : " + this.getName().toUpperCase() + "!\n" +
                "Burada " + getRanMobQty() + " adet " + this.getEnemy().getEnemyName() + " olduğu biliniyor..\n" +
                "Ne yapacağına karar vermelisin!\n" +
                "\n1) Savaş\n" +
                "2) Uzaklaş\n");

        int actionChoice = scanner.nextInt();

        if (actionChoice == 1 && combat(getRanMobQty())) {
            System.out.println("Tüm düşmanları yendin !");


            if (this.getEnemy().getEnemyAward().equals("Yemek")) {
                this.getPlayer().getInventory().setFood(true);
                System.out.println("Bu mekandaki tüm düşmanları temizlediğin için ödülün  : YEMEK\n");
                return true;
            }
            if (this.getEnemy().getEnemyAward().equals("Odun")) {
                this.getPlayer().getInventory().setWood(true);
                System.out.println("Bu mekandaki tüm düşmanları temizlediğin için ödülün  : ODUN\n");
                return true;
            }
            if (this.getEnemy().getEnemyAward().equals("Su")) {
                this.getPlayer().getInventory().setWater(true);
                System.out.println("Bu mekandaki tüm düşmanları temizlediğin için ödülün  : SU\n");
                return true;
            }

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
//                combat(this.getPlayer(), this.getEnemy());
                combat(getRanMobQty());
                break;
        }

        return true;
    }


    public boolean combat(int ranMobQty) {

        for (int i = 1; i <= ranMobQty; i++) {
            int randomFirstAttack = randomFirstAttack();
            this.getEnemy().setEnemyHealth(this.getEnemy().getEnemyBaseHealth());
            this.getPlayer().shortPlayerInfo();
            this.enemyStats(i);

            while (this.getPlayer().getPlayerHealth() > 0 && this.getEnemy().getEnemyHealth() > 0) {
                System.out.println("\n1)Saldır\n" +
                        "2)Kaç\n");
                int combatChoice = scanner.nextInt();


                if (combatChoice == 1) {


                    if (randomFirstAttack > 50) {

                        System.out.println(this.getPlayer().getPlayerCharName() + " SALDIRIYOR!");

                        this.getEnemy().setEnemyHealth(this.getEnemy().getEnemyHealth() - this.getPlayer().getPlayerDamage());
                        System.out.println("------------------------------------------");
                        this.enemyStats(i);
                        System.out.println("------------------------------------------");

                        if (this.getEnemy().getEnemyHealth() > 0) {

                            System.out.print("\n\n" + this.getEnemy().getEnemyName() + "  SALDIRIYOR!");

                            this.getPlayer().setPlayerHealth(this.getPlayer().getPlayerHealth() - this.getEnemy().getEnemyDamage());

                            getPlayer().shortPlayerInfo();
                        }

                    } else if (randomFirstAttack <= 50) {

                        System.out.println(this.getEnemy().getEnemyName() + " SALDIRIYOR!");

                        this.getPlayer().setPlayerHealth(this.getPlayer().getPlayerHealth() - this.getEnemy().getEnemyDamage());

                        getPlayer().shortPlayerInfo();

                        if (this.getPlayer().getPlayerHealth() > 0) {

                            System.out.println(this.getPlayer().getPlayerCharName() + " SALDIRIYOR!");

                            this.getEnemy().setEnemyHealth(this.getEnemy().getEnemyHealth() - this.getPlayer().getPlayerDamage());
                            System.out.println("------------------------------------------");
                            this.enemyStats(i);
                            System.out.println("------------------------------------------");

                        }

                    }

                } else {
                    return false;
                }

            }
            if (this.getEnemy().getEnemyHealth() <= 0) {
                System.out.println(i + ". Düşmanı yendin! ");
                System.out.println(this.getEnemy().getEnemyMoney() + " para kazandın!");
                this.getPlayer().setPlayerMoney(this.getPlayer().getPlayerMoney() + this.getEnemy().getEnemyMoney());
                System.out.println("Güncel para miktarın : " + this.getPlayer().getPlayerMoney());
            } else {
                return false;
            }

        }
        return true;
    }

    public void enemyStats(int i) {
        System.out.println(i + ". " + this.getEnemy().getEnemyName().toUpperCase() + " DURUMU : ");
        System.out.println("Sağlık : " + this.getEnemy().getEnemyHealth() +
                "\nHasar : " + this.getEnemy().getEnemyDamage() +
                "\nPara : " + this.getEnemy().getEnemyMoney());
    }

    public int randomEnemyQuantity() {
        Random random = new Random();
        return random.nextInt(this.getMaxEnemyQuantity()) + 1;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public String getAward() {
        return award;
    }

    public int getMaxEnemyQuantity() {
        return maxEnemyQuantity;
    }

    public void setMaxEnemyQuantity(int maxEnemyQuantity) {
        this.maxEnemyQuantity = maxEnemyQuantity;
    }

    public int getRanMobQty() {
        return ranMobQty;
    }

    public void setRanMobQty(int ranMobQty) {
        this.ranMobQty = ranMobQty;
    }

    public int randomFirstAttack() {
        Random random = new Random();

        return random.nextInt(101);

    }


}