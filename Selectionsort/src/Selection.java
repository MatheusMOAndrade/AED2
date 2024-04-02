public class Selection {

    public int countSwitch, countCompare = 0;

    public Series[] selectionSort (Series[] sortSeriesArray, int n) {

        for (int i = 0; i < (n - 1); i++) { //varre vetor

            int lower = i; //armazena primeira posição

            for (int j = (i + 1); j < n; j++) { //varre vetor a partir da segunda posição
                if (sortSeriesArray[lower].getCountryOriginal().compareTo(sortSeriesArray[j].getCountryOriginal()) > 0) {
                    lower = j;
                } else if (sortSeriesArray[lower].getCountryOriginal().compareTo(sortSeriesArray[j].getCountryOriginal()) == 0) {
                    if (sortSeriesArray[lower].getName().compareTo(sortSeriesArray[j].getName())>0) {
                        lower = j;
                    }
                }
                countCompare++;
            }

            Series temp = sortSeriesArray[i];
            sortSeriesArray[i] = sortSeriesArray[lower];
            sortSeriesArray[lower] = temp;
            countSwitch++;

        }

        return  sortSeriesArray;
    }

}
