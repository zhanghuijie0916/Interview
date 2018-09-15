package exam;

public class AiQiYi2 {
    public static void main(String args[]) {

    }
}

    #include<iostream>
#include<algorithm>
#include<cstdio>
#include<vector>
using namespace std;

        struct interval{
        int begin;
        int end;
        };

        bool cmp(interval x,interval y){
        return x.end < y.end;
        }


        int main(){
        freopen("a.txt", "r", stdin);
        int m;
        cin >> m;

        while (m--){
        int n;
        cin >> n;

        vector<interval> vec(n);

        for (int i = 0; i < n;i++){
        cin >> vec[i].begin >> vec[i].end;
        }

        sort(vec.begin(),vec.end(),cmp);

        int end = -1;
        int res = 0;
        for (int i = 0; i < n;i++){
        if (end<vec[i].begin){
        res++;
        end = vec[i].end;
        }
        }

        cout << res << endl;

        }
        return 0;
        }