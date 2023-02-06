package de.flohein;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Vector;

import de.flohein.socketCommunication.ConnectionBuilder;
import de.flohein.socketCommunication.ConnectionBuilderObserver;
import de.flohein.socketCommunication.udp.SingleSocketServer;
import de.flohein.socketCommunication.udp.SocketClient;

/**
 * Hello world!
 *
 */
public class App implements ConnectionBuilderObserver
{
    static ConnectionBuilder connectionBuilder;
	
	private SocketClient client; 
	private Vector<SingleSocketServer> servers;

    public static void main( String[] args )
    {
        App main = new App();
		connectionBuilder = new ConnectionBuilder();
		
		connectionBuilder.register(main);
		try {
			connectionBuilder.initConntection();
		} catch (URISyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
	public void buildFinish() {
		client = connectionBuilder.getSocketClient();
		servers = connectionBuilder.getSocketServers();
		
	}
}
