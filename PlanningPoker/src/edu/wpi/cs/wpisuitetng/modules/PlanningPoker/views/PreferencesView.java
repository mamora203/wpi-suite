/*******************************************************************************
 * Copyright (c) 2012-2014 -- WPI Suite
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributor: team struct-by-lightning
 *******************************************************************************/
package edu.wpi.cs.wpisuitetng.modules.PlanningPoker.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.wpi.cs.wpisuitetng.janeway.config.ConfigManager;
import edu.wpi.cs.wpisuitetng.modules.PlanningPoker.controller.AddPlanningPokerVoteController;
import edu.wpi.cs.wpisuitetng.modules.PlanningPoker.controller.GetPlanningPokerGamesController;
import edu.wpi.cs.wpisuitetng.modules.PlanningPoker.controller.GetPlanningPokerUserController;
import edu.wpi.cs.wpisuitetng.modules.PlanningPoker.controller.UpdatePlanningPokerUserController;
import edu.wpi.cs.wpisuitetng.modules.PlanningPoker.models.PlanningPokerUser;
import edu.wpi.cs.wpisuitetng.modules.PlanningPoker.models.PlanningPokerUserModel;

/**
 * @author sfmailand
 * 
 */
public class PreferencesView extends JPanel {

	PlanningPokerUser currentUser;

	public static void openNewTab() {
		final PreferencesView view = new PreferencesView();
		MainView.getInstance().addCloseableTab("Preferences", view);
	}

	/**
	 * Creates new form PreferencesWindow
	 */
	public PreferencesView() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		textPanel = new javax.swing.JPanel();
		emailPanel = new javax.swing.JPanel();
		emailField = new javax.swing.JTextField();
		aimPanel = new javax.swing.JPanel();
		aimField = new javax.swing.JTextField();
		notificationPanel = new javax.swing.JPanel();
		sendEmail = new javax.swing.JCheckBox();
		sendAIM = new javax.swing.JCheckBox();
		updateUser = new javax.swing.JButton();
		errorMessage = new javax.swing.JLabel();
		infoLabel = new JLabel();
		errorMessage.setForeground(Color.RED);

		fillAllFields();

