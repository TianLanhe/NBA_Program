package nba.window;

import java.awt.Color;
import javax.swing.JButton;

import nba.r.R;


public class Allplayer extends AbstractPage {

  private static final long serialVersionUID = 1L;
  private JButton btnPlayerAge, btnPlayerGames, btnPlayerPTS, btnPlayerLg, btnPlayerSeason;

  public Allplayer() {
    super();
    setTitle("�������");
    setSize(880, 610);
    Color c = new Color(202, 225, 255);
    getContentPane().setBackground(c);
  }

  protected void regitstComponent() {
    R r = R.getInstance();
    r.registObject("btnPlayerAge", btnPlayerAge);
    r.registObject("btnPlayerGames", btnPlayerGames);
    r.registObject("btnPlayerPTS", btnPlayerPTS);
    r.registObject("btnPlayerLg", btnPlayerLg);
    r.registObject("btnPlayerSeason", btnPlayerSeason);
  }

  protected void init() {
    setLayout(null);

    btnPlayerAge = new JButton("��Ա����ֲ�");
    btnPlayerAge.setBounds(80, 80, 200, 60);
    // button1.setBackground(Color.white);
    // button.setContentAreaFilled(false); ��Ϊ͸��ɫ
    add(btnPlayerAge);

    btnPlayerGames = new JButton("��Ա�÷ֲַ�");
    btnPlayerGames.setBounds(80, 230, 200, 60);
    add(btnPlayerGames);

    btnPlayerPTS = new JButton("��Ա�������ȷֲ�");
    btnPlayerPTS.setBounds(80, 380, 200, 60);
    add(btnPlayerPTS);

    btnPlayerLg = new JButton("��Ա�������ηֲ�");
    btnPlayerLg.setBounds(500, 80, 200, 60);
    add(btnPlayerLg);

    btnPlayerSeason = new JButton("��Ա���˷ֲ�");
    btnPlayerSeason.setBounds(500, 230, 200, 60);
    add(btnPlayerSeason);

  }

  protected void addListener() {

	}
}
