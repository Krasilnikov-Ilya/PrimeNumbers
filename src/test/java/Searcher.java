import java.util.Collections;
import java.util.List;

public class Searcher {
    int[] search(List<Integer> list, int trg) {
        Collections.sort(list);
        int resultLow = 0;
        for (int i : list) {
            if (i <= trg) {
                resultLow = i;
            }
        }
        int resultHigh = 0;
        int idx = list.indexOf(resultLow);

        if (idx <= list.size() - 2) {
            resultHigh = list.get(idx + 1);
        } else {
            resultHigh = list.get(idx);
        }

        int[] result = {resultLow, resultHigh};
        return result;
    }
}
