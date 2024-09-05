package Sigesp.model;

import java.util.HashMap;
import java.Util.ArrayList;
import Sigesp.view.*;
import Sigesp.controller.*;

public class Model{
  private HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();
  private Usuario usuarioAutt;
  private ArrayList<Observer> observers = new ArrayList<Observer>();

  public void notify(){
    for (Observer ob : observers){
    ob.update();
    }
  }
  public void addObserver(Observer observer){
    if(observer != null){
      observers.add(observer);
    }
  }
  public void rmvObserver(Observer observer){
    if(observer != null){
      observers.remove(observer)
    }
  }
  public int getTotUsuarios() {
		return usuarios.size();
	}

  
}
