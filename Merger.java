/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData;

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
    }


    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {
          ArrayList<String> sortedList = new ArrayList<String>();
          mergeSort(start0, start1, nItems, sortedList, start1);
    }

    // store var to see if we have to check if lists are empty?
    public void mergeSort(int start0, int start1, int nItems, ArrayList<String> sortedList, int endOfList0) {
        if (start0 == endOfList0) addRest(start1, nItems, sortedList);
        else if (start1 == nItems) addRest(start0, start1, sortedList);

        else if (usersData.get(start0).compareTo(usersData.get(start1)) <= 0) {
            sortedList.add(usersData.get(start0));
            mergeSort(start0 + 1, start1, nItems, sortedList, endOfList0);
        }
        else if (usersData.get(start0).compareTo(usersData.get(start1)) > 0) { // potentially could be else, not sure
            sortedList.add(usersData.get(start1));
            mergeSort(start0, start1 + 1, nItems, sortedList, endOfList0);
        }
    }

    public void addRest(int start, int end, ArrayList<String> sortedList) {
        for (int counter = start; counter < end; counter++) {
            sortedList.add(usersData.get(counter));
        }
        usersData = sortedList;
    }

    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData;
    }


    /**
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           )
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0) return false;
        return true;
    }
}
