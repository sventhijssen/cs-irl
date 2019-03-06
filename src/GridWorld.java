import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GridWorld
{
    public GridWorld(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        this.gridworld =  new Cell[rows][columns];
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                gridworld[i][j] = new Cell(i, j, this);
            }
        }
    }

    public GridWorld(Cell[][] gridworld)
    {
        this.gridworld = gridworld;
    }

    public void createPuddle(int row, int column)
    {
        this.gridworld[row][column].setType(CellType.PUDDLE);
    }

    public void createGoal(int row, int column)
    {
        this.gridworld[row][column].setType(CellType.GOAL);
    }

    public Policy generateRandomPolicy()
    {
        Policy policy = new Policy(this);
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                policy.addTransitions(i, j, Math.random(), Math.random(), Math.random(), Math.random());
            }
        }
        return policy;
    }

    @Override
    public GridWorld clone()
    {
        return new GridWorld(this.gridworld.clone());
    }

    private Cell[][] gridworld;

    private int rows;
    private int columns;

    public int getRows()
    {
        return this.rows;
    }

    public int getColumns()
    {
        return columns;
    }

    public Cell getCell(int row, int column)
    {
        return gridworld[row][column];
    }
}
