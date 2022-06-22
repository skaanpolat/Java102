import java.util.Random;

public class Snake extends Enemy {


    public Snake() {
        super(4, "Yılan", 0, 12, 0);
        this.setEnemyDamage(randomDamage());
        super.setEnemyAward("NaN");

    }

    public int randomDamage() {
        Random random = new Random();
        int range = 6 - 3 + 1;
        return (random.nextInt(range) + 3);
    }




}
