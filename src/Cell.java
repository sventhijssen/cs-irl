import java.util.LinkedList;
import java.util.List;

public class Cell
{

    public Cell(int row, int column, GridWorld gridWorld)
    {
        this.row = row;
        this.column = column;
        this.gridWorld = gridWorld;
    }

    public List<Transition> getTransitions()
    {
        List<Transition> neighbours = new LinkedList<>();

        // We only add neighbours to the right or down below
        // to avoid loops
        if(row < gridWorld.getRows()-1)
            neighbours.add(new Transition(gridWorld.getCell(row+1, column)));
        if(row > 0)
            neighbours.add(new Transition(gridWorld.getCell(row-1, column)));
        if(column < gridWorld.getColumns()-1)
            neighbours.add(new Transition(gridWorld.getCell(row, column+1)));
        if(column > 0)
            neighbours.add(new Transition(gridWorld.getCell(row, column-1)));

        int n =neighbours.size();
        for (Transition neighbour : neighbours)
        {
            neighbour.setProbability((double)1/n);
        }
        return neighbours;
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

    private GridWorld gridWorld;
}