		sendEmail.setText("Email");
		sendEmail.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sendEmailActionPerformed(evt);
			}
		});

		sendAIM.setText("AIM");
		sendAIM.setActionCommand("");
		sendAIM.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sendAIMActionPerformed(evt);
			}
		});

		emailField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				emailFieldKeyTyped(evt);
			}
		});

		aimField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				aimFieldKeyTyped(evt);
			}
		});

		updateUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				updateUserPressed(evt);
			}
		});

		updateUser.setText("Save Changes");

		emailPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						0, 0, 0)), "Email"));

		final javax.swing.GroupLayout emailPanelLayout = new javax.swing.GroupLayout(
				emailPanel);
		emailPanel.setLayout(emailPanelLayout);
		emailPanelLayout
				.setHorizontalGroup(emailPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								emailPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												emailField,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												264,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(sendEmail)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		emailPanelLayout
				.setVerticalGroup(emailPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								emailPanelLayout
										.createSequentialGroup()
										.addGroup(
												emailPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																emailField)
														.addComponent(
																sendEmail,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addGap(0, 6, Short.MAX_VALUE)));

		aimPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						0, 0, 0)), "Instant Message"));

		sendAIM.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sendAIMActionPerformed(evt);
			}
		});

		final javax.swing.GroupLayout aimPanelLayout = new javax.swing.GroupLayout(
				aimPanel);
		aimPanel.setLayout(aimPanelLayout);
		aimPanelLayout
				.setHorizontalGroup(aimPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								aimPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												aimField,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												264,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(sendAIM)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		aimPanelLayout
				.setVerticalGroup(aimPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								aimPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												aimPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																sendAIM,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																aimPanelLayout
																		.createSequentialGroup()
																		.addGap(0,
																				0,
																				Short.MAX_VALUE)
																		.addComponent(
																				aimField,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));

		updateUser.setText("Update");

		infoLabel
				.setText("<html>Please check the method you'd like <br> to use for recieving notifications.</html>");

		final javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addComponent(
														emailPanel,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														aimPanel,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(updateUser)
												.addComponent(
														errorMessage,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														280,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														infoLabel,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														234,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(310, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING,
												false)
												.addComponent(infoLabel)
												.addComponent(
														emailPanel,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														aimPanel,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		errorMessage,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		43,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		updateUser)))
								.addContainerGap(511, Short.MAX_VALUE)));
	}// </editor-fold>

	/**
	 * Description
	 * 
	 * @param evt
	 */
	protected void emailFieldKeyTyped(KeyEvent evt) {
		checkAllFields();
	}

	protected void smsFieldKeyTyped(KeyEvent evt) {
		checkAllFields();
	}

	protected void aimFieldKeyTyped(KeyEvent evt) {
		checkAllFields();
	}

	private void sendEmailActionPerformed(ActionEvent evt) {
		checkAllFields();
	}

	private void sendAIMActionPerformed(ActionEvent evt) {
		checkAllFields();
	}

	private void updateUserPressed(ActionEvent evt) {
		if (isValidEmail()) {
			currentUser.setEmail(emailField.getText());
		}

		final String aimText = aimField.getText();
		final boolean validAim = (aimText.length() > 0)
				&& !(aimText.contains(" "));

		if (validAim) {
			currentUser.setInstantMessage(aimText);
		}

		currentUser.setSendAim(sendAIM.isSelected());
		currentUser.setSendEmail(sendEmail.isSelected());
		UpdatePlanningPokerUserController.getInstance().update(currentUser);
		updateUser.setText("Saved!");
		updateUser.setEnabled(false);
	}

	private void checkAllFields() {

		updateUser.setText("Save Changes");
		updateUser.setEnabled(true);
		boolean emailEntered = isValidEmail();
		boolean aimEntered = !(aimField.getText().length() == 0)
				&& !aimField.getText().contains(" ");
		boolean oneOptionSelected = sendEmail.isSelected()
				|| sendAIM.isSelected();

		boolean aimChecked = true;
		boolean emailChecked = true;

		if (!aimEntered && sendAIM.isSelected()) {
			errorMessage.setText("AIM checked, but no account entered");
			aimChecked = false;
		}

		if (!emailEntered && sendEmail.isSelected()) {
			errorMessage.setText("Emailed checked, but no valid email entered");
			emailChecked = false;
		}
		if (!oneOptionSelected) {
			errorMessage.setText("Must have one option checked");
		}

		final boolean canUpdate = aimChecked && emailChecked
				&& oneOptionSelected;

		if (canUpdate) {
			errorMessage.setText("");
		}

		updateUser.setEnabled(canUpdate);

	}

	private boolean isValidEmail() {
		final String emailText = emailField.getText();
		final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern
				.compile(
						"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
						Pattern.CASE_INSENSITIVE);
		final Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailText);

		return matcher.find();
	}

	private void fillAllFields() {
		GetPlanningPokerUserController.getInstance().retrieveUser();
		try {
			Thread.sleep(150);
		} catch (Exception e) {
		}

		currentUser = PlanningPokerUserModel.getInstance().getUser(
				ConfigManager.getConfig().getUserName());

		if (currentUser.getEmail() != null) {
			emailField.setText(currentUser.getEmail());
		}
		if (currentUser.getInstantMessage() != null) {
			aimField.setText(currentUser.getInstantMessage());
		}

		sendEmail.setSelected(currentUser.canSendEmail());
		sendAIM.setSelected(currentUser.canSendAim());

	}

	// Variables declaration - do not modify
	private JLabel infoLabel;
	private javax.swing.JTextField aimField;
	private javax.swing.JPanel aimPanel;
	private javax.swing.JTextField emailField;
	private javax.swing.JPanel emailPanel;
	private javax.swing.JLabel errorMessage;
	private javax.swing.JPanel notificationPanel;
	private javax.swing.JCheckBox sendAIM;
	private javax.swing.JCheckBox sendEmail;
	private javax.swing.JPanel textPanel;
	private javax.swing.JButton updateUser;
	// End of variables declaration

}
