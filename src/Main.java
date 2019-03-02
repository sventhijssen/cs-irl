public class Main
{
    public static void main(String [ ] args)
    {
        // Example gridWorld, see gridWorld.jpg for layout
        GridWorld gridWorld = new GridWorld(4, 4);
        gridWorld.createPuddle(1, 0);
        gridWorld.createPuddle(0, 2);
        gridWorld.createPuddle(2,3);
        gridWorld.createGoal(3,3);

        ApprenticeshipLearning apprenticeshipLearning = new ApprenticeshipLearning(gridWorld);
        Vector weights = apprenticeshipLearning.solve();
    }
}
