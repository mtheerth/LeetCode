/*
pages = 2,3,4,5 days 5
need to find x where if x= 4 then days to read them per day is 1 +1+1+ 2 = 5 days */


public static int minimumNumberOfPages(List<Integer> pages, int days)
{
	int max_page_day = Integer.MIN_VALUE;
	for(int i =  0; i < pages.sizes(); i++)
	{
		if(max_page_day < pages.get(i))
		{
			max_page_day = pages.get(i);
		}
	}
	int low = 1;
	int high = max_page_day;
	
	int current_days = 0;
	int actual_days = Integer.MAX_VALUE;
	
	while(low <= high)
	{
		int mid = low + (high-low)/2;
		
		int current_days = getDays(pages, mid);
		
		if(current_days <= days)
		{
			actual_days = Math.min(current_days, mid);
			high = mid-1;
		}
		else 
		{
			low = mid +1;
		}
	}
	
	return actual_days == Integer.MAX_VALUE ? -1 : actual_days;
}

public static int getDays(List<Integer> pages, int capacity)
{
	int total = 0;
	int i = 0;
	while( i < pages.sizes())
	{
		int curr = pages.get(i);
		while( curr > 0)
		{
			total ++;
			curr -= capacity;
		}
		i++;
}
	return total;
}
		
