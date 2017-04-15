package nba.window;

import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import nba.listener.ClickBtnListener;

import R.R;

public class QueryWindow extends AbstractPage {

  private static final long serialVersionUID = 1L;
  private JRadioButton btnAnalysis, btnDetail;
  private JButton btnPlayer, btnTeam, btnCoach, btnGym;
  private JScrollPane scrollpane;
  private JLabel label;
  private JPanel imgPanel;

  public QueryWindow() {
    super();
    setTitle("NBA");
    // 背景图片
    ImageIcon background = new ImageIcon(HomePage.class.getResource("background.jpg"));
    // 把背景图片显示在一个标签里面
    label = new JLabel(background);
    // 把标签的大小位置设置为图片刚好填充整个面板
    label.setBounds(0, 0, this.getWidth(), this.getHeight());
    // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
    imgPanel = (JPanel) this.getContentPane();
    imgPanel.setOpaque(false);
    // 把背景图片添加到分层窗格的最底层作为背景
    this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
    setSize(880, 610);
    setVisible(true); // 设置可见
    setResizable(false);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }


  protected void regitstComponent() {
    R r = R.getInstance();
    r.registObject("scrollpane", scrollpane);
    r.registObject("imgPanel", imgPanel);
    r.registObject("btnAnalysis", btnAnalysis);
    r.registObject("btnDetail", btnDetail);
    r.registObject("btnPlayer", btnPlayer);
    r.registObject("btnTeam", btnTeam);
    r.registObject("btnCoach", btnCoach);
    r.registObject("btnGym", btnGym);
  }

  protected void init() {
    setLayout(null);

    ButtonGroup bg = new ButtonGroup();

    btnAnalysis = new JRadioButton("整体分析");
    btnAnalysis.setBounds(690, 0, 100, 40);
    btnAnalysis.setFont(new Font("楷体", Font.BOLD, 16));
    btnAnalysis.setContentAreaFilled(false); // 设为透明色
    add(btnAnalysis);

    btnDetail = new JRadioButton("详细信息");
    btnDetail.setBounds(780, 0, 100, 40);
    btnDetail.setFont(new Font("楷体", Font.BOLD, 16));
    btnDetail.setContentAreaFilled(false); // 设为透明色
    add(btnDetail);

    bg.add(btnAnalysis); // 将btnAnalysis btnDetail加入ButtonGroup中
    bg.add(btnDetail);
    btnAnalysis.setSelected(true);

    btnPlayer = new JButton("球 员", new ImageIcon(QueryWindow.class.getResource("1.png")));
    btnPlayer.setBounds(700, 390, 80, 110);
    btnPlayer.setContentAreaFilled(false); // 设为透明
    btnPlayer.setHorizontalTextPosition(SwingConstants.CENTER); // 设置标题位置
    btnPlayer.setVerticalTextPosition(SwingConstants.BOTTOM);
    // button3.setBorderPainted(false); //去边框
    add(btnPlayer);

    btnTeam = new JButton("球 队", new ImageIcon(QueryWindow.class.getResource("2.png")));
    btnTeam.setBounds(630, 480, 90, 100);
    btnTeam.setFocusPainted(false);
    btnTeam.setContentAreaFilled(false);
    btnTeam.setFocusable(true);
    btnTeam.setHorizontalTextPosition(SwingConstants.CENTER);
    btnTeam.setVerticalTextPosition(SwingConstants.BOTTOM);
    add(btnTeam);

    btnCoach = new JButton("教 练", new ImageIcon(QueryWindow.class.getResource("3.png")));
    btnCoach.setBounds(770, 340, 100, 110);
    btnCoach.setFocusPainted(false);
    btnCoach.setContentAreaFilled(false);
    btnCoach.setFocusable(true);
    btnCoach.setHorizontalTextPosition(SwingConstants.CENTER);
    btnCoach.setVerticalTextPosition(SwingConstants.BOTTOM);
    add(btnCoach);

    btnGym = new JButton("体育场", new ImageIcon(QueryWindow.class.getResource("4.png")));
    btnGym.setBounds(760, 480, 115, 110);
    btnGym.setContentAreaFilled(false); // 设为透明
    btnGym.setHorizontalTextPosition(SwingConstants.CENTER);
    btnGym.setVerticalTextPosition(SwingConstants.BOTTOM);
    add(btnGym);
  }

  protected void addListener() {
    btnPlayer.addActionListener(new ClickBtnListener());
  }
}
