/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package incompletesat;


import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author cfee8_000
 */
public class IncompleteSAT {
    
    public ArrayList<Clause> clausePool = new ArrayList<Clause>();
    public ArrayList<Literal> litPool = new ArrayList<Literal>();
    public Random rand = new Random();
    public static final int FLIP_LIMIT = 500000;
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public void randomStage()
    {
        for(Literal thisLit:litPool)
        {
            int decider = rand.nextInt(1);
            if(decider==0)
                thisLit.setValue(false);
            else
                thisLit.setValue(true);
            
        }
    }
    public Literal findNeighbor()
    {
        ArrayList<Literal> solvingLits = new ArrayList<Literal>();
        Literal bestSoFar = new Literal();
        int bestScore = 0;
        for(Literal thisLit:litPool)
        {
            int temp = 0;
            if(thisLit.getValue())
            {
                 temp = thisLit.inClause.size();
            }
            if(!(thisLit.getValue()))
            {
                temp+=(thisLit.negatedClauses.size());
            }
            if(temp>bestScore)
            {
                bestScore = temp;
                bestSoFar = thisLit;
                
            }
            
        }
        return bestSoFar;

    }
    
}
