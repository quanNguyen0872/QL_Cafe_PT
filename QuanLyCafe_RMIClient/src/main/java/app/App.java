package app;

import javax.swing.JDialog;

import gui.Login;

public class App {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "myrmi/myrmi.policy");
			System.setSecurityManager(new SecurityManager());
		}
	}
}
