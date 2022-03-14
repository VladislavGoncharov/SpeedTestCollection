package vladgoncharov;

import java.util.*;

public class speedTestOnGetting extends AbstractSpeedTest {

    private static Map<Long, String> speedTestMap = new TreeMap<>();

    public static void main(String[] args) {

        startProgram();

        printSpeedTestProgram(speedTestMap);

    }

    private static void calculateSpeedInList(List<Integer> list) {
        List<Long> timeForArrayList = new ArrayList<>();

        for (int j = 0; j < 10; j++) {

            List<Integer> startingList = list;
            int getting;

            for (int i = 1; i <= 500_000; i++) {
                startingList.add(i);
            }

            long timeStart = System.currentTimeMillis();

            for (Integer integer : startingList) {
                getting = integer;
            }

            long timeEnd = System.currentTimeMillis();


            timeForArrayList.add(timeEnd - timeStart);
        }

        long time = timeForArrayList.stream()
                .reduce((accumulate, i) -> accumulate = accumulate + i).get();

        speedTestMap.put(time, list.getClass().getSimpleName());
    }

    private static void calculateSpeedInSet(Set<Integer> set) {
        List<Long> timeForArrayList = new ArrayList<>();

        for (int j = 0; j < 10; j++) {

            Set<Integer> startingList = set;
            int getting;


            for (int i = 1; i <= 500_000; i++) {
                startingList.add(i);
            }

            long timeStart = System.currentTimeMillis();

            for (Integer integer : startingList) {
                getting = integer;
            }

            long timeEnd = System.currentTimeMillis();

            timeForArrayList.add(timeEnd - timeStart);
        }

        long time = timeForArrayList.stream()
                .reduce((accumulate, i) -> accumulate = accumulate + i).get();

        speedTestMap.put(time, set.getClass().getSimpleName());

    }

    private static void calculateSpeedInQueue(Queue<Integer> queue) {
        List<Long> timeForArrayList = new ArrayList<>();

        for (int j = 0; j < 10; j++) {

            Queue<Integer> startingList = queue;
            int getting;

            for (int i = 1; i <= 500_000; i++) {
                startingList.add(i);
            }

            long timeStart = System.currentTimeMillis();

            for (Integer integer : startingList) {
                getting = integer;
            }

            long timeEnd = System.currentTimeMillis();

            timeForArrayList.add(timeEnd - timeStart);
        }

        long time = timeForArrayList.stream()
                .reduce((accumulate, i) -> accumulate = accumulate + i).get();

        speedTestMap.put(time, queue.getClass().getSimpleName());
    }

    private static void calculateSpeedInMap(Map<Integer, Integer> map) {

        List<Long> timeForArrayList = new ArrayList<>();

        for (int j = 0; j < 10; j++) {

            Map<Integer, Integer> startingList = map;
            int getting;

            for (int i = 1; i <= 500_000; i++) {
                startingList.put(i, i);
            }

            long timeStart = System.currentTimeMillis();

            for (Integer integer : startingList.keySet()) {
                getting = integer;
            }
            long timeEnd = System.currentTimeMillis();

            timeForArrayList.add(timeEnd - timeStart);
        }

        long time = timeForArrayList.stream()
                .reduce((accumulate, i) -> accumulate = accumulate + i).get();

        speedTestMap.put(time, map.getClass().getSimpleName());

    }

    private static void startProgram() {
        calculateSpeedInList(new ArrayList<>());
        calculateSpeedInList(new Vector<>());

        calculateSpeedInQueue(new ArrayDeque<>());
        calculateSpeedInQueue(new PriorityQueue<>());
        calculateSpeedInQueue(new LinkedList<>());

        calculateSpeedInSet(new HashSet<>());
        calculateSpeedInSet(new LinkedHashSet<>());
        calculateSpeedInSet(new TreeSet<>());

        calculateSpeedInMap(new HashMap<>());
        calculateSpeedInMap(new TreeMap<>());
    }

}

