/**
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.
 */
public class Roman_to_Integer {
    public int romanToInt(String s) {
        int sum=0;

        /* just adding up all the numbers first, if the small number is before a larger number, we subtract it twice to justify the result */
        for(int i=0; i<s.length(); i++){
            sum += translate(s.charAt(i));
        }

        for(int i=1; i<s.length(); i++){
            if(translate(s.charAt(i-1))<translate(s.charAt(i)))
                sum -= 2*translate(s.charAt(i-1));
        }
        return sum;
    }

    /* translate the roman letter to numerical*/
    public int translate(char roman){
        if( roman == 'I')
            return 1;
        else if(roman == 'V')
            return 5;
        else if(roman == 'X')
            return 10;
        else if(roman == 'L')
            return 50;
        else if(roman == 'C')
            return 100;
        else if(roman == 'D')
            return 500;
        else if(roman == 'M')
            return 1000;
        else
            return -1;
    }

    public static void main(String[] args){

        String test = "DCXXI";      /* 621 */
        System.out.print(new Roman_to_Integer().romanToInt(test));

    }
}
