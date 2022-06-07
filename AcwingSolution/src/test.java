import java.util.*;
class MyCalendarTwo {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    public MyCalendarTwo() {

    }

    public boolean book(int start, int end) {
        Integer low = map.ceilingKey(start);
        Integer high = map.floorKey(end);
        if(low == null || high == null){
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) + 1);
            return true;
        }else {
            int cnt = 0;
            while (low != null && low <= high ){
                cnt += map.get(low);
                low = map.ceilingKey(low + 1);
                if(cnt == 2) return false;
            }
        }
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) + 1);
        return true;
    }
}

