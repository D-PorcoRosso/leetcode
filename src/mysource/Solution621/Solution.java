package mysource.Solution621;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int size = tasks.length;
        Queue<Character> waitingQueue = new LinkedList<>();
        HashMap<Character, Integer> count = new HashMap<>();
        for (  char task : tasks ) {
            int num = 0;
            if( count.get(task) != null){
                num = count.get(task);
            }
            num++;
            count.put(new Character(task), new Integer(num));
        }
        int output = 0;
        while ( size != 0 ) {
            Character task = getMax(count);
            if ( waitingQueue.contains(task) ) {
                if ( waitingQueue.size() == n )
                    waitingQueue.poll();
                waitingQueue.offer(' ');
            } else {
                if ( waitingQueue.size() == n )
                    waitingQueue.poll();
                waitingQueue.offer(task);
                Integer taskCount = count.get(task);
                taskCount--;
                size--;
                count.put(task, taskCount);
            }
            //System.out.println(waitingQueue);
            /*try {
                System.in.read();
            } catch(Exception e) {

            }*/
            output++;
        }

        return output;
    }

    private Character getMax(HashMap<Character, Integer> count) {
        Map.Entry<Character, Integer> maxEntry = null;
        for ( Map.Entry<Character, Integer> entry : count.entrySet() ) {
            if ( maxEntry == null || (entry.getValue() > maxEntry.getValue()) ) {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] test = {'A','A','A','B','B','B'};
        System.out.println(solution.leastInterval(test, 2));

        char[] test2 = {'A','A','A','B','B','B','B','B','C'};
        System.out.println(solution.leastInterval(test2, 3));
    }
}