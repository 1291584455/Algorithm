import java.util.TreeSet;

class MyCalendar {
    TreeSet<int[]> set = new TreeSet<>((o1, o2) -> o1[0] - o2[0]);
    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        if(set.isEmpty()){
            set.add(new int[]{start, end});
            return true;
        }
        int[] t = {start, end};
        int[] up = set.ceiling(t);
        int[] down = set.floor(t);
        if(up == null){
            int[] last = set.last();
            if(start < last[1]) return  false;
        }else if(down == null){
            int[] first = set.first();
            if(end > first[0]) return false;
        }else{
            if(up[0] < end || down[1] > start) return false;
        }

        set.add(t);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */