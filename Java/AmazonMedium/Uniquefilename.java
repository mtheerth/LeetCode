import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> nameMap = new HashMap<>();
        for (int i = 0; i < names.length; ++i) {
            if (nameMap.containsKey(names[i])) {
                int k = nameMap.get(names[i]);
                while (nameMap.containsKey(names[i] + "(" + k + ")")) {
                    ++k;
                }
                nameMap.put(names[i], k);
                names[i] += "(" + k + ")";
            }
            nameMap.put(names[i], 1);
        }
        return names;
    }
}

