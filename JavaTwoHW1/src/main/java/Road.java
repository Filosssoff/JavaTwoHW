public class Road implements JustDoIT{
    private static final int MAX_LENGTH = 25;

    private String id;
    private int length;

    public Road(String id, int length) {
        this.id = id;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public String getId() {
        return id;
    }

    public static int getMaxLength() {
        return MAX_LENGTH;
    }

    public void run() {

    }

    public void jump() {

    }

    @Override
    public void run(Road road) {

    }

    @Override
    public void jump(Wall wall) {

    }

}
