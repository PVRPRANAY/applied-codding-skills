import java.util.*;
class UndergroundSystem {
    class CheckIn {
        String station;
        int time;
        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
    class Journey {
        int totalTime;
        int count;
        Journey() {
            totalTime = 0;
            count = 0;
        }
    }
    HashMap<Integer, CheckIn> checkInMap;
    HashMap<String, Journey> journeyMap;
    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        journeyMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {

        CheckIn checkIn = checkInMap.get(id);

        String startStation = checkIn.station;
        int travelTime = t - checkIn.time;

        String route = startStation + "->" + stationName;

        Journey journey = journeyMap.getOrDefault(
            route, new Journey()
        );

        journey.totalTime += travelTime;
        journey.count++;

        journeyMap.put(route, journey);

        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {

        String route = startStation + "->" + endStation;

        Journey journey = journeyMap.get(route);

        return (double) journey.totalTime / journey.count;
    }
}