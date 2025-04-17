/*You are given a list of books. Each book has a certain number of pages. You have to assign books to students in such a way that:

Each student gets at least one book.

Each book is assigned to only one student.

Books are assigned in a contiguous manner (i.e., a student gets a continuous sequence of books).

The goal is to minimize the maximum number of pages assigned to any student.
example books = [12, 34, 67, 90]
students = 2
output 113 12,34,67 is a pair and 90 is another for 2 students.
*/


public class MinimumNumberOfPages {
    public static int findMinimumPages(int[] books, int students) {
        if (books.length < students) return -1;

        int low = getMax(books);
        int high = getSum(books);

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isPossible(books, students, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static boolean isPossible(int[] books, int students, int maxPages) {
        int studentCount = 1;
        int pagesSum = 0;

        for (int pages : books) {
            if (pagesSum + pages > maxPages) {
                studentCount++;
                pagesSum = pages;
                if (studentCount > students) return false;
            } else {
                pagesSum += pages;
            }
        }

        return true;
    }

    private static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    private static int getSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] books = {12, 34, 67, 90};
        int students = 2;
        System.out.println(findMinimumPages(books, students)); // Output: 113
    }
}

