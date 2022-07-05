package burger;

import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;

public class Menu extends Burger211 {
    String franchiseName;
    int discountRate;
    String promotion;
    String currencyCode;
    String currencySymbol;
    boolean hasPromotion = true;

    static ExchangeRate convert;

    static double exchangeRate;

    // constructor
    Menu(String country, String franchise) {
        Locale locale = new Locale.Builder().setRegion(country).build();

        currencyCode = Currency.getInstance(locale).getCurrencyCode();
        currencySymbol = Currency.getInstance(locale).getSymbol();

        // getting exchange rate
        try {
            convert = new ExchangeRate();
            exchangeRate = convert.getRate(currencyCode);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        franchiseName = franchise;
    }

    // getting promotions

    @Override
    public void Promotion(int discount,String promote) {
        // if we have a discount
        if (discount>0) {
            promotion = "get " + discount + "% off " + promote;
        }
        else {
            hasPromotion = false; // we will need it to understand either to print discount price or not
        }
        discountRate = discount;
    }

    @Override
    public void printMenu(){
        DecimalFormat df = new DecimalFormat("#,###,###.00");
        double[] localprice = new double[3];
        double[] localdisprice = new double[3];
        for (int i=0; i<getHowManyBurgers(); i++) {
            localprice[i] = getPrice(i);
            localdisprice[i] = getdisPrice(i);
        }
        // if we have a discount, we should print the version with the regular and discount prices
        if (hasPromotion) {
            new MenuGUI(franchiseName,promotion,
                    getName(0),currencySymbol+df.format(localprice[0]),getTopping(0),currencySymbol+df.format(localdisprice[0]),
                    getName(1),currencySymbol+df.format(localprice[1]),getTopping(1),currencySymbol+df.format(localdisprice[1]),
                    getName(2),currencySymbol+df.format(localprice[2]),getTopping(2),currencySymbol+df.format(localdisprice[2]),exchangeRate);
        }
        else {
            new MenuGUI(franchiseName,promotion,
                    getName(0),currencySymbol+df.format(localprice[0]),getTopping(0),
                    getName(1),currencySymbol+df.format(localprice[1]),getTopping(1),
                    getName(2),currencySymbol+df.format(localprice[2]),getTopping(2),exchangeRate);
        }
    }

    // getting price
    @Override
    public double getPrice(int i) {
        return super.getPrice(i) * exchangeRate;
    }

    // getting price with the discount
    public double getdisPrice(int i) {
        return (super.getPrice(i) - ((super.getPrice(i) * discountRate)/100.0)) * exchangeRate;
    }
}
