import java.util.HashSet;
import java.util.Set;

public class OtpGenerator {
    public static int generateSixDigitOtp() {
        int min = 100000;
        int max = 999999;
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static int[] generateOtpArray(int attempts) {
        int[] otps = new int[attempts];
        for (int i = 0; i < attempts; i++)
            otps[i] = generateSixDigitOtp();
        return otps;
    }

    public static boolean areAllUnique(int[] otps) {
        Set<Integer> set = new HashSet<>();
        for (int otp : otps)
            set.add(otp);
        return set.size() == otps.length;
    }

    public static void main(String[] args) {
        int attempts = 10;
        int[] otps = generateOtpArray(attempts);
        System.out.print("Generated OTPs: ");
        for (int otp : otps)
            System.out.print(otp + " ");
        System.out.println();
        System.out.println("All OTPs unique: " + areAllUnique(otps));
    }
}
