package carcrashgame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.util.Random;

import javax.swing.ImageIcon;

public class Design extends Applet implements Runnable, KeyListener
{
	Image i;
	Graphics gr;
	Image mycar_img;
	Image oppcar1_img;
	Image oppcar2_img;
	Image oppcar3_img;
	Image tree1_img;
	Image tree2_img;
	Image tree3_img;
	Image tree4_img;
	Image tree5_img;
	Image tree6_img;
	Thread t;
	int a = 30;
	int b = 180;
	int c = 330;
	int d = 480;
	int e = 630;
	int f = 730;
	int mycar_x = 480;
	int oppcar1_x = getRandom(450,680);
	int oppcar1_y = -130;
	int oppcar2_x = getRandom(450,680);
	int oppcar2_y = -560;
	int oppcar3_x = getRandom(450,680);
	int oppcar3_y = -950;
	
	int tree1_y = 100;
	int tree2_y = 300;
	int tree3_y = -200;
	int tree4_y = 200;
	int tree5_y = 400;
	int tree6_y = -200;
	
	int tree1_x = getRandom(0,300);
	int tree2_x = getRandom(0,300);
	int tree3_x = getRandom(0,300);
	int tree4_x = getRandom(750,1050);
	int tree5_x = getRandom(750,1050);
	int tree6_x = getRandom(750,1050);
	
