/*
Daniil Marozau, CS211 (Project 2 Burger_211)
202518560
04/27/2022

This application is an app that provides us with the menu consists of three burgers and prices converted to the locale currency
Also, we can add promotions, discounts and change burger toppings
*/

package burger;

import java.util.Scanner;

import static java.lang.System.exit;

public class myFranchise {
    public static void main(String[] args) {
        String country;
        String franchiseName;
        int discount;
        String promotion = "";
        int burgernumber;
        String newTopping;

        Scanner in = new Scanner(System.in);

        System.out.println("\n Project 2. Burger 211. Enter 0 to stop");
        boolean run = true;
        while (run) {
            System.out.println("\nEnter country name. (Alpha-2 code)");
            country = in.next();
            // if we want to end
            if (country.equals("0")) {
                run = false;
                System.out.println("Bye!");
                break;
            }
            else {
                in.nextLine();
                System.out.println("Enter your franchise name");
                franchiseName = in.nextLine();

                // starting new franchise
                Burger211 franchise = new Menu(country, franchiseName);

                System.out.println("Enter discount rate % (0 ~ 99)");
                discount = in.nextInt();
                // checking the discount
                if (discount>0) {
                    in.nextLine();
                    System.out.println("Enter promotion");
                    promotion = in.nextLine();
                }
                franchise.Promotion(discount,promotion);
                franchise.printMenu();
                System.out.println("Which burger would you like to change the topping? (enter 3 if not)");
                for (int i=0; i<franchise.getHowManyBurgers(); i++) {
                    System.out.println(i + ". " + franchise.getName(i));
                }
                burgernumber = in.nextInt();
                // no topping
                if (burgernumber == 3) {
                    System.out.println("As you want");
                }
                // changing topping
                else if (burgernumber>=0 && burgernumber<3) {
                    System.out.println("Write new toppings please");
                    newTopping = in.next();
                    franchise.UpdateTopping(newTopping, burgernumber);
                    franchise.printMenu();
                }
                // if Index out of range
                else {
                    System.out.println("No such Burger");
                    exit(0);
                }
            }
        }
    }
}
