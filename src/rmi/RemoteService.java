package rmi;import java.io.IOException;import java.rmi.Remote;import java.rmi.RemoteException;public interface RemoteService extends Remote {    void infoPerson(Person person) throws IOException;    void sayHello(Person name) throws RemoteException;}