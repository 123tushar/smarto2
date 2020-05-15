package com.Smartclean.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.Smartclean.shared.*;

import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialDatePicker;
import gwt.material.design.client.ui.MaterialDialog;
import gwt.material.design.client.ui.MaterialIntegerBox;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialListBox;
import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialNavBrand;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;

public class CitizenDashboard extends Composite {

	private static createappointUiBinder uiBinder = GWT.create(createappointUiBinder.class);
	GreetingServiceAsync a1=GWT.create(GreetingService.class);

	interface createappointUiBinder extends UiBinder<Widget, createappoint> {
	}
	String cname="";
    public createappoint(String s) {
    	this();
    	cname=s;
    	
    }
	public createappoint() {
		initWidget(uiBinder.createAndBindUi(this));
		//camnbr.setMarginLeft(20);
		lout.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				RootPanel.get("navbar").clear();
				RootPanel.get("body").clear();
				Logout lgout=new Logout();
				RootPanel.get().add(lgout);
				
			}
		});
		send.addClickHandler(new ClickHandler(
				) {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				MaterialDialog mdsend= new MaterialDialog();
				mdsend.setTextAlign(TextAlign.CENTER);
				mdsend.setSize("500px","500px");
				sevex sv=new sevex();
				mdsend.add(sv);
				RootPanel.get().add(mdsend);
				mdsend.open();
			}
		});
	
	}
	@UiField
	MaterialNavBar navBar;
	
	
	@UiField
	MaterialPanel m1;
	
	
	@UiField
	MaterialDatePicker t1;
	
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
	
	@UiField
	MaterialTextBox t8;
	
	@UiField
	MaterialTextBox t9;
	
	@UiField
	MaterialTextBox t10;
	
	@UiField
	MaterialLink lout;
	
	@UiField
	MaterialTextArea t11;
	@UiField
	MaterialButton button;
	@UiField
	MaterialLink send;
	//@UiField
	//MaterialNavBrand camnbr;
		
	
	@UiHandler("button")
	void onClick1(ClickEvent e) {
		String s1=t1.getDate().toString().substring(0,10);
		String s2=t2.getText();
		String s3=t3.getText();
		String s4=t4.getText();
		String s5=t5.getText();
		String s6=t6.getText();
		String s7=t7.getText();
		String s8=t8.getText();
		String s9=t9.getText();
		String s10=t10.getText();
		String s11=t11.getText();
		a1.insert(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,cname,new AsyncCallback<String>() {

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
