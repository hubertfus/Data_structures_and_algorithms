# Data Structures and Algorithms

Welcome to my repository where I store all the programs and data structures I have developed during my studies for the "Data Structures and Algorithms" course.

## Table of Contents

1. [Project Description](#project-description)
2. [Problems List](#problems)

## Project Description

The goal of this repository is to gather all the programs and algorithms created during my studies in the "Data Structures and Algorithms" course. It contains various solutions to problems and implementations of data structures that illustrate the knowledge and skills I have acquired.

## Problems

- [Mars Expedition Problem](#mars-expedition-problem)
- [GDP Prediction Problem](#gdp-prediction-problem)
- [Coin Change Problem](#coin-change-problem)
- [Shortest Path Problem (Monte Carlo)](#shortest-path-problem-monte-carlo)

### Mars Expedition Problem

The problem at hand involves selecting a crew for a manned mission to Mars. The main organizer of the expedition needs to solve the following problem:

There are five astronauts (k1, k2, k3, k4, k5) who have successfully passed the preliminary qualification for participation in the expedition. On board the special spaceship, at least one specialist from each of the following fields is required: A, B, C, and D.

The specialization of the astronauts is as follows:
- **Field A**: k1, k4
- **Field B**: k2, k3, k4
- **Field C**: k3, k5
- **Field D**: k1, k2, k5

Due to limited space on the spaceship, the aim is to choose the smallest possible group of astronauts that includes at least one specialist in each of the fields A, B, C, and D.

Link to the solution: [MarsExpedition.java](https://github.com/hubertfus/Data_structures_and_algorithms/blob/master/src/MarsExpedition.java)  
Link to the solution in greedy algorithm: [MarsExpeditionGA.java](https://github.com/hubertfus/Data_structures_and_algorithms/blob/master/src/MarsExpeditionGA.java)

### GDP Prediction Problem

In 1998, Poland's Gross Domestic Product (GDP) was $6,000, and the GDP growth rate was maintained at 6 percent per year. Assuming that the GDP growth rate in Poland remains at the same level in the following years, how many years will it take for Poland's GDP to double? In 1998, Germany's GDP was $12,000, and the GDP growth rate was 1.2 percent per year. Assuming that the GDP growth rate in Germany remains at the same level in the following years, is there a chance that Poland's GDP will equal Germany's GDP within the next 20 years?

Link to the solution in divide and conquer method: [GDPPredictionDAC.java](https://github.com/hubertfus/Data_structures_and_algorithms/blob/master/src/GDPPredictionDAC.java)  
Link to the solution in Dynamic programming method: [GDPPredictionDP.java](https://github.com/hubertfus/Data_structures_and_algorithms/blob/master/src/GDPPredictionDP.java)

### Coin Change Problem

The **Coin Change Problem** focuses on giving the correct change using the fewest coins possible. For this problem, we have coins of the following denominations: 1 gr, 2 gr, 5 gr, 10 gr, 20 gr, 50 gr, 1 zł, 2 zł, and 5 zł. The goal is to construct an algorithm that, given an amount of change, outputs the minimum number of coins required to make up that amount.

Link to the solution in greedy algorithm: [CoinChangeGA.java](https://github.com/hubertfus/Data_structures_and_algorithms/blob/master/src/CoinChangeGA.java)

### Shortest Path Problem (Monte Carlo)

The **Shortest Path Problem (Monte Carlo)** aims to determine the shortest path between Warsaw and Sofia using a Monte Carlo approach. Given a set of distances between cities, we want to find the shortest path between these two cities by simulating random paths and tracking the shortest route found.

#### Problem Details
The available routes between cities and their respective distances are as follows:

| City       | Warsaw | Katowice | Zakopane | Lviv  | Vienna | Budapest | Bucharest | Zagreb | Sofia |
|------------|--------|----------|----------|-------|--------|----------|-----------|--------|-------|
| Warsaw     | 0      | 300      | 402      | 356   | -      | -        | -         | -      | -     |
| Katowice   | 300    | 0        | -        | -     | 440    | 474      | -         | -      | -     |
| Zakopane   | 402    | -        | 0        | -     | -      | 330      | -         | -      | -     |
| Lviv       | 356    | -        | -        | 0     | -      | -        | 823       | -      | -     |
| Vienna     | -      | 440      | -        | -     | 0      | -        | -         | 430    | -     |
| Budapest   | -      | 474      | 330      | -     | -      | 0        | 813       | 365    | 774   |
| Bucharest  | -      | -        | -        | 823   | -      | 813      | 0         | -      | 403   |
| Zagreb     | -      | -        | -        | -     | 430    | 365      | -         | 0      | 768   |
| Sofia      | -      | -        | -        | -     | -      | 774      | 403       | 768    | 0     |

Using the Monte Carlo method, a large number of random paths are generated between Warsaw and Sofia. Each path is evaluated for its total distance, and the shortest path found during the trials is reported as the approximate shortest path between the two cities.

Link to the solution: [MonteCarloShortestPath.java](https://github.com/hubertfus/Data_structures_and_algorithms/blob/master/src/MonteCarloShortestPath.java)
