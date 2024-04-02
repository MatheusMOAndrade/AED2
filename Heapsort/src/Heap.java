/* Heapsort class start */
class Heap {

    public int countSwitch, countCompare = 0;

    public Series[] heapsort(Series[] sortSeriesArray, int n) {

        // Criando outro vetor, com todos os elementos do vetor anterior reposicionados (uma posição a frente)
        // de forma a ignorar a posição zero
        Series[] tmp = new Series[n + 1];
        for (int i = 0; i < n; i++) {
            tmp[i + 1] = sortSeriesArray[i];
        }
        sortSeriesArray = tmp;

        //Contrução do heap
        for (int sizeHeap = 2; sizeHeap <= n; sizeHeap++) {
            build(sortSeriesArray, sizeHeap);
        }

        //Ordenação propriamente dita
        int sizeHeap = n;
        while (sizeHeap > 1) {
            swap(sortSeriesArray, 1, sizeHeap--);
            rebuild(sortSeriesArray, sizeHeap);
        }

        //Alterar o vetor para voltar à posição zero
        tmp = sortSeriesArray;
        sortSeriesArray = new Series[n];
        for (int i = 0; i < n; i++) {
            sortSeriesArray[i] = tmp[i + 1];
        }

        return sortSeriesArray;
    }

    private boolean compare(Series serie1, Series serie2) {
        if (serie1.getSeasonNumber() > serie2.getSeasonNumber()) {
            countCompare++;
            return true;
        }
        else if (serie1.getSeasonNumber() == serie2.getSeasonNumber()) {
            if (serie1.getName().compareTo(serie2.getName()) > 0) {
                return true;
            }
        }
        return false;
    }

    void build(Series[] sortSeriesArray, int sizeHeap) {

        for (int i = sizeHeap; i > 1 && (compare(sortSeriesArray[i], sortSeriesArray[i / 2]) == true); i /= 2) {
            swap(sortSeriesArray, i, i / 2);
        }
    }

    private boolean compareRebuild(Series serie1, Series serie2) {
        if (serie1.getSeasonNumber() < serie2.getSeasonNumber()) {
            countCompare++;
            return true;
        }
        else if (serie1.getSeasonNumber() == serie2.getSeasonNumber()) {
            if (serie1.getName().compareTo(serie2.getName()) < 0) {
                return true;
            }
        }
        return false;
    }

    void rebuild(Series[] sortSeriesArray, int sizeHeap) {
        int i = 1;

        while (i <= (sizeHeap / 2)) {
            int heapSon = getBiggerSon(sortSeriesArray, i, sizeHeap);
            if (compareRebuild(sortSeriesArray[i], sortSeriesArray[heapSon]) == true) {
                swap(sortSeriesArray, i, heapSon);
                i = heapSon;
            } else {
                i = sizeHeap;
            }
        }
    }

    int getBiggerSon(Series[] sortSeriesArray, int i, int sizeHeap) {
        int heapSon;

        if (2 * i == sizeHeap || (compare(sortSeriesArray[2 * i], sortSeriesArray[2 * i + 1]) == true)) {
            heapSon = 2 * i;
        } else {
            heapSon = 2 * i + 1;
        }
        return heapSon;
    }

    void swap(Series[] sortSeriesArray, int i, int j) {
        Series temp = sortSeriesArray[i];
        sortSeriesArray[i] = sortSeriesArray[j];
        sortSeriesArray[j] = temp;
        countSwitch++;
    }
}
/* Heapsort class END */