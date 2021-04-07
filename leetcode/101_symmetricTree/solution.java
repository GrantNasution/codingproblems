class Solution {
    public static void main(String[] args) {
        Integer i = 0;
        System.out.println("Start: " + i);
        recursive(i);
        for(int j = 0; j < 1000; ++j) {}
        System.out.println("Final: " + i);
    }
    public static void recursive(Integer i) {
        if(i >= 5) {
            return;
        }
        System.out.println("Level: " + i);
        i++;
        recursive(i);
        System.out.println(i + "\n End");
    }
}