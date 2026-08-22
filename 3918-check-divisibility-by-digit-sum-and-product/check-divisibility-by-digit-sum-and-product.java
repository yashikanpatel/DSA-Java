class Solution {

    public boolean checkDivisibility(int n) {

        if (n % spliting(n) == 0) {
            return true;
        }

        return false;
    }

    public static int spliting(int n) {

        int sum = 0;
        int prod = 1;

        while (n != 0) {

            int rem = n % 10;

            sum += rem;
            prod *= rem;

            n /= 10;
        }

        return sum + prod;
    }
}