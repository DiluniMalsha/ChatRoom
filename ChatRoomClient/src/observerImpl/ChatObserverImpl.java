/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import observer.ChatObserver;
import view.ChatBox;

/**
 *
 * @author HP
 */
public class ChatObserverImpl extends UnicastRemoteObject implements ChatObserver{

    private ChatBox chatBox;

    public ChatObserverImpl(ChatBox chatBox) throws RemoteException{        
        this.chatBox=chatBox;       
    }
           
    @Override
    public void update(String chat) throws RemoteException {
        chatBox.sendChat(chat);
    }
    
    
    
}
