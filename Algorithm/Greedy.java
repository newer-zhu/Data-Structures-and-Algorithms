import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 电台覆盖各自的城市，又下列城市，需要用最少的电台去覆盖
 */
public class Greedy {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcast = new HashMap<>();
        //设置所有电台
        HashSet<String> broad_1 = new HashSet<>();
        broad_1.add("london");
        broad_1.add("beijing");
        broad_1.add("tokyo");

        HashSet<String> broad_2 = new HashSet<>();
        broad_2.add("beijing");
        broad_2.add("hk");
        //........
        HashSet<String> allAreas = new HashSet<>();
        //放入所有城市
        allAreas.add("london");
        //........
        broadcast.put("b1",broad_1);
        broadcast.put("b2",broad_2);

        //将选择的电台放入此集合
        ArrayList<String> elements = new ArrayList<>();

        //放遍历过程中一个电台覆盖的区域和未覆盖区域的交集
        HashSet<String> merge = new HashSet<>();
        String maxKey = null;//覆盖最多allAreas的电台
        while (allAreas.size() != 0){
            maxKey = null;//置空
            for (String key : broadcast.keySet()){
                merge.clear();
                HashSet<String> cities = broadcast.get(key);
                merge.addAll(cities);
                //求交集
                merge.retainAll(allAreas);
                //电台覆盖区域确实有未覆盖的区域并且能找到覆盖最多未覆盖区域的电台
                if (merge.size() > 0 && (maxKey == null || merge.size() > broadcast.get(maxKey).size())){
                    maxKey = key;
                }
            }
            if (maxKey != null){
                elements.add(maxKey);
                //清除电台里覆盖了的地区，更新allAreas
                allAreas.removeAll(broadcast.get(maxKey));

            }
        }

    }
}
