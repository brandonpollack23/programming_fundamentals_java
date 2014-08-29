import java.util.Scanner;


public class PrimeGenerator {

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		
		for (int i = 0; i < x; i++)
		{
			Generator generator = new Generator(scanner.nextInt(),scanner.nextInt());
			generator.printPrimes();
		}
		scanner.close();
	}

}
