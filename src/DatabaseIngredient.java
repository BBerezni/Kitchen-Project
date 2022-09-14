import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DatabaseIngredient {

    private List<WeightedIngredient> allIngredients = new ArrayList<>();

    public List<WeightedIngredient> getAllIngredients() {
        return allIngredients;
    }

    public void setAllIngredients(List<WeightedIngredient> allIngredients) {
        this.allIngredients = allIngredients;
    }

    WeightedIngredient jaja = new WeightedIngredient(1, "jaja", 1, 17);
    WeightedIngredient secer = new WeightedIngredient(2, "secer", 1, 89);
    WeightedIngredient brasno = new WeightedIngredient(3, "brasno", 1, 101);
    WeightedIngredient vanilinSecer = new WeightedIngredient(4, "vanilin secer", 1, 25);
    WeightedIngredient kakao = new WeightedIngredient(5, "kakao", 0.1, 147);
    WeightedIngredient sodaBikarbona = new WeightedIngredient(6, "soda bikarbona", 1, 23);
    WeightedIngredient mleko = new WeightedIngredient(7, "mleko", 1, 149);
    WeightedIngredient ulje = new WeightedIngredient(8, "ulje", 1, 223);
    WeightedIngredient cokoladaZaKuvanje = new WeightedIngredient(9, "cokolada za kuvanje", 0.2, 229);
    WeightedIngredient mast = new WeightedIngredient(10, "mast", 1, 234);
    WeightedIngredient prasakZaPecivo = new WeightedIngredient(11, "prasak za pecivo", 1, 19);
    WeightedIngredient kiselaVoda = new WeightedIngredient(12, "kisela voda", 1.5, 89);
    WeightedIngredient pekmez = new WeightedIngredient(113, "pekmez", 1, 499);
    WeightedIngredient cimet = new WeightedIngredient(14, "cimet", 1, 28);
    WeightedIngredient sir = new WeightedIngredient(15, "sir", 1, 537);
    WeightedIngredient kackavalj = new WeightedIngredient(16, "kackavalj", 1, 679);
    WeightedIngredient sunka = new WeightedIngredient(17, "sunka", 1, 672);
    WeightedIngredient krastavci = new WeightedIngredient(18, "krastavci", 0.15, 54);
    WeightedIngredient crvenaPaprika = new WeightedIngredient(19, "crvena paprika", 0.1, 70);
    WeightedIngredient majonez = new WeightedIngredient(20, "majonez", 0.1, 89);
    WeightedIngredient krompir = new WeightedIngredient(21, "krompir", 1, 88);
    WeightedIngredient sangarepa = new WeightedIngredient(22, "sangarepa", 1, 255);
    WeightedIngredient grasak = new WeightedIngredient(23, "grasak", 1, 875);
    WeightedIngredient pavlaka = new WeightedIngredient(24, "pavlaka", 0.2, 79);
    WeightedIngredient margarin = new WeightedIngredient(25, "margarin", 0.25, 200);
    WeightedIngredient mleveniOrah = new WeightedIngredient(26, "mleveni orah", 0.2, 234);
    WeightedIngredient mleveniKeks = new WeightedIngredient(27, "mleveni keks", 0.2, 159);



    public List<WeightedIngredient> AllIngredients() {
        allIngredients.add(jaja);
        allIngredients.add(secer);
        allIngredients.add(vanilinSecer);
        allIngredients.add(brasno);
        allIngredients.add(kakao);
        allIngredients.add(sodaBikarbona);
        allIngredients.add(mleko);
        allIngredients.add(ulje);
        allIngredients.add(cokoladaZaKuvanje);
        allIngredients.add(mast);
        allIngredients.add(prasakZaPecivo);
        allIngredients.add(kiselaVoda);
        allIngredients.add(pekmez);
        allIngredients.add(cimet);
        allIngredients.add(sir);
        allIngredients.add(kackavalj);
        allIngredients.add(sunka);
        allIngredients.add(krastavci);
        allIngredients.add(crvenaPaprika);
        allIngredients.add(majonez);
        allIngredients.add(krompir);
        allIngredients.add(sangarepa);
        allIngredients.add(grasak);
        allIngredients.add(pavlaka);
        allIngredients.add(margarin);
        allIngredients.add(mleveniOrah);
        allIngredients.add(mleveniKeks);
        return allIngredients;
    }

    public List<WeightedIngredient> getIngredients(List<String> nameOfInredient, List<WeightedIngredient> allIngredients) {
        List<WeightedIngredient> ingredientsForRecipe = new ArrayList<>();
        WeightedIngredient ingredient = null;
        for (String str : nameOfInredient) {
            for (WeightedIngredient weightedIngredient : allIngredients) {
                if (weightedIngredient.getNameOfIngredint().equals(str)) {
                    ingredient = weightedIngredient;
                    ingredientsForRecipe.add(ingredient);
                }
            }
        }
        return ingredientsForRecipe;
    }

    @Override
    public String toString() {
        return "DatabaseIngredient{" +
                "allIngredients=" + allIngredients +
                ", jaja=" + jaja +
                ", secer=" + secer +
                ", brasno=" + brasno +
                ", vanilinSecer=" + vanilinSecer +
                ", kakao=" + kakao +
                ", sodaBikarbona=" + sodaBikarbona +
                ", mleko=" + mleko +
                ", ulje=" + ulje +
                ", cokoladaZaKuvanje=" + cokoladaZaKuvanje +
                ", mast=" + mast +
                ", prasakZaPecivo=" + prasakZaPecivo +
                ", kiselaVoda=" + kiselaVoda +
                ", pekmez=" + pekmez +
                ", cimet=" + cimet +
                ", sir=" + sir +
                ", kackavalj=" + kackavalj +
                ", sunka=" + sunka +
                ", krastavci=" + krastavci +
                ", crvenaPaprika=" + crvenaPaprika +
                ", majonez=" + majonez +
                ", krompir=" + krompir +
                ", sangarepa=" + sangarepa +
                ", grasak=" + grasak +
                ", pavlaka=" + pavlaka +
                ", margarin=" + margarin +
                ", mleveniOrah=" + mleveniOrah +
                ", mleveniKeks=" + mleveniKeks +
                '}';
    }
}
