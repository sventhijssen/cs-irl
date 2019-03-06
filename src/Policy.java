import java.util.LinkedList;
import java.util.List;

public class Policy
{

    public Policy(GridWorld gridWorld)
    {
        int rows = gridWorld.getRows();
        int columns = gridWorld.getColumns();
        this.gridWorld = gridWorld;

        this.policy = new List[rows][columns];

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                policy[i][j] = new LinkedList<>();
            }
        }
    }

    public void addTransitions(int row, int column, double up, double right, double down, double left)
    {
        if (up + right + down + left != 1)
            throw new IllegalArgumentException("Probabilities must sum to 1");
        if(row > 0)
            this.policy[row][column].add(new Transition(gridWorld.getCell(row-1, column), up));
        if(column < this.gridWorld.getColumns()-1)
            this.policy[row][column].add(new Transition(gridWorld.getCell(row, column+1), right));
        if(row < this.gridWorld.getRows()-1)
            this.policy[row][column].add(new Transition(gridWorld.getCell(row+1, column), down));
        if(column > 0)
            this.policy[row][column].add(new Transition(gridWorld.getCell(row, column-1), left));
    }

    public Vector getFeatureExpectations(double discountFactor)
    {
        return null;
    }

    private GridWorld gridWorld;

    private List[][] policy;
}
