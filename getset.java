
class student{
   private  int id;
    private String name;

    public int  getid(){
          System.out.println(id);
          return id;
    }
    public void setid(int n){
        id=n;
  }
  public void setname(String i){
    name=i;
}
  public String  getname(){
    System.out.println(name);
    return name;
}




}


public class getset {
    public static void main(String[] args) {
         student sam =new student();
         sam.setid(69);
         sam.getid();
        
         sam.setname("samrath");
         sam.getname();
    }

    
}