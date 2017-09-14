/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

 Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

 You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.*/
public class First_Bad_Version {
    private boolean isBadVersion(int version){
        int badVersion = 1;
        return version >= badVersion;
    }
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        int mid;
        /* when low == high, the mid == low == high. The while loop terminates, the bad version is found. */
        while (low < high){
            mid = low + (high - low) / 2;
            if(!isBadVersion(mid)){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args){
        System.out.println(new First_Bad_Version().firstBadVersion(2));
    }
}
