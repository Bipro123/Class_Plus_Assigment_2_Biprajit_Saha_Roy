/* package whatever; // don't place package name! */
 
import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
 
 
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int h=sc.nextInt();
		int x=sc.nextInt();
		int total_suspected_epicenter=0; 
		
		Map<Integer, Set<Integer>> cities_connected_to = new HashMap<>();
		
		HashSet<Integer> hotspot_cities=new HashSet<Integer>(h);
		HashMap<Integer,Integer> suspected_hotspot_cities=new HashMap<Integer,Integer>();
		ArrayList<Integer> connected_cities= new ArrayList<Integer>(); 
		sc.nextLine();
	
		for(int i=0;i<h;i++)
		{
			hotspot_cities.add(sc.nextInt());	
		}
 
		 
 
		sc.nextLine();
 
		
 
		while(sc.hasNextLine())
		{
			connected_cities.add(sc.nextInt());
			connected_cities.add(sc.nextInt());
		}
		
		for(int i=0;i<connected_cities.size()-1;i+=2)
		{
			if(hotspot_cities.contains(connected_cities.get(i))==false && hotspot_cities.contains(connected_cities.get(i+1))==false)
			{
				System.out.println("No Hot-Spot");
				continue;
			}
			else
			{
				int set_index=0;
				int city_infected_index=0;
				
				if(hotspot_cities.contains(connected_cities.get(i))==false)
				{
					set_index=i;
					city_infected_index=i+1;
				}
				if(hotspot_cities.contains(connected_cities.get(i+1))==false)
				{
					set_index=i+1;
					city_infected_index=i;
					
				}
				
				if(suspected_hotspot_cities.containsKey(connected_cities.get(set_index))==false)
				{
					suspected_hotspot_cities.put(connected_cities.get(set_index),1);
				}
				else
				{
					suspected_hotspot_cities.put(connected_cities.get(set_index),suspected_hotspot_cities.get(connected_cities.get(set_index))+1);
				}
				
				if (!cities_connected_to.containsKey(connected_cities.get(set_index)))
				{
					cities_connected_to.put(connected_cities.get(set_index), new HashSet<>());	
				}
				cities_connected_to.get(connected_cities.get(set_index)).add(connected_cities.get(city_infected_index));
        		
			}
		}
		
		for (Map.Entry<Integer, Integer> set : suspected_hotspot_cities.entrySet()) {
		     if(set.getValue()==hotspot_cities.size())
		     {
		     	total_suspected_epicenter=total_suspected_epicenter+1;
		     }
		     
		}
		
		total_suspected_epicenter=total_suspected_epicenter+hotspot_cities.size();
		
		
		
		System.out.println(total_suspected_epicenter);
		
		
 
	}
}