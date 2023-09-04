package thread;

public class Consumer extends Thread { 

Thread1 p;


Consumer(Thread1 p) 

{ 

this.p=p; 

start(); 

} 

public void run() 

{ 
	int i=0;

while(i==0) 

{ 
i++;
p.deSerializeProjectDetails(); 

} 

} 

}
