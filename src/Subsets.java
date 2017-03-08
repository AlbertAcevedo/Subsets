import java.util.*;

/**
 * Created by win8 on 08/03/2017.
 */
public class Subsets {
    public static Set<Integer> input =new HashSet<Integer>(Arrays.asList(1,2,3,4,6,7,8,9,10,11,13,24));
    public static void main(String[] args) {
        Set<Set<Integer>> powerSet = powerSet(input);
        Set<Integer> q;
        for (Set<Integer> p : powerSet){
            q = complement(p,input);
            if (sumOfSet(p)==sumOfSet(q)){
                System.out.println(p);
                System.out.println(complement(p,input));
                return;
            }

        }
    }

    /**
     * Used to calculate the sum of a set of integers, the sum of a set is the sum of every element on it
     * @param set set to calculate sum
     * @return sum of the set
     */
    public static int sumOfSet(Set<Integer> set){
        int res=0;
        for (int p : set){
            res+=p;
        }
        return res;
    }

    /**
     * Finds complement of an specific element relative to the original set
     * @param actual element
     * @param originalSet Bigger set
     * @param <T> Type of data being used e.g integer, string etc.
     * @return complement of the actual set
     */
    public static <T>  Set<T> complement(Set<T>actual, Set<T> originalSet){
         Set<T> res = new HashSet<T>(Arrays.asList());
         res.addAll(originalSet);
         res.removeAll(actual);
         return res;
    }

    /**
     * Returns the power set of a set, also known as the set of all subsets
     * @param originalSet Find the power set of this set
     * @param <T> Type of data used in the set
     * @return PowerSet of originalSet, aka P(originalSet)
     */
    public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
        Set<Set<T>> sets = new HashSet<Set<T>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<T>());
            return sets;
        }
        List<T> list = new ArrayList<T>(originalSet);
        T head = list.get(0);
        Set<T> rest = new HashSet<T>(list.subList(1, list.size()));
        for (Set<T> set : powerSet(rest)) {
            Set<T> newSet = new HashSet<T>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }
}
