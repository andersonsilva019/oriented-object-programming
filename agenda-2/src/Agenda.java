import java.util.ArrayList;
import java.util.List;

public class Agenda {
  // Atributos
  private List<Contact> contacts;

  /**
   * Método Constructor
   */
  public Agenda() {
    contacts = new ArrayList<Contact>();
  }

  // retorna a posição do contato com esse nome no vetor ou -1 se não existir.
  private int findPosByName(String name) {
    for (int i = 0; i < this.contacts.size(); i++) {
      if (this.contacts.get(i).getName().equals(name)) {
        return i;
      }
    }
    return -1;
  }

  // retorna o objeto contato com esse nome ou null se não existir
  // utilize o método findPosByName
  public Contact findContact(String name) {
    int index = this.findPosByName(name);
    if (index == -1) {
      return null;
    }
    return contacts.get(index);
  }

  // se nenhum contato existir com esse nome, adicione
  // se ja existir, faça o merge adicionando os telefones
  // por fim, ordene a lista para ficar em ordem alfabética
  public void addContact(Contact contact) {
    int index = this.findPosByName(contact.getName());
    if (index == -1) {
      this.contacts.add(contact);
    } else {
      for (Fone fone : contact.getFones()) {
        this.contacts.get(index).addFone(fone);
      }
    }
    // O código para a ordenação da lista já está feito logo abaixo
    // esta é a última linha de código da função
    this.contacts.sort((Contact c1, Contact c2) -> (c1.getName().compareTo(c2.getName())));
  }

  // Utilize o método findPosByName
  public void rmContact(String name) {
    int index = this.findPosByName(name);
    if (index == -1) {
      return;
    }
    this.contacts.remove(index);
  }

  // Monte uma lista auxiliar procurando no .toString() de cada contato
  // se ele possui a substring procurada.
  // dica: reveja os métodos da classe String e procure algum que ajude aqui
  public List<Contact> search(String pattern) {
    List<Contact> auxArrayList = new ArrayList<Contact>();
    for (Contact c : this.contacts) {
      if (c.toString().contains(pattern.toLowerCase())) {
        auxArrayList.add(c);
      }
    }
    return auxArrayList;
  }

  public List<Contact> getContacts() {
    return this.contacts;
  }

  @Override
  public String toString() {
    String state = "";
    for (int i = 0; i < this.contacts.size(); i++) {
      if (i < this.contacts.size() - 1) {
        state += this.contacts.get(i).toString() + "\n";
      } else {
        state += this.contacts.get(i).toString();
      }
    }
    return state;
  }
}