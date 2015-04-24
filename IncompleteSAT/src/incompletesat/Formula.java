/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package incompletesat;
import java.util.ArrayList;
/**
 *
 * @author cfee8_000
 */
public class Formula {
    ArrayList<Clause> clauses;
    public Formula(ArrayList<Clause> c)
    {
        clauses=c;
    }

    public Formula()
    {
        clauses = new ArrayList<Clause>();
    }

    public void addClause(Clause c)
    {
        clauses.add(c);
    }

    public Clause getClause(int index)
    {
        return clauses.get(index);
    }

    public int size()
    {
        return clauses.size();
    }

    public boolean isEmpty() // changed - john
    {
        for(Clause c: clauses) 
        {
            if(!(c.isEmpty()))
            { 
                return false;
            }
        }
        return true;
    }

    public int findOccurances(Literal lit)
    {
        int occurances =0;
        int i=0;
        
        if(!(lit.isAssigned())){
            for (Clause c: clauses)
            {

                for(Literal thisLit: (c.getLiterals()))// added getLiterals - john 
                {
                    if(thisLit==lit)
                        occurances++;
                }
                i++;
            }
        }
        return occurances;
    }

    public ArrayList<Clause> getFormula()
    {
        return clauses;
    }
}
