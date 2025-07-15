public class FindPeakElement {

    public static int findPeak(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean leftCheck = (mid == 0) || (arr[mid] > arr[mid - 1]);
            boolean rightCheck = (mid == n - 1) || (arr[mid] > arr[mid + 1]);

            // Check if mid is a peak
            if (leftCheck && rightCheck) {
                return mid; // return index of peak element
            }

            // If left neighbor is greater, move to the left half
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            }
            // Else, move to the right half
            else {
                left = mid + 1;
            }
        }

        return -1; // this should not happen if input array has at least one element
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        int peakIndex = findPeak(arr);
        System.out.println("Peak Element Index: " + peakIndex);
        System.out.println("Peak Element: " + arr[peakIndex]);
    }
}
