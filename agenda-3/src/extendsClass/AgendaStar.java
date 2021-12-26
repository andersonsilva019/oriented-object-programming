package extendsClass;

import java.util.ArrayList;
import java.util.List;

import entities.Agenda;
import entities.Contact;

public class AgendaStar extends Agenda {
  // SE o contato existir e for do tipo ContatoStar altere o atributo star dele
  public void star(String name, boolean value) {
    boolean contactAlreadyExists = false;
    for (Contact contact : super.getContacts()) {
      if ((contact instanceof ContactStar) && (contact != null)) {
        if (contact.getName().equals(name)) {
          ((ContactStar) contact).setStar(value);
          contactAlreadyExists = true;
        }
      }
    }

    if (!contactAlreadyExists) {
      System.out.println(String.format("fail: contato %s nao existe", name));
    }
  }

  // filtre em uma nova lista apenas os contatos que forem do tipo ContatoStar e
  // que estão favoritados
  public List<Contact> getStarred() {
    List<Contact> auxArrayList = new ArrayList<Contact>();
    for (Contact contact : super.getContacts()) {
      if ((contact instanceof ContactStar) && (contact != null)) {
        if (((ContactStar) contact).getStar()) {
          auxArrayList.add(contact);
        }
      }
    }
    return auxArrayList;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}