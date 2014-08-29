/**A measure of Time (such as the span of time between two DateTimes
 * Can be negative since it is a span, not a point
 * @author Brandon Pollack
 *  */
public class Time 
{
	private int day, hour, min, sec;
	
	/** Constructor takes in a measure of time */
	public Time(int day, int hour, int min, int sec)
	{
		this.day = day;
		this.hour = hour;
		this.min = min;
		this.sec = sec;
	}
	
	public String toString() //Outputs in the form of a string
	{
		return (day + " days, " + hour + ":" + min + ":" + sec);  
	}
	
	public int getDays()
	{
		return day;
	}
	
	public int getHours()
	{
		return hour;
	}
	
	public int getMinutes()
	{
		return min;
	}
	
	public int getSeconds()
	{
		return sec;
	}
	/** Adds two time spans together */
	public Time add(Time time)
	{
		int totalDays = day, totalHours = hour, totalMinutes = min, totalSeconds = sec;
		
		if (time.getDays() < 0) //Here I check to make sure I shouldn't be subtracting if it is negative
		{
			Time placeholder = new Time(-time.getDays(), time.getHours(), time.getMinutes(), time.getSeconds());
			subtract(placeholder);
		}
		
		totalSeconds += time.getSeconds(); //adding is pretty simple since we can't end up with a negative number
		if (totalSeconds >= 60)
		{
			totalMinutes++;
			totalSeconds -= 60;
		}
		
		totalMinutes += time.getMinutes(); //just cascade through our levels
		if (totalMinutes >= 60)
		{
			totalHours++;
			totalMinutes -= 60;
		}
		
		totalHours += time.getHours();	
		if (totalHours >= 24)
		{
			totalDays++;
			totalHours -= 24;
		}
		
		totalDays += time.getDays();		
		
		return new Time(totalDays, totalHours, totalMinutes, totalSeconds); //and return
		
	}
	
	/** Subtracts two times */
	public Time subtract(Time time)
	{
		int totalDays = day, totalHours = hour, totalMinutes = min, totalSeconds = sec;
		
		if (time.getDays() < 0) //Make sure I shouldn't be adding by subtracting a negative
		{
			Time placeholder = new Time(-time.getDays(), time.getHours(), time.getMinutes(), time.getSeconds());
			add(placeholder);
		}
		
		if (time.getDays() > day)  //Adding on the other hand, is a bit more complex, here I am making sure my answer won't be negative
		{
			Time placeholder = time.subtract(this);
			return new Time( (- placeholder.getDays()), placeholder.getHours(),placeholder.getMinutes(),placeholder.getSeconds());
		}
		if (time.getDays() == day && time.getMinutes() > min)  //By checking in order all the values of Time
		{
			Time placeholder = time.subtract(this);
			return new Time( (- placeholder.getDays()), placeholder.getHours(),placeholder.getMinutes(),placeholder.getSeconds());
		}
		if (time.getDays() == day && time.getMinutes() == min && time.getSeconds() > sec) //If it is I subtract the other direction and return a negative value
		{
			Time placeholder = time.subtract(this);
			return new Time( (- placeholder.getDays()), placeholder.getHours(),placeholder.getMinutes(),placeholder.getSeconds());
		}
		
		
		if (totalSeconds - time.getSeconds() < 0) //After that isn't true I just cascade through again just like adding, but subtracting
		{
			totalMinutes--;
			totalSeconds = (60 + totalSeconds - time.getSeconds()); //Since subtracting indexes from teh hightest number down, I have added 60 here (no negatives)
		}
		else totalSeconds -= time.getSeconds();
		
		
		if (totalMinutes - time.getMinutes() < 0)
		{
			totalHours--;
			totalMinutes = (60 + totalMinutes - time.getMinutes()); //add 60 here
		}
		else totalMinutes -= time.getMinutes();
		
		if (totalHours - time.getHours() < 0)
		{
			totalDays--;
			totalHours = (totalHours + 24 - time.getHours()); //but 24 here b/c thats how many hours in a day
		}
		else totalHours -= time.getHours();
		
		totalDays -= time.getDays();
		
		return new Time(totalDays, totalHours, totalMinutes, totalSeconds);
	}
	
	
}
