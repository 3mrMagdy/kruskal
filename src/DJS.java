
public class DJS 
{
	int r[], p[];
	
	DJS(int sz)
	{
		r = new int [sz];
		p = new int [sz];
		Init(sz);
	}
	
	public void Init (int sz)
	{
		for(int i=0 ; i<sz ; i++)
		{
			p[i]=i;
			r[i]=1;
		}
	}
	
	public int Find (int x)
	{
		return p[x] = (p[x]==x ? p[x] : Find(p[x]));
	}
	
	public void Union (int x, int y)
	{
		x = Find(x);
		y = Find(y);
		
		if(r[x]>r[y])
		{
			p[y] = x;
			r[x] += r[y];
		}
		
		else
		{
			p[x] = y;
			r[y] += r[x];
		}
	}
}
