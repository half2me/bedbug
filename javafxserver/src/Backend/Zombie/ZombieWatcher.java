package Backend.Zombie;

import java.io.BufferedReader;
import java.io.IOException;

public class ZombieWatcher implements Runnable{
    private BufferedReader in;
    private Zombie zombie;

    public ZombieWatcher(Zombie zombie, BufferedReader in){
        this.zombie = zombie;
        this.in = in;
    }

    @Override
    public void run() {
        while(true){
            try {
                this.zombie.GetMessage(in.readLine());
            } catch (IOException e) {}
        }
    }
}
