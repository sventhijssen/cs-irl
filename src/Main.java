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

        Policy expertPolicy = new Policy(gridWorld);

        expertPolicy.addTransitions(0,0, 0, 1, 0, 0);
        expertPolicy.addTransitions(0,1, 0, 0, 1, 0);
        expertPolicy.addTransitions(0,2, 0, 0.1, 0.8, 0.1);
        expertPolicy.addTransitions(0,3, 0, 0, 1, 0);

        expertPolicy.addTransitions(1,0, 0, 0.5, 0.5, 0);
        expertPolicy.addTransitions(1,1, 0, 0, 1, 0);
        expertPolicy.addTransitions(1,2, 0, 0, 1, 0);
        expertPolicy.addTransitions(1,3, 0, 0, 0, 1);

        expertPolicy.addTransitions(2,0, 0, 0.8, 0.2, 0);
        expertPolicy.addTransitions(2,1, 0, 0, 1, 0);
        expertPolicy.addTransitions(2,2, 0, 0, 1, 0);
        expertPolicy.addTransitions(2,3, 0, 0, 1, 0);

        expertPolicy.addTransitions(3,0, 0, 1, 0, 0);
        expertPolicy.addTransitions(3,1, 0, 1, 0, 0);
        expertPolicy.addTransitions(3,2, 0, 1, 0, 0);
        expertPolicy.addTransitions(3,3, 0, 1, 0, 0);

        ApprenticeshipLearning apprenticeshipLearning = new ApprenticeshipLearning(gridWorld, expertPolicy);
        Vector weights = apprenticeshipLearning.solve();
    }
}
