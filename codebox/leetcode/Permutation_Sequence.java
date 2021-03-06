package main2;

import java.util.Arrays;

public class Permutation_Sequence {
    public static String getPermutation(int n, int k) {//according to the k, we assign the num in each
        // Start typing your Java solution below
        // DO NOT write main() function
        String ans="";
        int mode=1;// the maxnum which position can get
        int cn=n;
        for(int i=1;i<=n;i++){
            mode*=i;
        }
        k=(k-1)%mode+1;
        int state[]=new int[n];//state stand for the num isn`t used.
        Arrays.fill(state, 0);
        mode=mode/n;
        while(k>0){
            int c=(k-1)/mode;//find c in this position
            int count=0;
            for(int i=0;i<n;i++){
                if(count==c&&state[i]==0){//find the num of unused equal c
                    state[i]=1;
                    ans+=(char)(i+'1');
                    break;
                }
                if(state[i]==0)
                    count++;
            }
            cn--;
            if(cn<=0)
                break;
            k-=c*mode;
            mode/=cn;
        }
        return ans;
    }
    public static void main(String args[]){
        for(int i=1;i<=6*4;i++){
            System.out.println(getPermutation(4,i));
        }
        
    }
    
}
