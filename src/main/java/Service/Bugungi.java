package Service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;

public class Bugungi implements Base {
    @Override
    public synchronized SendMessage onUpdateReceived(Update update) {
        try {


            URL url = new URL("https://islam.global/namaz/uz/karakalpakstan/beruni/");
            URLConnection connection =url.openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            int n;
            String str = "";
            while ((n= bufferedReader.read())!=-1){
                str += (char)n;
            }
            int index = str.indexOf("<div class=\"row card-namaz-time-container d-print-none\">");
            int lastindex = str.indexOf("<h2 class=\"section-title\" id=\"nav-title-month\">");

            String s = str.substring(index,lastindex);

            String bomdod = s.substring(s.indexOf("<time>")+6, s.indexOf("<time>")+10);
            String quyosh = s.substring(s.indexOf("ВОСХОД")-30,s.indexOf("ВОСХОД")-26);
            String peshin = s.substring(s.indexOf("ЗУХР")-31,s.indexOf("ЗУХР")-26);
            String asr = s.substring(s.indexOf("АСР")-31,s.indexOf("АСР")-26);
            String shom = s.substring(s.indexOf("МАГРИБ")-31,s.indexOf("МАГРИБ")-26);
            String xufton = s.substring(s.indexOf("ИША")-31,s.indexOf("ИША")-26);

            LocalDate localDate = LocalDate.now();

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(update.getMessage().getChatId().toString());
            sendMessage.setText("Beruniy Tumani \uD83D\uDD4C\n\n"+"📆 "+localDate+"\n\n"+"\uD83C\uDFD9 Bomdod:  "+bomdod+"\n"+"\uD83C\uDF05 Quyosh:  "+quyosh+"\n"+"\uD83C\uDF07 Peshin:  "+peshin+"\n"+"\uD83C\uDF06 Asr:  "+asr+"\n"+"\uD83C\uDF04 Shom:  "+shom+"\n"+"\uD83C\uDF09 Xufton:  "+xufton+"\n");
            return sendMessage;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SendMessage();
    }

    @Override
    public Types type() {
        return Types.BUGUNGI;
    }
}
