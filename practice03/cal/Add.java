package practice03.cal;

public class Add {
    int a;
    int b;

    // public Add(int a, int b){
    //     this.a = a;
    //     this.b = b;
    // }


    public void setValue(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int calculate(){
        return this.a + this.b;
    } 

}
