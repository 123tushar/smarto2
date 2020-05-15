package com.Smartclean.client;

import java.sql.SQLException;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

public class Register extends Composite {

	private static RegisterUiBinder uiBinder = GWT.create(RegisterUiBinder.class);

	interface RegisterUiBinder extends UiBinder<Widget, Register> {
	}
    @UiField
    MaterialButton b1;
    @UiField
    MaterialTextBox t1;
    @UiField
    MaterialTextBox t2;
    @UiField
    MaterialTextBox t3;
    @UiField
    MaterialTextBox t4;
    @UiField
    MaterialTextBox t5;
    @UiField
    MaterialTextBox t6;
    @UiField
    MaterialTextBox t7;
    
	public Register() {
		initWidget(uiBinder.createAndBindUi(this));
		GreetingServiceAsync a1=GWT.create(GreetingService.class);
		b1.setText("Register");
		b1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				String s1=t1.getText();
				String s7=t7.getText();
				int v=0;
				a1.validclinic(s1, s7, new AsyncCallback<Integer>() {
					
					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						if(result==0) {
							Window.alert("clinic not registered");
						}
						else {
							String s2=t2.getText();
							String s3=t3.getText();
							String s4=t4.getText();
							String s5=t5.getText();
							String s6=t6.getText();
							a1.insertdc(s1,s2,s3,s4,s5,s6,new AsyncCallback<String>() {

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									Window.alert((caught.getMessage()));
									
								}

								@Override
								public void onSuccess(String result) {
									// TODO Auto-generated method stub
									Window.alert(result);
									
								}
							
						});
						}
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}
				});
				
			}
		});
	}

}
