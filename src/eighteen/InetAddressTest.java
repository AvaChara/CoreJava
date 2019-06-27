package eighteen;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String args[]) throws UnknownHostException {
        InetAddress address=InetAddress.getLocalHost();
        System.out.println(address);
        address=InetAddress.getByName("baidu.com");
        System.out.println(address);
        InetAddress address1[]=InetAddress.getAllByName("www.nba.com");
        for (int i = 0; i <address1.length ; i++) {
            System.out.println(address1[i]);
        }
    }
}
