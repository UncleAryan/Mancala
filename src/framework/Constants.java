package framework;

public class Constants {
    public static final int HEIGHT = 600;
    public static final int WIDTH = 800;

    // divided by 10 to account for 2 pits and empty space
    public static int HOLE_WIDTH = WIDTH / 10;
    public static int HOLE_HEIGHT = HEIGHT / 10;

    public static int PIT_WIDTH = HOLE_WIDTH;
    public static int PIT_HEIGHT = HOLE_HEIGHT * 2;

    public static int BIG_HOLE_FONT_SIZE = PIT_HEIGHT / 3;
    public static int HOLE_FONT_SIZE = HOLE_HEIGHT / 2;
}
