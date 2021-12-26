public class Vetor {
  private Integer[] array;
  private int size;
  private int capacity;

  /**
   * Construtor
   * @param n capacidade inicial do vetor
   */
  Vetor(int n){
    capacity = n;
    size = 0;
    array = new Integer[n];
  }

  public void add(Integer i){
    if(size == capacity){
      capacity *= 2;
      Integer[] aux = new Integer[capacity];
      for(int j = 0; j < size; j++){
        aux[j] = array[j];
      }

      array = aux;
    }
    array[size] = i;
    size++;
  }

  public Integer get(int i){
    if(i >= 0 && i < size){
      return array[i];
    }else {
      return null;
    }
  }

  public int size(){
    return size;
  }

  public String toString(){
    String resultado = "Vetor[ ";
    for(int i = 0; i < size; i++){
      resultado += (array[i] + " ");
    }

    resultado += "]";

    return resultado;
  } 

  public boolean equals(Vetor v){
    if(v == null){
      return false;
    }

    if(this.size != v.size()){
      return false;
    }

    for(int i = 0; i < size; i++){
      if(this.array[i].equals(v.array[i])){
        return false;
      }
    }

    return true;
  }

}
