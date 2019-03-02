import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Policy
{

    public Policy()
    {

    }

    public Vector getFeatureExpectations(double discountFactor)
    {
        int i = 0;
        Vector featureExpectations = new Vector(3);
        for (Cell cell: this.cells)
        {

            Vector features = cell.getFeatures();
            featureExpectations.plus(features.scale(Math.pow(discountFactor, i)));
            i++;
        }
        return featureExpectations;
    }

    public List<Cell> getCells()
    {
        return this.cells;
    }

    public boolean contains(Cell cell){
        return this.cells.contains(cell);
    }

    @Override
    public String toString()
    {
        return this.cells.stream().map(Cell::toString).collect(Collectors.joining(" -> "));
    }

    public void add(Cell cell)
    {
        this.cells.add(cell);
    }

    private List<Cell> cells = new LinkedList<>();
}
