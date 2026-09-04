public class TrafficSignalStreakAnalyzer {
    static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.length() == 0) {
            System.out.println("No signal data provided");
            return;
        }
 
        char longestColor = signalLog.charAt(0);
        int longestLength = 1;
 
        char currentColor = signalLog.charAt(0);
        int currentLength = 1;
 
        for (int i = 1; i < signalLog.length(); i++) {
            char c = signalLog.charAt(i);
 
            if (c == currentColor) {
                currentLength++;
            } else {
                currentColor = c;
                currentLength = 1;
            }
 
            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestColor = currentColor;
            }
        }
 
        System.out.println("Longest Streak: '" + longestColor + "' repeated " + longestLength + " times");
    }
 
    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}
