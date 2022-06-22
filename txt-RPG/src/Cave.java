public class Cave extends UnsafeLocation {

    public Cave(Player player) {
        super(player, "Mağara", new Zombie(), "Yemek", 3);
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
