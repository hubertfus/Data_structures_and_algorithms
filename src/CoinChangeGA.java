import java.util.Map;
import java.util.TreeMap;

public class CoinChangeGA {
    public static void main(String[] args) {
        final int[] coinValues = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        final int[] maxQuantities = {1, 2, 0, 7, 2, 2, 5, 2, 10}; // max 13.49

        TreeMap<Integer, Integer> change = calculateChange(1269, coinValues, maxQuantities);
        if (change != null) {
            int sum =0;
            System.out.println("Change:");
            for (Map.Entry<Integer, Integer> entry : change.entrySet()) {
                System.out.println("Coin Value: " + entry.getKey() + ", Quantity: " + entry.getValue());
                sum += entry.getValue()*entry.getKey();
            }
            System.out.println("Sum       : " + sum);
        } else {
            System.out.println("No change can be made for the target amount.");
        }
    }

    public static TreeMap<Integer, Integer> calculateChange(int targetAmount, int[] coinValues, int[] maxQuantities) {
        TreeMap<Integer, Integer> change = new TreeMap<>();

        for (int i = 0; i < coinValues.length; ) {
            if (targetAmount >= coinValues[i] && maxQuantities[i] > 0) {
                targetAmount -= coinValues[i];
                maxQuantities[i]--;
                change.put(coinValues[i], change.getOrDefault(coinValues[i], 0) + 1);
                if (targetAmount == 0) {
                    return change;
                }
            } else {
                i++;
            }
        }
        return null;
    }
}
