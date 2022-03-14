package vladgoncharov;

import java.util.*;

public class speedTestOnAdding extends AbstractSpeedTest{

    private static Map<Long, String> speedTestMap = new TreeMap<>();

    public static void main(String[] args) {

        startProgram();

        printSpeedTestProgram(speedTestMap);

    }

    private static void calculateSpeedInCollection(Collection<Integer> list){
        List<Long> timeForArrayList = new ArrayList<>();

        for (int j = 0; j < 10; j++) {

            Collection<Integer> startingList = list;

            long timeStart = System.currentTimeMillis();

            for (int i = 1; i <= 1_000_000; i++) {
                startingList.add(i);
            }

            long timeEnd = System.currentTimeMillis();

            timeForArrayList.add(timeEnd - timeStart);
        }

        long time = timeForArrayList.stream()
                .reduce((accumulate, i) -> accumulate = accumulate + i).get();

        speedTestMap.put(time, list.getClass().getSimpleName());
    }

    private static void calculateSpeedInMap(Map<Integer,Integer> map){

        List<Long> timeForArrayList = new ArrayList<>();

        for (int j = 0; j < 10; j++) {

            Map<Integer, Integer> startingList = map;

            long timeStart = System.currentTimeMillis();

            for (int i = 1; i <= 1_000_000; i++) {
                startingList.put(i, i);
            }

            long timeEnd = System.currentTimeMillis();

            timeForArrayList.add(timeEnd - timeStart);
        }

        long time = timeForArrayList.stream()
                .reduce((accumulate, i) -> accumulate = accumulate + i).get();

        speedTestMap.put(time, map.getClass().getSimpleName());

    }

    private static void startProgram() {
        calculateSpeedInCollection(new ArrayList<>());
        calculateSpeedInCollection(new Vector<>());
        calculateSpeedInCollection(new ArrayDeque<>());
        calculateSpeedInCollection(new PriorityQueue<>());
        calculateSpeedInCollection(new LinkedList<>());
        calculateSpeedInCollection(new HashSet<>());
        calculateSpeedInCollection(new LinkedHashSet<>());
        calculateSpeedInCollection(new TreeSet<>());

        calculateSpeedInMap(new HashMap<>());
        calculateSpeedInMap(new TreeMap<>());
    }


}
