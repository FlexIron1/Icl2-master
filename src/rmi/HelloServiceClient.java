package rmi;import com.example.InterfaceApp;import com.example.RunApplication;import java.rmi.registry.*;public class HelloServiceClient {	public static void main(String... args) throws Exception {		Registry registry = LocateRegistry.getRegistry("localhost", 2099);		RemoteHelloService service = (RemoteHelloService) registry.lookup("sample/HelloService");		InterfaceApp.main();	}}