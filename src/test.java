public class test {
    public static void main(String[] args) {
        Double sum = 0.0;
        for (int i = 1000; i>0; i--)
            sum = sum + PropertyRoll.rollAndSortOut();
        System.out.println(sum/1000);
    }
}
