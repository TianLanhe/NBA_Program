package nba.window;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import nba.listener.TeamAgeAnalysisListener;
import nba.listener.TeamGameAnalysisListener;
import nba.listener.TeamWinAnalysisListener;
import nba.r.R;

public class AllTeam extends AbstractPage {

  private static final long serialVersionUID = 1L;

  private JButton btnTeamwin_num;
  private JButton btnTeamgame_num;
  private JButton btnTeamage;

  private JRadioButton btnBar;
  private JRadioButton btnPie;

  private JPanel diagramPanel;

  @Override
  protected void initPage() {
    super.initPage();

    setTitle("����������");
    Color c = new Color(202, 225, 255);
    getContentPane().setBackground(c);

    setLayout(null);
  }

  @Override
  protected void regitstComponent() {
    R.getInstance().registObject("teamDiagramPanel", diagramPanel);
    R.getInstance().registObject("btnBarTeam", btnBar);
    R.getInstance().registObject("btnPieTeam", btnPie);
  }

  @Override
  protected void init() {
    btnTeamage = new JButton("������޷ֲ�");
    btnTeamage.setBounds(20, 120, 140, 60);
    add(btnTeamage);

    btnTeamgame_num = new JButton("��Ӳ������ηֲ�");
    btnTeamgame_num.setBounds(20, 240, 140, 60);
    add(btnTeamgame_num);

    btnTeamwin_num = new JButton("���ʤ�����ηֲ�");
    btnTeamwin_num.setBounds(20, 360, 140, 60);
    add(btnTeamwin_num);

    ButtonGroup bg = new ButtonGroup();

    btnBar = new JRadioButton("��״ͼ");
    btnBar.setBounds(690, 0, 100, 40);
    btnBar.setFont(new Font("����", Font.BOLD, 16));
    btnBar.setContentAreaFilled(false); // ��Ϊ͸��ɫ
    add(btnBar);

    btnPie = new JRadioButton("����ͼ");
    btnPie.setBounds(770, 0, 100, 40);
    btnPie.setFont(new Font("����", Font.BOLD, 16));
    btnPie.setContentAreaFilled(false); // ��Ϊ͸��ɫ
    add(btnPie);

    bg.add(btnBar); // ��btnAnalysis btnDetail����ButtonGroup��
    bg.add(btnPie);
    btnBar.setSelected(true);// Ĭ������״ͼ

    diagramPanel = new JPanel();
    diagramPanel.setBounds(175, 70, 670, 470);
    diagramPanel.setBackground(new Color(202, 225, 255));
    add(diagramPanel);
  }

  @Override
  protected void addListener() {
    btnTeamgame_num.addActionListener(new TeamGameAnalysisListener());
    btnTeamage.addActionListener(new TeamAgeAnalysisListener());
    btnTeamwin_num.addActionListener(new TeamWinAnalysisListener());
  }
}
