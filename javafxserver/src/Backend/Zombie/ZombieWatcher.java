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
		String tmp = in.readLine();
		if(tmp == null) return;
                this.zombie.GetMessage(tmp);
            } catch (IOException e) {}
        }
    }
}
