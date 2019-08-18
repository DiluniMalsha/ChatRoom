/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observable;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import observer.ChatObserver;

/**
 *
 * @author HP
 */
public class ChatObservable {

    private String chat="";
    private ArrayList<ChatObserver> observerList = new ArrayList<>();

    public void addChatObserver(ChatObserver observer) {
        observerList.add(observer);
    }

    public void removeChatObserver(ChatObserver observer) {
        observerList.remove(observer);
    }

    public void notifyObservers() throws RemoteException {
        for (ChatObserver chatObserver : observerList) {
            chatObserver.update(chat);
        }
    }

    public void setChat(String chat) {
        try {
            if (!this.chat.equals(chat)) {
                this.chat = chat;
            }
            notifyObservers();
        } catch (RemoteException ex) {
            Logger.getLogger(ChatObservable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
