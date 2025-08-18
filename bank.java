class procedure{
      private int acno;
      private double balance;

     
      public void deposit(double  n){
        if(n>0){
         balance +=n;
        }
        System.out.println("DEPOSITED AMOUNT : "+ balance);
  }
      public void withdraw(double  n){
        if(n>0 && n<=balance){
        balance -=n;
    }
    System.out.println("REMAINING BALANCE : "+ balance);
}



}
public class bank {
    public static void main(String[] args) {
        procedure sam=new procedure();
        sam.deposit(300);
        sam.withdraw(200);
    }
}