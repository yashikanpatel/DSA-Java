class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        // ⭐ PATTERN 1: HashMap
        // Store reserved seats row-wise.
        // row number -> reserved seat numbers
        Map<Integer, Set<Integer>> reserved = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int seatNumber = seat[1];

            reserved
                .computeIfAbsent(row, k -> new HashSet<>())
                .add(seatNumber);
        }

        int answer = 0;

        // ⭐ PATTERN 2: Rows with NO reservations
        // Completely empty row can always fit 2 families.
        int emptyRows = n - reserved.size();
        answer += emptyRows * 2;


        // Check only rows which have reserved seats
        for (Set<Integer> seats : reserved.values()) {

            // ⭐ PATTERN 3: Check fixed ranges
            // A family can sit in:
            // 1) seats 2-5
            // 2) seats 4-7
            // 3) seats 6-9

            boolean left = true;    // 2-5
            boolean middle = true;  // 4-7
            boolean right = true;   // 6-9

            // Check whether any seat is reserved
            for (int seat : seats) {

                if (seat >= 2 && seat <= 5) {
                    left = false;
                }

                if (seat >= 4 && seat <= 7) {
                    middle = false;
                }

                if (seat >= 6 && seat <= 9) {
                    right = false;
                }
            }

            // ⭐ PATTERN 4: Greedy choice
            // If both outer groups are available,
            // we can put 2 families.
            if (left && right) {
                answer += 2;
            }

            // Otherwise, if ANY one valid group is available,
            // we can put 1 family.
            else if (left || middle || right) {
                answer += 1;
            }
        }

        return answer;
    }
}