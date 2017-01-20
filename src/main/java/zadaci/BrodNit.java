package zadaci;

import model.Brod;

import java.util.Random;

/**
 * Created by androiddevelopment on 20.1.17..
 */
public class BrodNit extends Thread {
    private Brod brod;

    public BrodNit(Brod brod) {
        this.brod = brod;
    }

    @Override
    public void run(){

        Random random = new Random();
        try {
            System.out.println("Brod " + brod.getOznaka() + " je napustio luku");
            sleep(random.nextInt(2500)+2500);
            synchronized (brod){
               Luka.brojPristiglihBrodova++;
            }
            System.out.println("Brod " + brod.getNaziv() + " je stigao na odrediste");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
