package node;


import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * Class to represent a node.
 */
public class Node {
    
    private PrivateKey privateKey;
    public PublicKey publicKey;
    private String publicKeyAsString;
    private String host;
    private int port;

     public Node(PublicKey publicKey, String host, int port){
         this.publicKey = publicKey;
         this.host = host;
         this.port = port;
     }
    public Node(PrivateKey privateKey, PublicKey publicKey){
         this.privateKey = privateKey;
         this.publicKey = publicKey;
    }
    public Node(PrivateKey privateKey, String publicKeyAsString) throws NoSuchAlgorithmException, InvalidKeySpecException {
        this.privateKey = privateKey;
        byte[] publicBytes = Base64.getDecoder().decode(publicKeyAsString);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        this.publicKey = keyFactory.generatePublic(keySpec);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }
}
