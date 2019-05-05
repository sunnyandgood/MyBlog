#include<iostream>
#include<string.h>
#include<stdlib.h>
#include <sstream>
using namespace std;

long long countNum = 0;
bool IsSwap(char* pBegin, char* pEnd)
{
    char* p;
    for (p=pBegin; p<pEnd; p++)
    {
        if (*p == *pEnd)
            return false;
    }
    return true;
}

void Permutation(char* pStr, char* pBegin,char *pre_str,int m)
{
    if (*pBegin == '\0')
    {
        if (strcmp(pre_str, pStr) > 0)//如果pre_str>pStr则返回正数
        {
            stringstream ss;
            long long ll;
            ss<<pStr;
            ss>>ll;
            if(ll%m == 0)
            {
                countNum++;
            }
            //countNum++;
            /*if (strtol(pStr, NULL, 10)%m == 0)//将pStr转换为10进制数
            {
                countNum++;
            }*/
        }
    }
    else
    {
        for (char* pCh = pBegin; *pCh!='\0'; pCh++)
        {
            if( IsSwap(pBegin,pCh) )
            {
                char temp = *pCh;
                *pCh = *pBegin;
                *pBegin = temp;

                Permutation(pStr, pBegin+1,pre_str,m);

                temp = *pCh;
                *pCh = *pBegin;
                *pBegin = temp;
            }
        }
    }
}

int main()
{
    long long out[50];
    char strE[100];
    int time,m;
    char pre_str[100] = {0};
    cout<<"The time is: ";
    cin>>time;
    cout<<endl;

    cout<<"The original strings is: "<<endl;
    for (int i = 0; i < time; i++)
    {
        cin>>strE>>m;
        strcpy(pre_str, strE);
        Permutation(strE,strE,pre_str,m);
        out[i] = countNum%1000000007;
        countNum = 0;
    }

    cout<<"After permutation select, the price possible number  is: "<<endl;
    for (int i = 0; i < time; i++)
    {
        cout<<out[i]<<endl;
    }
    return 0;
}
