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
    // ����ͼƬ
    ImageIcon background = new ImageIcon(HomePage.class.getResource("background.jpg"));
    // �ѱ���ͼƬ��ʾ��һ����ǩ����
    label = new JLabel(background);
    // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
    label.setBounds(0, 0, this.getWidth(), this.getHeight());
    // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
    imgPanel = (JPanel) this.getContentPane();
    imgPanel.setOpaque(false);
    // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
    this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
    setSize(880, 610);
    setVisible(true); // ���ÿɼ�
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

    btnAnalysis = new JRadioButton("�������");
    btnAnalysis.setBounds(690, 0, 100, 40);
    btnAnalysis.setFont(new Font("����", Font.BOLD, 16));
    btnAnalysis.setContentAreaFilled(false); // ��Ϊ͸��ɫ
    add(btnAnalysis);

    btnDetail = new JRadioButton("��ϸ��Ϣ");
    btnDetail.setBounds(780, 0, 100, 40);
    btnDetail.setFont(new Font("����", Font.BOLD, 16));
    btnDetail.setContentAreaFilled(false); // ��Ϊ͸��ɫ
    add(btnDetail);

    bg.add(btnAnalysis); // ��btnAnalysis btnDetail����ButtonGroup��
    bg.add(btnDetail);
    btnAnalysis.setSelected(true);

    btnPlayer = new JButton("�� Ա", new ImageIcon(QueryWindow.class.getResource("1.png")));
    btnPlayer.setBounds(700, 390, 80, 110);
    btnPlayer.setContentAreaFilled(false); // ��Ϊ͸��
    btnPlayer.setHorizontalTextPosition(SwingConstants.CENTER); // ���ñ���λ��
    btnPlayer.setVerticalTextPosition(SwingConstants.BOTTOM);
    // button3.setBorderPainted(false); //ȥ�߿�
    add(btnPlayer);

    btnTeam = new JButton("�� ��", new ImageIcon(QueryWindow.class.getResource("2.png")));
    btnTeam.setBounds(630, 480, 90, 100);
    btnTeam.setFocusPainted(false);
    btnTeam.setContentAreaFilled(false);
    btnTeam.setFocusable(true);
    btnTeam.setHorizontalTextPosition(SwingConstants.CENTER);
    btnTeam.setVerticalTextPosition(SwingConstants.BOTTOM);
    add(btnTeam);

    btnCoach = new JButton("�� ��", new ImageIcon(QueryWindow.class.getResource("3.png")));
    btnCoach.setBounds(770, 340, 100, 110);
    btnCoach.setFocusPainted(false);
    btnCoach.setContentAreaFilled(false);
    btnCoach.setFocusable(true);
    btnCoach.setHorizontalTextPosition(SwingConstants.CENTER);
    btnCoach.setVerticalTextPosition(SwingConstants.BOTTOM);
    add(btnCoach);

    btnGym = new JButton("������", new ImageIcon(QueryWindow.class.getResource("4.png")));
    btnGym.setBounds(760, 480, 115, 110);
    btnGym.setContentAreaFilled(false); // ��Ϊ͸��
    btnGym.setHorizontalTextPosition(SwingConstants.CENTER);
    btnGym.setVerticalTextPosition(SwingConstants.BOTTOM);
    add(btnGym);
  }

  protected void addListener() {
    btnPlayer.addActionListener(new ClickBtnListener());
  }
}
