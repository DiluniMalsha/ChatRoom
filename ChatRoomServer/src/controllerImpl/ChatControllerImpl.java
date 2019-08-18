/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerImpl;

import controller.ChatController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import observable.ChatObservable;
import observer.ChatObserver;

/**
 *
 * @author HP
 */
public class ChatControllerImpl extends UnicastRemoteObject implements ChatController{          
    
    private ChatObservable chatObservable=new ChatObservable();
        
    public ChatControllerImpl() throws RemoteException {
    }
        
    
    @Override
    public void updateChat(String chat) throws RemoteException {
        chatObservable.setChat(chat);
    }

    @Override
    public void addChatObserver(ChatObserver chatObserver) throws RemoteException {
        chatObservable.addChatObserver(chatObserver);
    }

    @Override
    public void removeChatObserver(ChatObserver chatObserver) throws RemoteException {
        chatObservable.removeChatObserver(chatObserver);
    }
    
}
