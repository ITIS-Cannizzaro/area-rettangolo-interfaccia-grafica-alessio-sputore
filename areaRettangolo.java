import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;    //
public class areaRettangolo extends JFrame implements ActionListener {
	JTextArea base= new JTextArea ();   //area per inserimento testo
	JTextArea altezza=new JTextArea ();
	JTextArea risultato=new JTextArea();
	
	JButton calcola= new JButton("Calcola area");   //bottone per funzioni
	JButton cancella=new JButton("Cancella");
	
	JLabel Base=new JLabel ("Inserire base: ");   
	JLabel Altezza=new JLabel("Inserire altezza: ");
	JLabel Risultato=new JLabel ("L'area calcolata: ");
	
	public areaRettangolo () {
		super ("Calcolo area rettangolo con inserimento dati.");
		
		Container cont=this.getContentPane();
		cont.setLayout(new FlowLayout());       //definisce il layout del container  
		cont.add(Base);   //aggiunge nel container il label (testo)
		cont.add(base);    //aggiunge nel container la casella di testo 
		cont.add(Altezza);
		cont.add(altezza);
		
		Base.setHorizontalTextPosition(Base.LEFT);
		base.setPreferredSize(new Dimension(250,20));	
		altezza.setPreferredSize(new Dimension (250,20));
		cont.add(Risultato);
		cont.add(risultato);
		Risultato.setHorizontalTextPosition(Risultato.LEFT);    //posiziona il testo (label) a sinistra della casella di testo
		risultato.setPreferredSize(new Dimension(250,20));      
		cont.add(calcola);
		calcola.addActionListener(e -> calcoloArea());     //fa riferimento alla funzione calcolaArea dell'evento e
		cont.add(cancella);
		cancella.addActionListener(e->cancella());
		setSize(400,400);   //si definisce la dimensione del container
		setVisible (true);	//rende visibile 
		setResizable(false);   //impedisce il ridimensionamento
	}
	
	public void calcoloArea() {
		double B, A, Area;
		B=Double.parseDouble(base.getText());    //Double.parseDouble=prende il testo double di base
		A=Double.parseDouble(altezza.getText());  
		Area=B*A;
		risultato.setText(Double.toString (Area)); 
	}
	public void cancella(){
        base.setText("");
        altezza.setText("");
        risultato.setText("");
    }
	
	@Override       //metodo per svolgere un'azione da parte del pulsante 
	public void actionPerformed(ActionEvent e) {
        if(e.getSource()==calcola){  //quando calcola viene premuto (getSource), viene eseugita l'azione e calcola
            calcoloArea();
        }
        if(e.getSource()==cancella){   //quando cancella viene premuto (getSource), viene eseguita l'azione cancella 
            cancella();
        }
    }
}
