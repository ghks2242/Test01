package ��âȯ;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.omg.Messaging.SyncScopeHelper;

public class MainClass extends JFrame implements ActionListener {
	ProgTest1 pt1 = new ProgTest1();
	ProgTest2 pt2 = new ProgTest2();
	MemberData md = new MemberData();
	JLabel lb1, lb2, lb3, lb4;
	JTextField jf1, jf2, jf3;
	JButton jb1, jb2, jb3, jb4;
	JTextArea ja;
	JPanel jp1, jp2, jp3;
	JRadioButton rb1, rb2;
	ButtonGroup bg = new ButtonGroup();

	public MainClass() {
		// TODO Auto-generated constructor stub
		super("���α׷��� ��� Ȱ����");

		// ù��°
		Box hBox = Box.createHorizontalBox();

		hBox.add(Box.createHorizontalStrut(30));
		hBox.add(lb1 = new JLabel("ȸ�� ID :"));
		hBox.add(jf1 = new JTextField(10));
		hBox.add(Box.createHorizontalStrut(30));

		hBox.add(lb2 = new JLabel("ȸ���̸� :"));
		hBox.add(jf2 = new JTextField(10));
		hBox.add(Box.createHorizontalStrut(30));

		hBox.add(lb3 = new JLabel("��ȭ��ȣ :"));
		hBox.add(jf3 = new JTextField(10));
		hBox.add(Box.createHorizontalStrut(30));

		hBox.add(lb4 = new JLabel("���� :"));
		hBox.add(rb1 = new JRadioButton("��"));
		hBox.add(rb2 = new JRadioButton("��"));
		hBox.add(Box.createHorizontalStrut(30));
		bg.add(rb1);
		bg.add(rb2);

		Box hhBox = Box.createHorizontalBox();
		hhBox.add(jb1 = new JButton("ȸ�����"));
		hhBox.add(Box.createHorizontalStrut(10));
		hhBox.add(jb2 = new JButton("ȸ������"));
		hhBox.add(Box.createHorizontalStrut(10));
		hhBox.add(jb3 = new JButton("��üȸ����ȸ"));

		Box tBox = Box.createVerticalBox();
		tBox.add(hBox);
		tBox.add(Box.createVerticalStrut(10));
		tBox.add(hhBox);

		jp1 = new JPanel(new BorderLayout());
		jp1.setBorder(new TitledBorder(new EtchedBorder(), "ȸ�����,����,��ȸ"));
		jp1.add(tBox);

		// 2��°

		Box rBox = Box.createHorizontalBox();
		rBox.add(Box.createHorizontalGlue());
		rBox.add(jb4 = new JButton("�����ܺ���"));
		rBox.add(Box.createHorizontalGlue());

		jp2 = new JPanel(new BorderLayout());
		jp2.setBorder(new TitledBorder(new EtchedBorder(), "������"));
		jp2.add(rBox);

		// 3��°

		ja = new JTextArea(8, 30);
		ja.setEditable(false);
		jp3 = new JPanel(new BorderLayout());
		jp3.setBorder(new TitledBorder(new EtchedBorder(), "���"));
		jp3.add(ja);

		// ��ư�̺�Ʈ �߰��κ�
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);

		// �������߰��κ�
		add(jp1, "North");
		add(jp2, "Center");
		add(jp3, "South");
		setSize(800, 350);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainClass mc = new MainClass();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// ���� �����޴��� �κ�
		String gender = "";
		Enumeration<AbstractButton> enums = bg.getElements();
		while (enums.hasMoreElements()) {
			AbstractButton ab = enums.nextElement();
			JRadioButton jb = (JRadioButton) ab;
			if (jb.isSelected())
				gender = String.valueOf(jb.getText());
		}
		// ��ư1
		if (e.getSource() == jb1) {

			int con = JOptionPane.showConfirmDialog(this, "ȸ���� ����Ͻðڽ��ϱ�?", "ȸ�����", JOptionPane.YES_NO_OPTION);
			if (con == JOptionPane.YES_OPTION) {
				pt2.mapListAdd(jf1.getText(), jf2.getText(), jf3.getText(), gender);
			} else if (con == JOptionPane.NO_OPTION) {
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		}
		// ��ư2
		if (e.getSource() == jb2) {
			int con = JOptionPane.showConfirmDialog(this, "ȸ���� �����Ͻðڽ��ϱ�?", "ȸ������", JOptionPane.YES_NO_OPTION);
			if (con == JOptionPane.YES_OPTION) {
				pt2.mapListRemove(jf1.getText());
			} else if (con == JOptionPane.NO_OPTION) {
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		}
		// ��ư3
		if (e.getSource() == jb3) {
			ja.setText("ȸ��ID" + "\t" + "ȸ���̸�" + "\t" + "��ȭ��ȣ" + "\t" + "����" + "\n");
			for (int i = 0; i < pt2.getMapLIst().size(); i++) {
				ja.append(pt2.getMapLIst().get(i).getMemberID() + "\t" + pt2.getMapLIst().get(i).getName() + "\t"
						+ pt2.getMapLIst().get(i).getTel() + "\t" + pt2.getMapLIst().get(i).getGender() + "\n");
				
				// ArrayList<MemberData> list = pt2.getMapList();
				// for (int i=0; i<list.size(); i++) {
				//	 str+=pt2.getMapLIst().get(i).getMemberID() + "\t" + pt2.getMapLIst().get(i).getName() + "\t"
				// + pt2.getMapLIst().get(i).getTel() + "\t" + pt2.getMapLIst().get(i).getGender() + "\n"
			}
		}

		// ��ư4
		if (e.getSource() == jb4) {
			String dan = JOptionPane.showInputDialog(this, "����� ���ðڽ��ϱ�?", "�Է�", 2);
			ja.setText(pt1.getGugudan(Integer.parseInt(dan)));
			if (dan.equals("1")) {
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		}
	}
}