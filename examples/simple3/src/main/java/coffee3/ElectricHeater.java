package coffee3;

class ElectricHeater implements Heater {
  boolean heating;
  private String type;
  
  public ElectricHeater() {
	  this("");
  }

  public ElectricHeater(String type) {
	  this.type = type;
  }

  @Override public void on() {
    System.out.printf("~ ~ ~ heating(%s) ~ ~ ~\n", type);
    this.heating = true;
  }

  @Override public void off() {
    this.heating = false;
  }

  @Override public boolean isHot() {
    return heating;
  }
}
