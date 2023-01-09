package banque;

public class Client {
    private int code_client;
    private String  nom;
    private String  prenom;
    private String  adresse;

    public Client(int code , String nom , String prenom , String adresse) {
        this.code_client=code;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }


    public int getCode_client() {
        return this.code_client;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setCode_client(int code_client) {
        this.code_client = code_client;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Mr "+this.nom+" "+this.prenom+" du code numero: "+this.code_client+" et qui habite a "+this.adresse;
    }
}
