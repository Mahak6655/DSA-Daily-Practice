public class validPalindrome {

    public static boolean checkValidPalindrome(String str){
        int n = str.length();
        int i=0;
        int j=n-1;

        while (i<j) {
            if(!Character.isLetterOrDigit(str.charAt(i))){
                i++;
            }else if(!Character.isLetterOrDigit(str.charAt(j))){
                j--;
            }
            else if(Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j))){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(checkValidPalindrome(s));
    }
}
