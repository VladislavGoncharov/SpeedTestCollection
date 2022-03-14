package vladgoncharov;

import java.util.Map;

abstract public class AbstractSpeedTest {

    public static void printSpeedTestProgram(Map<Long, String> speedTestMap){

        System.out.println("\n" + " № | Speed | Name");
        System.out.println("-------------------------------");

        int number = 1;
        for (Map.Entry<Long, String> map : speedTestMap.entrySet()) {
            System.out.printf("%2d.| %5d | %-15s\n", (number++), map.getKey(), map.getValue());
        }

        System.out.println("-------------------------------");

    }


}
