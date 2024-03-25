package leet.week12prep.BinarySearch;

public class FirstBadVersion278 {
    public static void main(String[] args) {
        System.out.println(6);
    }
    public int firstBadVersion(int n) {

        int l = 0, h = n;
        while(l < h){
            int mid = l+(h-l)/2;

            boolean midVersion = isBadVersion(mid);
            if (!midVersion)
                l = mid+1;
            else
                h = mid;

        }
        return l;

    }

    private boolean isBadVersion(int mid) {
        return false;
    }
}
