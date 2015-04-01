package Backend;

import Backend.Zombie.*;

import java.io.IOException;
import java.util.ArrayList;

public class Backend {
    private ArrayList<Zombie> zombies;
    private Thread zombieThread;

    public Backend(int port) throws IOException {
        zombies = new ArrayList<Zombie>(1);
        zombieThread = new Thread(new Server(this, port));
        zombieThread.run();
    }

    public void AddZombie(Zombie zombie){
        zombies.add(zombie);
    }

    public static void main(String[] args){
        try {
            Backend b = new Backend(9595);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
