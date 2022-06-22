public class SafeHouse extends SafeLocation{



    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Bulunduğunuz Mekan : Güvenli Ev\nCan yenilendi.\n");
        this.getPlayer().setPlayerHealth(this.getPlayer().getPlayerBaseHealth());

        return true;
    }
}
