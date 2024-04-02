class List {

    private Cell first;
    private Cell last;
    private int listSize; //posição das células da lista

    /*Contructor*/
    public List() {
        Cell sentinel;

        sentinel = new Cell();
        first = sentinel;
        last = sentinel;
        listSize = 0;
    }

    public boolean emptyList() {
        return (first == last);
    }

    public void insertFirst(Series newElement) {
        Cell newCell = new Cell(newElement);

        first.getNextCell().setPreviousCell(newCell);
        newCell.setNextCell(first.getNextCell());
        newCell.setPreviousCell(first);
        first.setNextCell(newCell);

        listSize++;
    }

    public void insertLast(Series newElement) {
        Cell newCell = new Cell(newElement);

        last.setNextCell(newCell);
        newCell.setPreviousCell(last);
        last = newCell;

        listSize++;
    }

    public void insert(Series newSeries, int position) throws Exception {

        Cell previous, newCell, nextCell;

        if ((position >= 0) && (position <= listSize)) {
            previous = first;

            for (int i = 0; i < position; i++) { //passa por cada célula
                previous = previous.getNextCell();
            }

            newCell = new Cell(newSeries);

            nextCell = previous.getNextCell();

            previous.setNextCell(newCell);
            newCell.setNextCell(nextCell);

            nextCell.setPreviousCell(newCell);
            newCell.setPreviousCell(previous);

            if (position == listSize) {  // a inserção ocorreu na última posição da lista
                last = newCell;
            }

            listSize++;

        } else
            throw new Exception("Não foi possível inserir o item na lista: a posição informada é inválida!");
    }

    public Series removeFirst() throws Exception {
        Cell removed;

        if(! emptyList()){
            removed = first.getNextCell();
            removed.getNextCell().setPreviousCell(first);
            first.setNextCell(removed.getNextCell());

            removed.setNextCell(null);
            removed.setPreviousCell(null);

            listSize--;

            return (removed.getListSeries());
        }else
            throw new Exception("Não foi possível remover o último item da lista: a lista está vazia!");
    }

    public Series removeLast() throws Exception {
        Cell removed, secondLast;

        if(! emptyList()){
            removed = last;
            secondLast = last.getPreviousCell();
            secondLast.setNextCell(null);
            removed.setPreviousCell(null);

            last = secondLast;

            listSize--;

            return (removed.getListSeries());

        } else
            throw new Exception("Não foi possível remover o último item da lista: a lista está vazia!");
    }

    public Series remove(int position) throws Exception {

        Cell previousCell, removedCell, nextCell;

        if (! emptyList()) {
            if ((position >= 0) && (position <= listSize)) {
                removedCell = first.getNextCell();
                for (int i = 0; i < position; i++) {
                    removedCell = removedCell.getNextCell();
                }


                if (!(removedCell == last)) {
                    previousCell = removedCell.getPreviousCell();
                    nextCell = removedCell.getNextCell();

                    previousCell.setNextCell(nextCell);
                    nextCell.setPreviousCell(previousCell);

                    removedCell.setNextCell(null);
                    removedCell.setPreviousCell(null);
                    listSize--;
                    return (removedCell.getListSeries());


                } else{
                    listSize--;
                    return removeLast();
                }

            } else
                throw new Exception("Não foi possível remover o item da lista: a posição informada é inválida!");
        } else
            throw new Exception("Não foi possível remover o item da lista: a lista está vazia!");
    }

    public void show() throws Exception {

        Cell aux;
        int count = 0;

        if (! emptyList()) {
            aux = first.getNextCell();

            while (aux != null) {
                aux.getListSeries().printer(count);
                aux = aux.getNextCell();
                count++;
            }

        } else
            throw new Exception("Não foi possível imprimir o conteúdo da lista: a lista está vazia!");
    }
}