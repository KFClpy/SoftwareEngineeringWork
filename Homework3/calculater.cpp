#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<string.h>
#include<iostream>
using namespace std;

void clear_string(char string[]);
class Jisuanqi 
{
private:
	char string[128];
public:
	Jisuanqi(char string1[128]);
	char* show_string()
	{
		char *show;
		show=(char*)malloc(128);
		strcpy(show,string);
		return show;
	}
	void change_string1()
	{
		int i;
		char zichuan[128];
		char zichuan2[128];
		for(i=0;string[i]!='\0';i++)
		{
			if(string[i-1]=='s'&&string[i]=='(')
			{
				int j,u;
				u=i+1;
				for(j=0;;j++)
				{
					zichuan[j]=string[u];
					u++;
					if(string[u]==')')break;
				}
				zichuan[j+1]='\0';
			    double s;
			    sscanf(zichuan,"%lf",&s);
			    s=sin(s/180*3.141592654);
				sprintf(zichuan2,"%lf",s);
				if(s>=0)
				{
				char front[128];
				char last[128];
				int i1;
				for(i1=0;string[i1]!='s';i1++)
				{
					front[i1]=string[i1];
				};
				front[i1]='\0';
				int i2=0;
				for(i1=u+1;string[i1]!='\0';i1++)
				{
					last[i2]=string[i1];
					i2++;
				}
				last[i2]='\0';
				strcat(front,zichuan2);
				strcat(front,last);
				strcpy(string,front);
				i=0;
				}
				else 
				{
					char zichuan3[128];
					strcpy(zichuan3,"(");
					strcat(zichuan3,zichuan2);
						strcat(zichuan3,")");
						char front[128];
				char last[128];
				int i1;
				for(i1=0;string[i1]!='s';i1++)
				{
					front[i1]=string[i1];
				};
				front[i1]='\0';
				int i2=0;
				for(i1=u+1;string[i1]!='\0';i1++)
				{
					last[i2]=string[i1];
					i2++;
				}
				last[i2]='\0';
				strcat(front,zichuan3);
				strcat(front,last);
				strcpy(string,front);
				i=0;
				}
			}
		}
	}
	void change_string2()
	{
		int i;
		char zichuan[128];
		char zichuan2[128];
		for(i=0;string[i]!='\0';i++)
		{
			if(string[i-1]=='c'&&string[i]=='(')
			{
				int j,u;
				u=i+1;
				for(j=0;;j++)
				{
					zichuan[j]=string[u];
					u++;
					if(string[u]==')')break;
				}
				zichuan[j+1]='\0';
			    double c;
			    sscanf(zichuan,"%lf",&c);
			    c=cos(c/180*3.141592654);
				sprintf(zichuan2,"%lf",c);
				if(c>=0)
				{
				char front[128];
				char last[128];
				int i1;
				for(i1=0;string[i1]!='c';i1++)
				{
					front[i1]=string[i1];
				};
				front[i1]='\0';
				int i2=0;
				for(i1=u+1;string[i1]!='\0';i1++)
				{
					last[i2]=string[i1];
					i2++;
				}
				last[i2]='\0';
				strcat(front,zichuan2);
				strcat(front,last);
				strcpy(string,front);
				i=0;
				}
				else 
				{
					char zichuan3[128];
					strcpy(zichuan3,"(");
					strcat(zichuan3,zichuan2);
						strcat(zichuan3,")");
						char front[128];
				char last[128];
				int i1;
				for(i1=0;string[i1]!='c';i1++)
				{
					front[i1]=string[i1];
				};
				front[i1]='\0';
				int i2=0;
				for(i1=u+1;string[i1]!='\0';i1++)
				{
					last[i2]=string[i1];
					i2++;
				}
				last[i2]='\0';
				strcat(front,zichuan3);
				strcat(front,last);
				strcpy(string,front);
				i=0;
				}
			}
		}
	}
	void change_string3()
	{
		int i;
		char zichuan[128];
		char zichuan2[128];
		for(i=0;string[i]!='\0';i++)
		{
			if(string[i-1]=='t'&&string[i]=='(')
			{
				int j,u;
				u=i+1;
				for(j=0;;j++)
				{
					zichuan[j]=string[u];
					u++;
					if(string[u]==')')break;
				}
				zichuan[j+1]='\0';
			    double t;
			    sscanf(zichuan,"%lf",&t);
			    t=tan(t/180*3.141592654);
				sprintf(zichuan2,"%lf",t);
			if(t>=0)
				{
				char front[128];
				char last[128];
				int i1;
				for(i1=0;string[i1]!='t';i1++)
				{
					front[i1]=string[i1];
				};
				front[i1]='\0';
				int i2=0;
				for(i1=u+1;string[i1]!='\0';i1++)
				{
					last[i2]=string[i1];
					i2++;
				}
				last[i2]='\0';
				strcat(front,zichuan2);
				strcat(front,last);
				strcpy(string,front);
				i=0;
				}
				else 
				{
					char zichuan3[128];
					strcpy(zichuan3,"(");
					strcat(zichuan3,zichuan2);
						strcat(zichuan3,")");
						char front[128];
				char last[128];
				int i1;
				for(i1=0;string[i1]!='t';i1++)
				{
					front[i1]=string[i1];
				};
				front[i1]='\0';
				int i2=0;
				for(i1=u+1;string[i1]!='\0';i1++)
				{
					last[i2]=string[i1];
					i2++;
				}
				last[i2]='\0';
				strcat(front,zichuan3);
				strcat(front,last);
				strcpy(string,front);
				i=0;
				}
			}
		}
	}
	void change_string4()
	{
		int i;
		char zichuan[128];
		char zichuan2[128];
		for(i=0;string[i]!='\0';i++)
		{
			if(string[i-1]=='p'&&string[i]=='(')
			{
				int j,u;
				u=i+1;
				for(j=0;;j++)
				{
					zichuan[j]=string[u];
					u++;
					if(string[u]==')')break;
				}
				zichuan[j+1]='\0';
			    double p;
			    sscanf(zichuan,"%lf",&p);
			    p=pow(p,2);
				sprintf(zichuan2,"%lf",p);
				char front[128];
				char last[128];
				int i1;
				for(i1=0;string[i1]!='p';i1++)
				{
					front[i1]=string[i1];
				};
				front[i1]='\0';
				int i2=0;
				for(i1=u+1;string[i1]!='\0';i1++)
				{
					last[i2]=string[i1];
					i2++;
				}
				last[i2]='\0';
				strcat(front,zichuan2);
				strcat(front,last);
				strcpy(string,front);
				i=0;
			}
		}
	}
	void change_string5()
	{
      int i;
		char zichuan[128];
		char zichuan2[128];
		for(i=0;string[i]!='\0';i++)
		{
			if(string[i-1]=='k'&&string[i]=='(')
			{
				int j,u;
				u=i+1;
				for(j=0;;j++)
				{
					zichuan[j]=string[u];
					u++;
					if(string[u]==')')break;
				}
				zichuan[j+1]='\0';
			    double k;
			    sscanf(zichuan,"%lf",&k);
			    k=pow(k,0.5);
				sprintf(zichuan2,"%lf",k);
				char front[128];
				char last[128];
				int i1;
				for(i1=0;string[i1]!='k';i1++)
				{
					front[i1]=string[i1];
				};
				front[i1]='\0';
				int i2=0;
				for(i1=u+1;string[i1]!='\0';i1++)
				{
					last[i2]=string[i1];
					i2++;
				}
				last[i2]='\0';
				strcat(front,zichuan2);
				strcat(front,last);
				strcpy(string,front);
				i=0;
			}
		}
	}
	void change_string()
	{
		char front[128];
		char last[128];
		int i;
		int j=0;
     if(string[0]=='-'){strcpy(front,"(0-1)*");
	
	 for(i=1;string[i]!='\0';i++)
	 {
		 last[j]=string[i];
		 j++;
	 }
	 last[j]='\0';
	 strcat(front,last);
	 strcpy(string,front);
	 }
	 char front1[128];
	 char last1[128];
	 int u=0;
	 for(i=0;string[i]!='\0';i++)
	 {
		clear_string(last1);
		clear_string(front1);
		u=0;
		 if((string[i-1]=='('&&string[i]=='-')||(string[i-1]=='/'&&string[i]=='-')||(string[i-1]=='*'&&string[i]=='-'))
		 {
			 for(j=0;j<i;j++)
			 {
				 front1[u]=string[j];
				 u++;
			 }
			 front1[u]='\0';
			 strcat(front1,"(0-1)*");
			 u=0;
			 for(j=i+1;string[j]!='\0';j++)
			 {
				 last1[u]=string[j];
				 u++;
			 }
			 last1[u]='\0';
			 strcat(front1,last1);
			 strcpy(string,front1);
		 }
	 }
	}
	
};
Jisuanqi::Jisuanqi(char string1[])
{
	strcpy(string,string1);
}
void clear_string(char string[])
{
	int i;
	for(i=0;i<128;i++)
	{
		string[i]=0;
	}
}
typedef struct CharStack			
{
	char data[128];
	int top;
}cStack;

