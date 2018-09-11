package exam;

public class RenRen1 {
    public static void main(String[] args) {
        int x = 20;
        int y =5;
        System.out.println(x+y+""+(x+y)+y);
    }
}


#include<stdio.h>
        int main()
        {long long i,n,m,k,x,y=0;
        scanf("%lld%lld",&n,&k);
        for(x=1;x<=n;x<<=1);
        x>>=1;
        for(m=0;m<=k&&x>0;m++)
        {y+=x;
        x>>=1;
        }
        printf("%lld\n",y);
        return 0;
        }