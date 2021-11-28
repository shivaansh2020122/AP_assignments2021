public final class softToy implements Cloneable{
    private final String stoy;

    public softToy(String st) {
        this.stoy = st;
    }

    public String getStoy() {
        return stoy;
    }

    public softToy Clone(){
        try {
            softToy a=(softToy)super.clone();
            return a;
        }
        catch (CloneNotSupportedException a){
            return null;
        }
    }
}