typedef struct DoubleStack	
{
	double data[128];
	int top;
}dStack;

void Initc(cStack *s1)
{
	s1->top=-1;
}
int Pushc(cStack *c1,char op)
 {
 	if(c1->top<128)
 	{
 		c1->data[++c1->top]=op;
 		return 1;
	}
	else return 0;
}

char Gettopc(cStack *c1)
{
	return c1->data[c1->top];
}
char Popc(cStack *c1)
{
	return c1->data[c1->top--];
}
void Initd(dStack *d1)
{
	d1->top=-1;
}

int Pushd(dStack *d1,double data)
{
	if(d1->top<128)
	{
		d1->data[++d1->top]=data;
		return 1;
	}
	else return 0;
}

double Popd(dStack *d1)
{
	return d1->data[d1->top--];
}

int Isop(char op)		
{
	switch(op)
	{
		case '(': return 6;
		case '+': case '-': return 2;
		case '*': case '/': return 4;
	}
}
int Inop(char op)		
{
	switch(op)
	{
		case '(': return 1;
		case '+': case '-': return 3;
		case '*': case '/': return 5;
	}
}

void Trans(char *s1,char *s2)
{
	int i=0;
	int j=0;
	int flag1=-1;				
	int flag2=-1; 				
	cStack st1;				
	Initc(&st1);
	while(s1[i]!='\0')
	{
		if(flag1==0&&flag2==1)		
		{
			s2[j++]=' ';
			flag1=1; 
		}
		if(s1[i]>='0'&&s1[i]<='9'||s1[i]=='.')
		{
			s2[j++]=s1[i];
			flag2=0;
			flag1=0;
		}
		else if(s1[i]=='+'||s1[i]=='-'||s1[i]=='*'||s1[i]=='/'||s1[i]=='(')
		{
			flag2=1;
			if(st1.top<0||Isop(s1[i])>Inop(Gettopc(&st1)))
			{
				Pushc(&st1,s1[i]);
			}
			else
			{
				while(st1.top>=0&&Isop(s1[i])<Inop(Gettopc(&st1)))		 
				{
						s2[j++]=Popc(&st1);
						flag1=1;
				}
				if(st1.top<0||Isop(s1[i])>Inop(Gettopc(&st1)))			
				{
					Pushc(&st1,s1[i]);
				}
				
			}
		}
		else if(s1[i]==')')				 
		{
			flag2=1;
			if(Gettopc(&st1)!='(')		
			{
				flag1=1;
			}
			while(Gettopc(&st1)!='(')
			{
				s2[j++]=Popc(&st1);
			}
			Popc(&st1);		 
		}
		i++;
	}
	while(st1.top>=0)		
	{
		s2[j++]=Popc(&st1);
	}
	s2[j]='\0';
}

