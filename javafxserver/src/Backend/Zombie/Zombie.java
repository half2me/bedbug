package Backend.Zombie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Zombie {
    public Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private Thread thread;

    public Zombie(Socket socket) throws IOException {
        this.socket = socket;
        this.out = new PrintWriter(this.socket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        (this.thread = new Thread(new ZombieWatcher(this, this.in))).run();
    }

    public void GetMessage(String message){
        System.out.println("Z: " + message);
    }

    public void SendMessage(String message){
        System.out.println("S: " + message);
    }
}
