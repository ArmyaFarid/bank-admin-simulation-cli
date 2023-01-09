package banque;

public class Compte implements Operation {

    private Client client;
    private Double  solde;

    public Compte(Client client , Double solde){
        this.client=client;
        this.solde=solde;
    }

    @Override
    public void Verser(Double argent) {
        this.solde+=argent;
    }

    @Override
    public boolean Retirer(Double argent) throws CompteExeption{
        if(argent > solde){
            throw new CompteExeption("Solde insuffisant");
        }
        this.solde-=argent;
        return true;
    }

    public void Affiche(){
        System.out.println(this.client.toString());
        System.out.println("son solde est: "+this.solde);
    }

    public Double getSolde() {
        return this.solde;
    }

    public Client getClient() {
        return client;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
