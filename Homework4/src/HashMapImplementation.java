import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapImplementation<Type>
{
	private HashMap<Type, Long> someStats;
	private long numberOfItems;
	
	public HashMapImplementation(Map<Type, Long> initialStats)
	{
		someStats.clear();
		someStats = (HashMap<Type, Long>) initialStats;
		numberOfIterations = 0;
	}
	
	public HashMapImplementation()
	{
		someStats = new HashMap<Type, Long>();
	}
	
	public HashMapImplementation(int init)
	{
		someStats = new HashMap<Type, Long>(init);
	}
	
	//to do observe, forget, sorted-order iteration
	
	public void observe(Type value)
	{
		someStats.put(value, someStats.get(value) == null ? 1 : someStats.get(value) + 1);
	}
	
	public void forget(Type value) //i did a lot of borrowing from Josh's in class example code here, and figured out what exactly this class did
	{
		Long internalCount = someStats.get(value);
		if(internalCount == null) 
		{
			throw new IllegalStateException("There are no occurrences of entry \"" + value + "\" to forget.");
		}
		else if(internalCount > 1)
		{
			someStats.put(value, internalCount - 1);
		}
		else
		{
			someStats.remove(value);
		}
	}
	
	public int iteratetime() 
	{
		int complexity = 1;
		Set<Type> keySet = someStats.keySet();
		Iterator iterator = keySet.iterator();
		HashMap<Type, Long> copy = (HashMap<Type, Long>) someStats.clone();
		
		while (iterator.hasNext())
		{
			complexity++;
			iterator.next();
		}
		return complexity;
	}

}

