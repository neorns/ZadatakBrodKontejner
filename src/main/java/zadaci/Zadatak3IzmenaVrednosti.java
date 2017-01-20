package zadaci;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Kontejner;

import java.io.IOException;
import java.util.List;

import static model.Kontejner.POLJE_OPIS;
import static zadaci.Zadatak2DodavanjeVrednosti.kontejnerDao;

/**
 * Created by androiddevelopment on 20.1.17..
 */
public class Zadatak3IzmenaVrednosti {
    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            // create our data-source for the database
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:brodKontejner.db");

            kontejnerDao = DaoManager.createDao(connectionSource, Kontejner.class);
            List<Kontejner> kontejneri = kontejnerDao.queryForAll();
            for (Kontejner k : kontejneri)
                System.out.println(k);

            kontejneri=kontejnerDao.queryForEq(POLJE_OPIS,"Morski proizvodi");
            Kontejner kontejnerZaIzmenu = kontejneri.get(0);
            kontejnerZaIzmenu.setOpis("Plodovi mora");
            kontejnerDao.update(kontejnerZaIzmenu);

            kontejneri = kontejnerDao.queryForAll();
            for (Kontejner k : kontejneri)
                System.out.println(k);


        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connectionSource != null) {
                try {
                    connectionSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
