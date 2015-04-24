
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Clause class represents multiple literals all connected by OR operators
 * This class will hold its own boolean to keep track of its satisfied status
 * holds a list of booleans to track its negations
 * holds a list of literals
 * @ author (John Saunders && Craig Fee)
 * 2/5/15
 */
public class Clause {

    ArrayList<Boolean> negation;
    ArrayList<Literal> literals;
    boolean satisfied = false;
   

    public Clause()
    {
        negation = new ArrayList<Boolean> ();
        literals= new ArrayList<Literal>();
    }

    public int size(){
        int size=0;
        for(Literal l : literals)
        {
            if(!(l.isRemoved())){
                size++;
            }
        }
        return size;
    }

    public boolean getSat()
    {
        return satisfied;
    }

    public  ArrayList<Literal> getLiterals()
    {
        return literals;
    }

    /**
     * Uses a loop to go through each variabe in the clause
     * gets the boolean negation at the corisponing index  to  consider if the variable is to be negated
     * sets the satisfied variable to true if satisfied
     * @return boolean based on whether the clause is satisfied or not
     */
    public boolean satisfy()throws UnequalLitteralAndDisjuntion
    {
        boolean result = false;
        if(negation.size()!= literals.size()){
            throw new UnequalLitteralAndDisjuntion(this.toString());
        }
        int size = literals.size();
        Literal tempL;
        for(int i = 0; i< size && !result;i++){
            tempL = literals.get(i);
            if(tempL.isAssigned()&& !(tempL.isRemoved())){
                if(tempL.getValue() == true && negation.get(i) == false)
                {
                    //System.out.print("Clause Satisfied! state of Caues is \n"+toString()+"\n");
                    return (satisfied = true);
                }else
                if(tempL.getValue() == false && negation.get(i) == true)
                {
                    //System.out.print("Clause Satisfied! state of Caues is \n"+toString()+"\n");

                    return (satisfied = true);
                }
            }
        }
        satisfied = false;
        return result;
    }

    /**
     * adds a literal to the Litterals list
     * Pre: must have a negation to corispond with in negtion list
     */
    public void addLiteral(Literal lit)
    {
        literals.add(lit);
      
    }

    /**
     * adds a bolean varable to the negation list
     * Pre: must have a literal to corispond with in Literals list
     */
    public void addNegation(boolean y)
    {
        negation.add(y);
    }

    public void setSatisfied(boolean b)
    {
        satisfied=b;
    }

    public String toString(){
        String result =  "Literals = {";
        int size = literals.size();
        for (int i = 0; i<size; i++){
            if((negation.get(i))== true){
                result += "negation of ";
            }
            result += literals.get(i).toString()+",";
        }   
        return result +"}";
    }

    public boolean isEmpty() //changed - john
    {
        if(satisfied){return false;}
        for(Literal lit : literals)
        {
            if(!(lit.isAssigned()))
            {
                return false;
            }
        }
        return true;

    }

}
