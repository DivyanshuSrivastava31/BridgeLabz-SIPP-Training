public class FirstAndLastOccurrence {

    // Method to find the first occurrence
    public static int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // continue searching left
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // Method to find the last occurrence
    public static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1; // continue searching right
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 4, 5, 6, 7};
        int target = 4;

        int first = findFirst(arr, target);
        int last = findLast(arr, target);

        if (first == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("First Occurrence: " + first);
            System.out.println("Last Occurrence: " + last);
        }
    }
}
