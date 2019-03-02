public class PolicyIteration
{

    public PolicyIteration(GridWorld gridWorld, double discountFactor)
    {
        this.gridWorld = gridWorld;
        this.discountFactor = discountFactor;
    }

    public PolicyIteration(GridWorld gridWorld)
    {
        this(gridWorld, 0.9);
    }

    public void iterate()
    {

    }

    private GridWorld gridWorld;

    private double discountFactor;
}
