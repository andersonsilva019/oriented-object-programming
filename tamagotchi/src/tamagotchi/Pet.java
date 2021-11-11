package tamagotchi;

public class Pet {
  private int energyMax, hungryMax, cleanMax;
  private int energy, hungry, shower;
  private int diamonds;
  private int age;
  private boolean alive;

  /**
   * 
   * @param energy nivel de energia maxima do Pet
   * @param hungry nivel saciedade maxima do Pet
   * @param shower nivel de limpeza maxima do Pet
   */
  public Pet(int energy, int hungry, int shower) {
    this.energyMax = energy;
    this.energy = energy;
    this.hungry = hungry;
    this.hungryMax = hungry;
    this.shower = shower;
    this.cleanMax = shower;
    this.diamonds = 0;
    this.age = 0;
    this.alive = true;
  }

  // Atribui o valor de energia
  // Se o valor ficar abaixo de 0, o pet morre de fraqueza
  // Garanta que os valores ficarão no interalo 0 - max
  // Use esse modelo para fazer os outros métodos set
  /**
   * 
   * @param value quantidade de energia a ser adicionado ao Pet
   */
  void setEnergy(int value) {
    if (value <= 0) {
      this.energy = 0;
      System.out.println("fail: pet morreu de fraqueza");
      this.alive = false;
    } else if (value >= this.energyMax)
      this.energy = this.energyMax;
    else
      this.energy = value;
  }

  /**
   * 
   * @param value quantidade de comida a ser adicionado ao Pet
   */
  void setHungry(int value) {
    if (value <= 0) {
      this.hungry = 0;
      System.out.println("fail: pet morreu de fome");
      this.alive = false;
    } else if (value >= this.hungryMax) {
      this.hungry = this.hungryMax;
    } else {
      this.hungry = value;
    }
  }

  /**
   * 
   * @param value nivel de energia a ser adicionado ao Pet
   */
  void setClean(int value) {
    if (value <= 0) {
      this.shower = 0;
      System.out.println("fail: pet morreu de sujeira");
      this.alive = false;
    } else if (value >= this.cleanMax) {
      this.shower = this.cleanMax;
    } else {
      this.shower = value;
    }
  }

  int getClean() {
    return this.shower;
  }

  int getHungry() {
    return this.hungry;
  }

  int getEnergy() {
    return this.energy;
  }

  int getEnergyMax() {
    return this.energyMax;
  }

  int getCleanMax() {
    return this.cleanMax;
  }

  int getHungryMax() {
    return this.hungryMax;
  }

  public boolean testAlive() {
    if (this.alive) {
      return true;
    } else {
      System.out.println("fail: pet esta morto");
      return false;
    }
  }

  // Invoca o método testAlive para verificar se o pet esta vivo
  // Se estiver vivo, altere os atributos utilizando os métodos set e get
  // # O comando "$play" altera em -2 energia, -1 saciedade, -3 limpeza, +1
  // diamante, +1 idade.
  public void play() {
    if (this.testAlive()) {
      this.setEnergy(this.getEnergy() - 2);
      this.setHungry(this.getHungry() - 1);
      this.setClean(this.getClean() - 3);
      this.diamonds += 1;
      this.age += 1;
    }
  }

  // # O comando "$shower" alteram em -3 energia, -1 na saciedade, MAX na limpeza,
  // +0 diamantes, +2 na idade.
  public void shower() {
    if (this.testAlive()) {
      this.setEnergy(this.getEnergy() - 3);
      this.setHungry(this.getHungry() - 1);
      this.setClean(this.getCleanMax());
      this.age += 2;
    }
  }

  // O Comando "$eat" altera em -1 a energia, +4 a saciedade, -2 a limpeza, +0
  // diamantes, +1 a idade
  public void eat() {
    if (this.testAlive()) {
      this.setEnergy(this.getEnergy() - 1);
      this.setHungry(this.getHungry() + 4);
      this.setClean(this.getClean() - 2);
      this.age += 1;
    }
  }

  // # Para dormir, precisa ter perdido pelo menos 5 unidades de energia
  // # O Comando "$sleep" aumenta energia até o máximo e idade aumenta do número
  // de turnos que o pet dormiu.
  // #Os outros atributos permanecem inalterados.

  public void sleep() {
    if (this.testAlive()) {
      int resultTemp = this.getEnergyMax() - this.getEnergy();
      if (resultTemp >= 5) {
        this.setEnergy(this.getEnergyMax());
        this.setHungry(this.getHungry() - 1);
        this.age += resultTemp;
      } else {
        System.out.println("fail: nao esta com sono");
      }
    }
  }

  public String toString() {
    return "E:" + this.getEnergy() + "/" + this.getEnergyMax() + ", S:" + this.getHungry() + "/" + this.getHungryMax()
        + ", L:" + this.getClean() + "/" + this.getCleanMax() + ", D:" + this.diamonds + ", I:" + this.age;
  }
}
