import java.util.GregorianCalendar;
/**A calendar date that can be manipulated with specified methods
 * 
 * @author Brandon
 *
 */
public class DateTime 
{
	private int year, month, day, hour, minute, second;	
	/**Default constructor, builds a calendar date of today to the second using GregorianCalendar*/
	public DateTime()
	{
		 GregorianCalendar today = new GregorianCalendar(); //Constructors
		this.year = today.get(GregorianCalendar.YEAR);
		this.month = today.get(GregorianCalendar.MONTH)+1;
		this.day = today.get(GregorianCalendar.DAY_OF_YEAR);
		this.hour = today.get(GregorianCalendar.HOUR_OF_DAY);
		this.minute = today.get(GregorianCalendar.MINUTE);
		this.second = today.get(GregorianCalendar.SECOND);
	}
	/**Makes a DateTime of the specified date
	 * @note trying to input illegal dates (more days than the amount in a given month) will return an exception and exit*/
	public DateTime(int year, int month, int day, int hour, int min, int sec)
	{
		int[] monthmax = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] monthmaxleap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		//try
		//{	
			if (year % 4 != 0 && monthmax[month-1] < day)
			{
				throw new IllegalArgumentException("There Aren't That many Days in the " + month + " month of the year!");
			}
			else if (year % 4 == 0 && monthmaxleap[month-1] < day)
			{
				throw new IllegalArgumentException("There aren't that many days in February on a leap year!");
			}
		
