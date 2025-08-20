public class overiding{


static void method(){
System.out.println("YO");
}
static void method(int a){

System.out.println("YO"+" "+a);
}
static void method(int a,int b){
    System.out.println("YO" + a + b);
}


  public static void main(String[] args) {
      method();
      method(9);
      method(7, 9);
      
  }
  

}