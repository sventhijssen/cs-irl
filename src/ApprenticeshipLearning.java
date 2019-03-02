class ApprenticeshipLearning
{
    ApprenticeshipLearning(GridWorld gridWorld)
    {
        this.gridWorld = gridWorld;
    }

    Vector solve()
    {
        Policy expertPolicy = gridWorld.generateExpertPolicy();
        Vector mu_expert = expertPolicy.getFeatureExpectations(discountFactor);

        // Step 1: Random policy
        Policy randomPolicy = gridWorld.generateRandomPolicy();
        // Step 1: Compute mu_0 (mu_current)
        Vector mu_current = randomPolicy.getFeatureExpectations(discountFactor);
        // Step 1: Set i = 1
        int i = 1;

        // Projection method: w(1) = mu_e - mu(0)
        Vector w = mu_expert.minus(mu_current);
        // Projection method: mu_flat(0) = mu(0)
        Vector mu_flat_prev = mu_current;

        double t;

        // Step 4
        while(true)
        {
            Vector a = mu_current.minus(mu_flat_prev);
            Vector b = mu_expert.minus(mu_flat_prev);

            mu_flat_prev = mu_flat_prev.plus(a.scale(a.dot(b)/a.dot(a)));

            w = mu_expert.minus(mu_flat_prev);

            // Step 2: Compute t_i
            t = w.norm2();

            // Step 3: If t < threshold, terminate
            if(t < threshold) break;

            // Step 4: Compute optimal policy pi_i for the MDP using rewards R = w^T.phi

            // Step 5: Compute mu_i

            // Step 6: Set i = i+1
            i++;
        }

        return w;

    }

    private double computeT(Vector mu_flat, Vector mu_exp, Vector mu_i1, Vector mu_i2)
    {

        Vector w = mu_exp.minus(mu_flat);
        return w.norm2();
    }

    private double threshold = 0.1;

    private double discountFactor = 0.9;

    private GridWorld gridWorld;
}
