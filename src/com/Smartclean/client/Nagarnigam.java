package com.Smartclean.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.addins.client.fileuploader.MaterialFileUploader;
import gwt.material.design.addins.client.fileuploader.MaterialUploadPreview;
import gwt.material.design.addins.client.fileuploader.base.UploadFile;
import gwt.material.design.addins.client.fileuploader.events.AddedFileEvent;
import gwt.material.design.addins.client.fileuploader.events.AddedFileEvent.AddedFileHandler;
import gwt.material.design.client.events.DragOverEvent;
import gwt.material.design.client.events.DropEvent;
import gwt.material.design.client.events.DropEvent.DropHandler;

public class sevex extends Composite {

	private static sevexUiBinder uiBinder = GWT.create(sevexUiBinder.class);

	interface sevexUiBinder extends UiBinder<Widget, sevex> {
	}

    @UiField
    FormPanel fp;
    @UiField
    FileUpload fu;
    @UiField
    Button s;
    
	public sevex() {
		initWidget(uiBinder.createAndBindUi(this));
		//FileUpload fu = new FileUpload();	
		fu.setName("file");
		//fp.add(fu);
		//fp.add(s);
		Label l1=new Label(GWT.getModuleBaseURL());
		
		//System.out.println(GWT.getModuleBaseURL());
	//	RootPanel.get().add(fp);
	//	RootPanel.get().add(s);
	//	RootPanel.get().add(l1);
		fp.setMethod("post");
		fp.setEncoding("multipart/form-data");
		fp.setAction(GWT.getModuleBaseURL()+"upload");
		//RootPanel.get().add(new Label(Boolean.toString(fp.onFormSubmit())));
		s.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				 
				// System.out.println(GWT.getModuleBaseURL());
				 fp.submit();
				//RootPanel.get().add(new Label(Boolean.toString(fp.onFormSubmit())));
			}
		});
		
	//	RootPanel.get().add(fp);
		
		
	
	}
	
	

	

	public sevex(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		
	}

	

	
}
