
import Service.Base;
import Service.Types;
import UTIL.Util;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.Optional;

public class Mybot extends TelegramLongPollingBot {
    private final List<Base> base;
    public Mybot(List<Base> baseInterfaces) {
        this.base = baseInterfaces;
    }

    public Mybot(List<Base> baseInterfaces, List<Base> base) {
        this.base = base;
    }

    @Override
    public String getBotUsername() {
        return "@BeruniyNamozvaqtlari_bot";
    }

    @Override
    public String getBotToken() {
        return "5574662353:AAE6S6v-Xfpui2lZNl4PkYWndR7RKYzlrWw";
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        if (update.hasMessage()){
            if (update.getMessage().hasText()){
                if (update.getMessage().getText().equals("/start")){
                    sendMessage = Util.send(update);

                    try {

                        execute(sendMessage);
                        sendMessage.setChatId("1336442168");
                        sendMessage.setText("@"+update.getMessage().getFrom().getUserName() + "\n" +update.getMessage().getFrom().getFirstName());
                        execute(sendMessage);

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        if(update.getMessage().getText().equals("\uD83D\uDCFF⏳ Bugungi namoz vaqtlari")) {
            Optional<Base> any = base.stream().filter(t -> t.type().equals(Types.BUGUNGI)).findAny();
            Base baseInterface = any.get();
            sendMessage = baseInterface.onUpdateReceived(update);
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }




    }
}
