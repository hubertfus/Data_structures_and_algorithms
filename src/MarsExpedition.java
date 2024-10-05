import java.util.*;

public class MarsExpedition {
    public static void main(String[] args) {
        Map<String, Set<String>> astronautSpecialties = new HashMap<>();
        astronautSpecialties.put("a1", new HashSet<>(Arrays.asList("A", "D")));
        astronautSpecialties.put("a2", new HashSet<>(Arrays.asList("B", "D")));
        astronautSpecialties.put("a3", new HashSet<>(Arrays.asList("B", "C")));
        astronautSpecialties.put("a4", new HashSet<>(Arrays.asList("A", "B")));
        astronautSpecialties.put("a5", new HashSet<>(Arrays.asList("C", "D")));

        Set<String> requiredSpecialties = new HashSet<>(Arrays.asList("A", "B", "C", "D"));

        List<String> result = findMinimumAstronauts(astronautSpecialties, requiredSpecialties);

        if (result != null) {
            System.out.println("The astronauts who can go to Mars are: " + result);
        } else {
            System.out.println("Unable to find a group of astronauts covering all specialties.");
        }
    }

    public static List<String> findMinimumAstronauts(Map<String, Set<String>> astronautSpecialties, Set<String> requiredSpecialties) {
        List<String> bestCombination = null;
        List<String> astronauts = new ArrayList<>(astronautSpecialties.keySet());
        int n = astronauts.size();

        for (int i = 0; i < n; i++) {
            List<List<String>> combinations = new ArrayList<>();
            generateCombinations(astronauts, 0, i, new ArrayList<>(), combinations);
            for (List<String> combination : combinations) {
                Set<String> coveredSpecialties = new HashSet<>();
                for (String astronaut : combination) {
                    coveredSpecialties.addAll(astronautSpecialties.get(astronaut));
                }
                if (coveredSpecialties.containsAll(requiredSpecialties) && (bestCombination == null || combination.size() < bestCombination.size())) {
                    bestCombination = combination;
                }
            }
        }

        return bestCombination;
    }

    public static void generateCombinations(List<String> astronauts, int start, int size, List<String> current, List<List<String>> combinations) {
        if (current.size() == size) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < astronauts.size(); i++) {
            current.add(astronauts.get(i));
            generateCombinations(astronauts, i + 1, size, current, combinations);
            current.removeLast();
        }
    }
}
