import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Candidate implements Comparable<Candidate> {

    String name;
    double gpa;
    int codingScore;

    public Candidate(String name, double gpa, int codingScore) {
        this.name = name;
        this.gpa = gpa;
        this.codingScore = codingScore;
    }

    // Composite score used for ranking
    // Higher GPA and coding score give a higher composite score
    double compositeScore() {
        return gpa * 10 + codingScore * 0.5;
    }

    // Compare candidates by composite score in descending order
    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.compositeScore(), this.compositeScore());
    }

    // Shortlist and rank candidates
    public static Candidate[] shortlistAndRank(Candidate[] candidates) {

        List<Candidate> shortlisted = new ArrayList<>();

        for (Candidate c : candidates) {
            if (c.gpa >= 8.0 || c.codingScore >= 30) {
                shortlisted.add(c);
            }
        }

        Candidate[] result =
                shortlisted.toArray(new Candidate[0]);

        Arrays.sort(result);

        return result;
    }

    // Main method
    public static void main(String[] args) {

        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Karan", 7.5, 20),
            new Candidate("Rahul", 9.0, 35),
            new Candidate("Priya", 8.7, 45)
        };

        Candidate[] result = shortlistAndRank(candidates);

        System.out.println("Shortlisted and Ranked Candidates:");

        for (int i = 0; i < result.length; i++) {
            System.out.println(
                (i + 1) + ". " +
                result[i].name +
                " - GPA: " + result[i].gpa +
                ", Coding Score: " + result[i].codingScore +
                ", Composite Score: " +
                result[i].compositeScore()
            );
        }
    }
}