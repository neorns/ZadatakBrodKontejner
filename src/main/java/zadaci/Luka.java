package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Brod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static zadaci.Zadatak2DodavanjeVrednosti.brodDao;

/**
 * Created by androiddevelopment on 20.1.17..
 */
public class Luka {
    static Dao<Brod,Integer> brodDao;

    public static Integer brojPristiglihBrodova = 0;

    public static void main(String[] args) {

        ConnectionSource connectionSource = null;
        try {
            // create our data-source for the database
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:brodKontejner.db");
            brodDao = DaoManager.createDao(connectionSource, Brod.class);


            List<Brod> brodovi = brodDao.queryForAll();
            //podrazumevamo da su u bazi dva broda!!!!
            //BrodNit bn1 = new BrodNit(brodovi.get(0));
            //BrodNit bn2 = new BrodNit(brodovi.get(1));

            //for (Brod b : brodovi) System.out.println(b);
            List<BrodNit> brodNiti = new ArrayList<BrodNit>();

            for (Brod b : brodovi)
                brodNiti.add(new BrodNit(b));

            for (BrodNit bn : brodNiti)
                bn.start();

            //bn1.start();
            //bn2.start();

            try {
                //bn1.join();
                //bn2.join();
                for (BrodNit bn : brodNiti)
                    bn.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Svi brodovi su stigli na odrediste, stiglo ih je:" + brojPristiglihBrodova);
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
