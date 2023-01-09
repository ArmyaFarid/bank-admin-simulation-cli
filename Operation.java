package banque;

public interface Operation {
    public abstract void Verser(Double argent);
    public abstract boolean Retirer(Double argent) throws CompteExeption;
}
