import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MemoEx extends JFrame implements ActionListener{
	JTextArea ta;
	JLabel lb;
	JButton btn[]=new JButton[2];
	String[] btn_title= {"수정","등록"};
	Map<String,String> memoMap=new Hashtable<>();
	String mdate="",mcontents="";

		public MemoEx() {
			// TODO Auto-generated constructor stub
			super("일정메모장");
			display();
		}
		private void display() {
			JPanel np1=new JPanel();
			lb=new JLabel("날짜");
		
			np1.add(lb);
			add(np1,"North");
			
			ta=new JTextArea();
			ta.setEditable(false);
			add(ta,"Center");
			
			JPanel sp1=new JPanel();
			for(int i=0; i<btn.length; i++) {
				btn[i]=new JButton(btn_title[i]);
				btn[i].addActionListener(this);
				sp1.add(btn[i]);
			}
			add(sp1,"South");
			setSize(300,200);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
		public void printContents(String idate ) {
			mdate=idate;
			lb.setText(mdate);
			if(memoMap.containsKey(mdate)) {
				mcontents=memoMap.get(mdate);
				ta.setText(mcontents);
			}else {
				mcontents="";
				ta.setText(mcontents);
			}
		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MemoEx();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn[0]) {
			ta.setEditable(true);
			ta.requestFocus();
		}
		if(e.getSource()==btn[1] && ta.isEditable()) {
			
			ta.setEditable(false);
		}
	}

}
