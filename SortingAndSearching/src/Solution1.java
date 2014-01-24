import java.util.ArrayList;
import java.util.List;

class Solution1 {
	public static void main(String args[])
	{
		int []a={7, 6, 6, 6, 19, 7, 7, 6, 8, 13, 9, 12};
		int []b={4, 2, 2, 3, 1, 4, 7, 8, 6, 9};
		//int c=new Solution().stack_machine_emulator("11++");
		//System.out.println("count="+c);
		//int c=new Solution().nob(b);
		//System.out.println("count="+c);
		//combine("abc", new StringBuffer(), 0);
		//List<String> l=getPerms("abc");
		//System.out.println(l);
	}
	public int nob(int []A)
	{
		int flag=0,largest_value=0;
		int []t=new int[A.length];
		t[0]=A[0];
		t[A.length-1]=A[A.length-1];
		for(int i=1;i<A.length;i++)
		{
			if(flag==0){
			if(A[i]<=t[i-1])
			{
				t[i]=t[i-1];
			}
			else
			{
				flag=1;
				t[i]=A[i];
			}}
			else
			{	
			if(A[i]<=t[i-1])
			{
				t[i]=A[i];
			}
			else
			{
				t[i]=t[i-1];
			}}
		}
		for(int p:t)
		{
			System.out.print(" "+p);
		}
		System.out.println();
		for(int p:A)
		{
			System.out.print(" "+p);
		}
		int eq=0;
		for(int i=0;i<A.length-1;i++)
		{
			if(t[i+1]>t[i] && flag!=99)
			{
				System.out.println("--");
				eq=i+1;
				largest_value=t[i+1];
				flag=99;
			}
			if(flag==99)
			{
				if(A[i+1]<largest_value)
				{
					eq=i+2;
				}
			}
		}
		if(eq>=A.length || eq==0)
		{
			return -1;
		}
		return eq;
	}

  public int falling_disks ( int []A,int[] B ) {
   int count=0,flag=0;
   int index_largest_a=0;
int b=0;
if(B[0]>A[0])
{
	return 0;
}
for(int k=1;k<B.length;k++)
{
	if(B[k]>B[b])
	{
		b=k;
	}
}

//System.out.println("largest="+b+" ele="+B[b]);
for(int i=0;i<A.length-1;i++)
{
	if(B[b]>A[0])
	{
	//	System.out.println("226666");
		b=-1;
		break;
	}
	if(A[i+1]<B[b])
	{
		flag=1;
		index_largest_a=i-1;
		//System.out.println(A[i]+"--"+A[index_largest_a]+" "+B[b]);
		break;
	}
	else if(i==A.length-2)
	{
		index_largest_a=i;
	//	System.out.println(A[i]+"--"+A[index_largest_a]+" "+B[b]);
		
	}
}
count=b+1;
for(int k=b+1;k< B.length;k++){
	//System.out.println(B[k]);
for(int j=0;j<=index_largest_a;j++)
{
	//System.out.println(A[index_largest_a]);
	if(index_largest_a<0)
	{
		return count;
	}
	if(A[j]<=B[k])
	{
		//System.out.println("----");
		flag=1;
		count++;
		index_largest_a=j-1;
		break;
	}
	else if(j==index_largest_a)
	{
		//System.out.println("--");
		count++;
		index_largest_a=j-1;
		break;
	}

}}


return count;
  }
  public int stack_machine_emulator(String S)
  {
	  int count=0;
	  
	  char []char_Array=S.toCharArray();
	  List<Integer> listAsStack=new ArrayList<Integer>();
	  for(int i=0;i<char_Array.length;i++)
	  {
		  int length=listAsStack.size();
		  if(length>(listAsStack.size()-1))
		  {
			  return -1;
		  }
		  if(char_Array[i]=='+')
		  {
			  if(length>=2)
			  {
				int v1=listAsStack.get(--length);
				listAsStack.remove(length);
				int v2=listAsStack.get(--length);
				listAsStack.remove(length);
				listAsStack.add(v1+v2);
			  }
			  else
			  {
				  return -1;
			  }
		  }
		  else if(char_Array[i]=='*')
		  {
			  if(length>=2)
			  {

					int v1=listAsStack.get(--length);
					listAsStack.remove(length);
					int v2=listAsStack.get(--length);
					listAsStack.remove(length);
					listAsStack.add(v1*v2);
			  }
			  else
			  {
				  return -1;
			  }
		  }
		  else
		  {
			  listAsStack.add(Integer.parseInt(char_Array[i]+""));
		  }
	  }
	  return listAsStack.get(listAsStack.size()-1);
  }
}