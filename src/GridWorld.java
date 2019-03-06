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
        Policy policy = new Policy();
        Cell start = gridworld[0][0];
        Cell goal = gridworld[this.rows-1][this.columns-1];

        policy.add(start);

        Cell next = this.getRandomNeighbour(start, policy);

        policy.add(next);

        while(next != goal)
        {
            next = this.getRandomNeighbour(next, policy);
            policy.add(next);
        }

        return policy;
    }

    private Cell getRandomNeighbour(Cell cell, Policy policy)
    {
        int row = cell.getRow();
        int column = cell.getColumn();

        List<Cell> neighbours = new LinkedList<>();

        Cell neighbour;

        // We only add neighbours to the right or down below
        // to avoid loops
        if(row < this.rows-1)
        {
            neighbour = gridworld[row+1][column];
            if(!policy.contains(neighbour))
                neighbours.add(neighbour);
        }
        if(column < this.columns-1)
        {
            neighbour = gridworld[row][column+1];
            if(!policy.contains(neighbour))
                neighbours.add(neighbour);
        }

        Random rand = new Random();
        return neighbours.get(rand.nextInt(neighbours.size()));
    }

    private Cell getOptimalNeighbour(Cell cell, Policy policy)
    {
        int row = cell.getRow();
        int column = cell.getColumn();

        List<Cell> neighbours = new LinkedList<>();

        Cell neighbour;

        // We only add neighbours to the right or down below
        // to avoid loops
        if(row < this.rows-1)
        {
            neighbour = gridworld[row+1][column];
            if(!policy.contains(neighbour) && !neighbour.getType().equals(CellType.PUDDLE))
                neighbours.add(neighbour);
        }
        if(column < this.columns-1)
        {
            neighbour = gridworld[row][column+1];
            if(!policy.contains(neighbour) && !neighbour.getType().equals(CellType.PUDDLE))
                neighbours.add(neighbour);
        }

        Random rand = new Random();
        return neighbours.get(rand.nextInt(neighbours.size()));
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

    public Policy generateExpertPolicy()
    {
        Policy policy = new Policy();
        Cell start = gridworld[0][0];
        Cell goal = gridworld[this.rows-1][this.columns-1];

        policy.add(start);

        Cell next = this.getOptimalNeighbour(start, policy);

        policy.add(next);

        while(next != goal)
        {
            next = this.getOptimalNeighbour(next, policy);
            policy.add(next);
        }

        return policy;
    }
}
