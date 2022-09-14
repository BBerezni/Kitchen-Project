import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseRecipes {

    public List<Recipe> getRecipe() {

        List<Recipe> recipeList = new ArrayList<>();

        Recipe cokoladniMafini;
        List<WeightedIngredient> ingredientsCokoladniMafini = new ArrayList<>();
        WeightedIngredient jaja = new WeightedIngredient(1, "jaja", 1, 17);
        WeightedIngredient secer = new WeightedIngredient(2, "secer", 0.2, 89);
        WeightedIngredient brasno = new WeightedIngredient(3, "brasno", 0.17, 101);
        WeightedIngredient vanilinSecer = new WeightedIngredient(4, "vanilin secer", 1, 25);
        WeightedIngredient kakao = new WeightedIngredient(5, "kakao", 0.3, 147);
        WeightedIngredient sodaBikarbona = new WeightedIngredient(6, "soda bikarbona", 1, 23);
        WeightedIngredient mleko = new WeightedIngredient(7, "mleko", 0.18, 149);
        WeightedIngredient ulje = new WeightedIngredient(8, "ulje", 0.1, 223);
        WeightedIngredient cokoladaZaKuvanje = new WeightedIngredient(9, "cokolada za kuvanje", 0.2, 229);
        ingredientsCokoladniMafini.add(jaja);
        ingredientsCokoladniMafini.add(secer);
        ingredientsCokoladniMafini.add(brasno);
        ingredientsCokoladniMafini.add(vanilinSecer);
        ingredientsCokoladniMafini.add(kakao);
        ingredientsCokoladniMafini.add(sodaBikarbona);
        ingredientsCokoladniMafini.add(mleko);
        ingredientsCokoladniMafini.add(ulje);
        ingredientsCokoladniMafini.add(cokoladaZaKuvanje);
        cokoladniMafini = new Recipe("Cokoladni Mafini", ingredientsCokoladniMafini);
        cokoladniMafini.recipeDifficulty(jaja);
        cokoladniMafini.recipeDifficulty(secer);
        cokoladniMafini.recipeDifficulty(brasno);
        cokoladniMafini.recipeDifficulty(vanilinSecer);
        cokoladniMafini.recipeDifficulty(kakao);
        cokoladniMafini.recipeDifficulty(sodaBikarbona);
        cokoladniMafini.recipeDifficulty(mleko);
        cokoladniMafini.recipeDifficulty(ulje);
        cokoladniMafini.recipeDifficulty(cokoladaZaKuvanje);


        Recipe domaciKeksici;
        List<WeightedIngredient> ingredientsDomaciKeksici = new ArrayList<>();
        WeightedIngredient mast = new WeightedIngredient(10, "mast", 0.2, 234);
        jaja = new WeightedIngredient(1, "jaja", 2, 17);
        secer = new WeightedIngredient(2, "secer", 0.12, 89);
        brasno = new WeightedIngredient(3, "brasno", 0.5, 101);
        WeightedIngredient prasakZaPecivo = new WeightedIngredient(11, "prasak za pecivo", 1, 19);
        ingredientsDomaciKeksici.add(mast);
        ingredientsDomaciKeksici.add(jaja);
        ingredientsDomaciKeksici.add(secer);
        ingredientsDomaciKeksici.add(brasno);
        ingredientsDomaciKeksici.add(prasakZaPecivo);
        domaciKeksici = new Recipe("Domaci keksici", ingredientsDomaciKeksici);
        domaciKeksici.recipeDifficulty(mast);
        domaciKeksici.recipeDifficulty(jaja);
        domaciKeksici.recipeDifficulty(secer);
        domaciKeksici.recipeDifficulty(brasno);
        domaciKeksici.recipeDifficulty(prasakZaPecivo);

        Recipe medenoSrce;
        List<WeightedIngredient> ingredientsMedenoSrce = new ArrayList<>();
        secer = new WeightedIngredient(2, "secer", 0.2, 89);
        brasno = new WeightedIngredient(3, "brasno", 0.2, 101);
        kakao = new WeightedIngredient(5, "kakao", 0.3, 147);
        ulje = new WeightedIngredient(8, "ulje", 0.12, 223);
        WeightedIngredient kiselaVoda = new WeightedIngredient(12, "kisela voda", 0.25, 89);
        WeightedIngredient cimet = new WeightedIngredient(14, "cimet", 0.1, 28);
        ingredientsMedenoSrce.add(secer);
        ingredientsMedenoSrce.add(brasno);
        ingredientsMedenoSrce.add(kakao);
        ingredientsMedenoSrce.add(ulje);
        ingredientsMedenoSrce.add(kiselaVoda);
        ingredientsMedenoSrce.add(cimet);
        medenoSrce = new Recipe("Medeno srce", ingredientsMedenoSrce);
        medenoSrce.recipeDifficulty(secer);
        medenoSrce.recipeDifficulty(brasno);
        medenoSrce.recipeDifficulty(kakao);
        medenoSrce.recipeDifficulty(ulje);
        medenoSrce.recipeDifficulty(kiselaVoda);
        medenoSrce.recipeDifficulty(cimet);

        Recipe vanilice;
        List<WeightedIngredient> ingredientsVanilice = new ArrayList<>();
        sodaBikarbona = new WeightedIngredient(6, "soda bikarbona", 1, 23);
        cimet = new WeightedIngredient(14, "cimet", 0.1, 28);
        ulje = new WeightedIngredient(8, "ulje", 0.12, 223);
        cokoladaZaKuvanje = new WeightedIngredient(9, "cokolada za kuvanje", 0.2, 229);
        ingredientsVanilice.add(sodaBikarbona);
        ingredientsVanilice.add(cimet);
        ingredientsVanilice.add(ulje);
        ingredientsVanilice.add(cokoladaZaKuvanje);
        vanilice = new Recipe("Vanilice", ingredientsVanilice);
        vanilice.recipeDifficulty(sodaBikarbona);
        vanilice.recipeDifficulty(cimet);
        vanilice.recipeDifficulty(ulje);
        vanilice.recipeDifficulty(cokoladaZaKuvanje);

        Recipe carskaPita;
        List<WeightedIngredient> ingredientsCarskaPita = new ArrayList<>();
        ulje = new WeightedIngredient(10, "ulje", 0.2, 234);
        jaja = new WeightedIngredient(1, "jaja", 4, 17);
        brasno = new WeightedIngredient(3, "brasno", 0.4, 101);
        prasakZaPecivo = new WeightedIngredient(11, "prasak za pecivo", 1, 19);
        WeightedIngredient sir = new WeightedIngredient(15, "sir", 0.15, 537);
        WeightedIngredient kackavalj = new WeightedIngredient(16, "kackavalj", 0.15, 679);
        WeightedIngredient sunka = new WeightedIngredient(17, "sunka", 0.15, 672);
        WeightedIngredient krastavci = new WeightedIngredient(18, "krastavci", 0.25, 54);
        WeightedIngredient crvenaPaprika = new WeightedIngredient(19, "crvena paprika", 0.05, 70);
        ingredientsCarskaPita.add(ulje);
        ingredientsCarskaPita.add(jaja);
        ingredientsCarskaPita.add(brasno);
        ingredientsCarskaPita.add(prasakZaPecivo);
        ingredientsCarskaPita.add(sir);
        ingredientsCarskaPita.add(kackavalj);
        ingredientsCarskaPita.add(sunka);
        ingredientsCarskaPita.add(krastavci);
        ingredientsCarskaPita.add(crvenaPaprika);
        carskaPita = new Recipe("Carska pita", ingredientsCarskaPita);
        carskaPita.recipeDifficulty(ulje);
        carskaPita.recipeDifficulty(jaja);
        carskaPita.recipeDifficulty(brasno);
        carskaPita.recipeDifficulty(prasakZaPecivo);
        carskaPita.recipeDifficulty(sir);
        carskaPita.recipeDifficulty(kackavalj);
        carskaPita.recipeDifficulty(sunka);
        carskaPita.recipeDifficulty(krastavci);
        carskaPita.recipeDifficulty(crvenaPaprika);

        Recipe slanaTorta;
        List<WeightedIngredient> ingredientsSlanaTorta = new ArrayList<>();
        WeightedIngredient majonez = new WeightedIngredient(20, "majonez", 0.3, 89);
        sir = new WeightedIngredient(15, "sir", 0.2, 537);
        sunka = new WeightedIngredient(17, "sunka", 0.3, 672);
        kackavalj = new WeightedIngredient(16, "kackavalj", 0.05, 679);
        ingredientsSlanaTorta.add(majonez);
        ingredientsSlanaTorta.add(sir);
        ingredientsSlanaTorta.add(sunka);
        ingredientsSlanaTorta.add(kackavalj);
        slanaTorta = new Recipe("Slana torta", ingredientsSlanaTorta);
        slanaTorta.recipeDifficulty(majonez);
        slanaTorta.recipeDifficulty(sir);
        slanaTorta.recipeDifficulty(sunka);
        slanaTorta.recipeDifficulty(kackavalj);

        Recipe ruskaSalata;
        List<WeightedIngredient> ingredientsRuskaSalata = new ArrayList<>();
        WeightedIngredient krompir = new WeightedIngredient(21, "krompir", 0.6, 88);
        WeightedIngredient sangarepa = new WeightedIngredient(22, "sangarepa", 0.25, 255);
        jaja = new WeightedIngredient(1, "jaja", 1, 17);
        WeightedIngredient grasak = new WeightedIngredient(23, "grasak", 0.3, 875);
        krastavci = new WeightedIngredient(18, "krastavci", 0.2, 54);
        sunka = new WeightedIngredient(17, "sunka", 0.3, 672);
        majonez = new WeightedIngredient(20, "majonez", 0.3, 89);
        WeightedIngredient pavlaka = new WeightedIngredient(24, "pavlaka", 0.2, 79);
        ingredientsRuskaSalata.add(krompir);
        ingredientsRuskaSalata.add(sangarepa);
        ingredientsRuskaSalata.add(jaja);
        ingredientsRuskaSalata.add(grasak);
        ingredientsRuskaSalata.add(krastavci);
        ingredientsRuskaSalata.add(sunka);
        ingredientsRuskaSalata.add(majonez);
        ingredientsRuskaSalata.add(pavlaka);
        ruskaSalata = new Recipe("Ruska salata", ingredientsRuskaSalata);
        ruskaSalata.recipeDifficulty(krompir);
        ruskaSalata.recipeDifficulty(sangarepa);
        ruskaSalata.recipeDifficulty(jaja);
        ruskaSalata.recipeDifficulty(grasak);
        ruskaSalata.recipeDifficulty(krastavci);
        ruskaSalata.recipeDifficulty(sunka);
        ruskaSalata.recipeDifficulty(majonez);
        ruskaSalata.recipeDifficulty(pavlaka);


        Recipe bajadera;
        List<WeightedIngredient> ingredientsBajadera = new ArrayList<>();
        secer = new WeightedIngredient(2, "secer", 0.2, 89);
        WeightedIngredient margarin = new WeightedIngredient(25, "margarin", 0.25, 200);
        WeightedIngredient mleveniOrah = new WeightedIngredient(26, "mleveni orah", 0.2, 234);
        WeightedIngredient mleveniKeks = new WeightedIngredient(27, "mleveni keks", 0.2, 159);
        cokoladaZaKuvanje = new WeightedIngredient(9, "cokolada za kuvanje", 0.2, 229);
        ingredientsBajadera.add(secer);
        ingredientsBajadera.add(margarin);
        ingredientsBajadera.add(mleveniOrah);
        ingredientsBajadera.add(mleveniKeks);
        ingredientsBajadera.add(cokoladaZaKuvanje);
        bajadera = new Recipe("Bajadera", ingredientsBajadera);
        bajadera.recipeDifficulty(secer);
        bajadera.recipeDifficulty(margarin);
        bajadera.recipeDifficulty(mleveniOrah);
        bajadera.recipeDifficulty(mleveniKeks);
        bajadera.recipeDifficulty(cokoladaZaKuvanje);

        Recipe plazmaTorta;
        List<WeightedIngredient> ingredientsPlazmaTorta = new ArrayList<>();
        margarin = new WeightedIngredient(25, "margarin", 0.25, 200);
        mleveniKeks = new WeightedIngredient(27, "mleveni keks", 0.2, 159);
        secer = new WeightedIngredient(2, "secer", 0.2, 89);
        jaja = new WeightedIngredient(1, "jaja", 1, 17);
        mleveniOrah = new WeightedIngredient(26, "mleveni orah", 0.2, 234);
        ingredientsPlazmaTorta.add(margarin);
        ingredientsPlazmaTorta.add(mleveniKeks);
        ingredientsPlazmaTorta.add(secer);
        ingredientsPlazmaTorta.add(jaja);
        ingredientsPlazmaTorta.add(mleveniOrah);
        plazmaTorta = new Recipe("Plazma torta", ingredientsPlazmaTorta);
        plazmaTorta.recipeDifficulty(margarin);
        plazmaTorta.recipeDifficulty(mleveniKeks);
        plazmaTorta.recipeDifficulty(secer);
        plazmaTorta.recipeDifficulty(jaja);
        plazmaTorta.recipeDifficulty(mleveniOrah);

        Recipe krempitaSaKeksom;
        List<WeightedIngredient> ingredientsKrempitaSaKeksom = new ArrayList<>();
        mleveniKeks = new WeightedIngredient(27, "mleveni keks", 0.5, 159);
        mleko = new WeightedIngredient(7, "mleko", 1, 149);
        jaja = new WeightedIngredient(1, "jaja", 1, 17);
        margarin = new WeightedIngredient(25, "margarin", 0.25, 200);
        secer = new WeightedIngredient(2, "secer", 0.25, 89);
        brasno = new WeightedIngredient(3, "brasno", 0.04, 101);
        ingredientsKrempitaSaKeksom.add(mleveniKeks);
        ingredientsKrempitaSaKeksom.add(mleko);
        ingredientsKrempitaSaKeksom.add(jaja);
        ingredientsKrempitaSaKeksom.add(margarin);
        ingredientsKrempitaSaKeksom.add(secer);
        ingredientsKrempitaSaKeksom.add(brasno);
        krempitaSaKeksom = new Recipe("krempita sa krompirom", ingredientsKrempitaSaKeksom);
        krempitaSaKeksom.recipeDifficulty(mleveniKeks);
        krempitaSaKeksom.recipeDifficulty(mleko);
        krempitaSaKeksom.recipeDifficulty(jaja);
        krempitaSaKeksom.recipeDifficulty(margarin);
        krempitaSaKeksom.recipeDifficulty(secer);
        krempitaSaKeksom.recipeDifficulty(brasno);

        recipeList.add(cokoladniMafini);
        recipeList.add(domaciKeksici);
        recipeList.add(medenoSrce);
        recipeList.add(vanilice);
        recipeList.add(carskaPita);
        recipeList.add(slanaTorta);
        recipeList.add(ruskaSalata);
        recipeList.add(bajadera);
        recipeList.add(plazmaTorta);
        recipeList.add(krempitaSaKeksom);

        return recipeList;
    }

    public Recipe getIngredientsOfRecipe(String recipe, List<Recipe> recipeList) {
        for (Recipe recipes : recipeList) {
            if (recipes.getNameOfRecipe().equals(recipe)) {
                return recipes;
            }
        }
        return null;
    }
}
