import java.util.LinkedList;
import java.util.List;

public class Policy
{

    public Policy()
    {

    }

    public List<Cell> getCells()
    {
        return this.cells;
    }

    public boolean contains(Cell cell){
        return this.cells.contains(cell);
    }

    @Override
    /**
     * TODO: Fix, make neatly
     */
    public String toString()
    {
//        String out = "";
//        for(int i = 0; i < cells.size(); i++)
//        {
//            out += cells[i];
//            if(i != cells.size()-1){
//                out += " -> ";
//            }
//        }
        return "";
    }

    public void add(Cell cell)
    {
        this.cells.add(cell);
    }

    private List<Cell> cells = new LinkedList<>();
}
