public class BST {
    //BST = Binary Search Tree
    private Node root;

    //Cria uma nova árvore binária de series vazia.
    public BST(){
        root = null;
    }

    // Método booleano que indica se a árvore está vazia ou não.

    public Boolean emptyTree(){
        return (this.root == null);
    }

    // Metodo que encapsula a adição recursiva de series à árvore.
    public void insert(Series newSeries) throws Exception {
        this.root = insertSeries(this.root, newSeries);
    }

    // Método recursivo responsável por adicionar uma serie à árvore.
    private Node insertSeries(Node subRoot, Series newSeries) throws Exception {
        // Se a raiz da árvore ou sub-árvore for null, a árvore está vazia e então é possivel adicionar uma nova Serie
        if (subRoot == null)
            subRoot = new Node(newSeries);
        else if ( newSeries.getName().compareTo(subRoot.getItemSeries().getName()) == 0)
            throw new Exception("Não foi possível inserir o item na árvore: chave já inseriada anteriormente!");
        else if ( newSeries.getName().compareTo(subRoot.getItemSeries().getName()) > 0 )
            subRoot.setRight(insertSeries(subRoot.getRight(),newSeries));
        else
            subRoot.setLeft(insertSeries(subRoot.getLeft(),newSeries));
        /// Retorna a raiz atualizada da árvore ou sub-árvore em que o aluno foi adicionado.
        return subRoot;
    }

    // Metodo que encapsula a pesquisa recursiva de series à árvore.
    public Series search(String newSeries) throws Exception {
        return searchSeries(this.root, newSeries);
    }

    // Método recursivo responsável por pesquisar uma serie à árvore.
    private Series searchSeries(Node subRoot, String newSeries) throws Exception {
        // Se a raiz da árvore ou sub-árvore for null, a árvore está vazia e então é possivel adicionar uma nova Serie
        if (subRoot == null)
            return null;
        else if (newSeries.compareTo(subRoot.getItemSeries().getName()) == 0){
            subRoot.getItemSeries().printName();
            return subRoot.getItemSeries();
        }
        else if (newSeries.compareTo(subRoot.getItemSeries().getName()) > 0){
            subRoot.getItemSeries().printName();
            return searchSeries(subRoot.getRight(),newSeries);
        }
        else{
            subRoot.getItemSeries().printName();
            return searchSeries(subRoot.getLeft(),newSeries);
        }
    }
}