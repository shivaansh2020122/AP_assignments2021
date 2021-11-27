public final class player {
    private final bucket buckets;
    private int pos;
    public player(){
        buckets = new bucket();
        pos=0;
    }
    public void addinbuck(softToy toy){
        buckets.add(toy);
    }
    public void setPos(int i){
        this.pos=i;
    }
    public void prbucket(){
        buckets.pr();
    }

}
