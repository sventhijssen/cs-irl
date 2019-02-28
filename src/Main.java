public class Main
{
    public static void main(String [ ] args)
    {
        GridWorld gridWorld = new GridWorld(4, 4);
        gridWorld.createPuddle(1, 0);
        gridWorld.createPuddle(0, 2);
        gridWorld.createPuddle(2,3);


        Policy randomPolicy = gridWorld.generateRandomPolicy();

        System.out.println(randomPolicy.toString());
    }
}
