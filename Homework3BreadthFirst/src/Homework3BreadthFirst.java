import maze.*;

public class Homework3BreadthFirst {
	
	public static void main(String[] args) 
	{
		Maze problem = new ExampleMazeWithCycle();
		MazeSolver solver = new MazeSolver();
		
		solver.findRoute(problem.getStart());
	}

}
