public class
WeightedIngredient extends Ingredient {

    private double weight;
    private double pricePerUnit;

    public WeightedIngredient(int id, String nameOfIngredint, double weight, double pricePerUnit) {
        super(id, nameOfIngredint);
        this.weight = weight;
        this.pricePerUnit = pricePerUnit;
    }
    public WeightedIngredient(String nameOfIngredint, double weight) {
        super(nameOfIngredint);
        this.weight = weight;
    }

    public WeightedIngredient() {
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public void scaledWeight(double scale, double weight){
        weight = getWeight();
        weight = weight * scale;
        setWeight(weight);
    }

    public void addWeight(double addedWeight, double weight){
        weight = getWeight();
        weight = weight + addedWeight;
        setWeight(weight);
    }

    public void removeWeight(double removedWeight, double weight){
        weight = getWeight();
        weight = weight - removedWeight;
        setWeight(weight);
    }

    @Override
    public double getPrice(){
        return weight * pricePerUnit;
    }

    @Override
    public String toString() {
        return "Ingredient " + getNameOfIngredint() +  ", Weight: " + weight + "kg" + ", Price Per Unit: " + pricePerUnit + " RSD" + "\n";
    }
}
