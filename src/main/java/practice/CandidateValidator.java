package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return isValid(candidate, 35, "Ukrainian", 10);
    }


    private static boolean isValid(Candidate c, int age, String nationality, int required) {
        return c.getAge() > age
                && c.isAllowedToVote()
                && nationality.equals(c.getNationality())
                && liveMoreThan(c, required);
    }

    private static boolean liveMoreThan(Candidate candidate, int required) {
        String[] period = candidate.getPeriodsInUkr()
                .trim()
                .split("\\s*-\\s*");
        int diff = Math.abs(
                Integer.parseInt(period[1])
                        - Integer.parseInt(period[0]));
        return diff >= required;
    }
}
