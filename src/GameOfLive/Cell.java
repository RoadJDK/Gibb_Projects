package GameOfLive;

public class Cell {
    public boolean isAlive = false;

    public Cell() {

    }

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isAlive() {
        return this.isAlive;
    }
}