double Calculate(char *s1)
{
	int i=0;
	int flag;				
	double data1,data2;
	double sum;
	dStack ds1;
	Initd(&ds1);
	while(s1[i]!='\0')
	{
		if(s1[i]=='+'||s1[i]=='-'||s1[i]=='*'||s1[i]=='/')			
		{
			data1=Popd(&ds1);
			data2=Popd(&ds1);
			if(s1[i]=='+') Pushd(&ds1,data2+data1);
			else if(s1[i]=='-') Pushd(&ds1,data2-data1);
			else if(s1[i]=='*') Pushd(&ds1,data2*data1);
			else if(s1[i]=='/') Pushd(&ds1,data2/data1);
		}
		else							
		{
			flag=0;					
			sum=0;
			double divider=1;
			while(s1[i]!=' '&&s1[i]!='+'&&s1[i]!='-'&&s1[i]!='*'&&s1[i]!='/')
			{
				if(s1[i]=='.')		
				{
					flag=1;
					i++;
					continue;
				}
				if(flag==0)
				{
					sum=sum*10+(double)(s1[i]-'0');
				}
				else
				{
					divider=divider*10;
					sum=sum+((double)(s1[i]-'0'))/divider;
				}
				i++;
			}
			if(s1[i]=='+'||s1[i]=='-'||s1[i]=='*'||s1[i]=='/') i--;	
			Pushd(&ds1,sum);
		}
		i++;		
	}
	 return Popd(&ds1);
}

int main()
{
	char string[128];
	char string1[128];
	printf("特殊运算符:\n");
	printf("s():对括号内的数值进行sin计算\n");
	printf("c():对括号内的数值进行cos计算\n");
	printf("t():对括号内的数值进行tan计算\n");
	printf("p():对括号内的数值进行平方计算\n");
	printf("k():对括号内的数值进行开根号计算\n");
	while(1)
	{
		printf("请输入计算式:\n");
		clear_string(string);
		clear_string(string1);
	    scanf("%s",string);
	    getchar();
	    Jisuanqi jisuanji(string);
	    jisuanji.change_string1();
	    jisuanji.change_string2();
	    jisuanji.change_string3();
	    jisuanji.change_string4();
	    jisuanji.change_string5();
	    jisuanji.change_string();
	    strcpy(string,jisuanji.show_string());
	    Trans(string,string1);
	    double result;
	    result=Calculate(string1);
	    printf("%lf\n",result);
	}
	system("pause");
	return 0;
}
    
	

				



				


				










