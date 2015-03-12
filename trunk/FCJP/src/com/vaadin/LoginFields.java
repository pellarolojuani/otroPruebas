package com.vaadin;

import java.util.Spliterator;
import java.util.function.Consumer;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field.ValueChangeEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class LoginFields extends UI{
	
	TextField userTextField;
	PasswordField passwordTextField;

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		//Campo para ingresar el usuario
		userTextField = new TextField();
		userTextField.setImmediate(true);
		userTextField.setInputPrompt("Usuario");
		userTextField.setMaxLength(10);
        updateUserTextFieldCaption(0);
        
        //Campo para ingresar la contrasenia
        passwordTextField = new PasswordField();
        passwordTextField.setImmediate(true);
        passwordTextField.setMaxLength(10);
        updatePasswordFieldCaption(0);
 
        
        layout.addComponent(userTextField);
        layout.addComponent(passwordTextField);
        
        userTextField.addTextChangeListener(new TextChangeListener() {
            @Override
            public void textChange(final TextChangeEvent event) {
                updateUserTextFieldCaption(event.getText().length());
            }
        });
  
     }
	
	/*Updates the sample caption*/
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
