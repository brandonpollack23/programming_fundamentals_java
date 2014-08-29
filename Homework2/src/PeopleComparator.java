import java.util.Comparator;
import java.util.List;
import Person;

public class PeopleSortByBirthday implements Comparator<Person>
{
	
	public int compare(Person a, Person b)
	{		
		if (a.birthday.getMonth() < b.getMonth())
		{
			return -1;
		}
		else if(a.birthday.getMonth() > b.birthday.getMonth)
		{
			return 1;
		}
		else
		{
			if(a.birthday.getDay() < b.birthday.getDay)
			{
				return -1;
			}
			else if (a.birthday.getDay() > b.birthday.getDay())
			{
				return 1;
			}
			else return 0;
		}

}

	
public class HW2Comparator<T extends Comparable<T>> implements Comparator<List<T>>
{
	public int compare(List<T> v1, List<T> v2)
	{
		int i = 0;
		while(i<v1.size() || i<v2.size())
		{
			if(v1.get(i) == v2.get(i))
			{
				i++;
			}
			else
			{
				return v1.get(i).compareTo(v2.get(i));
			}
			
		}
	}
}