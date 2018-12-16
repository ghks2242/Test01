import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalendarForm extends JFrame implements ActionListener, FocusListener {
	JTextField yearText;
	JLabel lb1, lb2;
	JComboBox monthComb;
	JButton btn, btn1, btn2;
	JPanel jp1, jp2, jp3, jp4, calendar;
	String[] weekday = { "일", "월", "화", "수", "목", "금", "토" };
	String[] monthNum = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	int year, month;
	Calendar cd = Calendar.getInstance();
	MemoEx mmm=new MemoEx();
	
	public CalendarForm() {
		// TODO Auto-generated constructor stub
		super("달력");
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		calendar = new JPanel(new GridLayout(0, 7));

		lb1 = new JLabel("년");
		lb2 = new JLabel("월");
		yearText = new JTextField(4);
		yearText.setFont(new Font("고딕", Font.BOLD, 15));
		monthComb = new JComboBox(monthNum);

		for (int i = 0; i < 49; i++) {
			calendar.add(addCalnedarTextField(i));
		}

		btn = new JButton("확인");
		btn1 = new JButton("<");
		btn2 = new JButton(">");
		btn.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);

		jp1.add(yearText);
		jp1.add(lb1);
		jp1.add(monthComb);
		jp1.add(lb2);
		jp1.add(btn);

		add(jp1, "North");
		add(btn1, "West");
		add(btn2, "East");
		add(calendar, "Center");

		year = cd.get(Calendar.YEAR);
		month = cd.get(Calendar.MONTH);

		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		calcCalendar();
	}

	private void calcCalendar() {
		cd.set(year, month, 1);
		int date = cd.get(Calendar.DAY_OF_WEEK);
		displayCalendar(date, cd.getActualMaximum(Calendar.DAY_OF_MONTH));
		yearText.setText(String.valueOf(year));
		monthComb.setSelectedIndex(month);
	}

	private void displayCalendar(int dayOfWeek, int endDay) {
		System.out.println(dayOfWeek);
		for (int i = 7; i < dayOfWeek + 6; i++) {
			((JTextField) (calendar.getComponent(i))).setText("");
		}
		for (int i = 0; i < endDay; i++) {
			((JTextField) (calendar.getComponent(dayOfWeek + i + 6))).setText(String.valueOf(i + 1));
		}
		for (int i = dayOfWeek + 6 + endDay; i < 49; i++) {
			((JTextField) (calendar.getComponent(i))).setText("");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CalendarForm();
	}
	
	JTextField addCalnedarTextField(int i) {
		JTextField tf;
		if (i >= 0 && i <= 6) {
			tf = new JTextField(weekday[i]);
			tf.setBackground(Color.LIGHT_GRAY);
		} else {
			tf = new JTextField("");
			tf.setBackground(Color.white);
			tf.addFocusListener(this);
		}
		tf.setFont(new Font("고딕", Font.PLAIN, 15));
		tf.setHorizontalAlignment(JTextField.CENTER);
		tf.setEditable(false);
		if (i % 7 == 0) {
			tf.setForeground(Color.RED);
		} else if (i % 7 == 6) {
			tf.setForeground(Color.BLUE);
		} else {
			tf.setForeground(Color.BLACK);
		}

		return tf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btn) {
			year = Integer.parseInt(yearText.getText());
			month = monthComb.getSelectedIndex();
			calcCalendar();
		}
		if (e.getActionCommand().equals("<")) {
			month = month - 1;
			if (month < 0) {
				year -= 1;
				month = 11;
			}
			calcCalendar();
		}
		if (e.getActionCommand().equals(">")) {
			month = month + 1;
			if (month > 11) {
				year += 1;
				month = 0;
			}
			calcCalendar();
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(!((JTextField) e.getSource()).getText().trim().isEmpty()) {
			calendar.requestFocusInWindow();
			mmm.setVisible(true);
			mmm.printContents(year+"-"+(month+1)+"-"+((JTextField)e.getSource()).getText());
		}
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
