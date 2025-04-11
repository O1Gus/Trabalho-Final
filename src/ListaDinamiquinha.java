public class ListaDinamiquinha implements IDinamiquinha{
    private No primeiro;
    private No ultimo;
    private int tamanho;

    public ListaDinamiquinha(){
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    @Override
    public void inserirElemento(String elemento) {
        No novo = new No(elemento);

        if(estaVazia()){

            primeiro = novo;
            ultimo = novo;

        }else {
            ultimo.setProx(novo);
            novo.setAnterior(ultimo);
            ultimo = novo;
        }
        tamanho++;
    }

    @Override
    public void inserirSequencia(String sqElementos) {
        String[] lista = (sqElementos).split(",");

        for (String el : lista){
            inserirElemento(el.trim());
        }
    }

    @Override
    public boolean removerElemento(String elemento) {
        if (estaVazia()){
            System.out.println("Não há elementos na lista.");
            return false;
        }

        No atual = primeiro;

        while (atual != null){
            if (atual.getConteudo().equals(elemento)){
                No proximo = atual.getProx();

                if (atual == primeiro && atual == ultimo){
                    primeiro = ultimo = null;

                }else if (atual == primeiro){
                    primeiro = atual.getProx();
                    primeiro.setAnterior(null);
                }else if (atual == ultimo) {
                    ultimo = atual.getAnterior();
                    ultimo.setProx(null);
                }else{
                    atual.getAnterior().setProx(atual.getProx());
                    atual.getProx().setAnterior(atual.getAnterior());
                }

                tamanho--;
                System.out.println("Removido com Sucesso");
                return true;

            }else{
                atual = atual.getProx();
            }
        }
        System.out.println("Elemento não foi encontrado!");
        return false;
    }

    @Override
    public void removerSequencia(String elementos) {
        if(estaVazia()){
            System.out.println("Não a itens o suficiente para exclusão");
            return;
        }
        String[] lista = elementos.split(",");

        for(String el : lista){
            removerElemento(el.trim());
            System.out.println("Itens removidos com sucesso!");
        }
    }

    @Override
    public void removerTodasOcorrencias(String elemento) {
        if (estaVazia()) {
            System.out.println("A lista está vazia. Nenhuma ocorrência para remover.");
            return;
        }

        No atual = primeiro;
        boolean encontrou = false;

        while (atual != null) {
            if (atual.getConteudo().equals(elemento)) {
                encontrou = true;
                No proximo = atual.getProx();

                if (atual == primeiro && atual == ultimo) {
                    primeiro = ultimo = null;
                } else if (atual == primeiro) {
                    primeiro = atual.getProx();
                    if (primeiro != null) primeiro.setAnterior(null);
                } else if (atual == ultimo) {
                    ultimo = atual.getAnterior();
                    if (ultimo != null) ultimo.setProx(null);
                } else {
                    atual.getAnterior().setProx(atual.getProx());
                    atual.getProx().setAnterior(atual.getAnterior());
                }

                tamanho--;
                atual = proximo;
            } else {
                atual = atual.getProx();
            }
        }

        if (encontrou) {
            System.out.println("Todas as ocorrências do elemento \"" + elemento + "\" foram removidas.");
        } else {
            System.out.println("Nenhuma ocorrência do elemento \"" + elemento + "\" foi encontrada.");
        }
    }


    @Override
    public boolean estaCheia() {
        return false;
    }

    @Override
    public boolean estaVazia() {
        if(tamanho == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean buscarElemento(String elemento) {
        if(estaVazia()){
            System.out.println("Não a componentes na lista");
            return false;
        }
        String valor = elemento;
        No atual = primeiro;

        while(atual != null){
            if(atual.getConteudo().equals(valor)){
                System.out.println("O componente: "+ valor + " foi encontrado na lista");
                return true;
            }
            atual = atual.getProx();
        }
        System.out.println("Componente "+ valor + " não foi encontrado na lista.");
        return false;
    }

    @Override
    public void ordenarCrescente() {
        if(estaVazia() || primeiro == ultimo){
            System.out.println("Lista vazia, ou tem apenas um elemento");
            return;
        }
        boolean trocou;

        do{
            trocou = false;
            No atual = primeiro;

            while (atual.getProx() != null){
                String valorAtual = (String) atual.getConteudo();
                String valorProx = (String) atual.getProx().getConteudo();

                if(valorAtual.compareToIgnoreCase(valorProx) > 0){
                    atual.setConteudo(valorProx);
                    atual.getProx().setConteudo(valorAtual);
                    trocou = true;
                }
                atual = atual.getProx();
            }
        }
        while(trocou);
        System.out.println("Lista ordenada em crescente");
    }

    @Override
    public void ordenarDecrescente() {
        if(estaVazia() || primeiro == ultimo){
            System.out.println("Lista vazia, ou tem apenas um elemento");
            return;
        }
        boolean trocou;

        do{
            trocou = false;
            No atual = primeiro;

            while (atual.getProx() != null){
                String valorAtual = (String) atual.getConteudo();
                String valorProx = (String) atual.getProx().getConteudo();

                if(valorAtual.compareToIgnoreCase(valorProx) < 0){
                    atual.setConteudo(valorProx);
                    atual.getProx().setConteudo(valorAtual);
                    trocou = true;
                }
                atual = atual.getProx();
            }
        }
        while(trocou);
        System.out.println("Lista ordenada em crescente");
    }

    @Override
    public int quantidadeElementos() {
        System.out.println("A quantidade de elementos na lista é "+ tamanho);
        return tamanho;
    }

    @Override
    public void editarElemento(String elementoAntigo, String elementoNovo) {
        if(estaVazia()){
            System.out.println("A lista está vazia.");
            return;
        }

        No atual = primeiro;
        String antigo = elementoAntigo;
        String novo = elementoNovo;

        while(atual != null){
            if (atual.getConteudo().equals(antigo)){
                atual.setConteudo(novo);
                System.out.println("Elemento "+ antigo + " foi alterado para "+ novo + ".");
                return;
            }
            atual = atual.getProx();
        }
        System.out.println("Elemento "+ antigo + " não foi encontrado na lista");
    }

    @Override
    public void limpar() {
        if(estaVazia()){
            System.out.println("Não a itens na lista para serem limpados");
            return;
        }

        primeiro = null;
        ultimo = null;
        tamanho = 0;
        System.out.println("A lista foi completamente limpa");
    }

    @Override
    public void exibir() {
        if(estaVazia()){
            System.out.println("Essa lista não contem itens");
            return;
        }

        System.out.println("LISTA: ");
        No atual = primeiro;
        while(atual != null){
            System.out.println("[" + atual.getConteudo() + "] ");
            if(atual.getProx() != null) System.out.println(" ↓ ");//só pra ficar mais bonito essa seta foi pega no symbl.cc ('-')
            atual = atual.getProx();
        }
        System.out.println();//só pra quebra de linha
    }

    @Override
    public No obterPrimeiroElemento() {
        if(estaVazia()){
            System.out.println("Lista está vazia"); //só pa ficar claro na hora do teste
        }
        return primeiro;
    }

    @Override
    public No obterUltimoElemento() {
        if(estaVazia()){
            System.out.println("Lista está vazia");
        }
        return ultimo;
    }
}
