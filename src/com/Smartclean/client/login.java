package com.Smartclean.client;

import com.Smartclean.client.GreetingService;
import com.Smartclean.client.GreetingServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Float;
//import com.google.gwt.dev.protobuf.DescriptorProtos.FieldDescriptorProto.Label;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialNavBrand;
import gwt.material.design.client.ui.MaterialNavSection;
import gwt.material.design.client.ui.MaterialTextBox;

public class login extends Composite implements HasText {

	private static loginUiBinder uiBinder = GWT.create(loginUiBinder.class);

	/*
	 * @UiTemplate is not mandatory but allows multiple XML templates to be used for
	 * the same widget. Default file loaded will be <class-name>.ui.xml
	 */
	@UiTemplate("login.ui.xml")

	interface loginUiBinder extends UiBinder<Widget, login> {
	}

	public login() {
		initWidget(uiBinder.createAndBindUi(this));
		ml.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Window.alert("register");
			}
		});
	}

	@UiField
	MaterialButton button;

	@UiField
	MaterialTextBox t1;

	@UiField
	MaterialTextBox t2;
	
	@UiField
	MaterialLink ml;


	public login(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		t1.setText(firstName);
	}

	GreetingServiceAsync a1 = GWT.create(GreetingService.class);

	@UiHandler("button")
	void onClick(ClickEvent e) {
		// TODO Auto-generated method stub
		String s1 = t1.getText();
		String s2 = t2.getText();
		a1.check(s1, s2, new AsyncCallback<String[]>() {
			// TODO Auto-generated method stub
			@Override
			public void onSuccess(String result[]) {
				if(result[0].equals("Doctor")) {
					RootPanel.get("navbar").clear();
					RootPanel.get("body").clear();
					RootPanel.get("grd").clear();
					Doctscreen dosc=new Doctscreen(result[1]);
					
//					MaterialNavBar mnb=new MaterialNavBar();
//					MaterialNavBrand mnbr =new MaterialNavBrand("Doc Assisto");
//					mnbr.setFloat(Float.LEFT);
//					MaterialNavSection mns=new MaterialNavSection();
//					mns.setFloat(Float.RIGHT);
//					MaterialLink ml1=new MaterialLink("Logout");
//					ml1.setFontSize("20px");
//					mnbr.setMarginLeft(20);
//					mns.add(ml1);
//					ml1.setIconType(IconType.ALL_OUT);
//					ml1.setFloat(Float.RIGHT);
//					mnb.add(mnbr);
//					mnb.add(mns);
					
					RootPanel.get("body").add(dosc);
					//RootPanel.get("navbar").add(mnb);
				}
				if(result[0].equals("Compounder")) {
					RootPanel.get("navbar").clear();
					RootPanel.get("body").clear();
					RootPanel.get("grd").clear();
					createappoint cap=new createappoint(result[1]);
					RootPanel.get("body").add(cap);
				}

			}

			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});

	}

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
