public class Cell
{

    public Cell(int row, int column)
    {
        this.row = row;
        this.column = column;
    }

    public Vector getFeatures()
    {
        if(this.type == CellType.DEFAULT)
            return new Vector(new double[]{1, 0, 0});
        else if(this.type == CellType.PUDDLE)
            return new Vector(new double[]{0, 1, 0});
        else
            return new Vector(new double[]{0, 0, 1});
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

    public CellType getType()
    {
        return this.type;
    }

    @Override
    public String toString()
    {
        return "(" + this.row + ", " + this.column + ")";
    }

    private int row;
    private int column;

    private CellType type = CellType.DEFAULT;

    private double reward = Math.random();
}
