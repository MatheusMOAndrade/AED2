/* Insertion class - START */
class Insert {

    public int countSwitch, countCompare = 0;

    public Series[] insertSort(Series[] sortSeriesArray, int n) {

        for (int i = 1; i < n; i++) {

            Series tmp = sortSeriesArray[i];
            int j = i - 1;

            while ((j >= 0) && (sortSeriesArray[j].getTvChannel().compareTo(tmp.getTvChannel()) > 0 || ((sortSeriesArray[j].getTvChannel().compareTo(tmp.getTvChannel()) == 0 && sortSeriesArray[j].getName().compareTo(tmp.getName()) > 0 )))) {
                countCompare++;
                sortSeriesArray[j + 1] = sortSeriesArray[j];
                countSwitch++;
                j--;
            }
            sortSeriesArray[j + 1] = tmp;
            countSwitch++;

        }
        return sortSeriesArray;
    }
}

/* Insertion class - END */
