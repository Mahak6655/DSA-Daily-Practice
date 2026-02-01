import java.util.Arrays;

public class reversestring{

    public static char[] reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            i++;
            j--;
        }
        return s;
    }
    public static void main(String[] args) {
        char s[] ={'h','e','l','l','o'};
        char news[] = reverseString(s);
        System.out.println(Arrays.toString(news));
    }
}