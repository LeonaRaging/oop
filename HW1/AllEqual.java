public class AllEqual {
    public static void main(String[] args) {
        int[] a = new int[3];
        for (int i = 0; i < 3; i++)
            a[i] = Integer.parseInt(args[i]);
        if (a[0] == a[1] && a[1] == a[2]) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }
}
