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
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialDialog;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialTextBox;

public class disp extends Composite implements HasText {

	private static dispUiBinder uiBinder = GWT.create(dispUiBinder.class);

	interface dispUiBinder extends UiBinder<Widget, disp> {
	}

	public disp() {
		initWidget(uiBinder.createAndBindUi(this));
		GreetingServiceAsync a1=GWT.create(GreetingService.class);
		back.setText("Back");
		ml1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				MaterialDialog md =new MaterialDialog();
				MaterialTextBox mt1=new MaterialTextBox();
				MaterialTextBox mt2=new MaterialTextBox();
				MaterialTextBox mt3 = new MaterialTextBox();
				MaterialButton b1 =new MaterialButton("submit");
				mt1.setLabel("clinic name");
				mt2.setLabel("clinic pass");
				mt3.setLabel("phone");
				md.add(mt1);
				md.add(mt2);
				md.add(mt3);
				md.add(b1);
				
				b1.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub
						String s1=mt1.getText();
						String s2=mt2.getText();
						String s3=mt3.getText();
						a1.regclinic(s1, s2, s3, "1", new AsyncCallback<Integer>() {
							
							@Override
							public void onSuccess(Integer result) {
								// TODO Auto-generated method stub
								Window.alert(result.toString());
							}
							
							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								
							}
						});
						
					}
				});
				RootPanel.get().add(md);
				md.open();
				
			}
		});
		
ml2.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				MaterialDialog md =new MaterialDialog();
				MaterialTextBox mt1=new MaterialTextBox();
				MaterialTextBox mt2=new MaterialTextBox();
				MaterialTextBox mt3 = new MaterialTextBox();
				MaterialButton b1 =new MaterialButton("submit");
				mt1.setLabel("clinic name");
				mt2.setLabel("clinic pass");
				mt3.setLabel("phone");
				md.add(mt1);
				md.add(mt2);
				md.add(mt3);
				md.add(b1);
				b1.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub
						String s1=mt1.getText();
						String s2=mt2.getText();
						String s3=mt3.getText();
						a1.regclinic(s1, s2, s3, "6", new AsyncCallback<Integer>() {
							
							@Override
							public void onSuccess(Integer result) {
								// TODO Auto-generated method stub
								Window.alert(result.toString());
							}
							
							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								
							}
						});
						
					}
				});
				RootPanel.get().add(md);
				md.open();
				
			}
		});
ml3.addClickHandler(new ClickHandler() {
	
	@Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub
		MaterialDialog md =new MaterialDialog();
		MaterialTextBox mt1=new MaterialTextBox();
		MaterialTextBox mt2=new MaterialTextBox();
		MaterialTextBox mt3 = new MaterialTextBox();
		MaterialButton b1 =new MaterialButton("submit");
		mt1.setLabel("clinic name");
		mt2.setLabel("clinic pass");
		mt3.setLabel("phone");
		md.add(mt1);
		md.add(mt2);
		md.add(mt3);
		md.add(b1);
		b1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				String s1=mt1.getText();
				String s2=mt2.getText();
				String s3=mt3.getText();
				a1.regclinic(s1, s2, s3, "12", new AsyncCallback<Integer>() {
					
					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						Window.alert(result.toString());
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}
				});
				
			}
		});
		RootPanel.get().add(md);
		md.open();
		
	}
});

back.addClickHandler(new ClickHandler() {
	
	@Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub
		RootPanel.get("navbar").clear();
		RootPanel.get("body").clear();
		Logout lout=new Logout();
		RootPanel.get().add(lout);
	}
});

	}
	
	@UiField
	MaterialPanel p1;
	@UiField
	MaterialLink ml1;
	@UiField
	MaterialLink ml2;
	@UiField
	MaterialLink ml3;
	@UiField
	MaterialButton back;
	

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		
	}

	

	
}
