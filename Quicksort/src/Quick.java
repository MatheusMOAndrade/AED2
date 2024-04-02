public class Quick {

    public int countSwitch, countCompare = 0;

    public Series[] quicksort(Series[] sortSeriesArray, int left, int right) {

        int part;
        if (left < right){
            part = partition(sortSeriesArray, left, right);
            quicksort(sortSeriesArray, left, part - 1);
            quicksort(sortSeriesArray, part + 1, right);
        }
        return sortSeriesArray;
    }

    private boolean compare(Series serie1, Series serie2) {
        if (serie1.getEpNumber() < serie2.getEpNumber()) {
            countCompare++;
            return true;
        }
        else if (serie1.getEpNumber() == serie2.getEpNumber()) {
            if (serie1.getName().compareTo(serie2.getName()) < 0) {
                return true;
            }
        }
        return false;
    }

    private int partition(Series[] sortSeriesArray, int start, int end) {

        Series pivot = sortSeriesArray[end];
        int part = start - 1;
        for (int i = start; i < end; i++) {
            if (compare(sortSeriesArray[i], pivot) == true) {
                part++;
                swap(sortSeriesArray, part, i);
            }
        }
        part++;
        swap(sortSeriesArray, part, end);
        return (part);
    }

    private void swap(Series[] sortSeriesArray, int i, int j) {
        Series temp = sortSeriesArray[i];
        sortSeriesArray[i] = sortSeriesArray[j];
        sortSeriesArray[j] = temp;
        countSwitch++;
    }
}
