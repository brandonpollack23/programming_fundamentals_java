import java.math.BigInteger;
import java.util.Scanner;


class smallfactorials {
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		for (int i = 0; i < x; i++)
		{
			BigInteger n = new BigInteger(scanner.next());
			System.out.println(fact(n));
		}
		scanner.close();
	}

	static BigInteger fact(BigInteger n)
	{
		BigInteger result = BigInteger.ONE;
		while(!n.equals(BigInteger.ZERO))
		{
			result = result.multiply(n);
			n = n.subtract(BigInteger.ONE);		
		}
		return result;
	}

}
