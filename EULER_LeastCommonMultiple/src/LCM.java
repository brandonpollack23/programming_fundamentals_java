
public class LCM {

	
	public static void main(String[] args) {
		int[] arr = new int[190];
		Boolean done = true;
		
		int i = 0;
		for (int i1 = 1; i1 < 20; i1++)
		{
			arr[i1-1] = 20*i1;
		}
		
		 do 
		 {
			 for(int j1 = 1; j1 <= 20; j1++)
			 {
				 if (arr[i] % j1 != 0) done = false;
				 else done = true;
			 }
			 i++;
		 }while(done !=  true);
		 
		 System.out.println(arr[i-1]);

	}

}
