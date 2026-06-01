package rvt;

import java.util.HashMap;

public class IOweYou {

    private HashMap < String, Double > debts;

    public IOweYou() {
        this.debts = new HashMap <>();
    }

    public void setSum(String toWhom, double amount) {
        debts. put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        return debts.getOrDefault(toWhom, 0.0);
    }

}

    class Main {

        public static void main (String[] args) {
            IOweYou mattsIOU = new IOweYou();
            mattsIOU.setSum ("Arthurt", 51.5);
            mattsIOU.setSum("Michael", 30);

            System.out.println (mattsIOU.howMuchDoIOweTo("Arthurt"));
            System.out.println(mattsIOU.howMuchDoIOweTo("Michael"));

            mattsIOU.setSum("Arthur", 10.5);
            System.out.println(mattsIOU.howMuchDoIOweTo("Arthur"));
        }
    }