public class test {
    public static void main(String[] args){
        int[] test = new int[]{2,3,5,8,5};
        int res= 0;
        for(int i : test){
            res  = res ^ i;
        }
        System.out.print(res);
    }
}
