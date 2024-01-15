package Array;

public class CardNumberValidator {

    public static void main(String[] args) {
        String cardNumber = "4242424242426742"; // Replace this with the actual card number

//        4242424242426742-Valid
//        1111111111111111 - invalid
        boolean isValid = validateCardNumber(cardNumber);
        System.out.println("Is the card number valid? " + isValid);
    }

    private static boolean validateCardNumber(String cardNumber) {
        int sum = 0;
        boolean doubleDigit = false;

        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(cardNumber.charAt(i));

            if (doubleDigit) {
                digit *= 2;
                if (digit > 9) {
                    digit = digit % 10 + digit / 10;
                }
            }

            sum += digit;
            doubleDigit = !doubleDigit;
        }

        return sum % 10 == 0;
    }
}