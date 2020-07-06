package org.example.pattern.observer;

import java.util.ArrayList;

public class Child {

	public void hungry(){
		System.out.println("call Child hungry");
		
		notifyHungry();
	}
	
	private void notifyHungry() {

		for(OnChildListener c:mLitenerList){
			c.hungry();
		}
		
	}

	public void satiate(){
		System.out.println("call Child satiate");
	
		notifySatiate();
	}
	
	private void notifySatiate() {
		for(OnChildListener c:mLitenerList){
			c.fulled("notifySatiate");
		}		
	}

	public void sleepy(){
		System.out.println("call child sleepy");
		
		notifySleepy();
	}
	
	private void notifySleepy() {
		for(OnChildListener c:mLitenerList){
			c.sleepy(404);
		}
	}

	ArrayList<OnChildListener> mLitenerList = new ArrayList<OnChildListener>();
	
	public void addOnChildListener(OnChildListener listener){
		
		if(listener != null && !mLitenerList.contains(listener)){
			mLitenerList.add(listener);
		}
	}
	
	public void removeChildListener(OnChildListener listener){
		
		if(listener != null && mLitenerList.contains(listener)){
			mLitenerList.remove(listener);
		}
	}
	
}
