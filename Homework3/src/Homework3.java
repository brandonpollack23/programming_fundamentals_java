import maze.*;

public class Homework3 {

	
	public static void main(String[] args)
	{
		Maze example = new ExampleMazeWithCycle();
		
		System.out.println(MazeSolver.searchMaze(example.getStart()));
		System.out.println(MazeSolver.getDirections().toString());
	}

}
