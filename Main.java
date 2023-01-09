package banque;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int total_client = 0;
        String choice;
//        MenuPrincipal menuPrincipal = new MenuPrincipal();

        while (true) {
            MenuPrincipal.Menu();
            do {
                System.out.println("Taper : ");
                choice = scan.next();
                if (!MenuPrincipal.Verifier(choice)) {
                    System.out.println("Entre 0 et 6 , reesayer");
                }
            } while (!MenuPrincipal.Verifier(choice));

            Long rib;
            switch (choice) {
                case "1":
                    System.out.println("nom :");
                    String nom = scan.next();
                    System.out.println("prenom :");
                    String prenom = scan.next();
                    System.out.println("adresse :");
                    String adresse = scan.next();
                    Client client = new Client(total_client, nom, prenom, adresse);
                    System.out.println("Solde initial :");
                    Double solde = scan.nextDouble();
                    System.out.println("Son rib :");
                    rib = scan.nextLong();
                    CompteCourant compteCourant = new CompteCourant(client, solde, rib);
                    compteCourant.Affiche();
                    total_client++;
                    System.out.println(total_client);
                    MenuPrincipal.AjouterCompte(compteCourant);
                    break;
                case "2":
                    System.out.println("Saisir le rib");
                    rib = scan.nextLong();
                    if (MenuPrincipal.getCompte(rib) != null) {
                        Double montant = scan.nextDouble();
                        MenuPrincipal.getCompte(rib).Verser(montant);
                    } else {
                        System.out.println("no compte found");
                    }
                    break;
                case "3":
                    System.out.println("Saisir le rib");
                    rib = scan.nextLong();
                    if (MenuPrincipal.getCompte(rib) != null) {
                        System.out.println("Saisir le montant");
                        Double montant = scan.nextDouble();
                        try {
                            MenuPrincipal.getCompte(rib).Retirer(montant);
                        } catch (CompteExeption exception) {
                            System.out.println(exception);
                        }
                        ;
                    } else {
                        System.out.println("no compte found");
                    }
                    break;
                case "4":
                    System.out.println("Saisir le rib du compte");
                    rib = scan.nextLong();
                    if (MenuPrincipal.getCompte(rib) != null) {
                        System.out.println("Saisir le rib du destinataire");
                        Long RIB_receive = scan.nextLong();
                        if (MenuPrincipal.getCompte(RIB_receive) != null) {
                            System.out.println("Saisir le montant");
                            Double montant = scan.nextDouble();
                            MenuPrincipal.getCompte(rib).Virer(MenuPrincipal.getCompte(RIB_receive), montant);
                        } else {
                            System.out.println("Le destinataire n'existe pas");
                        }
                    } else {
                        System.out.println("no compte found");
                    }
                    break;
                case "5":
                    System.out.println("Saisir le rib");
                    rib = scan.nextLong();
                    if (MenuPrincipal.getCompte(rib) != null) {
                        MenuPrincipal.SupprimerCompte(MenuPrincipal.getCompte(rib));
                    } else {
                        System.out.println("no compte found");
                    }
                    break;
                case "6":
                    MenuPrincipal.ListerComptes();
                    break;
                case "0":
                    System.exit(0);
                    break;
            }
        }
    }
}
