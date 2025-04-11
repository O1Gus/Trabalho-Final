public interface IDinamiquinha {
    void inserirElemento(String elemento);
    void inserirSequencia(String elementos);
    boolean removerElemento(String elemento);
    void removerSequencia(String elementos);
    void removerTodasOcorrencias(String elemento);
    boolean estaCheia();
    boolean estaVazia();
    boolean buscarElemento(String elemento);
    void ordenarCrescente();
    void ordenarDecrescente();
    int quantidadeElementos();
    void editarElemento(String elementoAntigo, String elementoNovo);
    void limpar();
    void exibir();
    No obterPrimeiroElemento();
    No obterUltimoElemento();
}
