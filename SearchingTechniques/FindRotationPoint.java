public class FindRotationPoint {

    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than right, rotation point is to the right of mid
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } 
            // Else, rotation point is at mid or to the left of mid
            else {
                right = mid;
            }
        }

        // At this point, left == right pointing to the smallest element
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {15, 18, 2, 3, 6, 12}; // Rotated sorted array
        int rotationIndex = findRotationPoint(arr);
        System.out.println("Rotation Point Index: " + rotationIndex);
        System.out.println("Smallest Element: " + arr[rotationIndex]);
    }
}
