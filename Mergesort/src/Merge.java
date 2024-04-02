public class Merge {

    public int countSwitch, countCompare = 0;

    public Series[] mergesort(Series[] sortSeriesArray, int left, int right) {

        if (left < right) {

            int middle = (left + right) / 2;
            mergesort(sortSeriesArray, left, middle);
            mergesort(sortSeriesArray, middle + 1, right);
            intercalar(sortSeriesArray, left, middle, right);
            countSwitch++;
        }
        return sortSeriesArray;
    }

    private void intercalar(Series[] array, int left, int middle, int right) {

        int n1, n2, i, j, k;


        //Definir tamanho dos dois subarrays
        n1 = middle - left + 1;
        n2 = right - middle;

        Series[] a1 = new Series[n1];
        Series[] a2 = new Series[n2];

        //Inicializar primeiro subarray
        for (i = 0; i < n1; i++) {
            a1[i] = array[left + i];
        }

        //Inicializar segundo subarray
        for (j = 0; j < n2; j++) {
            a2[j] = array[middle + j + 1];
        }

        //Intercalação propriamente dita
        for (i = j = 0, k = left; (i < n1 && j < n2); k++) {
            countCompare++;
            if ((a1[i].getLanguageOriginal().compareTo(a2[j].getLanguageOriginal()) < 0) || (a1[i].getLanguageOriginal().compareTo(a2[j].getLanguageOriginal()) == 0 && a1[i].getName().compareTo(a2[j].getName()) < 0 )  )
                array[k] = a1[i++];
            else
                array[k] = a2[j++];
        }

        if (i == n1)
            for (; k <= right; k++) {
                array[k] = a2[j++];
            }
        else
            for (; k <= right; k++) {
                array[k] = a1[i++];
            }
    }
}

