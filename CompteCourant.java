package banque;

public class CompteCourant extends Compte{
    private Long RIB;
    public CompteCourant(Client client, Double solde, Long RIB) {
        super(client, solde);
        this.RIB = RIB;
    }

    public void Virer(CompteCourant cc , Double montant){
        boolean done=false;
        try {
            done = this.Retirer(montant);
        }catch (CompteExeption e){
            System.out.println(e);
        }
        if(done){
            cc.Verser(montant);
            System.out.println("success");
        }
    }

    public void Affiche(){
        System.out.println(this.getClient().toString());
        System.out.println("son solde est: "+ this.getSolde());
    }

    public Long getRIB() {
        return this.RIB;
    }
}
