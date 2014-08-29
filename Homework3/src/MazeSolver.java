import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

import maze.*;

public class MazeSolver 
{
	private static Deque<MazeCell> breadCrumbs = new LinkedList<MazeCell>();
	private static HashSet<MazeCell> visitedCells = new HashSet<MazeCell>();
	private static Deque<String> directions = new LinkedList<String>();
	private static int numberOfSteps = 0;
	
	public MazeSolver()
	{
		directions.addLast("Start");
	}
	
	public static MazeCell searchMaze(MazeCell cell)
	{	
		MazeCell solution;
		if (cell.isFinish())
		{
			return cell;
		}
		if (!visitedCells.contains(cell))
		{
			numberOfSteps++;
			visitedCells.add(cell);
			breadCrumbs.push(cell);
		}		
		
		if (cell.east() != null && !visitedCells.contains(cell.east()))
		{
			directions.addFirst("east");
			solution = searchMaze(cell.east());
			
		}
		else if (cell.north() != null && !visitedCells.contains(cell.north()))
		{
			directions.addFirst("north");
			solution = searchMaze(cell.north());
			
		}
		else if (cell.south() != null && !visitedCells.contains(cell.south()))
		{
			directions.addFirst("south");
			solution = searchMaze(cell.south());
			
		}
		else if (cell.west() != null && !visitedCells.contains(cell.west()))
		{
			directions.addFirst("west");
			solution = searchMaze(cell.west());
			
		}
		
		else
		{
			numberOfSteps--;
			directions.removeFirst();
			solution = searchMaze(breadCrumbs.pop());
			
		}
		
		return solution; 
				
	}
	
	public static Deque<String> getDirections()
	{
		return directions;
	}
	
	public static int getNumberOfSteps()
	{
		return numberOfSteps;
	}

}
