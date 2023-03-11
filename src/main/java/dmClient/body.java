package dmClient;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.DefaultCaret;

public class body {
	public static JTextArea textArea = null;
	public static int i = 0;
	public static void main(String[] args) {
		 List<Integer> list = setInfo();
		JFrame j = new JFrame();
		// 窗口置顶
		j.setAlwaysOnTop(true);
		// 此处不能加入内容，否则滚动条自动向上。
		textArea = new JTextArea();
		// 添加拖动位置功能
//		textArea.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				xOld = e.getX();
//				yOld = e.getY();
//			}
//		});
//		textArea.addMouseMotionListener(new MouseMotionAdapter() {
//			@Override
//			public void mouseDragged(MouseEvent e) {
//				int xOnScreen = (int) e.getXOnScreen();
//				int yOnScreen = (int) e.getYOnScreen();
//				int xx = xOnScreen - xOld;
//				int yy = yOnScreen - yOld;
//				j.setLocation(xx, yy);
//
//			}
//		});
		// 文本不可编辑
		textArea.setEditable(false);
		// 设置字体，大小和颜色。
		textArea.setFont(new Font(null, Font.PLAIN, 17));
		textArea.setForeground(new Color(0, 0, 0));
		// 文本自动换行
		textArea.setLineWrap(true);
		// 文本框透明
		textArea.setOpaque(false);
		//不可选中
		textArea.setHighlighter(null);
		// 文本定位到最下面一行
		DefaultCaret caret = (DefaultCaret) textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		// 不显示滚动条
		JScrollPane jScrollPane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//去除滚动条边框
		jScrollPane.setBorder(null);
		// 不显示滚动条但可用滚轮控制
//		jScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		// jScrollPane透明
		jScrollPane.setOpaque(false);
		jScrollPane.getViewport().setOpaque(false);

		j.setContentPane(jScrollPane);
		// 隐藏标题栏和边框
		j.setUndecorated(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//若想拖动文本框以改变位置，背景就不能完全透明，即最后一个参数>0
		j.setBackground(new Color(0, 0, 0, 0));
		j.setLocation(list.get(0), list.get(1));
		j.setSize(200, 800);
		j.setVisible(true);
		DanMuClient danMuClient = new DanMuClient(8299);
		danMuClient.start();	
	}



	private static List<Integer> setInfo() {
	    boolean flag=true;
	    List<Integer> l=new ArrayList<Integer>();
	    Scanner reader2=null;
	    Scanner reader=null;
		while(flag) {
			try {
				System.out.println("请输入横坐标，建议<100：");
				reader=new Scanner(System.in);
				int x = reader.nextInt();
				System.out.println("请输入纵坐标，建议<20：");
				reader2=new Scanner(System.in);
				int y = reader2.nextInt();
				l.add(x);
				l.add(y);
				flag=false;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("异常输入，请输入合法字符！");
				continue;
			}			
		}
		return l;
	}

}
