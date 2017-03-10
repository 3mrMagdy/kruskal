import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class edge
{
	int s, d;
	long w;
}

public class Run
{
	public static void main (String arg[])
	{
		Run ex = new Run();
		Scanner in = new Scanner(System.in);
		
		ArrayList<edge> edges = new ArrayList<>();
		String fname = in.nextLine();
		long sum=0;
		int n = ex.ReadN(fname);
		DJS djs = new DJS(n);
		
		edges = ex.Read(fname);
		
		edges = ex.MST(edges, djs);
		
		for(edge tmp : edges)
		{
			System.out.println(tmp.d + " " + tmp.s);
			sum += tmp.w;
		}
		
		System.out.println(sum);
		
		in.close();
	}
	
	public int ReadN (String fname)
	{
		int n=7;
		
		try
		{
			Scanner fin = new Scanner(new File (fname));
			
			n = fin.nextInt();
			
			fin.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return n;
	}
	
	public ArrayList<edge> Read (String fname)
	{
		int m;
		ArrayList<edge> edges = new ArrayList<>();
		edge tmp;
		
		try
		{
			Scanner fin = new Scanner(new File (fname));
			
			m = fin.nextInt();
			m = fin.nextInt();
						
			while (m-- > 0)
			{
				tmp = new edge();
				
				tmp.d = fin.nextInt();
				tmp.s = fin.nextInt();
				tmp.w = fin.nextInt();
				
				edges.add(tmp);
			}
			
			fin.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return edges;
	}
	
	public void Sort (ArrayList<edge> edges)
	{
		Collections.sort(edges, new Comparator<edge>()
		{
			@Override
			public int compare(edge e1, edge e2)
			{
				return (e1.w>e2.w ? 1 : (e1.w<e2.w ? -1 : 0));
			}
		});
	}
	
	public ArrayList<edge> MST (ArrayList<edge> edges, DJS djs)
	{
		ArrayList<edge> res = new ArrayList<>();
		
		Sort(edges);
		
		for(int i=0 ; i<edges.size() ; i++)
		{
			if(djs.Find(edges.get(i).s) != djs.Find(edges.get(i).d))
			{
				res.add(edges.get(i));
				djs.Union(edges.get(i).s, edges.get(i).d);
			}
		}
		
		return res;
	}
	
	
}
