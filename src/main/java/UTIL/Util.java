package UTIL;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.LinkedList;
import java.util.List;

public class Util {

    public  static SendMessage send(Update update){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.setText("Assolomu aleykum✋" +" "+ update.getMessage().getFrom().getFirstName()+"\n"+"Bizning botimizga hush kelibsiz\uD83E\uDD1D\n"+"");

        sendMessage.enableMarkdown(true);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboardRows = new LinkedList<>();

        KeyboardRow firstRow = new KeyboardRow();

        firstRow.add("\uD83D\uDCFF⏳ Bugungi namoz vaqtlari");




        keyboardRows.add(firstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        return sendMessage;

    }
}
