public final class Tile {
    private final softToy soft;
    public Tile(softToy a){
        this.soft=a;
    }
    public softToy getSoft(){
        return this.soft;
    }
    public String getwhichToystr(){
        return this.soft.getStoy();
    }
}
