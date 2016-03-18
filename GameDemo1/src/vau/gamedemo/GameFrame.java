package vau.gamedemo;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameFrame extends JFrame implements KeyListener{

		/**
	 * 
	 */
	private static final long serialVersionUID = -6384369600139105430L;
	JLabel label;
	JPanel panel;
	int [][] data_1;
		public GameFrame(){
			init();
		}
		
		private void init(){
			this.setTitle("GameMap");
			this.setSize(600, 412);
			this.setLocation(500, 200);
			this.setVisible(true);
			setCharacter();
			put_sth();
			this.addKeyListener(this);
		}
		
		private void setCharacter(){
			panel = new JPanel(null);
			label = new JLabel(new ImageIcon("images/image1.png"));
			label.setBounds(50,50, 10, 10);
			panel.add(label);
			this.setContentPane(panel);
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			Rectangle r = label.getBounds();
			int next_x;
			int next_y;
			
			switch(e.getKeyCode()){
			//move up
				case 38:
					next_x = r.x;
					next_y = r.y-10;
					
					try{
					if(data_1[next_x/10][next_y/10] == 0){
						label.setBounds(next_x, next_y, r.width,r.height);
					}
					}catch(ArrayIndexOutOfBoundsException exception){	
					}
					break;
			//move down
				case 40:
					next_x = r.x;
					next_y = r.y+10;
					try{
						if(data_1[next_x/10][next_y/10] == 0){
							label.setBounds(next_x, next_y, r.width,r.height);
						}
						}catch(ArrayIndexOutOfBoundsException exception){	
						}
					break;
			//move right
				case 39:
					next_x = r.x+10;
					next_y = r.y;
					try{
						if(data_1[next_x/10][next_y/10] == 0){
							label.setBounds(next_x, next_y, r.width,r.height);
						}
						}catch(ArrayIndexOutOfBoundsException exception){	
						}
					break;
			//move left
				case 37:
					next_x = r.x-10;
					next_y = r.y;
					try{
						if(data_1[next_x/10][next_y/10] == 0){
							label.setBounds(next_x, next_y, r.width,r.height);
						}
						}catch(ArrayIndexOutOfBoundsException exception){	
						}
					break;
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		private void put_sth(){
			JLabel[][] layer_1 = new JLabel[60][40];
			data_1 = new int [60][40];
			for(int i=24;i<34;i++){
				for(int j=0;j<40;j++){
					data_1[i][j] = 1;
				}
			}
			
			for(int i=24;i<34;i++){
				for(int j=18;j<21;j++){
					data_1[i][j] = 0;
				}
			}
			
			for(int i=0;i<60;i++){
				for(int j=0;j<40;j++){
					if(data_1[i][j] == 1){
						layer_1[i][j] = new JLabel(new ImageIcon("images/pattern_type1.png"));
						layer_1[i][j].setBounds(i*10, j*10, 10, 10);
						panel.add(layer_1[i][j]);
					}
					
				}
			}
			
			
			
		}
		
}
