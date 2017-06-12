package nba.window;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import nba.listener.PlayerAgeAnalysisListener;
import nba.listener.PlayerGameAnalysisListener;
import nba.listener.PlayerPointAnalysisListener;
import nba.listener.PlayerSeasonAnalysisListener;
import nba.r.R;

public class Allplayer extends AbstractPage {

  private static final long serialVersionUID = 1L;

  private JButton btnPlayerAge;
  private JButton btnPlayerGames;
  private JButton btnPlayerPTS;
  private JButton btnPlayerSeason;

  private JRadioButton btnBar;
  private JRadioButton btnPie;

  private JPanel diagramPanel;

  @Override
  protected void initPage() {
    super.initPage();

    setTitle("��Ա�������");
    Color c = new Color(202, 225, 255);
    getContentPane().setBackground(c);

    setLayout(null);
  }

  @Override
  protected void regitstComponent() {
    R.getInstance().registObject("btnBar", btnBar);
    R.getInstance().registObject("playerDiagramPanel", diagramPanel);
  }

  @Override
  protected void init() {
    btnPlayerAge = new JButton("��Ա����ֲ�");
    btnPlayerAge.setBounds(20, 100, 140, 60);
    add(btnPlayerAge);

    btnPlayerGames = new JButton("��Ա�������ηֲ�");
    btnPlayerGames.setBounds(20, 200, 140, 60);
    add(btnPlayerGames);

    btnPlayerPTS = new JButton("��Աƽ���÷ֲַ�");
    btnPlayerPTS.setBounds(20, 300, 140, 60);
    add(btnPlayerPTS);

    btnPlayerSeason = new JButton("��Ա�������ȷֲ�");
    btnPlayerSeason.setBounds(20, 400, 140, 60);
    add(btnPlayerSeason);

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

    diagramPanel = new JPanel();
    diagramPanel.setBounds(175, 70, 670, 470);
    diagramPanel.setBackground(new Color(202,225,255));
    add(diagramPanel);
  }

  @Override
  protected void addListener() {
    btnPlayerAge.addActionListener(new PlayerAgeAnalysisListener());
    btnPlayerGames.addActionListener(new PlayerGameAnalysisListener());
    btnPlayerPTS.addActionListener(new PlayerPointAnalysisListener());
    btnPlayerSeason.addActionListener(new PlayerSeasonAnalysisListener());
  }
}
