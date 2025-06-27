package SOLID.Factory;

public class Client {
    public static void main(String[] args) {
        OSFactory osFactory = new OSFactory();

        MobileOS os1 = osFactory.getInstance("Android");
        MobileOS os2 = osFactory.getInstance("iOS");
        

        OS_1.display();
        OS_2.display();
      
    }
}
