import java.util.*;
class Solution {

    public void bucketSort(float[] arr, int size) {
        HashMap<Integer, List<Float>> bucket = new HashMap<>();
        for ( float a : arr ) {
            int index = (int)(size*a);
            if ( bucket.get(index) == null ) {
                List<Float> link = new LinkedList<>();
                link.add(a);
                bucket.put(index,link);
            } else {
                List<Float> link = bucket.get(index);
                link.add(a);
                bucket.put(index,link);
            }
        }

        int count = 0;
        for ( Map.Entry<Integer, List<Float>> entry : bucket.entrySet() ) {
            List<Float> b = entry.getValue();
            int length = b.size();
            for ( int i = 1 ; i < length ; i++ ) {
                float temp = b.get(i);
                int j = i;
                for ( ; j > 0 && temp < b.get(j-1) ; j-- ) {
                    b.add(j,b.get(j-1));
                    b.remove(j+1);
                }
                b.add(j,temp);
                b.remove(j+1);
            }
            for ( Float f : b ) {
                arr[count] = f;
                count++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        float[] test1 = { 0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f };
        int n = (int)(test1.length/test1[0]);
        System.out.println(n);
        solution.bucketSort(test1,n);
        for (int i = 0; i < test1.length; i++) {
            System.out.print(test1[i]+",");
        }
        System.out.println();
    }
}