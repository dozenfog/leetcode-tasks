import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
    private Map<Integer, Integer> vals = new HashMap<>();
    private int[] valsArr = new int[(int) (2 * Math.pow(10, 5))];

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (vals.containsKey(val)) return false;
        valsArr[vals.size()] = val;
        vals.put(val, vals.size());
        return true;
    }

    public boolean remove(int val) {
        if (!vals.containsKey(val)) return false;
        if (vals.size() != 1) {
            valsArr[vals.get(val)] = valsArr[vals.size() - 1];
        }
        vals.put(valsArr[vals.get(val)], vals.get(val));
        vals.remove(val);
        return true;
    }

    public int getRandom() {
        Random random = new Random();
        return valsArr[random.nextInt(0, vals.size())];
    }
}

class Runner {
    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        set.insert(10);
        set.insert(11);
        set.remove(10);
        set.insert(12);
        set.remove(11);
        System.out.println(set.getRandom());
    }
}