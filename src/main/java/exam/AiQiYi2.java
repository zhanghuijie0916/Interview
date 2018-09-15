package exam;

public class AiQiYi2 {
    public static void main(String args[]) {

    }
}
#include<iostream>
using namespace std;
    int main(){
        struct SEGMENT{
            int x;
            int y;
        };
        int n,si,ei,pos,k,tmp,i,cur;
        struct SEGMENT seg[101];
        while(cin>>n){
            pos = 0;
            if(n==0)break;
            while(n--){
                cin>>si>>ei;
                seg[pos].x=si;
                seg[pos].y=ei;
                pos++;
            }
            //BubbleSort
            for(k=1;k<pos;k++){
                for(i=0;i<pos-k;i++){
                    if(seg[i].y>seg[i+1].y){
                        //swap
                        tmp=seg[i+1].y;
                        seg[i+1].y=seg[i].y;
                        seg[i].y=tmp;
                        tmp=seg[i+1].x;
                        seg[i+1].x=seg[i].x;
                        seg[i].x=tmp;
                    }
                }
            }
            //main process
            cur=seg[0].y;
            int cnt=1;
            for(k=1;k<pos;k++){
                if(seg[k].x>=cur){
                    cur=seg[k].y;
                    cnt++;
                }
            }
            cout<<cnt<<endl;
        }
        return 0;
    }