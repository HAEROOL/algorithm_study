class Solution {
    public long solution(int w, int h) {
        long allBlockCount = (long)w*h;

        long repetitionCount = euclideanAlgorithm(w, h);

        long widthRepeatSize = (long)w / repetitionCount;
        long heightRepeatSize = (long)h / repetitionCount;

        long cutBlockCount = widthRepeatSize + heightRepeatSize - 1;

        return allBlockCount - cutBlockCount * repetitionCount;
    }

    private int euclideanAlgorithm(int a, int b) {
        if (b == 0){
            return a;
        }
        return euclideanAlgorithm(b, a % b);
    }
}