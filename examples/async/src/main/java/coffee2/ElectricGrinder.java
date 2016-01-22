package coffee2;

class ElectricGrinder implements Grinder {
  boolean heating;

  @Override public void grind() {
    System.out.println("~ ~ ~ grinding ~ ~ ~");
  }

}
