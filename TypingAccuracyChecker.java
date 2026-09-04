public class TypingAccuracyChecker {
    static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatchPos = -1;
 
        for (int i = 0; i < original.length(); i++) {
            char o = original.charAt(i);
            char t = typed.charAt(i);
 
            if (o == t) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; // 1-based position
            }
        }
 
        int total = original.length();
        double accuracy = ((double) matched / total) * 100;
 
        StringBuilder result = new StringBuilder();
        result.append("Matched: ").append(matched).append("/").append(total);
        result.append(" | Accuracy: ").append(String.format("%.2f", accuracy)).append("%");
 
        if (firstMismatchPos == -1) {
            result.append(" | No Mismatches");
        } else {
            char oChar = original.charAt(firstMismatchPos - 1);
            char tChar = typed.charAt(firstMismatchPos - 1);
            result.append(" | First Mismatch at position ").append(firstMismatchPos)
                  .append(" ('").append(oChar).append("' vs '").append(tChar).append("')");
        }
 
        System.out.println(result);
    }
 
    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
