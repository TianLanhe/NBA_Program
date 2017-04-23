package nba.window;

import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import nba.r.R;

import nba.listener.PlayerClickListener;

public class QueryPage extends AbstractPage {
  private static final long serialVersionUID = 1L;
  private JRadioButton btnAnalysis, btnDetail;
  private JButton btnPlayer, btnTeam, btnCoach, btnGym;

  @Override
  protected void regitstComponent() {
    R r = R.getInstance();
    r.registObject("btnAnalysis", btnAnalysis);
    r.registObject("btnDetail", btnDetail);
    r.registObject("btnPlayer", btnPlayer);
    r.registObject("btnTeam", btnTeam);
    r.registObject("btnCoach", btnCoach);
    r.registObject("btnGym", btnGym);
  }

  @Override
  protected void init() {
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
    btnAnalysis.setSelected(true);// Ĭ�����������

    btnPlayer = new JButton("�� Ա", new ImageIcon("res/1.png"));
    btnPlayer.setBounds(700, 390, 80, 110);
    btnPlayer.setContentAreaFilled(false); // ��Ϊ͸��
    btnPlayer.setHorizontalTextPosition(SwingConstants.CENTER); // ���ñ���λ��
    btnPlayer.setVerticalTextPosition(SwingConstants.BOTTOM);
    add(btnPlayer);

    btnTeam = new JButton("�� ��", new ImageIcon("res/2.png"));
    btnTeam.setBounds(630, 480, 90, 100);
    btnTeam.setContentAreaFilled(false);
    btnTeam.setHorizontalTextPosition(SwingConstants.CENTER);
    btnTeam.setVerticalTextPosition(SwingConstants.BOTTOM);
    add(btnTeam);

    btnCoach = new JButton("�� ��", new ImageIcon("res/3.png"));
    btnCoach.setBounds(770, 340, 100, 110);
    btnCoach.setContentAreaFilled(false);
    btnCoach.setHorizontalTextPosition(SwingConstants.CENTER);
    btnCoach.setVerticalTextPosition(SwingConstants.BOTTOM);
    add(btnCoach);

    btnGym = new JButton("������", new ImageIcon("res/4.png"));
    btnGym.setBounds(760, 480, 115, 110);
    btnGym.setContentAreaFilled(false); // ��Ϊ͸��
    btnGym.setHorizontalTextPosition(SwingConstants.CENTER);
    btnGym.setVerticalTextPosition(SwingConstants.BOTTOM);
    add(btnGym);
    
    JLabel label;
    ImageIcon background = new ImageIcon("res/background.jpg");
    label = new JLabel(background);
    label.setBounds(0, 0, this.getWidth(), this.getHeight());// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
    add(label);

    validate();
  }

  @Override
  protected void addListener() {
    btnPlayer.addActionListener(new PlayerClickListener());
  }

  @Override
  protected void initPage() {
    super.initPage();
    setTitle("NBA");
    setSize(880, 610);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
  }
}
