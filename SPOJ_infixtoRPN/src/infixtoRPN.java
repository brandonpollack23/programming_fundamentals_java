import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class infixtoRPN {
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		for (int i = 0; i < x; i++)
		{
			String problem = scanner.next();
			System.out.println(Solver.convertToRPN(problem));
		}
		scanner.close();
	}
}

class Solver
{
	static String convertToRPN(String infix)
	{
		String answer = new String();
		Deque<Character> operators = new LinkedList<Character>();
		for (int i = 0; i < infix.length(); i++)
		{
			if (!isOp(infix.charAt(i)))
			{
				answer += infix.charAt(i);
			}
			else
			{
				if (!operators.isEmpty() && topHasPriority(operators, infix.charAt(i)))
				{
					answer = popOffOps(operators, answer);
				}
				if (infix.charAt(i) != ')') operators.push(infix.charAt(i));
			}
		}
		while(!operators.isEmpty()) answer += operators.pop();
		return answer;		
	}
	
	static boolean isOp(Character currentchar)
	{
		if (currentchar.equals('+') || currentchar.equals('-') || currentchar.equals('/') || currentchar.equals('*') || currentchar.equals('^') || currentchar.equals('(') || currentchar.equals(')'))
		{
			return true;			
		}
		else return false;
	}
	
	static int priorityOf(char symbol)
	{
		if (symbol == '+' || symbol == '-' || symbol == '(')
		{
			return 1;
		}
		if (symbol == '*' || symbol == '/')
		{
			return 2;
		}
		if (symbol == '^')
		{
			return 3;
		}
		if (symbol == ')')
		{
			return 4;
		}
		else return 0;
	}
	
	static boolean topHasPriority(Deque<Character> ops, char key) //checks if the stack's top outprioritizes in PEMDAS
	{
		if (priorityOf(ops.peek()) < priorityOf(key))
		{
			return true;
		}
		else return false;
	}
	
	static String popOffOps(Deque<Character> ops, String answer) //pops all of the ops down to nothing or until (
	{
		while (ops.peek() != '(' && !ops.isEmpty())
		{
			answer += ops.pop();
		}
		if (ops.peek() == '(') ops.pop();
		
		return answer;
		
	}

}
