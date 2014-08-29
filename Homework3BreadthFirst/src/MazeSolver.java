import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

import maze.*;
public class MazeSolver 
{
	private Deque<MazeCell> cells = new LinkedList<MazeCell>();
	private HashSet<MazeCell> visitedCells = new HashSet<MazeCell>();
	private HashSet<MazeCell> wrongRoute = new HashSet<MazeCell>();
	private boolean printDirections = false;
	
	public MazeCell solve(MazeCell firstCell)
	{
		cells.add(firstCell);
		boolean didNotEnter = true;
		while(!cells.isEmpty())
		{
			didNotEnter = true;
			MazeCell currentCell = cells.poll();
			visitedCells.add(currentCell);
			if(currentCell.isFinish())
			{
				visitedCells = new HashSet<MazeCell>();
				return currentCell;
			}			
			
			if(currentCell.east() != null && !visitedCells.contains(currentCell.east()) && !wrongRoute.contains(currentCell.east()))
			{
				didNotEnter = false;
				cells.add(currentCell.east());
				if(printDirections) System.out.println("East ");
			}
			if(currentCell.south() != null && !visitedCells.contains(currentCell.south()) && !wrongRoute.contains(currentCell.south()))
			{
				didNotEnter = false;
				cells.add(currentCell.south());
				if(printDirections) System.out.println("South ");
			}
			if(currentCell.west() != null && !visitedCells.contains(currentCell.west()) && !wrongRoute.contains(currentCell.west()))
			{
				didNotEnter = false;
				cells.add(currentCell.west());
				if(printDirections) System.out.println("West ");
			}
			if(currentCell.north() != null && !visitedCells.contains(currentCell.north()) && !wrongRoute.contains(currentCell.north()))
			{
				didNotEnter = false;
				cells.add(currentCell.north());
				if(printDirections) System.out.println("North ");
			}
			if (didNotEnter)
			{
				wrongRoute.add(currentCell);
			}
		}
		
		return null;
		
	}
	public void findRoute(MazeCell start)
	{
		HashSet<MazeCell> previousWrongRoute = new HashSet<MazeCell>();
		HashSet<MazeCell> currentWrongRoute = new HashSet<MazeCell>();
		
		do
		{
			previousWrongRoute = wrongRoute;
			solve(start);
			currentWrongRoute = wrongRoute;
		}while(!currentWrongRoute.equals(previousWrongRoute));
		
		printDirections = true;
		solve(start);
		printDirections = false;
	}
}
