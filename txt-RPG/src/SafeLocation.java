public abstract class SafeLocation extends Location{


    public SafeLocation ( Player player, String name){
        super(player,name);
    }


    @Override
    public boolean onLocation() {
        return true;
    }
}