			this.year = year;
			this.month = month;
			this.day = day;
			this.hour = hour;
			this.minute = min;
			this.second = sec;
		/*} 
		catch  (IllegalArgumentException ex)	
		{
			System.out.println(ex.getMessage());
			// I want to stop the object from being created here due to this Exception, is there a command to do that???
		}*/
	}
	
	//Methods
	public String toString()    
	{
		return this.month + "/" + this.day + "/" +this.year +
			", " + this.hour + ":" + this.minute + ":" + this.second;		
	}
	
	public int getYear()
	{
		return year;
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public int getDay()
	{
		return day;
	}
	
	public int getHour()
	{
		return hour;
	}
	
	public int getMinute()
	{
		return minute;
	}
	
	public int getSecond()
	{
		return second;
	}
	/**Adds a span of time to the date and returns the new date*/
	public DateTime add(Time time) //adds to datetime and outputs new date
	{
		if (time.getDays() < 0)
		{
			Time time2 = new Time(-(time.getDays()), time.getHours(), time.getMinutes(), time.getSeconds());
			this.subtract(time2); //if the time is negative we should subtract it with the add function
		}
		
		int year = this.getYear();
		int month = this.getMonth();
		int day = this.getDay();
		int hour = this.getHour();
		int minute = this.getMinute(); //can you tell this is the first method i wrote? here are some place holders
		int second = this.getSecond();
		
		minute += (time.getSeconds() + second)/60; //integer division will (thankfully) give me a good cascade for how many minutes to add
		second = (time.getSeconds() + second)%60; //Also it will fix any illegal values of seconds in the given Time (ie 120 seconds will be broken into 2 minutes 0 seconds)
		
		hour += (time.getMinutes() + minute)/60;
		minute = (time.getMinutes() + minute)%60;
		
		day += (time.getHours() + hour)/24;
		hour = (time.getHours() + hour)%24;  //this cascades all up to day, now there will be some trouble with month due to 
												//different lengths
		
		int daysleft = time.getDays(); //going to need this placeholder
		
		
		for(Boolean i = true; i == true;) //For loops are the most clear as far as what the conditions are
		{
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) //All the months with 31 days, enum would have been nice to know at this point 
			{
				
				if (day+daysleft > 31) //oh nos you cant have more than 31 days in these months!
				{
					if (month == 12) //but there are only 12 months, so that'd be a new year!
					{
						month = 1;
						year++;
					}
					else month++; //better inc the month then!
					
					daysleft -= 31; //ok so we've gone through incrementing a month so lets get rid of a month's worth of days
				}
				else i = false; //there weren't even enough days to make a new month! exit the loop silly
			}
			
			else if (month == 2 && (year % 4 != 0)) //non leap year february
			{
				if (day+daysleft > 28)
				{
					month++;
					daysleft -= 28;
				}
				else i = false;
							
			}
			
			else if (month == 2 && (year % 4 == 0) || year == 0) //leap year february
			{
				if (day+daysleft > 29)
				{
					month++;
					daysleft -= 29;
				}
				else i = false;								
			}
			
			else if (month == 4 || month == 6 || month == 9 || month == 11) //30 day months
			{
				if (day+daysleft > 30)
				{
					month++;
					daysleft -= 30;
				}	
				else i = false;
			}			
		}
		
		day += daysleft; //get in there fools
		
		return new DateTime(year, month, day, hour, minute, second);
		
	}
	/** Subtracts a span of time from the date and return sthe new date*/
	public DateTime subtract(Time time) //subtracts to datetime and outputs new date
	{
		if (time.getDays() < 0)
		{
			Time time2 = new Time(-(time.getDays()), time.getHours(), time.getMinutes(), time.getSeconds());
			return this.add(time2); //if the time is negative we should add it with the subtract function
		}
		
		int year = this.getYear();
		int month = this.getMonth();
		int day = this.getDay();
		int hour = this.getHour();
		int minute = this.getMinute();
		int second = this.getSecond();
		//int[] monthmax = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		//int[] monthmaxleap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		 
		
		if (time.getSeconds() > second) //similar thing but we're indexing from above again
		{
			minute--;
			second = (60 + second - time.getSeconds());
		}
		else second -= time.getSeconds();
		
		if (time.getMinutes() > minute)
		{
			hour--;
			minute = (60 + minute - time.getMinutes());
		}
		else minute -= time.getMinutes();
		
		if (time.getHours() > hour)
		{
			day--;
			hour = (24 + hour - time.getHours());
		}
		else hour -= time.getHours();
		
		int daysleft = time.getDays();  //placeholder
				
		for(Boolean i = true; i == true;)
		{
			if (month == 2 || month == 4 || month == 6 || month == 8 || month == 9 || month == 11 || month == 1) //months with 31 days BEFORE them
			{
				
				if (day - daysleft < 0) //similar to adding but subtracting instead from the month ahead to the month before
				{
					if (month == 1)
					{
						month = 12;
						year--;
					}
					else month--;
					
					daysleft -= 31;	//subtract this amount from am month before a month with 31 days and you end up on the same day of the month, clever Gregorians. 
				}
				else i = false;
				
							
			}
			
			else if (month == 3 && (year % 4 != 0))
			{
				if (day - daysleft < 0)
				{
					month++;
					daysleft -= 28;
				}
				else i = false;
											
			}
			
			else if (month == 3 && ((year % 4 == 0) || year == 0))
			{
				if (day+daysleft > 29)
				{
					month++;
					daysleft -= 29;
				}
				else i = false;
												
			}
			
			else if (month == 5 || month == 7 || month == 10 || month == 12)
			{
				if (day+daysleft > 30)
				{
					month++;
					daysleft -= 30;
				}
				else i = false;				
				
			}			
		}
		
		day -= daysleft; //get outta here, im subtracting you
		
		return new DateTime(year, month, day, hour, minute, second);
	}
	/**Subtracts two dates and gives the span of time between them, even if it is negative*/
	public Time subtract(DateTime dateTime) //subtracts the two datetimes and outputs the Time
	{
		int year = this.getYear();
		int month = this.getMonth();
		int day = this.getDay();
		int hour = this.getHour();
		int minute = this.getMinute();
		int second = this.getSecond();
		int[] monthmax = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] monthmaxleap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //needed these for my algorithm
		
		//this one was quite the doozy but just before I went to bed one night a great solution dawned on me
		
		
		if (year < dateTime.getYear()) //now if we have a look at the lenghts of these so we can tell if our answer should be negative, 
			//much like in the Time class, but longer, cascading ifs I messed up something and got a stack overflow so I just did this even though its super ugly
		{
			Time negans = dateTime.subtract(this);
			return new Time(-negans.getDays(), negans.getHours(), negans.getMinutes(), negans.getSeconds());
		}		
		if (year == dateTime.getYear() && month < dateTime.getMonth())
		{
			Time negans = dateTime.subtract(this);
			return new Time(-negans.getDays(), negans.getHours(), negans.getMinutes(), negans.getSeconds());
		}		
		if (month == dateTime.getMonth() && year == dateTime.getYear() && day < dateTime.getDay())
		{
			Time negans = dateTime.subtract(this);
			return new Time(-negans.getDays(), negans.getHours(), negans.getMinutes(), negans.getSeconds());
		}		
		if (month == dateTime.getMonth() && year == dateTime.getYear() && day < dateTime.getDay())
		{
			Time negans = dateTime.subtract(this);
			return new Time(-negans.getDays(), negans.getHours(), negans.getMinutes(), negans.getSeconds());
		}
		if (day == dateTime.getDay() && month == dateTime.getMonth() && year == dateTime.getYear() && hour < dateTime.getHour())
		{
			Time negans = dateTime.subtract(this);
			return new Time(-negans.getDays(), negans.getHours(), negans.getMinutes(), negans.getSeconds());
		}
		if (hour == dateTime.getHour() && day == dateTime.getDay() && month == dateTime.getMonth() && year == dateTime.getYear() && minute  < dateTime.getMinute())
		{
			Time negans = dateTime.subtract(this);
			return new Time(-negans.getDays(), negans.getHours(), negans.getMinutes(), negans.getSeconds());
		}
		if (minute == dateTime.getMinute() && hour == dateTime.getHour() && day == dateTime.getDay() && month == dateTime.getMonth() && year == dateTime.getYear() && second  < dateTime.getSecond())
		{
			Time negans = dateTime.subtract(this);
			return new Time(-negans.getDays(), negans.getHours(), negans.getMinutes(), negans.getSeconds());
		}
		//start operations
		if (second < dateTime.getSecond()) //well we can certainly cascade all the way up to day, that is no trick, same number of everthing in days
		{
			minute--;
			second = (60 + this.getSecond() - dateTime.getSecond());
		}
		else second -= dateTime.getSecond();
		
		
		if (minute < dateTime.getMinute())
		{
			hour--;
			minute = (60 + minute - dateTime.getMinute());
		}
		else minute -= dateTime.getMinute();
		
		
		if (hour <  dateTime.getHour())
		{
			day--;
			hour = (24 + hour - dateTime.getHour());
		}
		else hour -= dateTime.getHour();		
		
		//here is where it gets fun
		
		if (day < dateTime.getDay()) //well we are subtracting and we cant go negative days, so here we go to cascade and reindex up
		{
			if (this.getMonth() == 2 || this.getMonth() == 4 || this.getMonth() == 6 || this.getMonth() == 8 || this.getMonth() == 9 || this.getMonth() == 11 || this.getMonth() == 1)
			{
				if (this.getMonth() == 1)
				{
					month = 12;
					year--;
				}
				else month--;
				
				day = (31 + day - dateTime.getDay()); 
			}//months with 31 day montsh before them, 
			
			else if (this.getMonth() == 5 || this.getMonth() == 7 || this.getMonth() == 10 || this.getMonth() == 12)
			{
				month--;
				day = (30 + day - dateTime.getDay());
			} //30 day months before
			
			else if (this.getMonth() == 3 && ((year % 4 == 0 || year == 0)))
			{
				month--;
				day = (29 + day - dateTime.getDay());
			} //leap march or year 0
			
			else if (this.getMonth() == 3 && (year % 4) != 0)
			{
				month--;
				day = (28 + day - dateTime.getDay());
			} //normal march
		}
		else day -= dateTime.getDay(); //so now we have it down all the way up to days, this state ment just subtracts since there is no month cascade
		
		//now start with the year operations that have to do with subtracting them
		//and breaking everything down into terms of days
		
		day += (365*(year - dateTime.getYear()) + ((year - dateTime.getYear()) / 4)); //welp no years in a Time class so lets get an add of all the leap years there as extra days, and all the days in the difference of years
		
		if (dateTime.year % 4 == 0 || dateTime.year == 0) //add months in dateTime
		{
			for (int i = 0; i <= this.getMonth() - 2; i++) //here is where we needed those arrays, this form loop adds the days into the year of the end year
			{
				day += monthmaxleap[i];
			}
		}
		else
		{
			for (int i = 0; i <= this.getMonth() - 2; i++) //same but not leap year
			{
				day += monthmax[i];
			}
		}
		
		if (year % 4 == 0 || year == 0) //subtract days from the year we are already in
		{
			for (int i = 0; i <= dateTime.getMonth() - 2; i++)
			{
				day -= monthmaxleap[i];
			}
		}
		else
		{
			for (int i = 0; i <= dateTime.getMonth() - 2; i++) //and not leap year
			{
				day -= monthmax[i];
			}
		}
		
		return new Time(day, hour, minute, second); //YEAHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
	}
}
		
