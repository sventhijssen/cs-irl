public class Cell
{

    public Cell(int row, int column)
    {
        this.row = row;
        this.column = column;
    }

    public int getRow()
    {
        return row;
    }

    public int getColumn()
    {
        return column;
    }

    public void setType(CellType type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "( " + this.row + ", " + this.column + " )";
    }

    private int row;
    private int column;

    private CellType type = CellType.DEFAULT;

    private double reward = Math.random();
}
