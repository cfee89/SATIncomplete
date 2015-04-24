 

/**
 * holds a value that will determine if the whole literal is true
 * holds both hasNegation and hasTruth booleans to determine if the a negation was used in any clauses 
 * or if only negations were used(hasTruth = false) this will be used to help speed up how fast we can solve the problem
 * skipping over value = true if hasTruth is false or skiping over value = false if hasNegation = false;   no need to check it if we no it wont solve any of them. 
 * @ author (Craig Fee)
 * 2/5/15
 */
import java.util.ArrayList;
public class Literal {

    boolean value=true;
    boolean assigned = false;
    boolean removed = false;
    
    boolean hasNegation = false ; 
    boolean hasTruth = false;
    int ID = 0;
    ArrayList<Clause> inClause = new ArrayList<Clause>();
    ArrayList<Clause> negatedClauses = new ArrayList<Clause>();
    public Literal(int ID)
    {
        this.ID = ID;
    }

	public boolean isRemoved()
	{
	    return removed;
	   }
    public boolean getValue()
    {
        return value;
    }
    public boolean isAssigned()
    {
        return assigned;
    }

    public void setValue(boolean newVal)
    {
        value = newVal;
    }

    public boolean getHasNegation()
    {
        return hasNegation;
    }

    /**
     * to be made true if at any point a clause has a negation of this literal
     */
    public void hasNegation(){
        hasNegation = true;
    }

    /**
     * to be made true if at any point a clause does not have a negation of this literal
     */
    public boolean getHasTruth()
    {
        return hasTruth;
    }

    public void hasTruth(){
        hasTruth = true;
    }

    public void setAssigned(boolean tf)
    {
        assigned = tf;
    }
    
    public void setRemoved(boolean r)
    {
        removed = r;
    }

    public String toString(){
        return (ID+"="+value+"");
    }

}
