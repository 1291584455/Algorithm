import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

class MyCalendar {
    Map<Integer, Integer> map = new TreeMap<>();

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        map.put(start , 1);
        map.put(end, -1);
        int t = 0;
        for(int key : map.keySet()){
            t += map.get(key);
        }
        if(t == 0){
            return  true;
        }
        map.remove(start);
        map.remove(end);
        return false;
    }

}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */