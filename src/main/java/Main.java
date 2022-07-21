
import Service.Base;
import Service.Bugungi;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Base> baseInterfaces = new ArrayList<>(10);
    public static void main(String[] args){
        baseInterfaces.add(new Bugungi());
//        baseInterfaces.add(new Ertangi());
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new Mybot(baseInterfaces));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
