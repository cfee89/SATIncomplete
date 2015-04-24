/**
 * Checks that both arrays in literal are equal
 * @ author Johnathan Saunders
 */
public class UnequalLitteralAndDisjuntion extends Exception implements java.io.Serializable
{
    private String key;
    
    public UnequalLitteralAndDisjuntion(String key)
    {
        this.key = key;
    }
    
    public String getKey()
    {
        return key;
    }

    public String toString()
    {
        return "Disjunction and Literal Lists are not equal in size in " + key ;
    }
}