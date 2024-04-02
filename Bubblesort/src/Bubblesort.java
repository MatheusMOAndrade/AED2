public class Bubblesort {

    public int countSwitch, countCompare = 0;

    public Series[] sortArray(Series[] sortSeriesArray, int n) {

        for (int i = (n - 1); i > 0; i--) {

            for (int j = 0; j < i; j++) {

                countCompare++;

                if ((sortSeriesArray[j].getDuration().compareTo(sortSeriesArray[j + 1].getDuration()) > 0) || ((sortSeriesArray[j].getDuration().compareTo(sortSeriesArray[j + 1].getDuration()) == 0) && (sortSeriesArray[j].getName().compareTo(sortSeriesArray[j + 1].getName()) > 0))) {
                    Series temp = sortSeriesArray[j];
                    sortSeriesArray[j] = sortSeriesArray[j + 1];
                    sortSeriesArray[j + 1] = temp;
                    countSwitch++;
                }
            }
        }
        return sortSeriesArray;
    }
}