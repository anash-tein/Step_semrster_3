public class MovieReviewWordLengthProfiler
 {
    static void analyzeReview(String review) {
        if (review == null || review.isEmpty()) {
            System.out.println("No review provided");
            return;
        }

        String[] words = review.split("\\s+");
        int totalWords = words.length;
        int totalLength = 0;
        int maxLength = 0;
        String longestWord = "";

        for (String word : words) {
            int length = word.length();
            totalLength += length;

            if (length > maxLength) {
                maxLength = length;
                longestWord = word;
            }
        }

        double averageLength = (double) totalLength / totalWords;

        System.out.println("Total Words: " + totalWords);
        System.out.println("Average Word Length: " + averageLength);
        System.out.println("Longest Word: '" + longestWord + "' with length " + maxLength);
    }

    public static void main(String[] args) {
        analyzeReview("This movie was absolutely fantastic and thrilling!");
    }
}
