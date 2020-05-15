package com.Smartclean.client;


import java.util.Date;

import com.Docassisto.client.GreetingService;
import com.Docassisto.client.GreetingServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DomEvent.Type;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;
//import com.sun.prism.paint.Color;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.FontWeight;

import gwt.material.design.client.constants.*;
import gwt.material.design.client.ui.*;


public class Doctscreen extends Composite {

	private static DoctscreenUiBinder uiBinder = GWT.create(DoctscreenUiBinder.class);

	interface DoctscreenUiBinder extends UiBinder<Widget, Doctscreen> {
	}
	
	 @UiField
	 MaterialLabel l1;
	 @UiField
	 MaterialButton bd;
	 @UiField
	 MaterialDatePicker db;
	 @UiField
	 MaterialLabel l2;
	// @UiField
	 //Label l3;
	 @UiField
	 Label tl;
//	 @UiField
//	 MaterialCollection vp;
//	 @UiField
//	 HorizontalPanel hp;
//	 @UiField
//	 DialogBox dibo;
	 @UiField
	 MaterialCollapsible maco;
//	 @UiField
//	 MaterialListBox mlb;

	 String temp="";
	 Button close = new Button("close");
	 VerticalPanel pdvp=new VerticalPanel();
	 private GreetingServiceAsync a=GWT.create(GreetingService.class);
	 int totalp=0;
    int totalf=0;
    String cname="";
    public Doctscreen(String s) {
    	this();
    	cname=s;
    }
	public Doctscreen(){
		initWidget(uiBinder.createAndBindUi(this));
		
		MaterialNavBar mnb=new MaterialNavBar();
		//MaterialNavBrand mnbr =new MaterialNavBrand("Doc Assisto");
		//mnbr.setFloat(Float.LEFT);
		MaterialLabel mla=new MaterialLabel("Check appointments");
		mla.setFloat(Float.LEFT);
		//MaterialNavSection mns=new MaterialNavSection();
		//mns.setFloat(Float.RIGHT);
		MaterialLink ml1=new MaterialLink("Logout");
		ml1.setFontSize("20px");
		//mnbr.setMarginLeft(20);
		mla.setFontSize("20px");
		mnb.add(ml1);
		mnb.add(mla);
		ml1.setIconType(IconType.ALL_OUT);
		ml1.setFloat(Float.RIGHT);
		//mnb.add(mnbr);
		//mnb.add(mns);
		RootPanel.get("navbar").add(mnb);
		
		maco.setWidth("70%");
		maco.setType(CollapsibleType.POPOUT);
		db.setPlaceholder("Select Date");
		//dibo.setVisible(false);
		//dibo.setHeight("100px");
		//dibo.setWidth("300px");
		 bd.setText("submit");
		   //vp.setBorderWidth(2);
			l2.setText("Appointments");
			db.setWidth("200px");
		
            db.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					db.open();
			       
				}
			});
            db.addMouseUpHandler(new MouseUpHandler() {
				
				@Override
				public void onMouseUp(MouseUpEvent event) {
					// TODO Auto-generated method stub
					db.close();
				}
			});
            
            ml1.addClickHandler(new ClickHandler() {
				
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
	

	
	@UiHandler("bd")
    void onClick(ClickEvent event) {
		//totalp=0;
		Date tstdt=db.getValue();
		String tst1=tstdt.toString();
		final String tst=tst1.substring(0, 10);
		
       a.getappointtd(tst,cname, new AsyncCallback<String[][]>() {
		
		@Override
		public void onSuccess(String[][] result) {
			maco.clear();
			totalp=0;
			for(int i=1;i<=result.length;i++) {
				if(result[i-1][1].length()>0){
					totalp++;
					if(i==1) {

					}
					MaterialCollapsibleItem mci=new MaterialCollapsibleItem();
					MaterialCollapsibleHeader mch =new MaterialCollapsibleHeader();
					MaterialCollapsibleBody mcb=new MaterialCollapsibleBody();
					MaterialLabel appno=new MaterialLabel(result[i-1][1]);
					MaterialLabel appname=new MaterialLabel(result[i-1][2]);
					appno.setFontSize("20px");
					appname.setFontSize("20px");
					//appname.setFontWeight(FontWeight.BOLD);
					MaterialIcon appicon=new MaterialIcon(IconType.ERROR);
					
					mcb.setBackgroundColor(Color.GREY_LIGHTEN_3);
					appicon.setTextColor(Color.RED);
					appno.setFloat(Float.LEFT);
					appname.setFloat(Float.LEFT);
					appicon.setFloat(Float.RIGHT);
					appname.setMarginLeft(maco.getWidth()/2-maco.getAbsoluteLeft()-100);
					
					mch.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							mcb.clear();
							// TODO Auto-generated method stub
							a.getpatient(Integer.parseInt(appno.getText()), tst,new AsyncCallback<String[]>() {
								
								@Override
								public void onSuccess(String[] result) {
									// TODO Auto-generated method stub
									for(int i=0;i<11;i++) {
										MaterialLabel bodylb=new MaterialLabel((result[i].toUpperCase()));
										bodylb.setFontSize("20px");
										mcb.add(bodylb);
									}
									MaterialButton checkedb =new MaterialButton("Checked");
									mcb.add(checkedb);
									checkedb.addClickHandler(new ClickHandler() {
										
										@Override
										public void onClick(ClickEvent event) {
											// TODO Auto-generated method stub
											appicon.clear();
											appicon.setIconType(IconType.CHECK);
											appicon.setTextColor(Color.GREEN);
											mci.setActive(false);
										}
									});
									
								}
								
								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									
								}
							});
							
						}
					});
					
					mch.add(appno);
					mch.add(appname);
					mch.add(appicon);
					mci.add(mch);
					mci.add(mcb);
					maco.add(mci);
					
					
					
	}
				else {
					//tl.setText("Total Patient - "+Integer.toString(totalp));
					
					break;}
				}
			
			//tl.setVisible(true);
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}
	});
		
       
        a.gettfee(tst,cname,new AsyncCallback<Integer>() {
			@Override
			public void onSuccess(Integer result) {
				tl.setText("Total Patient - "+Integer.toString(totalp)+" Total Fees - "+Integer.toString(result));
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		l1.setText("Date - "+tst);
		//l3.setText(temp);
	}
	
	}
