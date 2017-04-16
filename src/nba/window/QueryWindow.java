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

import nba.r.R;

import nba.listener.ClickBtnListener;
import nba.listener.PlayerGameAnalysisListener;


public class QueryWindow extends AbstractPage {

  private static final long serialVersionUID = 1L;
  private JRadioButton btnAnalysis, btnDetail;
  private JButton btnPlayer, btnTeam, btnCoach, btnGym;
  private JScrollPane scrollpane;
  private JLabel label;
  private JPanel imgPanel;

  @Override
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

  @Override
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
    btnAnalysis.setSelected(true);// 默认是整体分析

    btnPlayer = new JButton("球 员", new ImageIcon("res/1.png"));
    btnPlayer.setBounds(700, 390, 80, 110);
    btnPlayer.setContentAreaFilled(false); // 设为透明
    btnPlayer.setHorizontalTextPosition(SwingConstants.CENTER); // 设置标题位置
    btnPlayer.setVerticalTextPosition(SwingConstants.BOTTOM);
    // button3.setBorderPainted(false); //去边框
    add(btnPlayer);

    btnTeam = new JButton("球 队", new ImageIcon("res/2.png"));
    btnTeam.setBounds(630, 480, 90, 100);
    btnTeam.setFocusPainted(false);
    btnTeam.setContentAreaFilled(false);
    btnTeam.setFocusable(true);
    btnTeam.setHorizontalTextPosition(SwingConstants.CENTER);
    btnTeam.setVerticalTextPosition(SwingConstants.BOTTOM);
    add(btnTeam);

    btnCoach = new JButton("教 练", new ImageIcon("res/3.png"));
    btnCoach.setBounds(770, 340, 100, 110);
    btnCoach.setFocusPainted(false);
    btnCoach.setContentAreaFilled(false);
    btnCoach.setFocusable(true);
    btnCoach.setHorizontalTextPosition(SwingConstants.CENTER);
    btnCoach.setVerticalTextPosition(SwingConstants.BOTTOM);
    add(btnCoach);

    btnGym = new JButton("体育场", new ImageIcon("res/4.png"));
    btnGym.setBounds(760, 480, 115, 110);
    btnGym.setContentAreaFilled(false); // 设为透明
    btnGym.setHorizontalTextPosition(SwingConstants.CENTER);
    btnGym.setVerticalTextPosition(SwingConstants.BOTTOM);
    add(btnGym);

    ImageIcon background = new ImageIcon("res/background.jpg");
    label = new JLabel(background);
    label.setBounds(0, 0, this.getWidth(), this.getHeight());// 把标签的大小位置设置为图片刚好填充整个面板
    add(label);

    validate();
  }

  @Override
  protected void addListener() {
    btnPlayer.addActionListener(new ClickBtnListener());
    btnGym.addActionListener(new PlayerGameAnalysisListener());
  }

  @Override
  protected void initPage() {
    super.initPage();
    setTitle("NBA");
    setSize(880, 610);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
