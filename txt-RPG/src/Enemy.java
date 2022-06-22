public abstract class Enemy {

    private final int enemyID;
    private String enemyName;
    private int enemyDamage;
    private int enemyHealth;
    private int enemyMoney;
    private int enemyBaseHealth;
    private String enemyAward;


    public Enemy(int enemyID, String enemyName, int enemyDamage, int enemyHealth, int enemyMoney) {
        this.enemyID = enemyID;
        this.enemyName = enemyName;
        this.enemyDamage = enemyDamage;
        this.enemyHealth = enemyHealth;
        this.enemyBaseHealth = enemyHealth;
        this.enemyMoney = enemyMoney;
    }



    public int getEnemyID() {
        return enemyID;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public int getEnemyDamage() {
        return enemyDamage;
    }

    public void setEnemyDamage(int enemyDamage) {
        this.enemyDamage = enemyDamage;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public void setEnemyHealth(int enemyHealth) {
        if(enemyHealth<0){
            enemyHealth = 0;
        }
        this.enemyHealth = enemyHealth;
    }

    public int getEnemyMoney() {
        return enemyMoney;
    }

    public void setEnemyMoney(int enemyMoney) {
        this.enemyMoney = enemyMoney;
    }

    public int getEnemyBaseHealth() {
        return enemyBaseHealth;
    }

    public String getEnemyAward() {
        return enemyAward;
    }

    public void setEnemyAward(String enemyAward) {
        this.enemyAward = enemyAward;
    }
}
