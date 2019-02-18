package socketserver;

//SOCKET SERVER
import Windows.MainWindow;
import Models.Reading;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;
import org.json.JSONException;


public class SocketServer {

    public static void main(String[] args) throws IOException {
        MainWindow main = new MainWindow();
        main.setVisible(true);
        ServerSocket ss;
        Socket s;
        InputStreamReader isr;
        BufferedReader br;
        PrintStream ps;
        try {
            ss = new ServerSocket(2800); //Assign to port 28000
            System.out.println("Socket opened...");
            //infinite loop
            while(true) {
                int status = 0; //status 0 equals OK
                String response = "Message received";
                s = ss.accept();
                isr = new InputStreamReader(s.getInputStream());
                br = new BufferedReader(isr);
                String data = br.readLine();
                if(data != null) {
                    try {
                        Date date = Calendar.getInstance().getTime();
                        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm");
                        String strDate = dateFormat.format(date);
                        String[] array = new String[8];
                        JSONObject JSONdata = new JSONObject(data);
                        int id = JSONdata.getInt("id");
                        String description = JSONdata.getString("description");
                        double temperature = Double.valueOf(JSONdata.getString("temperature"));
                        double humidity = Double.valueOf(JSONdata.getString("humidity"));
                        String windQuality = String.valueOf(JSONdata.getInt("windQuality"));
                        double powder = JSONdata.getDouble("powder");
                        String ipAddress = JSONdata.getString("ipAddress");
//                        JSONObject JSONdata = new JSONObject(data);
//                        int id = JSONdata.getInt("id");
//                        String timeStamp = JSONdata.getString("ts");
//                        JSONObject station = JSONdata.getJSONObject("station");
//                        String idStation = station.getString("id");
//                        String descriptionStation = station.getString("description");
//                        double temp = Double.parseDouble(station.getString("temperature")); 
//                        double hum = Double.parseDouble(station.getString("humidity")); 
//                        String wind = station.getString("windQuality"); 
//                        String ipStation = station.getString("ipAddress");
                        System.out.println(id);
                        System.out.println(description);
                        System.out.println(temperature);
                        System.out.println(humidity);
                        System.out.println(windQuality);
                        System.out.println(ipAddress);
                        array[0] = String.valueOf(id);
                        array[1] = description;
                        array[2] = String.valueOf(temperature);
                        array[3] = String.valueOf(humidity);
                        array[4] = windQuality;
                        array[5] = String.valueOf(powder);
                        array[6] = ipAddress;
                        array[7] = strDate;
                        int idParsed = id;
                        Reading.add(strDate, idParsed, temperature, humidity, windQuality,powder);
                        main.realTimeValues(array);
                        
                    } catch(JSONException e) {
                        status = 2;
                        response = "Invalid JSON format";
                    }
                } else {
                    status = 1;
                    response = "Data not received";
                }
                //response to client
                ps = new PrintStream(s.getOutputStream());
                ps.println(response);
            }
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        } 
    }
}

