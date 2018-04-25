package selenium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
 class interface1
{
	 public static String username;
	 public static String flipkartpassword;
	 public static String value;
public static void main(String[] args)
	{
	JFrame f=new JFrame ("Interface");
	JButton b=new JButton("Submit");
	b.setBounds(925,290,100,40);
	JLabel l=new JLabel("Enter CustomerID");
	l.setBounds(780, 205, 100, 100);
        JLabel l1=new JLabel("");
	l1.setBounds(930, 250, 300, 300);
	JTextField t= new JTextField();
	t.setBounds(900, 235, 150, 40);
	f.add(t);
	f.add(l);
	f.add(b);    
    f.add(l1);
	f.setSize(2050,1100);    
	f.setLayout(null);    
	f.setVisible(true);
	autologin a=new autologin();
	html1 h=new html1();
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  b.addActionListener(new ActionListener() {
        
		@Override
		public void actionPerformed(ActionEvent arg0) {
				l1.setText("Initiated");
				String value = t.getText();
				try {
					Thread.sleep(3000);
					connector.setValues(value);
					l1.setText("Connected");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a.autoLogin();
				l1.setText("Logged In");
				a.parse();
				h.creation();
				sendmail.sendMail();
				l1.setText("Mail Sent");
		}          
      });
	}
}