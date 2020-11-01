public class Test {


     public static void main(String[] args) {
        //System.out.println(LCS("1AB2345CD","12345EF"));
        System.out.println(findKth(new int[]{1,3,5,2,2},5,3));//[1,3,5,2,2],5,3

    }




    public static String LCS (String str1, String str2) {
        // write code here
        int result=0;
        int index=0;
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] str = new int[len2][len1];
        for(int i=0;i<len2;i++){
            for(int j=0;j<len1;j++){
                if(str1.charAt(j)==str2.charAt(i)){
                    if(i==0||j==0){
                        str[i][j]=1;
                    }else{
                        str[i][j]=str[i-1][j-1]+1;
                    }
                    if(max(str[i][j],result)){
                        result=str[i][j];
                        index=i;
                    }
                }
            }
        }
        if(result>0){
            return str2.substring(index-result+1,index+1);
        }else{
            return "-1";
        }
    }

    public static boolean max(int a,int b){
        return a>b;
    }





//复制
//[1,3,5,2,2],5,3
    int[] a=new int[]{1,3,5,2,2};
     int n=5;int k=3;
    public static int findKth(int[] a, int n, int K) {
        // write code here
        int result = quickSort(a,0,a.length-1,K);
        return result;
    }

    public static int quickSort(int[] a,int low,int high,int k){
        int i = part(a,low,high);
        if((a.length-i)==k){
            return a[i];
        }
        if((a.length-i)>k){
            return quickSort(a,i+1,high,k);
        }else{
            return quickSort(a,low,i-1,k);
        }
    }


    public static int part(int[]a ,int low,int high){
        int index=high;
        int temp = a[high];
        high--;

        while(low<high){

            while(a[low]<temp){
                low++;
            }
            if(low>=high){
                break;
            }
            while(a[high]>temp){
                high--;
            }
            swap(a,low,high);
        }

        swap(a,high,index);
        return high;
    }


    public static void swap(int[] str,int a,int b){
        int temp = str[a];
        str[a] = str[b];
        str[b]=temp;
    }
}
