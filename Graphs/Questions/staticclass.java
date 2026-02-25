// package Graphs.Questions;

class different{
    static int count = 0;
    static{
        count += 5; //16
    }
    
        System.out.print("insta");

        count += 1; //17
    
    different(){
        System.out.println("constructor");
        count += 10;//27
    }
    void print(){
        System.out.println(count);
    }
}
public class staticclass {
    public static void main(String[] args){
        different obj = new different();
        different obj1 = new different();

        // obj1.print();
    }
}
