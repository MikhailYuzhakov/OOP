package Model.Builders;

import Model.Chats.Chat;
import Model.Users.User;

/**
 * Интерфейс Builder для создания различных частов (групповой, личный, канал)
 */
public interface ChatBuilder {
    /**
     * Уникальный идентификатор чата
     * id < 0 - каналы и групповые чаты
     * id > 0 - личный чаты
     * 
     * @return
     */
    public ChatBuilder setId();

    /**
     * Установить имя чата
     * 
     * @return
     */
    public ChatBuilder setName(String name);

    /**
     * Описывает права доступа пользователей в чате
     * Канал - доступ на чтение, возможность комментировать
     * Личный - чтение и отправка, отсутствие комментариев
     * Групповой - чтение и отправка, возможность комментировать
     */
    public ChatBuilder accessMode(Boolean read, Boolean write, Boolean comment);

    /**
     * Создает конкретный чат
     * 
     * @return
     */
    public Chat createChat();
}
