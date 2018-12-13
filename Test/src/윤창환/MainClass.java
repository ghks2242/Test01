package 윤창환;

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
		super("프로그래밍 언어 활용평가");

		// 첫번째
		Box hBox = Box.createHorizontalBox();

		hBox.add(Box.createHorizontalStrut(30));
		hBox.add(lb1 = new JLabel("회원 ID :"));
		hBox.add(jf1 = new JTextField(10));
		hBox.add(Box.createHorizontalStrut(30));

		hBox.add(lb2 = new JLabel("회원이름 :"));
		hBox.add(jf2 = new JTextField(10));
		hBox.add(Box.createHorizontalStrut(30));

		hBox.add(lb3 = new JLabel("전화번호 :"));
		hBox.add(jf3 = new JTextField(10));
		hBox.add(Box.createHorizontalStrut(30));

		hBox.add(lb4 = new JLabel("성별 :"));
		hBox.add(rb1 = new JRadioButton("남"));
		hBox.add(rb2 = new JRadioButton("여"));
		hBox.add(Box.createHorizontalStrut(30));
		bg.add(rb1);
		bg.add(rb2);

		Box hhBox = Box.createHorizontalBox();
		hhBox.add(jb1 = new JButton("회원등록"));
		hhBox.add(Box.createHorizontalStrut(10));
		hhBox.add(jb2 = new JButton("회원삭제"));
		hhBox.add(Box.createHorizontalStrut(10));
		hhBox.add(jb3 = new JButton("전체회원조회"));

		Box tBox = Box.createVerticalBox();
		tBox.add(hBox);
		tBox.add(Box.createVerticalStrut(10));
		tBox.add(hhBox);

		jp1 = new JPanel(new BorderLayout());
		jp1.setBorder(new TitledBorder(new EtchedBorder(), "회원등록,삭제,조회"));
		jp1.add(tBox);

		// 2번째

		Box rBox = Box.createHorizontalBox();
		rBox.add(Box.createHorizontalGlue());
		rBox.add(jb4 = new JButton("구구단보기"));
		rBox.add(Box.createHorizontalGlue());

		jp2 = new JPanel(new BorderLayout());
		jp2.setBorder(new TitledBorder(new EtchedBorder(), "구구단"));
		jp2.add(rBox);

		// 3번째

		ja = new JTextArea(8, 30);
		ja.setEditable(false);
		jp3 = new JPanel(new BorderLayout());
		jp3.setBorder(new TitledBorder(new EtchedBorder(), "결과"));
		jp3.add(ja);

		// 버튼이벤트 추가부분
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);

		// 프레임추가부분
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

		// 성별 선택햇는지 부분
		String gender = "";
		Enumeration<AbstractButton> enums = bg.getElements();
		while (enums.hasMoreElements()) {
			AbstractButton ab = enums.nextElement();
			JRadioButton jb = (JRadioButton) ab;
			if (jb.isSelected())
				gender = String.valueOf(jb.getText());
		}
		// 버튼1
		if (e.getSource() == jb1) {

			int con = JOptionPane.showConfirmDialog(this, "회원을 등록하시겠습니까?", "회원등록", JOptionPane.YES_NO_OPTION);
			if (con == JOptionPane.YES_OPTION) {
				pt2.mapListAdd(jf1.getText(), jf2.getText(), jf3.getText(), gender);
			} else if (con == JOptionPane.NO_OPTION) {
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		}
		// 버튼2
		if (e.getSource() == jb2) {
			int con = JOptionPane.showConfirmDialog(this, "회원을 삭제하시겠습니까?", "회원삭제", JOptionPane.YES_NO_OPTION);
			if (con == JOptionPane.YES_OPTION) {
				pt2.mapListRemove(jf1.getText());
			} else if (con == JOptionPane.NO_OPTION) {
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		}
		// 버튼3
		if (e.getSource() == jb3) {
			ja.setText("회원ID" + "\t" + "회원이름" + "\t" + "전화번호" + "\t" + "성별" + "\n");
			for (int i = 0; i < pt2.getMapLIst().size(); i++) {
				ja.append(pt2.getMapLIst().get(i).getMemberID() + "\t" + pt2.getMapLIst().get(i).getName() + "\t"
						+ pt2.getMapLIst().get(i).getTel() + "\t" + pt2.getMapLIst().get(i).getGender() + "\n");
				
				// ArrayList<MemberData> list = pt2.getMapList();
				// for (int i=0; i<list.size(); i++) {
				//	 str+=pt2.getMapLIst().get(i).getMemberID() + "\t" + pt2.getMapLIst().get(i).getName() + "\t"
				// + pt2.getMapLIst().get(i).getTel() + "\t" + pt2.getMapLIst().get(i).getGender() + "\n"
			}
		}

		// 버튼4
		if (e.getSource() == jb4) {
			String dan = JOptionPane.showInputDialog(this, "몇단을 보시겠습니까?", "입력", 2);
			ja.setText(pt1.getGugudan(Integer.parseInt(dan)));
			if (dan.equals("1")) {
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		}
	}
}