	int score = 0;
	double k =0.0;
	String gameover = "";
	int speed = 51;
	public void start()
	{
		setSize(1200,700);
		setBackground(Color.GREEN);
		ImageIcon mycar_icon = new ImageIcon("C:\\Users\\micro\\Desktop\\yellowcar.png");
		mycar_img = mycar_icon.getImage();
		
		ImageIcon oppcar1_icon = new ImageIcon("C:\\Users\\micro\\Desktop\\redcar.png");
		oppcar1_img = oppcar1_icon.getImage();
		ImageIcon oppcar2_icon = new ImageIcon("C:\\Users\\micro\\Desktop\\redcar.png");
		oppcar2_img = oppcar2_icon.getImage();
		ImageIcon oppcar3_icon = new ImageIcon("C:\\Users\\micro\\Desktop\\redcar.png");
		oppcar3_img = oppcar3_icon.getImage();
		ImageIcon tree_icon = new ImageIcon("C:\\Users\\micro\\Desktop\\tree.png");
		tree1_img = tree_icon.getImage();
		tree2_img = tree_icon.getImage();
		tree3_img = tree_icon.getImage();
		tree4_img = tree_icon.getImage();
		tree5_img = tree_icon.getImage();
		tree6_img = tree_icon.getImage();
		addKeyListener(this);
		t = new Thread(this);
		t.start();
	}
	public void paint(Graphics g)
	{
		
		
		g.setColor(Color.BLACK);
		g.fillRect(450, 0, 300, 700);
		
		
		g.setColor(Color.WHITE);
		g.fillRect(590, a, 20, 100);
		g.fillRect(590, b, 20, 100);
		g.fillRect(590, c, 20, 100);
		g.fillRect(590, d, 20, 100);
		g.fillRect(590, e, 20, 100);
		g.fillRect(590, f, 20, 100);
		
		g.drawImage(mycar_img, mycar_x, 520, 80, 150,this);
		g.drawImage(oppcar1_img, oppcar1_x, oppcar1_y, 70, 130,this);
		g.drawImage(oppcar2_img, oppcar2_x, oppcar2_y, 70, 130,this);
		g.drawImage(oppcar3_img, oppcar3_x, oppcar3_y, 70, 130,this);
		g.drawImage(tree1_img, tree1_x, tree1_y,150,200, this);
		g.drawImage(tree2_img, tree2_x, tree2_y,150,200,  this);
		g.drawImage(tree3_img, tree3_x, tree3_y,150,200,  this);
		g.drawImage(tree4_img, tree4_x, tree4_y,150,200,  this);
		g.drawImage(tree5_img, tree5_x, tree5_y,150,200,  this);
		g.drawImage(tree6_img, tree6_x, tree6_y,150,200,  this);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial",Font.BOLD,34));
		g.drawString("Score "+score, 770, 45);
		
		g.setColor(Color.RED);
		g.setFont(new Font("Algerian",Font.BOLD,65));
		g.drawString(gameover, 400, 350);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			a+=1;
			b+=1;
			c+=1;
			d+=1;
			e+=1;
			f+=1;
			oppcar1_y += 2;
			oppcar2_y += 2;
			oppcar3_y += 2;
			
			tree1_y += 1;
			tree2_y += 1;
			tree3_y += 1;
			tree4_y += 1;
			tree5_y += 1;
			tree6_y += 1;
			
			if(score <= 3)
			{
				speed = 24;
			}
			else if(score <= 6)
			{
				speed = 21;
			}
			else if(score <= 9)
			{
				speed = 18;
			}
			else if(score <= 12)
			{
				speed = 15;
			}
			else if(score <= 15)
			{
				speed = 12;
			}
			else
			{
				speed = 7;
			}
				
			
			
			try
			{
				
				Thread.sleep(speed);
				if(a == 50)
				{
					f = -100;
					repaint();
				}
				if(f == 50)
				{
					e = -100;
					repaint();
				}
				if(e == 50)
				{
					d = -100;
					repaint();
				}
				if(d == 50)
				{
					c = -100;
					repaint();
				}
				if(c == 50)
				{
					b = -100;
					repaint();
				}
				if(b == 50)
				{
					a = -100;
					repaint();
				}
				
				if(oppcar1_y + 130 >= 540 && oppcar1_y < 650)
				{
					boolean b = isCollided(oppcar1_x,mycar_x);
					if(b)
					{
						gameover = "Game Over";
						repaint();
						t.stop();
						
					}
				}
				else if(oppcar2_y + 130 >= 540 && oppcar2_y < 650)
				{
					boolean b = isCollided(oppcar2_x,mycar_x);
					if(b)
					{
						gameover = "Game Over";
						repaint();
						t.stop();
					}
				}
				else if(oppcar3_y + 130 >= 540 && oppcar3_y < 650)
				{
					boolean b = isCollided(oppcar3_x,mycar_x);
					if(b)
					{
						gameover = "Game Over";
						repaint();
						t.stop();
					}
				}
				
				if(oppcar1_y == 700)
				{
					oppcar1_y = -570;
					oppcar1_x = getRandom(450, 680);
					score++;
					repaint();
				}
				if(oppcar2_y == 700)
				{
					oppcar2_y = -570;
					oppcar2_x = getRandom(450, 680);
					score++;
					repaint();
				}
				if(oppcar3_y == 700)
				{
					oppcar3_y = -570;
					oppcar3_x = getRandom(450, 680);
					score++;
					repaint();
				}
				
				if(tree2_y >= 700)
				{
					tree2_y = -200;
					tree2_x = getRandom(0, 300);
					repaint();
				}
				if(tree1_y >= 700)
				{
					tree1_y = -200;
					tree1_x = getRandom(0, 300);
					repaint();
				}
				if(tree3_y >= 700)
				{
					tree3_y = -200;
					tree3_x = getRandom(0, 300);
					repaint();
				}
				
				if(tree5_y >= 700)
				{
					tree5_y = -200;
					tree5_x = getRandom(750, 1050);
					repaint();
				}
				if(tree4_y >= 700)
				{
					tree4_y = -200;
					tree4_x = getRandom(750, 1050);
					repaint();
				}
				if(tree6_y >= 700)
				{
					tree6_y = -200;
					tree6_x = getRandom(750, 1050);
					repaint();
				}
				
				repaint();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_LEFT && !gameover.equals("Game Over"))
		{
			
			if(mycar_x == 450)
			{
				mycar_x = 450;
			}
			else
			{
				mycar_x = mycar_x - 5;
				repaint();
			}
			
			
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT && !gameover.equals("Game Over"))
		{
			if(mycar_x == 670)
			{
				mycar_x = 670;
			}
			else
			{
				mycar_x = mycar_x + 5;
				repaint();
			}
			
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public int getRandom(int low, int high)
	{
		Random r = new Random();
		int rand = r.nextInt(high-low)+low;
		return rand;
	}
	public boolean isCollided(int oppcar_x, int mycar_x)
	{
		int oppleft = oppcar_x;
		int oppright = oppcar_x + 50;
		
		int myleft = mycar_x;
		int myright = mycar_x + 65;
		
		if(myright >= oppleft && myleft <= oppright)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	@Override
	public void update(Graphics g)
	{
		if(i == null)
		{
			i = createImage(this.getSize().width, this.getSize().height);
			gr = i.getGraphics();
		}
		gr.setColor(getBackground());
		gr.fillRect(0, 0, this.getSize().width, this.getSize().height);
		
		gr.setColor(getForeground());
		paint(gr);
		
		g.drawImage(i, 0, 0, this);
	}

}

