/**
 * Created by Venelin on 27.4.2017 г..
 */
public class Cell {

    private int row;
    private int col;
    private int step;

    public Cell(int row, int col, int step) {
        this.row = row;
        this.col = col;
        this.step = step;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
