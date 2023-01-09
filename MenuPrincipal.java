package banque;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {
    private static ArrayList<CompteCourant> comptes = new ArrayList<CompteCourant>();
//    Scanner scan = new Scanner(System.in);
    public static boolean  Verifier(String choix){
        try {
            Byte choixbyte= Byte.parseByte(choix);
            if(choixbyte >=0 && choixbyte <=6){
                return true;
            }
            return false;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static void AjouterCompte(CompteCourant c){
        comptes.add(c);
    }


    public static boolean RechercherCompte(Long RIB){
        for (CompteCourant compte:comptes) {
            if(compte.getRIB()==RIB){
                return true;
            }
        }
        return false;
    }

    public static CompteCourant getCompte(Long RIB) {
        if(RechercherCompte(RIB)){
            for (CompteCourant compte:comptes) {
                if(compte.getRIB()==RIB){
                    return compte;
                }
            }
        }
        return null;
    }

    public static void SupprimerCompte(CompteCourant c){
        if(RechercherCompte(c.getRIB())){
            comptes.remove(c);
        }
    }

    public static void ListerComptes(){
        if(comptes.size()>0){
            for (CompteCourant compte:comptes) {
                compte.Affiche();
            }
        }else {
            System.out.println("La base de donnee est vide");
        }

    }

    public static void  Menu(){
        System.out.println("1.Ajouter un cc");
        System.out.println("2.Verser argent");
        System.out.println("3.Retirer argent");
        System.out.println("4.Virer de argent");
        System.out.println("5.Supprimer un compte");
        System.out.println("6.Lister les comptes");
        System.out.println("0.quitter");
    }
}
