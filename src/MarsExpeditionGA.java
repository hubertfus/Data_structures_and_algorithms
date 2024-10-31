import java.util.*;

public class MarsExpeditionGA {
    public static void main(String[] args) {
        int[][] astronauts = {
               //A  B  C  D  E  F
                {1, 0, 0, 0, 1, 0}, // k1
                {0, 1, 0, 1, 0, 1}, // k2
                {1, 1, 0, 0, 1, 0}, // k3
                {0, 1, 0, 0, 1, 1}, // k4
                {0, 0, 1, 1, 0, 0}  // k5
        };

        Set<Integer> result = selectAstronautsForMarsMission(astronauts, 6);

        if (result != null) {
            System.out.println("The astronauts who can go to Mars are: " + result);
        } else {
            System.out.println("Unable to find a group of astronauts covering all specialties.");
        }
    }

    public static Set<Integer> selectAstronautsForMarsMission(int[][] astronauts, int requiredSpecialties) {
        Set<Integer> pickedAstronauts = new HashSet<>();
        Set<Integer> coveredSpecialties = new HashSet<>();
        int n = astronauts.length;
        int minSpecialties = requiredSpecialties;

        while (minSpecialties > 0) {
            boolean foundAstronaut = false;

            for (int j = 0; j < n; j++) {
                if (pickedAstronauts.contains(j)) {
                    continue;
                }

                int specialtiesAmount = Arrays.stream(astronauts[j])
                        .reduce(0, Integer::sum);
                if (specialtiesAmount == minSpecialties) {
                    int newSpecialties = 0;

                    for (int x = 0; x < astronauts[j].length; x++) {
                        if (astronauts[j][x] == 1) {
                            if (!coveredSpecialties.contains(x)) {
                                newSpecialties++;
                            }
                            coveredSpecialties.add(x);
                        }
                    }

                    if (newSpecialties > 0) {
                        pickedAstronauts.add(j);
                        foundAstronaut = true;

                    }
                }

                if (coveredSpecialties.size() == requiredSpecialties) {
                    return pickedAstronauts;
                }
            }

            if (!foundAstronaut) {
                minSpecialties--;
            }
        }

        return null;
    }
}
