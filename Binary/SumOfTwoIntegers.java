class Solution {
    List<Integer> al = new ArrayList<>();
    List<Integer> bl = new ArrayList<>();
    int sum = 0;

    public int getSum(int a, int b) {
        binarya(a);
        binaryb(b);
        return sum;
    }

    public void binarya(int a) {
        while (a != 0) {
            al.add(a % 2);
            a = a / 2;
        }
        // System.out.println(al);
        decimal(al);
    }

    public void binaryb(int b) {
        while (b != 0) {
            bl.add(b % 2);
            b = b / 2;
        }
        // System.out.println(bl);
        decimal(bl);
    }

    public void decimal(List<Integer> l) {
        int count = 0;
        for (int i = 0; i < l.size(); i++) {
            sum += l.get(i) * (int) (Math.pow(2, count));
            count++;
        }
    }
}
