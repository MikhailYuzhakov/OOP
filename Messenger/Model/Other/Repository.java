package Model.Other;

import java.util.ArrayList;

public interface Repository {
    /**
     * "Генерирует" ID для пользователя, пишет в массив и возвращает его
     */
    public Integer getId();
}

class RepoUsr implements Repository {
    private Integer usrId = 0;
    ArrayList<Integer> listUsrId = new ArrayList<>();

    @Override
    public Integer getId() {
        listUsrId.add(++usrId);
        return listUsrId.get(-1);
    }
}

class RepoChat implements Repository {
    private Integer chatId = 0;
    ArrayList<Integer> listChatId = new ArrayList<>();

    @Override
    public Integer getId() {
        listChatId.add(++chatId);
        return listChatId.get(-1);
    }
}

class RepoMsg implements Repository {
    private Integer msgId = 0;
    ArrayList<Integer> listMsgId = new ArrayList<>();

    @Override
    public Integer getId() {
        listMsgId.add(++msgId);
        return listMsgId.get(-1);
    }
}
