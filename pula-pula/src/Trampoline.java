import java.util.LinkedList;

public class Trampoline {

  /**
   * Declaração dos atributos da classe
   */
  private LinkedList<Kid> waiting;
  private LinkedList<Kid> playing;

  /**
   * Método construtor
   */
  public Trampoline() {
    this.waiting = new LinkedList<Kid>();
    this.playing = new LinkedList<Kid>();
  }

  /**
   * Remove e retorna o Kid que tenha o nome igual ao passado como parâmetro
   * 
   * @param name Kid a ser procurado
   * @param list Lista a ser percorrida para encontrar o Kid
   * @return Kid ou null
   */
  private Kid remove_kid(String name, LinkedList<Kid> list) {
    Kid kidTemp = null;
    for (int i = 0; i < list.size(); i++) {
      if (name.equals(list.get(i).getName())) {
        kidTemp = list.get(i);
        list.remove(i);
        return kidTemp;
      }
    }

    return null;
  }

  /**
   * insere na lista de espera
   * 
   * @param kid kid a ser inserido na lista de espera
   */
  public void arrive(Kid kid) {
    this.waiting.add(kid);
  }

  // remove da lista de espera e insere na lista playing
  public void in() {
    this.playing.add(this.waiting.removeFirst());
  }

  // remove de playing para waiting
  public void out() {
    this.waiting.add(this.playing.removeFirst());
  }

  /**
   * remove do parquinho em qualquer das listas
   * 
   * @param name Kid a ser removido
   * @return Kid ou null
   */
  public Kid remove(String name) {

    Kid kidWaiting = null;
    Kid kidPlaying = null;

    kidWaiting = this.remove_kid(name, this.waiting);
    kidPlaying = this.remove_kid(name, this.playing);

    if (kidPlaying != null) {
      return kidPlaying;
    } else if (kidWaiting != null) {
      return kidWaiting;
    } else {
      return null;
    }
  }

  public String toString() {
    String str = null;
    str = "=> ";
    for (int i = this.waiting.size() - 1; i >= 0; i--) {
      str += "" + this.waiting.get(i);
    }
    str += " => [ ";
    for (int i = this.playing.size() - 1; i >= 0; i--) {
      str += this.playing.get(i);
    }
    str += "]";
    return str;
  }
}
