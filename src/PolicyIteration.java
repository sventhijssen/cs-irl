import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PolicyIteration
{

    public PolicyIteration(GridWorld gridWorld, double discountFactor, Vector weights)
    {
        this.gridWorld = gridWorld;
        this.discountFactor = discountFactor;
        this.weights = weights;
    }

    public Policy getOptimalPolicy()
    {
        HashMap<Cell, Double> V = initV();
        double delta = 0;
        for (Map.Entry<Cell, Double> entry : V.entrySet()) {
            Cell cell = entry.getKey();
            Double tmp = entry.getValue();

            for(Transition transition: cell.getTransitions())
            {
                Cell nextState = transition.getNextState();
                V.put(cell, this.weights.dot(nextState.getFeatures()) + discountFactor*V.get(nextState));
                delta = Math.max(delta, Math.abs(V.get(cell) - tmp));
            }

        }
        return null;
    }

    private HashMap<Cell, Double> initV()
    {
        HashMap<Cell, Double> V = new HashMap<>();
        int rows = gridWorld.getRows();
        int columns = gridWorld.getColumns();
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                V.put(gridWorld.getCell(i, j), 0.0);
            }
        }
        return V;
    }

    private GridWorld gridWorld;

    private double discountFactor;

    private Vector weights;
}
