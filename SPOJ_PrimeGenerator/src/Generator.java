
public class Generator 
{
	private int minVal, maxVal;
	boolean[] isNotPrime;
	
	public Generator(int min, int max)
	{
		minVal = min;
		maxVal = max;
		
		isNotPrime = new boolean[1 + maxVal - minVal];
		for (int i = 2; i*i < maxVal; i++)
		{
			int base = minVal/i;
			base *= i;
			for (int j = base; j <= maxVal; j += i)
			{
				if (j >= minVal && i != j)
				{
					isNotPrime[j - minVal] = true;
				}
			}
			
			if (minVal == 1)
			{
				isNotPrime[0] = true;
			}
		}
	}
	
	public void printPrimes()
	{
		for(int i = 0; i <= (maxVal - minVal); i++)
		{
			if(!isNotPrime[i])
			{
				System.out.println(minVal + i);
			}
		}
	}
}
