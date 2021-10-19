
public class Problem2 {
	public static void main(String[] args) {
		double [] arr = {1,2,9,8,10,5};
		double tem=0;
		
		for (int i = 0; i < arr.length; i++) {     
            for (int j = i+1; j < arr.length; j++) {     
               if(arr[i] < arr[j]) {    
                   tem = arr[i];    
                   arr[i] = arr[j];    
                   arr[j] = tem;    
               }     
            }     
        }    
		
		
		
		
		for(int i=0;i<6;i++){
		    
		    arr[i]= Math.sqrt(arr[i]);
		    
		}
		
		
		
		
		for(double i:arr){
		    System.out.print(i+" ");
		}
		
	
	}
}
