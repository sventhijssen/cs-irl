public class Transition
{
    public Transition(Cell nextState)
    {
        this(nextState, 0);
    }
    public Transition(Cell nextState, double probability)
    {
        this.nextState = nextState;
        this.probability = probability;
    }

    public Cell getNextState()
    {
        return nextState;
    }

    public double getProbability()
    {
        return probability;
    }

    public void setProbability(double probability)
    {
        this.probability = probability;
    }

    private Cell nextState;

    private double probability;
}
