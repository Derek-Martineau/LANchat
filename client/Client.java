package client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

	private DatagramSocket socket;
	public InetAddress address;
	public int port;

	public Client(String address, int port) {
		try {
			this.address = InetAddress.getByName(address);
			this.port = port;

			socket = new DatagramSocket();

		} catch (Exception e) {
			e.printStackTrace();
		}

		this.send("\\con Derek", this.address, port);
	}

	public void send(String message, InetAddress address, int port) {
		try {
			message += "\\e";
			byte[] data = message.getBytes();
			DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
			socket.send(packet);
			System.out.println("Sent Message To, " + address.getHostAddress() + ":" + port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
