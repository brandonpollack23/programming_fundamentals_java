import java.math.*;
public class sumsquarediff {

	
	public static void main(String[] args) {
		
		int[] arr = new int[100];
		int sumofsquares = 0;
		int squareofsums = 0;
		for (int i = 0; i < 100; i++)
		{
			arr[i]=i+1;
		}
		
		for(int i = 0; i < 100; i++)
		{
			sumofsquares += (int)Math.pow(arr[i], 2);
		}
		
		for(int i = 0; i < 100; i++)
		{
			squareofsums += arr[i];
		}
		
		squareofsums = (int) Math.pow(squareofsums,2);
		
		System.out.println(squareofsums-sumofsquares);
		
		
		
	}

}
