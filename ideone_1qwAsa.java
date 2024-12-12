import java.util.Scanner;
class hashmap{
    int size=0;
    int [] data;
    int [] freq;
    int [] state;
    hashmap(int size){
        data = new int [size];
        freq = new int [size];
        state = new int [size];
        this.size=size;
    }
    void insert(int x)
    {
        for(int i=0;i<this.size;i++){
            if (data[i]==x){
                freq[i]+=1;
                return;
            }
        }
        int indx = hashcode(x),i=1;
        while(state[indx]==1)
        {
            indx=hashcode(x+i);
            i++;
        }
        data[indx]=x;
        freq[indx]+=1;
        state[indx]=1;
        if (indx<10)
        {
        System.out.println(" the element "+x+" inserted at a position "+indx);
        }
        else{
            System.out.println("no space found in the table");
        }
    }
    boolean search( int x){
        int indx=hashcode(x);
        int i=1;
        while(data[indx]!=x && state[indx]!=0) {
            indx=hashcode(x+i);
            i++;
        }
        if(data[indx]==x)
            return true;
        return false;
    }
    int getCount( int x){
        int indx =hashcode(x),i=1,ans=0;
        while(data[indx]!=x && state[indx]!=0) {
            indx=hashcode(x+i);
            i++;
        }
        if (data[indx]==x){
            return freq[indx];
        }
        return 0;
    }
    void delete (int x){
        int indx = hashcode(x),i=1;
        while(data[indx]!=x && state[indx]!=0) {
            indx=hashcode(x+i);
            i++;
        }
        if (data[indx]==x){
            if(freq[indx]-1==0){
                data[indx]=0;
                state[indx]=-1;
            }
            freq[indx]--;
        }
    }
    int Size(){
        int count = 0;
        for(int i=0;i<this.size;i++)
            if ( state[i]==1)
                count++;
        return count;
    }
    int hashcode(int x){
        return ((x%this.size)+((x/2)%this.size))%7;
    }
}
public class Main{
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        System.out.println("********************MENU*******************");
        System.out.print("1. insert \n 2. search \n 3. getcount \n 4. delete \n  5.size\n 6.hashcode \n 7.exit \n");
        hashmap hm= new hashmap(10);
        int choice=0;
        while(choice !=7){
            System.out.println("enter you choice:");
            choice = sc.nextInt();
            int x;
            switch(choice){
                case 1:
                    System.out.println("enter the number to insert");
                    x=sc.nextInt();
                    hm.insert(x);
                    break;
                case 2:
                    System.out.println("enter an element to search:");
                    boolean var=hm.search(sc.nextInt());
                    if(var)
                        System.out.println("element found in map");
                    else
                        System.out.println("element not found");
                    break;
                case 3:
                    System.out.println("enter element to getcount:");
                    x=sc.nextInt();
                    int count=hm.getCount(x);
                    System.out .println("the count of "+x+" is"+count);
                    break;
                case 4:
                    System.out.println("enter element to delete :");
                    hm.delete(sc.nextInt());
                    break;
                case 5:
                    System.out.println("the size is :"+hm.Size());
                    break;
                case 6:
                    System.out.println("enter an element to calculate hashcode :");
                    System.out.println(hm.hashcode(sc.nextInt()));
                    break;
                case 7:
                    return;
                default:
                    System.out.println("invalid case try again !");
            }
        }
System.out.println("****************************************");
    }
} 