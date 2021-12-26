package extendsClass;

import java.util.List;

import entities.Contact;
import entities.Fone;

public class ContactStar extends Contact {
  private boolean star;

  // contrutor default
  public ContactStar(String name, List<Fone> fones, boolean star) {
    super(name, fones);
    this.star = star;
  }

  // muda o prefixo e o valor de star
  public void setStar(boolean value) {
    super.prefix = value ? "@" : "-";
    this.star = value;
  }

  public boolean getStar() {
    return this.star;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
