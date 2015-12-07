package com.erhuo.tools;

public  class RandomNum {
	//随机数
		public static int[] randomCommon(int min, int max, int n)//随机显示不重复的数字
		{  
			System.out.println(min+" "+max+" "+n);
		    if (n > (max - min + 1) || max < min) 
		    {  
		           return null;  
		    }  
		    int[] result = new int[n];  
		    int count = 0;  
		    while(count < n) 
		    {  
		        int num = (int) (Math.random() * (max - min)) + min;  
		        boolean flag = true;  
		        for (int j = 0; j < n; j++)
		        {  
		            if(num == result[j])
		            {  
		                flag = false;  
		                break;  
		            }  
		        }  
		        if(flag)
		        {  
		            result[count] = num;  
		            count++;  
		        }  
		    }  
		    for(int i=0;i<result.length;i++)
		    {
		    	System.out.println(result[i]);
		    }
		    return result;  
		} 

}
