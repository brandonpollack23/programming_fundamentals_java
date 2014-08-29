import java.util.Arrays;

public class main {

	public static void main(String[] args) 
	{
		int[] testCase = new int[1];
		testCase[0] = 1;
		
		//try {System.out.println(binarySearch(testCase, 237).toString());}
		//catch (Exception e) {}
		
		collatzConj(5).toString();
				
	}
	
	static Integer binarySearch(int[] array, int key)
	{
		int half = array.length/2;
		if (array.length == 1 && array[0] != key)
		{
			System.out.println("Element Does not exist");
			return null;
		}
		if (array[half] == key)
		{
			return half;
		}
		else if (array[half] < key)
		{
			try 
			{
				return  binarySearch(Arrays.copyOfRange(array, half, array.length), key) + half;
			}
			catch (Exception e) {return null; }
		}
		else if (array[half] > key)
		{
			return binarySearch(Arrays.copyOfRange(array, 0, half), key);
		}
		return null;
	}
	
	static Integer collatzConj(int gunnaBeOne)
	{
		System.out.print(gunnaBeOne + " ");
		if (gunnaBeOne < 1)
		{
			System.out.println("This only works for natural numbers");
			return -1;
		}
		if (gunnaBeOne == 1)
		{
			return 1;
		}
		if (gunnaBeOne % 2 == 0)
		{
			return collatzConj(gunnaBeOne/2);
		}
		if (gunnaBeOne % 2 == 1)
		{
			return collatzConj((3*gunnaBeOne + 1));
		}
		return null;
	}

}
