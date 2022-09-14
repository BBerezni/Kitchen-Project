public abstract class Ingredient implements Priceable{

    private int id;
    private String nameOfIngredint;

    public Ingredient(int id, String nameOfIngredint) {
        this.id = id;
        this.nameOfIngredint = nameOfIngredint;
    }
    public Ingredient(String nameOfIngredint){
        this.nameOfIngredint = nameOfIngredint;
    }
    public Ingredient() {

    }
    public int getId() {
        return id;
    }
    public String getNameOfIngredint() {
        return nameOfIngredint;
    }
    @Override
    public String toString() {
        return "Ingredient" + getId() +" : " + nameOfIngredint;
    }
}
