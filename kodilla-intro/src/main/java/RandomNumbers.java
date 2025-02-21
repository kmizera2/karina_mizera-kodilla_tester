public class RandomNumbers {

    public static int number;
    public static int sum = 0;
    public static int sum1 = 0;
    public static int sum2 = 0;
    static int min;
    static int max;

    public static int drawNumbers() {
        while (sum <= 5000) {
            sum = sum + (int) ((Math.random() * 30) + 0);
        }
        return sum;
    }

    public static int minNumber() {
        min = (int) ((Math.random() * 30) + 0);
        sum1 = min;
        while (sum1 <= 5000) {
            number = (int) ((Math.random() * 30) + 0);
            sum1 = sum1 + number;
            if (number < min)
                min = number;
        }
        return min;
    }

    public static int maxNumber() {
        max = (int) ((Math.random() * 30) + 0);
        sum2 = max;
        while (sum2 <= 5000) {
            number = (int) ((Math.random() * 30) + 0);
            sum2 = sum2 + number;
            if (number > max)
                max = number;
        }
        return max;
    }
}
