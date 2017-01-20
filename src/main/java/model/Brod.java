package model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

/**
 * Created by androiddevelopment on 20.1.17..
 */
public class Brod {
    public static final String POLJE_OZNAKA="oznaka";
    public static final String POLJE_NAZIV="naziv";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_OZNAKA,canBeNull = false, unique=false)
    private String oznaka;
    @DatabaseField(columnName = POLJE_NAZIV,canBeNull = false, unique=false)
    private String naziv;

    @ForeignCollectionField(foreignFieldName = "brod")
    private ForeignCollection<Kontejner> kontejneri;

    public Brod() {
    }

    public Brod(String oznaka, String naziv) {
        this.oznaka = oznaka;
        this.naziv = naziv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public ForeignCollection<Kontejner> getKontejneri() {
        return kontejneri;
    }

    public void setKontejneri(ForeignCollection<Kontejner> kontejneri) {
        this.kontejneri = kontejneri;
    }

    @Override
    public String toString() {
        return "Brod{id = " + id + " oznaka = " + oznaka + " naziv = " + naziv + '}';
    }
}
