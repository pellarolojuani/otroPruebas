package com.vaadin;

import java.awt.Font;
import java.util.Spliterator;
import java.util.function.Consumer;

import javax.servlet.annotation.WebServlet;
import javax.swing.JLabel;

import sun.font.TextLabel;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Field.ValueChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.themes.Reindeer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


@SuppressWarnings("serial")
public class LoginFields extends UI{
	
	TextField userTextField;
	PasswordField passwordTextField;
	VerticalLayout layout;

	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = LoginFields.class)
	public static class Servlet extends VaadinServlet {
	}
	
	@Override
	protected void init(VaadinRequest request) {
		this.layout = new VerticalLayout();
		//layout.setMargin(true);
		this.setSizeFull();
		setContent(layout);
		
		TextArea comentarios = new TextArea("Comentarios:");
				
		Label textLabel1 = new Label("Inicio sesion");
		layout.addComponent(textLabel1);
	
		//Campo para ingresar el usuario
		userTextField = new TextField();
		userTextField.setImmediate(true);
		userTextField.setInputPrompt("Nombre");
		userTextField.setWidth("300px");
        //updateUserTextFieldCaption(0);
        
        TextField apellidoField = new TextField();
        apellidoField.setImmediate(true);
        apellidoField.setInputPrompt("Apellido");
        //updateUserTextFieldCaption(0);
        
        TextField userNameField = new TextField();
        userNameField.setImmediate(true);
        userNameField.setInputPrompt("User Name");
        //updateUserTextFieldCaption(0);
        
        //Campo para ingresar la contrasenia
        passwordTextField = new PasswordField();
        passwordTextField.setImmediate(true);
        passwordTextField.setMaxLength(10);
        //updatePasswordFieldCaption(0);
        
        //Campo para repetir la contrasenia
        PasswordField passwordRepeatField = new PasswordField();
        passwordRepeatField = new PasswordField();
        passwordRepeatField.setImmediate(true);
        passwordRepeatField.setMaxLength(10);
        //updatePasswordFieldCaption(0);
        
        Label passwordLabel = new Label("Password:");
        Label repeatPasswordLabel = new Label("Repeat password:");
        
        Button submitButton = new Button("Submit");
        submitButton.addClickListener(new Button.ClickListener() {
			
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				layout.addComponent(new Label("En etapa de construcción..."));
				
			}
		});
                
        layout.addComponent(userTextField);
        layout.addComponent(apellidoField);
        layout.addComponent(userNameField);
        layout.addComponent(passwordLabel);
        layout.addComponent(passwordTextField);
        layout.addComponent(repeatPasswordLabel);
        layout.addComponent(passwordRepeatField);
        layout.addComponent(comentarios);
        layout.addComponent(submitButton);
        
        layout.setSpacing(true);
        
        layout.setMargin(new MarginInfo(true, true, true, false));
		layout.setSizeUndefined();
		layout.setComponentAlignment(submitButton, Alignment.MIDDLE_CENTER);
        
		// The view root layout
		//VerticalLayout viewLayout = new VerticalLayout(layout);
		//viewLayout.setSizeFull();
		///viewLayout.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
		//viewLayout.setStyleName(Reindeer.LAYOUT_BLUE);
		//setCompositionRoot(viewLayout);
		

        userTextField.addTextChangeListener(new TextChangeListener() {
            @Override
            public void textChange(final TextChangeEvent event) {
                updateUserTextFieldCaption(event.getText().length());
            }
        });
  
     }
	
	public VerticalLayout getLayout() {
		return layout;
	}

	public void setLayout(VerticalLayout layout) {
		this.layout = layout;
	}

	//Updates the sample caption
    private void updatePasswordFieldCaption(final int textLength) {
        final StringBuilder builder = new StringBuilder();
        builder.append(textLength);
        if (passwordTextField.getMaxLength() >= 0) {
            builder.append("/").append(passwordTextField.getMaxLength());
        }
        builder.append(" characters");
        passwordTextField.setCaption(builder.toString());
        
        passwordTextField.addValueChangeListener(new ValueChangeListener() {
            public void valueChange(final ValueChangeEvent event) {
                final String valueString = String.valueOf(event.getProperty()
                        .getValue());
                Notification.show("Value changed:", valueString,
                        Type.TRAY_NOTIFICATION);
            }

			@Override
			public void valueChange(
					com.vaadin.data.Property.ValueChangeEvent event) {
				// TODO Auto-generated method stub
				
			}
        });
    }

	//Updates the userTextField caption
    private void updateUserTextFieldCaption(final int textLength) {
        final StringBuilder builder = new StringBuilder();
        builder.append(String.valueOf(textLength));
        if (userTextField.getMaxLength() >= 0) {
            builder.append("/").append(userTextField.getMaxLength());
        }
        builder.append(" characters");
        userTextField.setCaption(builder.toString());
        
        userTextField.addValueChangeListener(new ValueChangeListener() {
            public void valueChange(final ValueChangeEvent event) {
                final String valueString = String.valueOf(event.getProperty()
                        .getValue());
                Notification.show("Value changed:", valueString,
                        Type.TRAY_NOTIFICATION);
            }

			@Override
			public void valueChange(
					com.vaadin.data.Property.ValueChangeEvent event) {
				// TODO Auto-generated method stub
				
			}
        });
    }
		
}
