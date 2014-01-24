  import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class AllSort {

	static int[] insertionSort(int []arr)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]>arr[i+1])
			{
				for(int j=i;j>=0;j--)
				{
					if(arr[j+1] < arr[j])
					{
						int temp=arr[j];
						arr[j]=arr[j+1];
						arr[j+1]=temp;
					}
				}
			}
		}
		return arr;
	}
	static int[] merge(int []arr,int b,int e)
	{
		if(b==e)
			return null;
		
		int m=(b+e)/2;
		merge(arr,b,m);
		merge(arr,m+1,e);
		return mergesort(arr,b,m,e);
	}
	static int[] mergesort(int []a,int s,int m,int e)
	{
	int[] res=new int[10];//temp array
	int l=s;//take the left index
	int r=m+1;//take the right index
	int ind=s;
while(l<=m && r<=e)
{
	if(a[l]<a[r])
	{
		res[ind++]=a[l++];//merge into result array
	}
	else
	{
		res[ind++]=a[r++];
	}
}
while(l<=m)
{
	res[ind++]=a[l++];//place the remainder into res
}
while(r<=e)
{
	res[ind++]=a[r++];
}
for(int i=s;i<=e;i++)
{
	a[i]=res[i];
}
return res;
	}
	static int[] radix(int []a)
	{
		int m=10;
		for(int j=0;j<3;j++)
		{
Map<Integer, ArrayList<Integer>> hm=new HashMap<Integer,ArrayList<Integer>>();
			for(int i:a)
			{
				int temp=(int) ((i/(Math.pow(m, j)))%10);
				if(!hm.containsKey(temp))
				{
					ArrayList<Integer> al=new ArrayList<Integer>();
					al.add(i);
					hm.put(temp, al);
				}
				else
				{
					try
					{
					ArrayList<Integer> al= (ArrayList<Integer>)hm.get(temp);
					al.add(i);
					}
					catch(ClassCastException e)
					{
						
					}
				}
			}
			int ind=0;
			for(int pq=0;pq<10;pq++)
			{
				if(hm.containsKey(pq))
				{
					ArrayList<Integer> al=(ArrayList<Integer>)hm.get(pq);
					while(al.size()>0)
					{
						int i=al.remove(0);
						a[ind++]=i;
					}
				}
			}
		}
		return a;
	}

	static int Partition(int[] a, int left, int right) {
		
        int p = a[right],l = left,r = right,i = left-1;
        System.out.println(i+" "+p+" "+a[r]);
        if(p == a[r])
        {
        //	int temp = a[(right+left)/2]; a[right] = a[left+1]; a[left+1] = temp;
        }
        for(int j = left;j<right;j++) {
        	if(a[j] < p) {
        		i = i+1;
        		int temp = a[i]; a[i] = a[j]; a[j] = temp;
        	}
        	for(int c:a)
    		{
    			System.out.print(c+" ");
    		}
        	System.out.println();
        	System.out.println(i+ " "+ j);
        }
        int temp = a[i+1]; a[i+1] = a[right]; a[right] = temp; 
          /*do {
            while (a[l] < p && l < right) {
            	l++;
            }
            while ( a[r] > p && r > left) {
            	r--;
            }
            if (l <= r) {
                int temp = a[l]; a[l] = a[r]; a[r] = temp;
                l++;
                r--;
            }
        } while (l < r); 
        //a[left] = a[r];
        //a[r] = p;
        if(left < r) {
        	Partition(a, left, r);
        }
        if(l < right) {
        	Partition(a, l, right);
        }*/
        return i+1;
    }
	static int [] quicksort(int []a,int st,int end)
	{
		int m;
	if(st<end)
	{
		m=Partition(a, st, end);
		System.out.println(m);
		quicksort(a, st, m-1);
		quicksort(a, m+1, end);	
	}
	return a;
	}
	static int partition(int s[], int l, int h)
	{
	int i;
	int p;
	int firsthigh;
	p = h;
	firsthigh = l;
	for (i=l; i<h; i++)
	/* counter */
	/* pivot element index */
	/* divider position for pivot element */
	        if (s[i] < s[p]) {
	        	int temp = s[i]; s[i] = s[firsthigh]; s[firsthigh] = temp;    
//	        	//swap(&s[i],&s[firsthigh]);
	                firsthigh ++;
	        }
	int temp = s[p]; s[p] = s[firsthigh]; s[firsthigh] = temp;
	//swap(&s[p],&s[firsthigh]);
	return(firsthigh);
	}
	public static void main(String[] args) {
		int []a={3,4,2,5,6,1,3};
		//=radix(a);
		int[] res=quicksort(a, 0, a.length-1);
		//int [] b= merge(a,0,a.length-1);		
		//int m=Partition(a, 0, a.length-1);
		//System.out.println(m);
		for(int c:res)
		{
			System.out.print(c+" ");
		}
	}

}
