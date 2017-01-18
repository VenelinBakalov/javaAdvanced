import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int distance = Integer.valueOf(scanner.nextLine());
        String daytime = scanner.nextLine();

        double travelRate = 0.90;
        double totalPrice = 0;

        if (distance < 20){
            if (daytime.equals("day")){
                travelRate = 0.79;
                totalPrice = 0.7 + (travelRate * distance);
            } else{
                travelRate = 0.9;
                totalPrice = 0.7 + (travelRate * distance);
            }
        } else if (distance < 100){
            travelRate = 0.09;
            totalPrice = travelRate * distance;
        } else {
            travelRate = 0.06;
            totalPrice = travelRate * distance;
        }

        System.out.printf("%.2f", totalPrice);


    }
}
