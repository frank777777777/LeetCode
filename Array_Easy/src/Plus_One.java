/**
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

 You may assume the integer do not contain any leading zero, except the number 0 itself.

 The digits are stored such that the most significant digit is at the head of the list.
 */
public class Plus_One {
    public int[] plusOne(int[] digits) {
        boolean nine=true;
        /* Check to see if they are all 9s, if true, create a bigger array and return plus one */
        for(int i:digits)
            if(i!=9) nine=false;
        if(nine==true){
            int[] rt = new int[digits.length+1];
            rt[0]=1;
            return rt;
        }

        /* do the sum from the very last digits, plus a carry digits from the right to the left */
        int carry=0;
        digits[digits.length-1]++;
        for(int i=0 ;i<digits.length;i++){
            if(digits[digits.length-1-i]+carry==10){
                digits[digits.length-1-i]=0;
                carry=1;
            }
            else{
                digits[digits.length-1-i]+=carry;
                carry=0;
            }
        }
        return digits;
    }
    public static void main(String[] args){




        int[] nums={99};
        for(int i:new Plus_One().plusOne(nums))
            System.out.print(i);

    }

}
