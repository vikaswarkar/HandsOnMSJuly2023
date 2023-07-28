package handsonms.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
@Slf4j
public class ServiceUtil {
    private final String port;
    private String serviceAddress = null;

    @Autowired
    public ServiceUtil(@Value("${server.port}")  String port){
        this.port = port;
    }

    public String getServiceAddress()  {
        if (this.serviceAddress == null){
            try{
                this.serviceAddress =
                        InetAddress.getLocalHost().getHostName() + "/" +
                                InetAddress.getLocalHost().getHostAddress() + ":" + port;

            }catch (UnknownHostException unknownHostException){
                return "Unknown hostname or IpAddress";
            }

        }
        return this.serviceAddress;
    }
}
