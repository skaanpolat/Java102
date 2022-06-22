public class Forest extends UnsafeLocation {


    public Forest(Player player) {
        super(player, "Orman", new Vampire(), "Odun",3);
    }


    @Override
    public boolean onLocation() {
        return super.onLocation();

    }


    @Override
    public boolean combat(int ranMobQty) {
        return super.combat(ranMobQty);
    }

}
