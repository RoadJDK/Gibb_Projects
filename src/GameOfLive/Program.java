package GameOfLive;

public class Program {
    private static Game game;

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        game = new Game();
        game.run();
    }
}
