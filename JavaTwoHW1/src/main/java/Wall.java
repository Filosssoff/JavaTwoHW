public class Wall implements JustDoIT{
    private static final int MAX_HEIGHT = 25;

    private String id;
    private int height;

    public Wall(String id, int height) {
        this.id = id;
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public int getHeight() {
        return height;
    }

    public static int getMaxHeight() {
        return MAX_HEIGHT;
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
