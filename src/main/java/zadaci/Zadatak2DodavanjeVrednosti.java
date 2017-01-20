package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Brod;
import model.Kontejner;

import java.io.IOException;
import java.util.List;


/**
 * Created by androiddevelopment on 20.1.17..
 */
public class Zadatak2DodavanjeVrednosti {
    static Dao<Brod,Integer> brodDao;
    static Dao<Kontejner,Integer> kontejnerDao;

    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            // create our data-source for the database
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:brodKontejner.db");

            brodDao = DaoManager.createDao(connectionSource, Brod.class);
            kontejnerDao = DaoManager.createDao(connectionSource, Kontejner.class);

            //Za testiranje obrisati sadrzaj - ne trazi se u zadatku pa je pod komentarom
            //TableUtils.clearTable(connectionSource, Kontejner.class);
            //TableUtils.clearTable(connectionSource, Brod.class);

            Brod b1 = new Brod("Brod1", "Transporter1");
            brodDao.create(b1);
            Brod b2 = new Brod("Brod2", "Transporter2");
            brodDao.create(b2);

            Kontejner k1 = new Kontejner("KP1","Namestaj",100);
            k1.setBrod(b1);
            kontejnerDao.create(k1);

            Kontejner k2 = new Kontejner("KP2","Banane",1000.5);
            k2.setBrod(b1);
            kontejnerDao.create(k2);

            Kontejner k3 = new Kontejner("KP3","Morski proizvodi",200.7);
            k3.setBrod(b1);
            kontejnerDao.create(k3);

            Kontejner k4 = new Kontejner("KP4","Mercedes",500.4);
            k4.setBrod(b2);
            kontejnerDao.create(k4);

            Kontejner k5 = new Kontejner("KP5","Klavir",100);
            k5.setBrod(b2);
            kontejnerDao.create(k5);


            List<Brod> brodovi = brodDao.queryForAll();
            for (Brod b : brodovi)
                System.out.println(b);

            List<Kontejner> kontejneri = kontejnerDao.queryForAll();
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
