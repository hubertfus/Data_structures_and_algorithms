import java.util.*;

public class MonteCarloShortestPath {

    static Map<String, Map<String, Integer>> connections = new HashMap<>();

    static {
        connections.put("Warsaw", Map.of("Katowice", 300, "Zakopane", 402, "Lviv", 356));
        connections.put("Katowice", Map.of("Warsaw", 300, "Vienna", 440, "Budapest", 474));
        connections.put("Zakopane", Map.of("Warsaw", 402, "Budapest", 330));
        connections.put("Lviv", Map.of("Warsaw", 356, "Bucharest", 823));
        connections.put("Vienna", Map.of("Katowice", 440, "Zagreb", 430));
        connections.put("Budapest", Map.of("Katowice", 474, "Zakopane", 330, "Bucharest", 813, "Zagreb", 365, "Sofia", 774));
        connections.put("Bucharest", Map.of("Lviv", 823, "Budapest", 813, "Sofia", 403));
        connections.put("Zagreb", Map.of("Vienna", 430, "Budapest", 365, "Sofia", 768));
        connections.put("Sofia", Map.of("Budapest", 774, "Bucharest", 403, "Zagreb", 768));
    }

    public static MonteCarloResult monteCarloShortestPath(int trials) {
        String start = "Warsaw";
        String destination = "Sofia";
        int shortestDistance = Integer.MAX_VALUE;
        List<String> shortestRoute = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < trials; i++) {
            int distance = 0;
            Set<String> visited = new HashSet<>();
            List<String> route = new ArrayList<>();
            String currentCity = start;

            while (!currentCity.equals(destination)) {
                visited.add(currentCity);
                route.add(currentCity);
                List<String> neighbors = new ArrayList<>(connections.get(currentCity).keySet());
                neighbors.removeIf(visited::contains);
                if (neighbors.isEmpty()) break;
                String nextCity = neighbors.get(random.nextInt(neighbors.size()));
                distance += connections.get(currentCity).get(nextCity);
                currentCity = nextCity;
            }

            if (currentCity.equals(destination)) {
                route.add(destination);
                if (distance < shortestDistance) {
                    shortestDistance = distance;
                    shortestRoute = new ArrayList<>(route);
                }
            }
        }

        return new MonteCarloResult(shortestDistance, shortestRoute);
    }

    public static void main(String[] args) {
        int trials = 100;
        MonteCarloResult result = monteCarloShortestPath(trials);

        if (result.shortestDistance < Integer.MAX_VALUE) {
            System.out.println("The shortest path from Warsaw to Sofia is approximately: "
                    + result.shortestDistance + " km.");
            System.out.println("Route taken: " + String.join(" -> ", result.shortestRoute));
        } else {
            System.out.println("No route found from Warsaw to Sofia in the given number of trials.");
        }
    }

    public static class MonteCarloResult {
        int shortestDistance;
        List<String> shortestRoute;

        MonteCarloResult(int shortestDistance, List<String> shortestRoute) {
            this.shortestDistance = shortestDistance;
            this.shortestRoute = shortestRoute;
        }
    }
}
