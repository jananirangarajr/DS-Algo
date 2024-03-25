package leet.week12prep.BinarySearch;

public class SmallestLetterGreaterThanTarget744 {
    public static void main(String[] args) {
       char[] letters = new char[]{'e','e','e','e','e','e','n','n','n','n'};
       char target = 'e';
        System.out.println(nextGreatestLetter(letters,target));
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length-1;
        if (letters[right] <= target)
            return letters[0];
        else {
            target++;
            while(left < right){
                int mid = (left+right)/2;
                if (letters[mid] == target)
                    return letters[mid];
                else if (letters[mid] < target){
                    left = mid+1;
                }
                else {
                    right = mid;
                }
            }
            return letters[left];
        }
    }
    /*public static char dc(char[] letters, char target, int left, int right){
        if (left == right){
            return letters[left];
        }
        else {
            int mid = (left+right)/2;
            if (letters[mid] == target){
                return letters[mid];
            }
            else if (letters[mid] > target){
                char leftChar =  dc(letters,target,left,mid);
                if (leftChar <)
            }
            else {
                return dc(letters,target,mid,right);
            }

        }
    }
    Not correct
    */
}
