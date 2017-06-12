package nba.window;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import nba.listener.ArenaAgeAnalysisListener;
import nba.listener.ArenaCapacityAnalysisListener;
import nba.r.R;

public class AllArena extends AbstractPage {

  private static final long serialVersionUID = 1L;

  private JButton btnCapacity;// �����������ֲ�
  private JButton btnArenaAge;// ������ʹ������
  private JRadioButton btnBar;
  private JRadioButton btnPie;

  private JPanel diagramPanel;// ͼ�����

  @Override
  protected void initPage() {
    super.initPage();

    setTitle("�������������");
    Color c = new Color(202, 225, 255);
    getContentPane().setBackground(c);

    setLayout(null);
  }

  @Override
  protected void regitstComponent() {
    R.getInstance().registObject("diagramPanel", diagramPanel);
    R.getInstance().registObject("btnBarArena", btnBar);
  }

  @Override
  protected void init() {
    ButtonGroup bg = new ButtonGroup();
    btnBar = new JRadioButton("��״ͼ");
    btnBar.setBounds(690, 0, 100, 40);
    btnBar.setFont(new Font("����", Font.BOLD, 16));
    btnBar.setContentAreaFilled(false); // ��Ϊ͸��ɫ
    btnBar.setActionCommand("bar");
    add(btnBar);

    btnPie = new JRadioButton("����ͼ");
    btnPie.setBounds(770, 0, 100, 40);
    btnPie.setFont(new Font("����", Font.BOLD, 16));
    btnPie.setContentAreaFilled(false); // ��Ϊ͸��ɫ
    btnPie.setActionCommand("pie");
    add(btnPie);

    bg.add(btnBar); // ��btnAnalysis btnDetail����ButtonGroup��
    bg.add(btnPie);
    btnBar.setSelected(true);// Ĭ������״ͼ

    btnArenaAge = new JButton("������ʹ������");
    btnArenaAge.setBounds(20, 120, 140, 60);
    add(btnArenaAge);

    btnCapacity = new JButton("�����������ֲ�");
    btnCapacity.setBounds(20, 320, 140, 60);
    add(btnCapacity);

    diagramPanel = new JPanel();
    diagramPanel.setBounds(175, 70, 670, 470);
    diagramPanel.setBackground(new Color(202,225,255));
    add(diagramPanel);
  }

  @Override
  protected void addListener() {
    btnArenaAge.addActionListener(new ArenaAgeAnalysisListener());
    btnCapacity.addActionListener(new ArenaCapacityAnalysisListener());
  }
}
