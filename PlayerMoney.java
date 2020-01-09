public class PlayerMoney{

double moneyavail;



public PlayerMoney(double m){
  this.moneyavail = m;
}



public void bet(double m){
if ((moneyavail - m)>=0){
moneyavail-=m;
}
 else {
   System.out.println("Funds not available for that bet. All-In.");
   m = moneyavail;
   moneyavail = 0;
 }
}


public void win(double m){
  moneyavail += m;
}




}
