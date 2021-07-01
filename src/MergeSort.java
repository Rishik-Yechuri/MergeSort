import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        //Array used to store unsorted data
        int[] dataSet = new int[100];
        //Used to generate random numbers
        Random random = new Random();
        //Loops through the array
        for (int x = 0; x < 100; x++) {
            //Generates a random number between 1 and 100
            int randomNum = random.nextInt(100) + 1;
            //Adds it to "dataSet"
            dataSet[x] = randomNum;
        }
        //Calls mergeSort on the data and prints it out
        System.out.println(Arrays.toString(mergeSort(dataSet)));
    }

    //Sorts an array using mergesort
    public static int[] mergeSort(int[] unsortedList) {
        //Checks if the array has two elements or less
        if (unsortedList.length <= 2) {
            //Checks if the array has two elements
            if (unsortedList.length == 2) {
                //Swaps the items if they aren't ordered correctly
                if (unsortedList[0] > unsortedList[1]) {
                    int tempInt = unsortedList[1];
                    unsortedList[1] = unsortedList[0];
                    unsortedList[0] = tempInt;
                }
            }
            //Returns the array
            return unsortedList;
        }
        //Determines the size of the first array
        int firstHalfSize = unsortedList.length % 2 == 0 ? unsortedList.length / 2 : (unsortedList.length - 1) / 2 + 1;
        //Creates two arrays
        int[] firstHalf = new int[firstHalfSize];
        int[] secondHalf = new int[unsortedList.length - firstHalfSize];
        //Fills both the arrays
        System.arraycopy(unsortedList, 0, firstHalf, 0, firstHalfSize);
        System.arraycopy(unsortedList, firstHalfSize, secondHalf, 0, secondHalf.length);
        //Sorts the arrays
        firstHalf = mergeSort(firstHalf);
        secondHalf = mergeSort(secondHalf);
        //Creates a new array where both arrays can be combined
        int[] sortedList = new int[unsortedList.length];
        //loops through the two arrays and adds elements to "sortedList"
        for (int x = 0; x < unsortedList.length; x++) {
            //Stores which number should be added
            int numberToAdd = 0;
            //Checks if the first array has a smaller number
            if (secondHalf.length < 1 || firstHalf.length > 0 && firstHalf[0] < secondHalf[0]) {
                //Moves the number from the first array to "sortedList"
                numberToAdd = firstHalf[0];
                firstHalf = Arrays.copyOfRange(firstHalf, 1, firstHalf.length);
            }
            //Otherwise moves a number from the second half to "sortedList"
            else {
                numberToAdd = secondHalf[0];
                secondHalf = Arrays.copyOfRange(secondHalf, 1, secondHalf.length);
            }
            //Adds "numberToAdd" to "sortedList"
            sortedList[x] = numberToAdd;
        }
        //Returns the sorted list
        return sortedList;
    }
}