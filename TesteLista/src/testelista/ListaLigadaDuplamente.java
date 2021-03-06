package testelista;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListaLigadaDuplamente<T> implements List<T> {

    private No inicio;
    private No fim;
    private int indice;
    private int size;

    public ListaLigadaDuplamente() {
        this.inicio = null;
        this.fim = null;
        this.indice = 0;
        this.size = 0;
    }
    
    
    
    

    @Override
    public int size() {
        return this.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.getInicio() == null;
    }

    public T getLast() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Lista vazia");
        } else {
            return (T) getFim().getInfo();
        }
    }

    @Override
    public boolean contains(Object o) {
    
    No p = new No(null);

        if (o == null) {

            throw new NullPointerException("Objeto é nulo, não é possivél verificar na lista.");
        } else {
            No aux = this.inicio;
            while ((aux != null) || (aux.getProximo() != this.inicio)) {
                if (aux.getInfo() == o) {
                    return true;
                }
                aux = aux.getProximo();
            }
            return false;
        }
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(T e) {
        No aux;
        if (!this.isEmpty()) {
            aux = new No(getIndice(), e, getInicio(), getFim());
            this.getFim().setProximo(aux);
            this.setFim(aux);
            this.getInicio().setAnterior(getFim());
        } else {
            this.setInicio(new No(getIndice(), e, getInicio(), getInicio()));
            this.getInicio().setAnterior(getInicio());
            this.getInicio().setProximo(getInicio());
            this.setFim(getInicio());
        }

        this.setIndice(this.getIndice() + 1);
        this.setSize(this.getSize() + 1);
        return true;
    }

    @Override
    public boolean remove(Object o) {
       
        No aux;
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Lista vazia");
        } else {
          
            aux = this.inicio;
            while (aux != this.fim) {
                if(o == aux.getInfo()){
                    No anterior= null;
                    No proximo = null;
                }else{
                    
                    aux = aux.getProximo();
                    
            }
            
                No anterior = aux.getAnterior();
                No proximo = aux.getProximo();
                anterior.setProximo(proximo);
                proximo.setAnterior(anterior);
                this.size--;
                this.decrementarLista(proximo);
                return true;
           
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends T> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T get(int i) {
        No aux = this.getInicio();

        for (int j = 0; j < getIndice(); j++) {
            aux = aux.getProximo();

        }

        return (T) aux;
    }

    /**
     * @return the inicio
     */
    public No getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the fim
     */
    public No getFim() {
        return fim;
    }

    /**
     * @param fim the fim to set
     */
    public void setFim(No fim) {
        this.fim = fim;
    }

    /**
     * @return the indice
     */
    public int getIndice() {
        return indice;
    }

    /**
     * @param indice the indice to set
     */
    public void setIndice(int indice) {
        this.indice = indice;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }



@Override
        public T set(int i, T e) { 
            
            if (e == null) {

            throw new NullPointerException("Objeto é nulo, não pode ser salvo na lista.");
        } else if (i < 0 || i >= size()) {

            throw new IndexOutOfBoundsException("Valor fora do intervalo válido.");

        } else {
            No aux = this.getInicio();
            Object obj;

            for (int j = 0; j < i; j++) {
                aux = aux.getAnterior();

            }
            obj = aux.getInfo();
            aux.setInfo(e);
            return (T) obj;
        } 
        
        }

    @Override
        public void add(int i, T e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
        public T remove(int i) {
        T aux1;
        No aux = null;
         if (this.isEmpty()) {
            throw new IllegalArgumentException("Lista vazia");
        } else {
             aux =(No) get(i);
            /*aux = this.inicio;
            while (aux != this.fim) {
                i =  aux.getImovel();
                if (i.getCodigo() == im.getCodigo()) {
                    break;
                }
                aux = aux.getProximo();
            }
            i = (Imovel) aux.getImovel();
            if (i.getCodigo() == im.getCodigo()) {*/
                No anterior = aux.getAnterior();
                No proximo = aux.getProximo();
                anterior.setProximo(proximo);
                proximo.setAnterior(anterior);
                this.size--;
                this.decrementarLista(proximo);
                return (T)aux;
         }
        
    }
        

    @Override
        public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
        public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
        public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
        public ListIterator<T> listIterator(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
        public List<T> subList(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     /**
     * Método que decrementa a Lista
     *
     * @param n
     */
    private void decrementarLista(No n) {
        if (this.size == 1) {
            this.fim = inicio;
        }
        this.indice--;
        No aux = n;
        while (aux != this.fim) {
            aux.decrementarIndice();
            aux = aux.getProximo();
        }
        aux.decrementarIndice();
    }

    /**
     * Método que incrementa a Lista
     *
     * @param n
     */
    private void incrementarLista(No n) {
        this.indice++;
        No aux = n;
        while (aux != this.fim) {
            aux.IncrementarIndice();
            aux = aux.getProximo();
        }
        aux.decrementarIndice();

    }


}
