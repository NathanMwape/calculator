package calculatrice_scientifique;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Calculatrice extends JFrame implements ActionListener,ItemListener
{   //JFrame frame=new JFrame();On peut ne pas l'inserer si on fait extends JFrame
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b,bexp,bc,bcl,bMult,bDiv,bSom,bSoust;
	JButton bRes,bX1Y,b1X,bpm,bSqrt,bLog,bRand,bnCr,bnAr,bFact,bSin,bCos;
	JButton bX2,b10x,bEx,bF,bE,bD,bC,bB,bA,b2ndF;
	ButtonGroup bg1,bg2;
	JPanel pTxt,p2,p3;
	JTextField txt;
	double xp=1,xs=0,aux=0;
	boolean op=false,mult=false,div=false,som=false,soust=false,init=true;
	boolean YX=false,X1Y=false;
	boolean nAr=false,nCr=false,shift=false,virg=false;
	Calculatrice()
	{
	super("calculatrice_scientifique");
	// Initialisation des bouton et champs de saisie
	b0=new JButton("0");b1=new JButton("1");b2=new JButton("2");
	b3=new JButton("3");b4=new JButton("4");b5=new JButton("5");
	b6=new JButton("6");b7=new JButton("7");b8=new JButton("8");
	b9=new JButton("9");b=new JButton(".");bexp=new JButton("Pi");
	bX1Y=new JButton("X^(1/Y)");bpm=new JButton("+/-");bMult=new JButton("*");
	bDiv=new JButton("/");bSom=new JButton("+");bSoust=new JButton("-");
	bRes=new JButton("=");b1X=new JButton("1/X");txt =new JTextField("");
	bSqrt=new JButton("Rac");bLog=new JButton("Ln/Log");bRand=new JButton("Rand");
	bnCr=new JButton("nCr");bnAr=new JButton("nAr");bFact=new JButton("n!");
	bSin=new JButton("Sin");bCos=new JButton("Cos");bX2=new JButton("X^2");b10x=new JButton("10^x");
	bEx=new JButton("e^x");bF=new JButton("F");bE=new JButton("E");
	bD=new JButton("D");bC=new JButton("C");bB=new JButton("B");
	bA=new JButton("A");b2ndF=new JButton("2nF");bc=new JButton("C");
	bcl=new JButton("Del");
	bg1=new ButtonGroup();bg2=new ButtonGroup();
	bA.setEnabled(false);bB.setEnabled(false);bC.setEnabled(false);
	bD.setEnabled(false);bE.setEnabled(false);bF.setEnabled(false);
	// Definir la taille préférer des composants
	b0.setPreferredSize(new Dimension(70,40));b1.setPreferredSize(new Dimension(70,40));
	b2.setPreferredSize(new Dimension(70,40));b3.setPreferredSize(new Dimension(70,40));
	b4.setPreferredSize(new Dimension(70,40));b5.setPreferredSize(new Dimension(70,40));
	b6.setPreferredSize(new Dimension(70,40));b7.setPreferredSize(new Dimension(70,40));
	b8.setPreferredSize(new Dimension(70,40));b9.setPreferredSize(new Dimension(70,40));
	b.setPreferredSize(new Dimension(70,40));bexp.setPreferredSize(new Dimension(70,40));
	bDiv.setPreferredSize(new Dimension(70,40));bSom.setPreferredSize(new Dimension(70,40));
    bSoust.setPreferredSize(new Dimension(70,40));bRes.setPreferredSize(new Dimension(165,40));
	bX1Y.setPreferredSize(new Dimension(70,40));b1X.setPreferredSize(new Dimension(70,40));
	bpm.setPreferredSize(new Dimension(70,40));bMult.setPreferredSize(new Dimension(70,40));
	bSqrt.setPreferredSize(new Dimension(70,40));
	
	bSin.setPreferredSize(new Dimension(70,40));bc.setPreferredSize(new Dimension(70,40));
	bcl.setPreferredSize(new Dimension(70,40));txt.setPreferredSize(new Dimension(440,50));
	txt.setHorizontalAlignment(SwingConstants.RIGHT);
	txt.setBackground(Color.DARK_GRAY);txt.setForeground(Color.WHITE);
	txt.setFont(new Font("DIALOG",Font.CENTER_BASELINE+Font.BOLD,18));
	// Declaration des Panel et leurs contenues
            JPanel pNorm=new JPanel();
	pNorm.add(b7);pNorm.add(b8);pNorm.add(b9);pNorm.add(bexp);pNorm.add(bSqrt);
	pNorm.add(b4);pNorm.add(b5);pNorm.add(b6);pNorm.add(bMult);pNorm.add(bDiv);
	pNorm.add(b1);pNorm.add(b2);pNorm.add(b3);pNorm.add(bSom);pNorm.add(bSoust);
	pNorm.add(b0);pNorm.add(b);pNorm.add(bpm);pNorm.add(bRes);
	p2=new JPanel(new GridLayout(1,1));p2.add(pNorm);
	JPanel pStd=new JPanel();pStd.add(bcl);
	pStd.add(bc);
	JPanel pSci=new JPanel();
	p3 =new JPanel(new GridLayout(1,1)); p3.add(pSci);
	pTxt=new JPanel();pTxt.add(txt);pTxt.add(pStd);
	// Ajout des écouteurs aux deffirents boutons
    b0.addActionListener(this);b1.addActionListener(this);b2.addActionListener(this);
    b3.addActionListener(this);b4.addActionListener(this);b5.addActionListener(this);
    b6.addActionListener(this);b7.addActionListener(this);b8.addActionListener(this);
    b9.addActionListener(this);b.addActionListener(this);bexp.addActionListener(this);
    b1X.addActionListener(this);bpm.addActionListener(this);bMult.addActionListener(this);
    bDiv.addActionListener(this);bSom.addActionListener(this);bSoust.addActionListener(this);
    bRes.addActionListener(this);bX1Y.addActionListener(this);bc.addActionListener(this);
    bcl.addActionListener(this);bSqrt.addActionListener(this);
    bLog.addActionListener(this);bRand.addActionListener(this);
    bF.addActionListener(this);
    // Mise en forme de la fenetre
   // ImageIcon image=new ImageIcon("Clock.png");
   // this.setIconImage(image.getImage());
    this.setSize(new Dimension(452,331));
    this.getContentPane().setLayout(new GridLayout(2,1));
    this.getContentPane().add(pTxt);this.getContentPane().add(p2);
    this.setLocation(300,100);
    this.setCursor(12);this.setResizable(true);this.show();
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    void activatehex(boolean b)
    {
    bA.setEnabled(b);bB.setEnabled(b);bC.setEnabled(b);
	bD.setEnabled(b);bE.setEnabled(b);bF.setEnabled(b);	
    }
    void activateP2P3(boolean v)
    {
    b0.setEnabled(v);b1.setEnabled(v);b2.setEnabled(v);b3.setEnabled(v);
    b4.setEnabled(v);b5.setEnabled(v);b6.setEnabled(v);b7.setEnabled(v);
    b8.setEnabled(v);b9.setEnabled(v);b.setEnabled(v);bexp.setEnabled(v);
    bMult.setEnabled(v);bDiv.setEnabled(v);bSom.setEnabled(v);bSoust.setEnabled(v);
    bRes.setEnabled(v);bX1Y.setEnabled(v);b1X.setEnabled(v);bpm.setEnabled(v);
    bSqrt.setEnabled(v);bLog.setEnabled(v);
    }
    void activateOp(boolean v)
    {
    b.setEnabled(v);bexp.setEnabled(v);bMult.setEnabled(v);bDiv.setEnabled(v);
    bSom.setEnabled(v);bSoust.setEnabled(v);bRes.setEnabled(v);bX1Y.setEnabled(v);
    b1X.setEnabled(v);bpm.setEnabled(v);bSqrt.setEnabled(v);
    bSin.setEnabled(v);bCos.setEnabled(v);
    bX2.setEnabled(v);b10x.setEnabled(v);bEx.setEnabled(v);b2ndF.setEnabled(v);
    }


    void Resultat()
    {
    	double x2=Double.parseDouble(txt.getText());
    	if(mult) {txt.setText(""+(xp*x2));xp=Double.parseDouble(txt.getText());}
		else if(div) 
		{
			if(x2!=0)
			{
			txt.setText(""+(xp/x2));
			xp=Double.parseDouble(txt.getText());
			}
			else
			{
				activateP2P3(false);
				txt.setBackground(Color.DARK_GRAY);txt.setForeground(Color.RED);
				txt.setText("  ERROR !!  DIVISION   PAR   ZERO   IMPOSSIBLE  ");
			}		
		}
		else if(som) {txt.setText(""+(xs+x2));xs=Double.parseDouble(txt.getText());}
		else if(soust){ txt.setText(""+(xs-x2));xs=Double.parseDouble(txt.getText());}
		else if(YX)	{double res=Math.pow(aux,x2);txt.setText(""+res);}
		else if(nAr)
		{
			if((aux>=x2)&&(aux>=0)&&(x2>=0))
			{
			double res=(fact(aux)/fact((aux-x2)));
			txt.setText(""+res);
			}
			else
			{
				txt.setBackground(Color.DARK_GRAY);txt.setForeground(Color.RED);
				txt.setText("  ERROR!!  RULE  :  \"  n  doit  etre >= r  et  n >= 0  et  r >= 0  \" ");
			    activateP2P3(false);}
		}
		else if(nCr)
		{
			if((aux>=x2)&&(aux>=0)&&(x2>=0))
			{
				double res=(fact(aux)/(fact(x2)*fact((aux-x2))));
				txt.setText(""+res);
			}
			else
			{
				txt.setBackground(Color.DARK_GRAY);txt.setForeground(Color.RED);
				txt.setText(" ERROR!!   RULE  :  \"  n  doit  etre  >= r  et  n  >= 0  et  r  >= 0  \" ");
			    activateP2P3(false);}
		}
		else if(X1Y)
		{
			if(x2!=0)
			{double res=Math.pow(aux,(1/x2));txt.setText(""+res);}
			else
			{
				txt.setBackground(Color.DARK_GRAY);txt.setForeground(Color.RED);
				txt.setText(" ERROR!!  DEUXIEME  NOMBRE  DOIT  ETRE  DIFFERENT  DE  0 ");
			    activateP2P3(false);}
		}
		 init=false;   
		 virg=false; 
    }
    double fact(double x)
    {
    	double res=1;
    	if(x>=0)
    	{
    	for(int i=2;i<=x;i++)
		{
			res=res*i;
		}
		return res;
		}
		else return 0;
    }
	public void actionPerformed(ActionEvent e)
	{
		Object src = e.getSource();
		JButton baux=(JButton)src;
		////////////*********Bouton des chiffres********//////////////
		if((src==b0)||src==b1||src==b2||src==b3||src==b4||src==b5||src==b6||src==b7||src==b8||src==b9||src==bA||src==bB||src==bC||src==bD||src==bE||src==bF)
		{ 
		if(!op) txt.setText(txt.getText()+baux.getLabel());
		else if(op)
		{
			txt.setText(baux.getLabel());
			op=false;
		}
		}
		////////////*********Bouton virgule********//////////////
		else if(src==b)
		{
			if(!virg)
			{
				txt.setText(txt.getText()+".");
				virg=true;
			}
		}
		////////////*********Bouton Pi********//////////////
		else if(src==bexp)
		{
			txt.setText(""+Math.PI);
			virg=true;
		}
		////////////*********Bouton clear********//////////////
		else if(src==bc)
		{txt.setText("0");xp=1;xs=0;init=true;aux=0;shift=false;op=false;X1Y=true;
		mult=false;div=false;som=false;soust=false;nAr=false;nCr=false;
		activateP2P3(true);activatehex(false);
		txt.setBackground(Color.LIGHT_GRAY);txt.setForeground(Color.WHITE);}
		////////////*********Bouton de +/-********//////////////
		else if(src==bpm)
		txt.setText(""+Double.parseDouble(txt.getText())*-1);
		else if(src==bcl)
		 txt.setText(txt.getText().substring(0,txt.getText().length()-1));
		 
		 ////////////*********Multiplication********//////////////
		else if(src==bMult)
		{
		try
		{
		if(init || op)
		{
			xp=(Double.parseDouble(txt.getText()));
			init=false;virg=false;
			txt.setText(""+xp);
		}
		else
		{
			Resultat();
			xp=(Double.parseDouble(txt.getText()));
		}
			op=true;mult=true;div=false;som=false;soust=false;YX=false;
			nAr=false;nCr=false;X1Y=true;
		}catch(NumberFormatException execp)
    	{
    		txt.setBackground(Color.DARK_GRAY);txt.setForeground(Color.RED);
    		txt.setText("ERROR :  CONVERTION  AVEC  VERGULE  FLOTTANTE  NON  SUPPORTEE ");
	     	activateP2P3(false);}
		}
		////////////*******Division******////////////
		else if(src==bDiv)
		{
		try
		{
		if(init || op)
		{
			xp=(Double.parseDouble(txt.getText()));
			init=false;virg=false;
			txt.setText(""+xp);
		}
		else
		{
			 Resultat();
		 xp=(Double.parseDouble(txt.getText()));
		}
		op=true;mult=false;div=true;som=false;soust=false;YX=false;
		nAr=false;nCr=false;X1Y=true;
		}catch(NumberFormatException execp)
    	{
    		txt.setBackground(Color.DARK_GRAY);txt.setForeground(Color.RED);
    		txt.setText("ERROR :  CONVERTION  AVEC  VERGULE  FLOTTANTE  NON  SUPPORTEE ");
		    activateP2P3(false);}
		}
		////////////////***********Somme**********////////////////
		else if(src==bSom)
		{
		try
		{
		if(init || op)
		{
			xs=(Double.parseDouble(txt.getText()));
			init=false;virg=false;
			txt.setText(""+xs);
		}
		else
		{
			 Resultat();
			 xs=(Double.parseDouble(txt.getText()));
		}
		op=true;mult=false;div=false;som=true;soust=false;YX=false;
		nAr=false;nCr=false;X1Y=true;
		}catch(NumberFormatException execp)
    	{
    		txt.setBackground(Color.DARK_GRAY);txt.setForeground(Color.RED);
    		txt.setText("ERROR :  CONVERTION  AVEC  VERGULE  FLOTTANTE  NON  SUPPORTEE ");
		    activateP2P3(false);}
		}
		////////////////************Soustraction***********//////////////////
		else if(src==bSoust)
		{
		try
		{
		if(init || op)
		{
			xs=(Double.parseDouble(txt.getText()));
			init=false;virg=false;
			txt.setText(""+xs);
		}
		else
		{
			Resultat();
			xs=(Double.parseDouble(txt.getText()));
		}
	    op=true;mult=false;div=false;som=false;soust=true;YX=false;
	    nAr=false;nCr=false;X1Y=true;
		}catch(NumberFormatException execp)
    	{
    		txt.setBackground(Color.DARK_GRAY);txt.setForeground(Color.RED);
    		txt.setText("ERROR :  CONVERTION  AVEC  VERGULE  FLOTTANTE  NON  SUPPORTEE ");
		    activateP2P3(false);}
	    }
	    //////////////////**************Resultat*************//////////////////
		else if(e.getSource()==bRes)
		{
			Resultat();
			init=true;virg=false;
		}
		//////////************Les fonction Scientifiques********/////////////
	 	
		/////////************FIN des Fonctions Scientifiques********/////////
	
	  
	}
	public void itemStateChanged(ItemEvent i)
	{
		Object srci=i.getSource();
	}
	public static void main (String[] args) 
	{
		Calculatrice c=new  Calculatrice();
	}
}